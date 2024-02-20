package com.server.login.domain.user.service;

import com.server.login.domain.user.dto.LoginReqDto;
import com.server.login.domain.user.dto.SignupReqDto;
import com.server.login.domain.user.dto.UserResDto;
import com.server.login.domain.user.entity.UserEntity;
import com.server.login.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // 회원가입
    @Transactional
    public UserResDto signup(SignupReqDto signupReqDto) {
        UserEntity user = UserEntity.builder()
                .account(signupReqDto.getAccount())
                .password(passwordEncoder.encode(signupReqDto.getPassword()))
                .account(signupReqDto.getAccount())
                .build();
        userRepository.save(user);

        return UserResDto.fromEntity(user);
    }

    // 유저조회
    @Transactional
    public UserResDto search(String account) {
        UserEntity user = userRepository.findByAccount(account);
        return UserResDto.fromEntity(user);
    }

    // 로그인
    @Transactional
    public UserResDto login(LoginReqDto loginReqDto) {
        // 로그인 요청 DTO에서 아이디를 가져옵니다.
        String account = loginReqDto.getAccount();
        // 로그인 요청 DTO에서 비밀번호를 가져옵니다.
        String password = loginReqDto.getPassword();

        // userRepository에서 아이디로 사용자를 조회합니다.
        UserEntity user = userRepository.findByAccount(account);

        // DB에서 가져온 사용자의 암호화된 비밀번호와 입력받은 비밀번호를 비교합니다.
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("다시 확인해보세요!");
        }

        // 로그인 성공 시 사용자 정보를 반환합니다.
        return UserResDto.fromEntity(user);
    }
}