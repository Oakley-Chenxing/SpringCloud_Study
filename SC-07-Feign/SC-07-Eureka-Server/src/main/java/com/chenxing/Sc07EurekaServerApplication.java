package com.chenxing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Sc07EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sc07EurekaServerApplication.class, args);
    }

}
