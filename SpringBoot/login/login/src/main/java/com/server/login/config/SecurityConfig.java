package com.server.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            // Swagger UI 접근 허용
            .antMatchers("/swagger-ui.html", "/swagger-ui/**", "/v2/api-docs", "/v2/api-docs/**").permitAll()
            // "/user/**" 패턴에 대해서는 인증이 필요
            //.antMatchers("/user/**").authenticated()
             // 나머지 요청에 대해서는 접근 허용
            .anyRequest().permitAll()
            .and()

        /*// 폼 기반 로그인을 활성화하고, 로그인 페이지는 "/login"으로 설정합니다.
        .formLogin()
            .loginPage("/user/login") // 사용자 정의 로그인 페이지 경로
            .permitAll() // 로그인 페이지에는 모든 사용자에게 접근을 허용합니다.
            .defaultSuccessUrl("/home") // 로그인 성공 시 리다이렉트할 경로를 지정합니다.
            .and()

        .logout()
            .permitAll()
            .and()*/
        .csrf().disable(); // CSRF 보호 비활성화 (Swagger UI를 사용할 때 편의를 위해)
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
