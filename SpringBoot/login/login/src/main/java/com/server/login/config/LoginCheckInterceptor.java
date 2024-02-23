package com.server.login.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI(); // 현재 요청 URI
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loginUser") == null) {
            log.info("미인증 사용자 요청");
//            response.sendRedirect("/login?redirectURL=" + requestURI);
            return false;
        }return true;
    }
}
