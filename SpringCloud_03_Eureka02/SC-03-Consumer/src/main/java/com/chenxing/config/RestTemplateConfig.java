package com.chenxing.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName RestTemplateConfig
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 09/02/2023 14:12
 */
@Configuration
public class RestTemplateConfig {
    // 把 RestTemplate 对象放到 Spring 容器中
    @Bean
    @LoadBalanced // restTemplate 需要 使用 Ribbon 的负载均衡，作为支持。
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
