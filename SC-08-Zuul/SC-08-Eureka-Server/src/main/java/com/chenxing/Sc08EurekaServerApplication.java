package com.chenxing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Sc08EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sc08EurekaServerApplication.class, args);
    }

}
