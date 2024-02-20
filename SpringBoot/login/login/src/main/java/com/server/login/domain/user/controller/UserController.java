package com.server.login.domain.user.controller;


import com.server.login.domain.user.dto.LoginReqDto;
import com.server.login.domain.user.dto.SignupReqDto;
import com.server.login.domain.user.dto.UserResDto;
import com.server.login.domain.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping("/singup")
    @ApiOperation(value = "회원가입", notes = "")
    public UserResDto sinup(@RequestBody SignupReqDto signupReqDto) {
        UserResDto user = userService.signup(signupReqDto);
        return user;
    }

    @GetMapping("/{account}")
    @ApiOperation(value = "유저 조회")
    public UserResDto search(@PathVariable String account) {
        UserResDto user = userService.search(account);
        return user;
    }

    @PostMapping("/login")
    @ApiOperation(value = "로그인", notes = "")
    public UserResDto sinup(@RequestBody LoginReqDto loginReqDto) {
        UserResDto user = userService.login(loginReqDto);
        return user;
    }
}
