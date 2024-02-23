package com.server.login.domain.user.controller;


import com.server.login.common.code.dto.ResultDto;
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

        return ResponseEntity.ok()
                .body(user);
    }

    @PostMapping("/login")
    @ApiOperation(value = "로그인", notes = "")
    public ResponseEntity<ResultDto<UserResDto>> login(@RequestBody LoginReqDto loginReqDto) {
        System.out.println("로그인 요청 시작");
        UserResDto user = userService.login(loginReqDto);

        return ResponseEntity.ok()
                .body(ResultDto.of(user));
    }

    @GetMapping("/check")
    @ApiOperation(value = "세션 확인")
    public String check() {
        System.out.println("시작");
        return userService.check();
    }

}
