package com.chenxing.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName ConsumerController
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 09/02/2023 14:11
 */
@RestController
public class ConsumerController {
    // 注入一个 restTemplate 对象，具体的配置详见 config.RestTemplateConfig
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/test")
    public String test(){
        // 定义服务的消费地址（服务提供者的地址）- 直连方式
        // String URL = "http://localhost:8081/test";
        // 定义服务的消费地址（服务提供者的地址）- 使用注册中心发现的服务
        String URL = "http://SC-03-PROVIDER/test";

        // 通过 RestTemplate 对象发送 一个 Get 请求
        // 第一个参数是 服务提供者的地址
        // 第二个参数是 服务提供者的返回值类型 class 对象
        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);

        // 通过得到的响应对象，获取相应的一些信息
        System.out.println(response.getHeaders());
        System.out.println(response.getStatusCodeValue());
        System.out.println(response.getStatusCode());

        // 获取请求响应的响应体
        String info = response.getBody();

        return "SpringCloud 使用 Eureka 注册中的服务消费者 正在消费 ===> " + info;
    }
}
