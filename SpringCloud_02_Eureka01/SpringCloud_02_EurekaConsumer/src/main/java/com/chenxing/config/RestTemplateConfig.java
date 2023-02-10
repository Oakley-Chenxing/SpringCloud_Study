package com.chenxing.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName RestTemplateConfig
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 09/02/2023 10:22
 */
@Configuration
public class RestTemplateConfig {
    // 如果通过注册中心访问服务，必须使用 LoadBalanced 注解，添加 Ribbon 负载均衡支持
    @Bean
    @LoadBalanced // 交集当前的restTemplate继承 Ribbon 的负载均衡，默认轮询

    public RestTemplate restTemplate(){

        return new RestTemplate();
    }
}
