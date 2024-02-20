import { Outlet, useNavigate } from "react-router-dom";

function Main() {
  const navigate = useNavigate();
  return (
    <div className="w-screen h-screen">
      <nav
        aria-label="네비게이션"
        className="w-full h-[5vh] bg-black flex justify-between items-center px-2"
      >
        <div aria-label="메인">
          <img
            src="/img/cat.jpeg"
            alt="고양이"
            className="w-[3vw] h-[3vh] h-s110 rounded-xl"
            onClick={() => navigate("")}
          />
        </div>
        <div aria-label="로그인">
          <img
            src="/img/dog.jpg"
            alt="강아지"
            className="w-[3vw] h-[3vh] h-s110 rounded-xl"
            onClick={() => navigate("/login")}
          />
        </div>
      </nav>
      <Outlet />
    </div>
  );
}

export default Main;
