package com.bancow.process.security.config.jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.bancow.process.repository")
public class AuditConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditConfigImpl();

    }
}
