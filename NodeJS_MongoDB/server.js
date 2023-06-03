const express = require("express"); //위에서 작성한 라이브러리를 설치
const app = express(); // 설치한 라이브러리로 객체를 생성해줘

// listen(서버 포트 번호, 해당 서버에 실행할 코드)
app.listen(8080, function () {
  console.log("listening on 8080");
});

// get 요청 API 만들기
app.get("/pet", function (req, res) {
  res.send("펫용품 쇼핑할 수 있는 페이지 입니다.");
});

app.get("/beauty", function (req, res) {
  res.send("뷰티용품 쇼핑할 수 있는 페이지 입니다.");
});
