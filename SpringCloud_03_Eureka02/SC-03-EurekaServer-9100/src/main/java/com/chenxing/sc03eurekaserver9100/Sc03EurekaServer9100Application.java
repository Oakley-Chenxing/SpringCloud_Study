package com.chenxing.sc03eurekaserver9100;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // 激活 Eureka 注册中心服务
public class Sc03EurekaServer9100Application {

    public static void main(String[] args) {
        SpringApplication.run(Sc03EurekaServer9100Application.class, args);
    }

}
