const router = require("express").Router();

// 만약 해당 라우터를 로그인을 한 유저만 사용하도록 하려면 어떻게 미들웨어를 추가 해야할까?

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

//  만약 무조건 로그인을 해야만 이동하도록 해서 isLogin을 계속 넣지 않도록 하는 방법
// router에서 무조건 해당 미들웨어를 실행시키고 다음으로 넘어가게 하는 방법
router.use(isLogin);
// 만약 특정 URL에만 적용하는 미들웨어를 추가하려면
//  아래처럼 코드 작성하기
// router.use('/shirts', isLogin);

router.get("/sports", (req, res) => {
  res.send("스포츠 게시판");
});

router.get("/game", (req, res) => {
  res.send("게임 게시판");
});

module.exports = router;
