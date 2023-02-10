package com.chenxing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // 激活注册中心服务

public class Sc04EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sc04EurekaServerApplication.class, args);
    }

}
