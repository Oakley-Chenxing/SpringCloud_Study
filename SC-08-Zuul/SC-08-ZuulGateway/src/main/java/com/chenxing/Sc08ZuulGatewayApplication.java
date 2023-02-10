package com.chenxing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy // 激活 API 网关功能
@EnableEurekaClient
public class Sc08ZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sc08ZuulGatewayApplication.class, args);
    }

}
