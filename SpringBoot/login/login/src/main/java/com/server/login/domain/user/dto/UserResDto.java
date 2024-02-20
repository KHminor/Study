package com.server.login.domain.user.dto;

import com.server.login.domain.user.entity.UserEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResDto {
    private String account;
    private String password;
    private String nickname;

    public static UserResDto fromEntity(UserEntity user) {
        return UserResDto.builder()
                .account(user.getAccount())
                .password(user.getPassword())
                .nickname(user.getNickname())
                .build();
    }
}
