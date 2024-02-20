import { configureStore, createSlice } from "@reduxjs/toolkit";
import { Api } from "./api";

// 유저 권한 코드
const authCode = createSlice({
  name: "authCode",
  initialState: 3,
  reducers: {
    changeAuthCode(state, action) {
      return (state = action.payload);
    },
  },
});

export default configureStore({
  reducer: {
    // ------------- 유저 -------------
    authCode: authCode.reducer,
  },
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware().concat(Api.middleware),
});

// ------------- 유저 -------------
export const { changeAuthCode } = authCode.actions;
