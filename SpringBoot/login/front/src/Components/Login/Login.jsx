import axios from "axios";
import { useState } from "react";

function Login() {
  const [user, setUser] = useState("");
  const [value, setValue] = useState("???");
  return (
    <>
      <div className="h-[95vh] w-screen">
        <div className="h-full w-full bg-pink-100 flex justify-center items-center">
          <input type="text" onChange={(e) => setUser(e.target.value)} />
          <button
            onClick={() => {
              axios
                .get(`/user/admin`)
                .then((r) => {
                  console.log(r.data);
                })
                .catch((e) => {
                  console.log(e);
                });
            }}
          >
            {value}
          </button>
        </div>
      </div>
    </>
  );
}

export default Login;
