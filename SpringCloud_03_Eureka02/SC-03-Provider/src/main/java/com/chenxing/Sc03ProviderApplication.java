package com.chenxing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // 激活注册中心客户端
public class Sc03ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sc03ProviderApplication.class, args);
    }

}
