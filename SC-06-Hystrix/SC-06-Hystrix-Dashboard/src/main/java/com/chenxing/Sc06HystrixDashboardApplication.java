package com.chenxing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard // 激活仪表盘
public class Sc06HystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sc06HystrixDashboardApplication.class, args);
    }

}
