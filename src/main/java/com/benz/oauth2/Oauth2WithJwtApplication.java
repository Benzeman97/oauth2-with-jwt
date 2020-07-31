package com.benz.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
public class Oauth2WithJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2WithJwtApplication.class, args);
    }

}
