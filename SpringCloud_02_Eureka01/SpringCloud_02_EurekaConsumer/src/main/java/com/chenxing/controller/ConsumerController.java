package com.chenxing.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName ConsumerController
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 09/02/2023 10:38
 */
@RestController
@ResponseBody
public class ConsumerController {
    // 用于远程访问,注入之前需要先定义这个对象到 Spring 容器中，详见 config.RestTemplateConfig
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/test")
    public String test(){

        // 根据注册中心的服务名进行访问
        // 注意：
        // 使用注册中心服务名访问是，服务名不区分大小写，一般Copy就行
        // 使用注册中心服务名访问时，必须在 RestTemplate 中添加 Ribbon 负载均衡支持
        String URL = "http://SPRINGCLOUD_02_EUREKAPROVIDER/test";
        // URL : 请求地址
        // String.class : 请求响应返回类型
        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusCodeValue());
        System.out.println(response.getHeaders());

        String info = response.getBody();

        return "使用 Eureka 注册中心 SpringCloud 的服务消费者 ---> " + info;
    }
}
