package com.chenxing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProviderController
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 09/02/2023 14:07
 */
@RestController
public class ProviderController {
    @RequestMapping("/test")
    public String test(){
        return "使用了 Eureka 注册中心的服务提供者提供的信息 Info (SC-03) ！~";
    }
}
