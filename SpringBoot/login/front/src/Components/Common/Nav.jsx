import { useEffect } from "react";
import { useNavigate } from "react-router-dom";

function Nav({ setNavMenu }) {
  const navigate = useNavigate();

  return (
    <nav
      aria-label="네비게이션"
      className="top-0 sticky w-full h-[5vh] bg-black flex justify-between items-center"
    >
      <div aria-label="메인" className="w-[6rem] h-4/5">
        <img
          src="/img/cat.jpeg"
          alt="고양이"
          className="w-full h-full h-s110 rounded-xl"
          onClick={() => navigate("")}
        />
      </div>
      <div className="flex justify-around items-center w-[16rem] h-4/5 space-x-12">
        <div className="w-1/3 h-full h-s110">
          <img
            className="w-full h-full rounded-xl"
            src="/img/karina.jpg"
            alt=""
            onClick={() => {
              setNavMenu((navMenu) => !navMenu);
            }}
          />
        </div>
        <div aria-label="로그인" className="w-1/3 h-full">
          <img
            src="/img/dog.jpg"
            alt="강아지"
            className="w-full h-full h-s110 rounded-xl"
            onClick={() => navigate("/login")}
          />
        </div>
      </div>
    </nav>
  );
}

export default Nav;
