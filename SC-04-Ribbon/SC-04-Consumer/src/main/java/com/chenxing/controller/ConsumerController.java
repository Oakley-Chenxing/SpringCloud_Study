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
 * @date ：Created in 09/02/2023 16:33
 */
@RestController
public class ConsumerController {
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/test")
    public String test(){
        String URL = "http://SC-04-Provider/test";

        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);

        String info = response.getBody();

        return "Ribbon 服务消费者正在消费 ===> " + info;
    }
}
