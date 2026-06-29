package org.atyeti.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
public class AuditConfig {
    @Bean(name = "auditorProvider")
    AuditorAware<String> auditorProvider(){
        return ()-> Optional.of(System.getProperty("user.name"));
    }
}