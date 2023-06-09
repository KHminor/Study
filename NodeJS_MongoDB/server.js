const express = require("express"); //위에서 작성한 라이브러리를 설치
const app = express(); // 설치한 라이브러리로 객체를 생성해줘
const bodyParser = require("body-parser"); // body-parser 가져오기

// socket.io 셋팅
const http = require("http").createServer(app);
const { Server } = require("socket.io");
const io = new Server(http);

// PUT, DELETE 요청 가능하게 하는 방법
const methodOverride = require("method-override");
const { ObjectID } = require("mongodb");
app.use(methodOverride("_method"));

// 환경변수
require("dotenv").config();

// 암호화
const crypto = require("crypto");

app.use(bodyParser.urlencoded({ extended: true }));
app.set("view engine", "ejs");
app.use("/public", express.static("public"));
var db;

const MongoClient = require("mongodb").MongoClient;
MongoClient.connect(process.env.DB_URL, (에러, client) => {
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

  http.listen(process.env.PORT, () => {
    console.log("listening on" + process.env.PORT);
  });
});

// listen(서버 포트 번호, 해당 서버에 실행할 코드)

// get 요청 API 만들기
app.get("/pet", (req, res) => {
  res.send("펫용품 쇼핑할 수 있는 페이지 입니다.");
});

app.get("/beauty", (req, res) => {
  res.send("뷰티용품 쇼핑할 수 있는 페이지 입니다.");
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
      res.render("list.ejs", { posts: data });
    }); // 해당 db에 있는 모든 데이터를 가져오게 됨.
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

// 설치한 라이브러리를 가져오기
const passport = require("passport");
const localStrategy = require("passport-local").Strategy;
const session = require("express-session");

// middleware
// app.use() 를 사용하게 되면 () 안의 미들웨어를 사용하겠다라는 의미.
// middleware란?
// 우선 웹서버는 요청-응답을 해주는 것.
// 그래서 요청-응답 중간에 실행되는 코드를 미들웨어라고 한다.
app.use(
  session({ secret: "비밀코드", resave: true, saveUninitialized: false })
); // <-- secret은 세션을 만들때의 비밀번호 같은 것.
app.use(passport.initialize());
app.use(passport.session());

app.get("/login", (req, res) => {
  res.render("login.ejs", { data: "" });
});

// 기존 post 요청과는 달리 맞는지 인증 검사를 해야하기에 passport.authenticate('local') 를 추가해주기
//  해당 코드는 local 방식으로 회원인지 인증해달라는 코드
//  그리고 {} 를 추가하면 셋팅을 더 추가로 할 수 있게 됨.--> 그래서 현재는 로그인 실패시 /fail 페이지로 이동시켜달라는 코드
app.post(
  "/login",
  passport.authenticate("local", {
    failureRedirect: "/fail",
  }),
  (req, res) => {
    // 아이디, 비번 맞으면 메인 페이지로 보내주기.
    res.redirect("/");
  }
);

// 로그인 유저만 mypage에 입장 가능하도록 해야하니깐 middleware 추가하기
// 아래 isLogin 함수는 req.user 가 있는지 확인하는 middleware
// next() 는 다음으로 진행을 의미 (통과)
function isLogin(req, res, next) {
  if (req.user) {
    // <--- req.user는 로그인 후 세션이 있으면 항상 있는 데이터
    next();
  } else {
    res.redirect("/login");
  }
}

app.get("/mypage", isLogin, (req, res) => {
  // console.log(req.user); // <--- deserializeUser() 의 결과를 받아온 db에 있는 유저의 데이터
  res.render("mypage.ejs", { userData: req.user });
});

function checkPassword(pw, salt, savedHash) {
  const hash = crypto.pbkdf2Sync(pw, salt, 1000, 64, "sha512").toString("hex"); // 입력된 비밀번호를 해시화
  return hash === savedHash;
}

