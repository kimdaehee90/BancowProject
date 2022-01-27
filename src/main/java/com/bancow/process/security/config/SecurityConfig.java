package com.bancow.process.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CorsFilter corsFilter;
    //BCryptPasswordEncoder Bean 등록
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
//        http.httpBasic().disable()
//                    .csrf().disable();
        http.csrf().disable();
        http.headers().frameOptions().disable();
        // 세션을 사용하지 않겠다.
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(corsFilter)
                .formLogin().disable() // 폼 로그인 형태 안씀
                .httpBasic().disable() // httpBasic의 방식 안씀
                .authorizeRequests()
                .antMatchers("/api/login/**").permitAll() // /api/login/ 이하의 주소로 호출되는 api는 모두 허용
                .anyRequest().authenticated(); // 위의 주소로 호출하는 경우 이외의 모든 호출시에 인증 필요
    }
}
