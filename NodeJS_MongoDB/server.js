const express = require("express"); //위에서 작성한 라이브러리를 설치
const app = express(); // 설치한 라이브러리로 객체를 생성해줘
const bodyParser = require("body-parser"); // body-parser 가져오기
app.use(bodyParser.urlencoded({ extended: true }));

// listen(서버 포트 번호, 해당 서버에 실행할 코드)
app.listen(8080, () => {
  console.log("listening on 8080");
});

// get 요청 API 만들기
app.get("/pet", (req, res) => {
  res.send("펫용품 쇼핑할 수 있는 페이지 입니다.");
});

app.get("/beauty", (req, res) => {
  res.send("뷰티용품 쇼핑할 수 있는 페이지 입니다.");
});

app.get("/", (req, res) => {
  // res.sendFIle(__dirname + '보낼파일경로')
  res.sendFile(__dirname + "/index.html");
});

app.get("/write", (req, res) => {
  // res.sendFIle(__dirname + '보낼파일경로')
  res.sendFile(__dirname + "/write.html");
});

app.post("/add", (req, res) => {
  res.send("전송완료");
  console.log(req.body);
});

// 콘솔에 input 태그에 작성한 값이 출력되는 것을 확인할 수 있다.