// 아이디와 비번을 인증하는 세부 코드의 경우엔 상세히 작성해야 함.
//  그래서 인증하는 방법을 strategy로 작성
passport.use(
  new localStrategy(
    {
      usernameField: "id", // form 태그의 name 속성의 id 값
      passwordField: "pw", // form 태그의 name 속성의 pw 값
      session: true, // 로그인 후 세션을 저장할 것인지에 대한 셋팅
      passReqToCallback: false, // 아이디/비밀번호 말고도 다른 정보로 검증을 할 것인지에 대한 셋팅
      // 만약 passReqToCallback: true로 한다면 밑의 (id, pw, done) 에서 req를 추가해서 req.body 하면 데이터가 나온다고 한다.
    },
    (id, pw, done) => {
      // done(1번째 인자: 서버에러와 같은 db 연결 불가 등, 2번째 인자: 요청을 성공했을 때 사용자 db 데이터 만약 실패의 경우 false 넣어야 함, 3번째 인자: 에러 메시지)
      db.collection("login").findOne({ id: id }, (err, data) => {
        // 해당 아이디의 salt, hash 값 가져오기
        const isPW = checkPassword(pw, data.salt, data.hash);

        if (err) return done(err);
        else if (!data)
          // 결과가 없다면 --> db에 대항 아이디가 없다면
          return done(null, false, { msg: "존재하지 않는 아이디 입니다." });
        else if (isPW) {
          console.log("로그인 했다!");
          // pw가 암호화 되어있지 않기에 보안이 좋지 않지만 지금은 우선 이렇게 진행함.
          // db에 아이디가 있다면, 입력한 비밀번호와 db에 있는 비번이랑 확인해보기.

          // 아이디와 비번이 맞아서 로그인을 성공하면 세션 정보를 만들어줘야 함 (로그인 했는지 확인하기 위해)
          return done(null, data); // <--- 여기 성공시의 data가 257번줄의 serializeUser((user, done))의 user 데이터에 들어가게 됨
        } else {
          return done(null, false, { msg: "잘못된 비밀번호 입니다." });
        }
      });
    }
  )
);

// id를 이용해서 세션을 저장시키는 코드 (로그인 성공시 발동)
passport.serializeUser((user, done) => {
  console.log(user);
  done(null, user); // 보통 id를 이용해서 세션을 저장시키기에 user.id로 세션을 만들어 주면서 쿠키도 만들어주게 됨. 그리고 쿠키안에는 로그인 했다는 정보가 들어감
});

// 나중에 마이페이지 접속시 발동할 예정 (이 세션 데이터를 가진 사람을 db에서 찾아줘) --> 즉 해당 세션 데이터를 가진 유저의 정보를 가져오기
// 여기서 done(null, data)로 받아온 data 값은 mypage 를 get 할때 가져오는 req.user의 데이터에 담겨져 있음
passport.deserializeUser((userData, done) => {
  // 위의 파라미터 id값은 258번줄의 user.id의 id를 가지고 있음
  db.collection("login").findOne({ id: userData.id }, (err, data) => {
    done(null, userData);
  });
});

// 회원 기능이 필요하다면 passport 셋팅하는 부분이 위에 있어야한다고 함.
app.get("/signup", (req, res) => {
  res.render("signup.ejs");
});

function isTrueId(id) {
  const pattern = /^[a-zA-Z0-9]+$/;
  return pattern.test(id);
}

function hashPassword(pw) {
  const salt = crypto.randomBytes(16).toString("hex"); // 임의의 salt 생성
  const hash = crypto.pbkdf2Sync(pw, salt, 1000, 64, "sha512").toString("hex"); // 입력한 비밀번호와 salt를 가지고 비밀번호를 해싱

  return {
    salt: salt,
    hash: hash,
  };
}

app.post("/register", (req, res) => {
  db.collection("login")
    .find({ id: req.body.id })
    .toArray((err, data) => {
      if (data.length === 0) {
        // 해당 데이터가 없다면 정규식 검사로 알파벳 또는 숫자만 들어가 있는지 확인
        if (isTrueId(req.body.id)) {
          // 확인되고 만약 잘 작성되었다면 비밀번호 암호화 후 DB에 저장하기 <----- 비밀번호는 저장하지 않고 salt와 hash 값을 저장해줘서 로그인시 매칭할때 사용하기
          const { salt, hash } = hashPassword(req.body.pw);
          db.collection("login").insertOne(
            {
              id: req.body.id,
              salt: salt,
              hash: hash,
              nickname: req.body.nick,
            },
            (err, data) => {
              if (!err) {
                res.render("login.ejs", { data: "성공" });
              }
            }
          );
        }
      }
    });
});

