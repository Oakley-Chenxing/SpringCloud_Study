package com.chenxing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Sc06ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sc06ProviderApplication.class, args);
    }

}
