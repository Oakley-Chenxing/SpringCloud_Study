package com.chenxing.springcloud_01_consumer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName ConsumerController
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 08/02/2023 18:27
 */
@RestController
public class ConsumerController {
    // 用于远程访问,注入之前需要先定义这个对象到 Spring 容器中，详见 config.RestTemplateConfig
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/test")
    public String test(){

        String URL = "http://localhost:8081/test";
        // URL : 请求地址
        // String.class : 请求响应返回类型
        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);

        // 通过得到的响应对象，获取相应的一些信息
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusCodeValue());
        System.out.println(response.getHeaders());

        // 获取请求响应的响应体
        Object body = response.getBody();

        return "SpringCloud的服务消费者 ---> " + body;
    }
}
