package com.nemsy.nemsy_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// TODO 데이터베이스 연결 후 exclude 제거할 것
@EnableJpaAuditing
@SpringBootApplication(scanBasePackages = {"com.nemsy.nemsy_server.domain.comment_law"})
public class NemsyServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NemsyServerApplication.class, args);
    }

}