// shop.js 라우터 첨부하기
// app.use 는 미들웨어를 사용하겠다 라는 의미 (다시 한번 기억하기!)
// 현재는 /shop으로 접속하면 shop.js 라우터를 이용하겠다 라는 의미가 됨.
app.use("/shop", require("./routes/shop"));
app.use("/board/sub", require("./routes/board"));

// Full Scan 방식
// app.get("/search", (req, res) => {
//   console.log(req.query.value); // query string은 req.query 에 담겨있음.
//   db.collection("post")
//     .find({ 제목: req.query.value })
//     .toArray((err, data) => {
//       console.log(data);
//       res.render("search.ejs", { posts: data });
//     });
// });

// Search Index ==> 이진 탐색
// app.get("/search", (req, res) => {
//   db.collection("post")
//     .find({ $text: { $search: req.query.value } }) // <------- 만들어둔 Index 사용하기 (검색 엔진과 같이 조회)
//     .toArray((err, data) => {
//       console.log(data);
//       res.render("search.ejs", { posts: data });
//     });
// });

// 한국어 친화적인 Search Index
app.get("/search", (req, res) => {
  const search_Condition = [
    {
      $search: {
        index: "titleSearch",
        text: {
          query: req.query.value,
          path: "제목", // 제목과 날짜 둘다 찾고 싶다면 ['제목', '날짜']
        },
      },
    },
    // 추가 검색 조건
    {
      $sort: { _id: -1 }, // 내림차순
      // $sort: {_id: 1} 내림차순
    },
    // {
    //   $limit: 5 // 조회 게시물 제한
    // }
    // 그리고 기본적으로 정렬을 하지 않으면 searchScore로 검색어와의 유사도를 점수로 메겨서 그것을 기준으로 정렬하게 됨.
    // {
    //   $project: { 제목: 1, _id: 0, score: { $meta: "searchScore"}} // 여기서 value로 1은 조건 추가, 0은 조건 제거를 의미
    // }
  ];
  db.collection("post")
    .aggregate(search_Condition) // aggregate([{},{},{}]) 를 사용해서 배열 안의 여러개의 검색 조건을 넣을 수 있다. 예를 들어 어느 날짜, 어떤 단어, 정렬이요 등등
    .toArray((err, data) => {
      console.log(data);
      res.render("search.ejs", { posts: data });
    });
});

app.post("/add", (req, res) => {
  res.redirect("/list");
  // id 값을 매기기 위해 총 데이터 개수를 가져오는 방법
  //  단 예를 들어 하나의 데이터를 삭제했을 때 같은 id를 가진 새로운 데이터가 생기면 안되기에
  //  기존의 id 값이 아닌 +1 한 id 값을 가져와야함.
  // 위와 같은 문제를 해결하기 위해 1개의 collection을 더 만들어서 관리할 예정
  // counter라는 collection에서 name: '게시물 개수'인 데이터를 찾아달라는 코드
  db.collection("counter").findOne({ name: "게시물 개수" }, (error, data) => {
    const id = data.totalPost;
    const sendData = {
      제목: req.body.title,
      날짜: req.body.date,
      _id: id + 1,
      user: req.user._id,
      nickname: req.user.nickname,
    }; // 로그인한 유저의 정보를 가져오려고 할 경우 req.user를 입력하면 된다.

    db.collection("post").insertOne(sendData, (에러, 결과) => {
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
    });
  });
});

app.get("/", (req, res) => {
  // res.sendFIle(__dirname + '보낼파일경로')
  res.render("index.ejs");
});

