package com.chenxing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // 激活注册中心客户端
public class Sc04Provider8082Application {

    public static void main(String[] args) {
        SpringApplication.run(Sc04Provider8082Application.class, args);
    }

}
