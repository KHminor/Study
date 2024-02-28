import React from "react";
import { Route, Routes } from "react-router-dom";
import "./App.css";
import Login from "./Components/Login/Login";
import Main from "./Components/Main/Main";
import Layout from "./Components/Common/Layout";
import Youtube from "./Components/Youtube/Youtube";

function App() {
  return (
    <>
      <Routes>
        <Route path="" element={<Layout />}>
          <Route path="" element={<Main />} />
          <Route path="/login" element={<Login />} />
        </Route>
        <Route path="/youtube" element={<Youtube />} />
      </Routes>
    </>
  );
}

export default App;