app.delete("/delete", (req, res) => {
  // req.body를 하게되면 ajax로 요청시 보낸 data를 받아서 확인할 수 있다.
  // 그리고 아래처럼 req.body로 보낸 숫자 1의 데이터가 받아올때는 문자 '1'로 받아와지기에 Int로 변경 시켜주기.
  const id = parseInt(req.body._id);
  // req.body에 담겨온 게시물번호를 가진 글을 db에서 찾아서 삭제해주세요.
  console.log("req.user._id", req.user._id);
  const deleteData = { _id: id, user: req.user._id };

  // deleteOne({어떤 항목을 삭제할지}, ()=>{}) --> 삭제 메서드
  db.collection("post").deleteOne(deleteData, (error, data) => {
    // 응답코드 200을 보내주기.
    // .send({}) 로 메시지를 함께 보내주기.
    console.log("data.deletedCount", data.deletedCount);

    if (error) {
      res.status(400).send({ message: "실패" });
    } else if (data.deletedCount !== 1) {
      res.status(400).send({ message: "실패" });
    } else {
      res.status(200).send({ message: "성공" });
    }
  });
});

// multer 사용법
const multer = require("multer");
// 이미지를 어디에 저장할 것인지 인데
//  diskStorage는 폴더 안에 저장해달라는 것.
//  memoryStorage는 렘에 저장해달라는 것(휘발성).
const storage = multer.diskStorage({
  destination: (req, file, cd) => {
    cd(null, "./public/images"); // 저장할 파일 경로
  },
  filename: (req, file, cd) => {
    // 저장한 파일의 파일명 설정 --> originalname은 파일명 그대로
    cd(null, file.originalname);
  },
});

const path = require("path");

// 필터랑 제한을 주고 싶을 땐 multer({}) 안에 작성해야한다.
const upload = multer({
  storage: storage,
  // 파일 필터 걸기
  fileFilter: function (req, file, callback) {
    var ext = path.extname(file.originalname);
    if (ext !== ".png" && ext !== ".jpg" && ext !== ".jpeg") {
      return callback(new Error("PNG, JPG만 업로드하세요"));
    }
    callback(null, true);
  },
  limits: {
    fileSize: 1024 * 1024,
  },
});

app.get("/upload", (req, res) => {
  res.render("upload.ejs");
});

// 미들웨어처럼 upload 사용하기.
// app.post('/upload', single('input태그의 name속성'), (req, res)=> {
//    만약 파일 여러개를 업로드하고 싶다면 upload.single이 아니라 upload.array('name속성', 최대 개수)로 변경해주고
//    upload 해주는 input도 여러개로 넣을 수 있게 multiple 속성을 추가로 해줘야함. --> 이게 그냥 클릭하면 안되고 컨트롤 누르고 해야 적용됨.
app.post("/upload", upload.array("upload", 2), (req, res) => {
  res.redirect("/");
});

// 업로드한 이미지 보여주기.

app.get("/images/:fileName", (req, res) => {
  // __dirname 는 현재 파일의 경로를 의미
  // res.sendFile( __dirname + 'public/images' + 이미지이름)
  res.sendFile(__dirname + "/public/images/" + req.params.fileName);
});

app.get("/chat", isLogin, (req, res) => {
  console.log("req.user._id: ", req.user._id);
  db.collection("chatroom")
    .find({ member: ObjectID(req.user._id) })
    .toArray()
    .then((data) => {
      res.render("chat.ejs", { data: data, userId: req.user._id });
    });
});

app.post("/chat", isLogin, (req, res) => {
  const chatRoomData = {
    member: [ObjectID(req.user._id), ObjectID(req.body.user)],
    date: new Date(),
    title: req.body.title,
    nickname: [req.user.nickname, req.body.nickname],
  };
  db.collection("chatroom").findOne(
    { member: [ObjectID(req.user._id), ObjectID(req.body.user)] },
    (err, data) => {
      if (data === null) {
        db.collection("chatroom")
          .insertOne(chatRoomData)
          .then(() => {
            console.log("생성");
            res.redirect("/chat"); // /chat 페이지로 리다이렉션
          })
          .catch((error) => {
            console.log("에러:", error);
            res.redirect("/error"); // 실패 시 에러 페이지로 리다이렉션
          });
      } else {
        res.redirect("/chat"); // 이미 존재하는 경우에도 /chat 페이지로 리다이렉션
      }
    }
  );
});

