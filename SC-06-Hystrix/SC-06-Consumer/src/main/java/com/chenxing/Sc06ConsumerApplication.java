package com.chenxing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker // 表示激活 hystrix 熔断
public class Sc06ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sc06ConsumerApplication.class, args);
    }

}
