package com.server.login.domain.user.repository;

import com.server.login.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByAccount(String account);
}
