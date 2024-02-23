package com.server.login.domain.user.service;

import com.server.login.domain.user.dto.LoginReqDto;
import com.server.login.domain.user.dto.SignupReqDto;
import com.server.login.domain.user.dto.UserResDto;
import com.server.login.domain.user.entity.UserEntity;
import com.server.login.domain.user.repository.UserRepository;
import com.server.login.exception.CustomException;
import com.server.login.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final HttpServletRequest request;

    // 회원가입
    @Transactional
    public UserResDto signup(SignupReqDto signupReqDto) {
        UserEntity user = UserEntity.builder()
                .account(signupReqDto.getAccount())
                .password(passwordEncoder.encode(signupReqDto.getPassword()))
                .build();
        userRepository.save(user);

        return UserResDto.fromEntity(user);
    }

    // 유저조회
    @Transactional
    public UserResDto search(String account) {
        if (getUserAccount(account) == null) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }
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
        if (user == null) throw new RuntimeException("다시 확인해보세요!");
        // DB에서 가져온 사용자의 암호화된 비밀번호와 입력받은 비밀번호를 비교합니다.
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("다시 확인해보세요!");
        } else {
            HttpSession session = request.getSession(); // 현재 요청과 관련된 세션을 가져오거나 생성하는 메서드
            session.setAttribute("loginUser", user); // loginUser라는 이름으로 user 객체를 세션에 저장하여 사용자와 관련된 정보 및 식별이 가능.
        }

        // 로그인 성공 시 사용자 정보를 반환합니다.
        return UserResDto.fromEntity(user);
    }

    @Transactional
    public String check() {
        System.out.println("서비스");
        HttpSession session = request.getSession(false);
        System.out.println(session);
        if (session == null) return "세션 없다🎮";
        else return "세션 있다😉";
    }


    public UserEntity getUserAccount(String account) {
        return userRepository.findByAccount(account);
    }
}