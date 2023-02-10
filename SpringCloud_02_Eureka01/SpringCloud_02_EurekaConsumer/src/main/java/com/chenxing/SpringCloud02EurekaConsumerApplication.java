package com.chenxing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // 激活客户端
public class SpringCloud02EurekaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloud02EurekaConsumerApplication.class, args);
    }

}
