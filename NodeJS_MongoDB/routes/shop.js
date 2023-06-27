const router = require("express").Router(); // 라우터 파일 필수
// require는 다른 파일이나 라이브러리를 여기에 첨부하겠다라는 의미가 된다.

// app.get('/shop/shirts', (req, res)=> {  // <--------- app 대신에 위에서 불러온 router로 변경하기
//   res.send('셔츠 판매 페이지')
// })

router.get("/shirts", (req, res) => {
  res.send("셔츠 판매 페이지");
});

router.get("/pants", (req, res) => {
  res.send("바지 판매 페이지");
});

module.exports = router; // module.exports = 내보낼 변수명
// 그래서 다른 곳에서 shop.js를 가져다 쓸 때 내보낼 변수가 된다.
