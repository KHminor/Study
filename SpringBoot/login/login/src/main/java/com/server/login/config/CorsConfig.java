package com.server.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 모든 경로에 대해 CORS 구성을 적용.
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:8080", "http://localhost:3000")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .exposedHeaders("Access-Control-Allow-Headers, Authorization, X-Refresh-Token")
            .allowCredentials(true);
    }
}
