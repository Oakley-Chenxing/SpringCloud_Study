package com.chenxing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // 激活注册中心服务
public class SpringCloud02EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloud02EurekaServerApplication.class, args);
    }

}
