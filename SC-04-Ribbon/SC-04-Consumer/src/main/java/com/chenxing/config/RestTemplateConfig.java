package com.chenxing.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName RestTemplateConfig
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 09/02/2023 16:33
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced
    // 将 RestTemplate 对象放到 Spring 容器中
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    // 根据 Bean 对象的返回值，设置负载均衡策略
    @Bean
    public IRule iRule(){
        // return new RandomRule(); // 设置为随机策略
        return new RoundRobinRule(); // 设置为轮询策略
    }
}
