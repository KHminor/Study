package com.server.login.domain.user.controller;


import com.server.login.domain.user.dto.LoginReqDto;
import com.server.login.domain.user.dto.SignupReqDto;
import com.server.login.domain.user.dto.UserResDto;
import com.server.login.domain.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpHeaders;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping("/singup")
    @ApiOperation(value = "회원가입", notes = "")
    public UserResDto signup(@RequestBody SignupReqDto signupReqDto) {
        UserResDto user = userService.signup(signupReqDto);
        return user;
    }

    @GetMapping("/{account}")
    @ApiOperation(value = "유저 조회")
    public ResponseEntity<UserResDto> search(HttpServletRequest request, @PathVariable String account) {
        System.out.println("조회 요청 시작");
        UserResDto user = userService.search(account);

        // 로그인 성공 시 세션에 사용자 정보 저장
        HttpSession session = request.getSession();
        session.setAttribute("loginUser", user);
        System.out.println(session);

        // 세션 ID를 클라이언트에게 응답
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("sessionId", session.getId());
        System.out.println(responseHeaders);
        System.out.println("조회 요청 끝");

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(user);
    }

    @PostMapping("/login")
    @ApiOperation(value = "로그인", notes = "")
    public ResponseEntity<UserResDto> login(@RequestBody LoginReqDto loginReqDto) {
        System.out.println("로그인 요청 시작");
        UserResDto user = userService.login(loginReqDto);

        return ResponseEntity.ok()
                .body(user);
    }

    @GetMapping("/check")
    @ApiOperation(value = "세션 확인")
    public String check() {
        System.out.println("시작");
        return userService.check();
    }

}
