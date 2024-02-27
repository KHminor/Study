import { Outlet } from "react-router-dom";
import Nav from "./Nav";
import { useEffect, useState } from "react";
import css from "./test.module.css";
function Layout() {
  const [navMenu, setNavMenu] = useState(false);
  const ScrollMenu = () => {
    return (
      <>
        <div className="fixed top-[5vh] right-0 flex justify-end items-start w-full h-full  text-white text-xl">
          <div
            className={`flex flex-col justify-center items-center w-[16rem] h-[16rem] ${css.myScroll} bg-black rounded-es-md space-y-6`}
          >
            <div className="w-4/5 h-[25%] bg-red-400 flex justify-center items-center">
              유저 검색
            </div>
            <div className="w-4/5 h-[25%] bg-red-400 flex justify-center items-center">
              회원 탈퇴
            </div>
          </div>
        </div>
      </>
    );
  };
  return (
    <>
      <div className="w-full h-full relative">
        <Nav setNavMenu={setNavMenu} />
        {navMenu && <ScrollMenu />}
        <Outlet />
      </div>
    </>
  );
}

export default Layout;
