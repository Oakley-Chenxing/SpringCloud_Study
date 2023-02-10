package com.chenxing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients // 激活 Feign 声明式消费
public class Sc07ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sc07ConsumerApplication.class, args);
    }

}
