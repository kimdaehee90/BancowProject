package com.bancow.process.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // 내 서버가 응답을 할때 json을 자바스크립트에서 처리할 수 있게 할지를 설정
//        config.addAllowedOrigin("http://localhost:3000"); // 모든 ip에 응답을 허용
        config.addAllowedOriginPattern("*");
        config.addAllowedHeader("*"); // 모든 header에 응답을 허용
        config.addAllowedMethod("*"); // 모든 post,get 등 모든 method에 요청을 허용
        config.addExposedHeader("Authorization"); // 토큰이 파싱되도록 header에 Authorization 노출

        source.registerCorsConfiguration("/**", config); // /**로 들어오는 모든 요청은 config가 설정되어 있는 필터를 타라
        return new CorsFilter(source);
    }
}
