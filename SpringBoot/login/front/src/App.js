import React from "react";
import { Route, Routes } from "react-router-dom";
import "./App.css";
import Login from "./Components/Login/Login";
import Main from "./Components/Main/Main";

function App() {
  return (
    <>
      <Routes>
        <Route path="" element={<Main />}>
          <Route path="/login" element={<Login />} />
        </Route>
      </Routes>
    </>
  );
}

export default App;
