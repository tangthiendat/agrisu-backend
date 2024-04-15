package com.ttdat.agrisubackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.ttdat.agrisubackend.repository")
@MapperScan("com.ttdat.agrisubackend.repository.mapper")
@EntityScan("com.ttdat.agrisubackend.entity")
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AgrisuBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgrisuBackendApplication.class, args);
    }

}
