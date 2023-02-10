package com.chenxing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // 激活 Eureka 客户端

public class Sc03ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sc03ConsumerApplication.class, args);
    }

}