app.post("/msg", isLogin, (req, res) => {
  const saveMsg = {
    parent: req.body.parent,
    content: req.body.content,
    userId: req.user._id,
    date: new Date(),
  };

  db.collection("msg")
    .insertOne(saveMsg)
    .then((r) => {
      console.log("성공");
    });
});

// SSE
//  아래와 같이 작성하면 /sse 로 GET 요청하면 실시간으로 채널이 오픈됨
app.get("/msg/:id", isLogin, (req, res) => {
  // Header를 아래와 같이 수정해달라는 코드
  res.writeHead(200, {
    Connection: "keep-alive",
    "Content-Type": "text/event-stream",
    "Cache-Control": "no-cache",
  });

  // 일반적으로 GET, POST 요청은 1번 요청시 1번 응답을 하게 되는데
  //  위와 같이 코드를 작성하게 되면 여러번 응답이 가능하게 됨

  // 유저에게 데이터 전송은 event: 보낼데이터 이름 + \n
  // 유저에게 데이터 전송은 data: 보낼데이터 + \n\n  <--- 개행을 두번 작성하는게 안정적이라고 한다.

  // 지금은 메세지들을 한번 찾아서 보내고 끝임.
  // 그리고 DB는 수동적이기에 DB가 업데이트 될 때마다 유저에게 데이터를 전송해 달라는 것을 잘 못함.
  //  그래서 MongoDB Change Stream 을 사용하게 되면 변경시 전송이 가능하게 된다.
  //  Change Stream 설정하게 되면, DB 변동시 -> 서버에게 알려줌 -> 유저에게 보낼 수 있다.

  db.collection("msg")
    // params로 채팅방 id를 가져오는 이유는 get 요청이기에
    // 두가지 방법인 params와 query string 둘 중 params를 사용했음.
    .find({ parent: req.params.id })
    .toArray()
    .then((r) => {
      res.write("event: test\n");
      // 다만 서버에서 실시간 전송시 문자자료만 전송이 가능하다.
      // 그래서 toArray()로 배열 상태로 들어오기에 JSON 형식으로 변경 해주기.
      res.write("data: " + JSON.stringify(r) + "\n\n");
    });

  // 내가 원하는 document만 감시하고 싶으면 match 안에 특정 값을 찾을 수 있는 값을 넣어주기
  // 여기서 key 값으로 문자로 특정 key 값 앞에 fullDocument. 를 붙여줘야 한다.
  const pipeline = [{ $match: { "fullDocument.parent": req.params.id } }];
  const collection = db.collection("msg");
  const changeStream = collection.watch(pipeline); // watch 하게 되면 실시간으로 감시하게 됨
  changeStream.on("change", (r) => {
    // console.log(r.fullDocument); // 전체 메시지 확인 방법
    //  아래에서 [] 안에 넣어주는 이유는 chat.ejs 에서 배열로 다루기 때문
    res.write("event: test\n");
    res.write(`data: ${JSON.stringify([r.fullDocument])}\n\n`);
  });
});

app.get("/socket", (req, res) => {
  res.render("socket.ejs");
});

// 누가 웹소켓에 접속하면 내부 코드를 실행해달라는 코드
io.on("connection", (socket) => {
  console.log("접속됨.");

  // // 채팅방 개설하는 방법
  // socket.join("room1"); // <-- 개설을 하고 유저 또한 함께 참가할 수 있게 해줌

  socket.on("joinroom", (data) => {
    socket.join(data);
  });

  socket.on("room1_send", (data) => {
    io.to("room1").emit("broadcast", data);
  });

  // 유저가 데이터를 보내면 서버가 수신할 수 있도록 코드 작성하기
  socket.on("user-send", (data) => {
    // data 가 유저가 보낸 데이터
    // console.log("유저가 보낸거: ", data);

    // 모든 유저에게 보낼 데이터
    io.emit("broadcast", data);
    // 특정 유저에게 보낼 데이터
    //  socket을 날린 사용자에게 데이터를 전송하게 됨
    // console.log(socket.id);  // <--- 요청을 한 사용자, 유저 구분이 가능
    // io.to(socket.id).emit("broadcast", data);
  });
});
