import axios from "axios";
import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";

// const fetchAccessToken = async () => {
//   const accessToken = localStorage.getItem('accessToken');

//   if (accessToken != null) {
//     // 토큰 만료상태 확인
//     const decode = jwtDecode(accessToken);
//     const nowDate = new Date().getTime() / 1000;
//     // 토큰 만료시간이 지났다면
//     if (decode.exp < nowDate) {
//       // 리프레쉬 토큰 발급 서버 요청
//       const { data } = await axios({
//         url: `${process.env.REACT_APP_API_URL}refresh`,
//         method: 'POST',
//         headers: {
//           'x-refresh-token': localStorage.getItem('refreshToken')
//         }
//       });
//       // 엑세스 토큰 갱신 로컬스토리지 넣어주기
//       localStorage.setItem('accessToken', data.data.accessToken);
//       return data.data.accessToken;
//     } else {
//       // 유효기간이 싱싱할때
//       return localStorage.getItem('accessToken');
//     }
//   } else {
//     // 토큰이 null 일때
//     return;
//   }
// };

export const Api = createApi({
  reducerPath: "Api",
  tagTypes: ["UserApi"],
  baseQuery: fetchBaseQuery({
    baseUrl: process.env.REACT_APP_API_URL,
    prepareHeaders: async (headers) => {
      // By default, if we have a token in the store, let's use that for authenticated requests
      // const token = await fetchAccessToken();
      // if (token) {
      //   headers.set('authorization', `Bearer ${token}`);
      // }
      return headers;
    },
  }),

  endpoints: (builder) => ({
    // ------------- 유저 -------------
    // 1. 나의 로그인 정보
    // getUsersInfo: builder.query({
    //   query: () => '/users',
    //   providesTags: (result, error, arg) => {
    //     return [{ type: 'UserApi' }];
    //   }
    // }),
    // 1. 알람 상태 변경
    // postAlarm: builder.mutation({
    //   query: (data) => {
    //     return {
    //       url: '/alarm/change',
    //       method: 'POST',
    //       body: {
    //         alarm_row_id: data
    //       }
    //     };
    //   },
    //   invalidatesTags: (result, error, arg) => [{ type: 'Alarm' }]
    // }),
  }),
});

// 임시저장
export const {
  // ------------- 유저 -------------
  // useGetAdminUserCheckQuery,
  // useLazyGetAdminUserCheckQuery
} = Api;
