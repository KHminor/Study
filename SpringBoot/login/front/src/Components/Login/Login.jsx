import axios from "axios";
import { useRef, useState } from "react";

function Login() {
  const id = useRef();
  const pwd = useRef();
  const account = useRef();
  const submit = async (event) => {
    event.preventDefault();
    axios
      .post("/user/login", {
        account: id.current.value,
        password: pwd.current.value,
      })
      .then((r) => {
        console.log(r);
      })
      .catch((e) => {
        alert(e);
      });
  };
  return (
    <>
      <div className="h-[95vh] w-screen">
        <div className="h-full w-full bg-pink-100 flex flex-col justify-center items-center">
          <form
            method="post"
            className="flex flex-col items-end"
            onSubmit={submit}
          >
            <div className="m-4 ml-0">
              <label className="mr-8" htmlFor="id">
                아이디
              </label>
              <input type="text" name="id" id="id" ref={id} />
            </div>
            <div className="m-4 ml-0">
              <label className="mr-4" htmlFor="pwd">
                비밀번호
              </label>
              <input type="password" name="pwd" id="pwd" ref={pwd} />
            </div>
            <input
              type="submit"
              value="submit"
              className="px-2 bg-white h-s110 rounded-lg mr-4"
            />
          </form>

          <button
            onClick={() => {
              const sessionId = sessionStorage.getItem("sessionId");
              alert(sessionId);
              axios
                .get("/user/check")
                .then((r) => {
                  console.log(r);
                })
                .catch((e) => {
                  console.log(e);
                });
            }}
            className="bg-green-200"
          >
            탈퇴
          </button>

          <div>
            <input type="text" ref={account} />
            <button
              className="bg-yellow-200"
              onClick={() => {
                axios
                  .get(`/user/${account.current.value}`)
                  .then((r) => {
                    console.log(r);
                  })
                  .catch((e) => {
                    console.log(e);
                  });
              }}
            >
              조회
            </button>
          </div>
        </div>
      </div>
    </>
  );
}

export default Login;
