const express = require("express"); //위에서 작성한 라이브러리를 설치
const app = express(); // 설치한 라이브러리로 객체를 생성해줘
const bodyParser = require("body-parser"); // body-parser 가져오기
// PUT, DELETE 요청 가능하게 하는 방법
const methodOverride = require("method-override");
app.use(methodOverride("_method"));

app.use(bodyParser.urlencoded({ extended: true }));
app.set("view engine", "ejs");
app.use("/public", express.static("public"));
var db;

const MongoClient = require("mongodb").MongoClient;
MongoClient.connect(
  "mongodb+srv://admin:ghdals9578@cluster0.mhotj5h.mongodb.net/?retryWrites=true&w=majority",
  (에러, client) => {
    if (에러) return console.log(에러);

    db = client.db("todoapp"); // todoapp이라는 database에 연결하는 코드

    // db에 내 이름과 나이를 저장하기
    // db.collection('post').insertOne('저장할 데이터', (에러, 결과)=> {
    //   console.log('저장완료');
    // })

    // 아래 코드는 post라는 파일에 inserOne으로 저장하는데 데이터는 아래 작성한 객체형식의 데이터를 넣을거야 라는 의미
    // 저장할 데이터는 객체형식으로 작성하기
    // db.collection("post").insertOne(
    //   { 이름: "admin", 나이: 10, _id: 0 },
    //   (에러, 결과) => {
    //     console.log("저장완료");
    //   }
    // );

    // 콘솔에 input 태그에 작성한 값이 출력되는 것을 확인할 수 있다.

    app.listen(8080, () => {
      console.log("listening on 8080");
    });
  }
);

// listen(서버 포트 번호, 해당 서버에 실행할 코드)

// get 요청 API 만들기
app.get("/pet", (req, res) => {
  res.send("펫용품 쇼핑할 수 있는 페이지 입니다.");
});

app.get("/beauty", (req, res) => {
  res.send("뷰티용품 쇼핑할 수 있는 페이지 입니다.");
});

app.get("/", (req, res) => {
  // res.sendFIle(__dirname + '보낼파일경로')
  res.render("index.ejs");
});

app.get("/write", (req, res) => {
  // res.sendFIle(__dirname + '보낼파일경로')
  res.render("write.ejs");
});

app.get("/edit/:id", (req, res) => {
  db.collection("post").findOne(
    { _id: parseInt(req.params.id) },
    (error, data) => {
      if (data === null) {
        res.render("error.ejs");
      } else {
        res.render("edit.ejs", { data: data });
      }
    }
  );
});

app.put("/edit", (req, res) => {
  // form에 담긴 데이터를 서버에서 해당 게시글에 맞는 id를 찾아서 데이터를 수정하기.
  // update를 할 때는 updateOne({어떤 게시글}, {수정값}, (err, data) => {})
  //  여기서 $set 은 operator로 ~가 있으면 수정하고, 없다면 추가해주세요 라는 의미
  console.log(req.body);
  db.collection("post").updateOne(
    { _id: parseInt(req.body.id) },
    { $set: { 제목: req.body.title, 날짜: req.body.date } },
    (err, data) => {
      res.redirect("/list");
    }
  );
});

app.post("/add", (req, res) => {
  res.send("전송완료");
  console.log(req.body.title);
  console.log(req.body.date);
  // id 값을 매기기 위해 총 데이터 개수를 가져오는 방법
  //  단 예를 들어 하나의 데이터를 삭제했을 때 같은 id를 가진 새로운 데이터가 생기면 안되기에
  //  기존의 id 값이 아닌 +1 한 id 값을 가져와야함.
  // 위와 같은 문제를 해결하기 위해 1개의 collection을 더 만들어서 관리할 예정
  // counter라는 collection에서 name: '게시물 개수'인 데이터를 찾아달라는 코드
  db.collection("counter").findOne({ name: "게시물 개수" }, (error, data) => {
    const id = data.totalPost;
    db.collection("post").insertOne(
      { 제목: req.body.title, 날짜: req.body.date, _id: id + 1 },
      (에러, 결과) => {
        // 만약 여러개를 수정하겠다면 updateMany()
        // db.collection('counter').updateOne({어떤데이터를 수정할지}, {operator : {변경할key : 수정값}}, ()=>{})
        // operator ==> $set = 변경, $inc = 기존값에 더해줄 값, $min = 기존값보다 적을 때만 변경, $ rename = key값 이름 변경 ...
        // 만약 딱히 처리할게 없다면 콜백함수를 지워도 됨
        db.collection("counter").updateOne(
          { name: "게시물 개수" },
          { $inc: { totalPost: 1 } },
          () => {
            console.log("저장완료");
          }
        );
      }
    );
  });
});

// 과제
// /list 로 GET 요청하면 실제 DB에 저장된 데이터들로 꾸며진 HTML 보여주기
app.get("/list", (req, res) => {
  // DB에 있는 데이터를 꺼내려고 할 때는 어떤 데이터를 꺼낼지 작성해줘야 한다.
  // 그래서 DB에 저장된 post라는 collection안의 어떠한 변수로 적힌 데이터를 꺼내달라고 코드를 작성해야함.
  // 그리고 순서가 있는데 데이터를 꺼내고 ejs 파일을 불러오는게 순서가 맞으니 주의 해야함!

  // db.collection('post').find() // toArray()를 안붙이면 메타데이터까지 다 가져오게 되기에 아래처럼 작성해주기.
  db.collection("post")
    .find()
    .toArray((error, data) => {
      console.log(data);
      res.render("list.ejs", { posts: data });
    }); // 해당 db에 있는 모든 데이터를 가져오게 됨.
});

app.delete("/delete", (req, res) => {
  // req.body를 하게되면 ajax로 요청시 보낸 data를 받아서 확인할 수 있다.
  // 그리고 아래처럼 req.body로 보낸 숫자 1의 데이터가 받아올때는 문자 '1'로 받아와지기에 Int로 변경 시켜주기.
  const id = parseInt(req.body._id);
  // req.body에 담겨온 게시물번호를 가진 글을 db에서 찾아서 삭제해주세요.
  // deleteOne({어떤 항목을 삭제할지}, ()=>{}) --> 삭제 메서드
  db.collection("post").deleteOne({ _id: id }, (error, data) => {
    console.log("삭제완료");
    // 응답코드 200을 보내주기.
    // .send({}) 로 메시지를 함께 보내주기.
    if (error) {
      res.status(400).send({ message: "실패" });
    } else {
      res.status(200).send({ message: "성공" });
    }
  });
});

// /detail로 접속하면 detail.ejs를 보여주기 (URL Parameter) ==> 각 상세페이지의 서로 다른 URL
app.get("/detail/:id", (req, res) => {
  // :?? 를 작성하게 되면 parameter를 받아서 가변 주소를 가져오게 된다.
  // res.render('detail.ejs', {이런 이름으로: 이런 데이터를 전송 가능})
  // db에서 우리가 찾을 데이터의 _id에 해당하는 데이터를 가져와달라는 건데
  //  parameter의 값을 가져오려고 할 경우 req.params.?? 를 작성하게 되면 가져올 수 있다.
  // 그리고 위에서 확인했던것처럼 req 데이터로 날라오는 값이 모두는 잘 모르겠지만 대부분이 string type으로 날라오기에 정수화 시켜주기!!!
  db.collection("post").findOne(
    { _id: parseInt(req.params.id) },
    (error, data) => {
      if (data === null) {
        console.log("데이터 없다.");
        res.render("error.ejs");
      } else {
        res.render("detail.ejs", { data: data });
      }
    }
  );
});
