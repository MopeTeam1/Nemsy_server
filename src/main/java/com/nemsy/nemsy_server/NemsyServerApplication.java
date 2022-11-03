package com.nemsy.nemsy_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class NemsyServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NemsyServerApplication.class, args);
    }

}
