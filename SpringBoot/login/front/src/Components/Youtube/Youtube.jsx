import axios from "axios";
import { useRef, useState } from "react";
import YouTube from "react-youtube";
import css from "./youtube.module.css";
import { useNavigate } from "react-router-dom";

function Youtube() {
  const searchRef = useRef();
  const [videoId, setVideoId] = useState("OtVwklG6cRE");
  const [videoType, setVideoType] = useState("video");
  const [sideMenuState, setSideMenuState] = useState(false);
  const [searchDatas, setSearchDatas] = useState(null);
  const navigate = useNavigate();

  const opts = {
    height: window.innerHeight - (window.innerHeight / 100) * 5,
    width: window.innerWidth,

    playerVars: {
      autoplay: 1,
    },
  };
  const _onReady = (event) => {
    // event.target.pauseVideo();
    event.target.playVideo(1);
  };

  const search = async () => {
    setSideMenuState(false);
    const { data } = await axios.get(
      `${process.env.REACT_APP_YOUTUBE_URL}/search?part=snippet&maxResults=25&q=${searchRef.current.value}type=${videoType}&key=${process.env.REACT_APP_YOUTUBE_API}`
    );
    console.log();
    setVideoId(data.items[0].id["videoId"]);
    setVideoType(data.items[0].id["kind"].split("#")[1]);
    setSearchDatas(data.items);
  };

  const VideoList = () => {
    return (
      <div className="flex flex-col justify-start items-center text-white w-full h-full space-y-3 overflow-y-auto">
        {searchDatas.map((data) => {
          return (
            <>
              <div
                className="flex justify-start items-center w-[95%] h-full space-x-2 bg-neutral-900 cursor-pointer border-2 border-white/5 hover:border-white/50"
                onClick={() => {
                  setVideoId(data.id.videoId);
                  setVideoType(data.id.kind.split("#")[1]);
                }}
              >
                <img
                  src={`${data.snippet.thumbnails.default.url}`}
                  alt={`${data.snippet.title}`}
                />
                <div className="truncate">{data.snippet.title}</div>
              </div>
            </>
          );
        })}
      </div>
    );
  };
  const SideMenu = () => {
    return (
      <>
        <div
          className={`absolute right-0 top-[5vh] bg-black w-[15vw] h-[95vh] rounded-es-md ${
            sideMenuState && css.sideMenu
          }`}
        >
          <div className="w-full h-full flex flex-col justify-start text-white ">
            <VideoList />
          </div>
        </div>
      </>
    );
  };
  return (
    <>
      {sideMenuState && <SideMenu />}
      <div className="w-screen h-[5vh] flex justify-end items-center bg-black text-lg border-b-2 border-b-gray-600">
        <div
          aria-label="메인"
          className="flex justify-start items-center w-1/3 h-full"
        >
          <img
            src="/img/cat.jpeg"
            alt="고양이"
            className="w-[3vw] h-full p-2 h-s110 rounded-xl"
            onClick={() => navigate("/")}
          />
        </div>
        <div className="flex justify-center items-center w-1/3 space-x-2">
          <input
            ref={searchRef}
            type="text"
            className="text-center"
            autoFocus
            onKeyPress={(e) => {
              if (e.key === "Enter") {
                search();
              }
            }}
          />
          <button className="px-2 h-s110 text-white" onClick={search}>
            검색
          </button>
        </div>
        <div className="flex justify-end items-center text-white w-1/3 pr-[1.8vw]">
          <button
            className="h-s110"
            onClick={() => {
              setSideMenuState((state) => !state);
            }}
          >
            List
          </button>
        </div>
      </div>
      <YouTube videoId={videoId} opts={opts} onReady={_onReady} />
    </>
  );
}

export default Youtube;
