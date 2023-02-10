package com.chenxing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProviderController
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 09/02/2023 16:28
 */
@RestController
public class ProviderController {
    @RequestMapping("/test")
    public String test(){
        return "Ribbon 负载均衡 服务提供者 --- 8082";
    }
}
