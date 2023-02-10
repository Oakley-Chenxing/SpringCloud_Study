package com.chenxing.springcloud_01_provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProviderController
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 08/02/2023 18:24
 */
@RestController
public class ProviderController {
    @RequestMapping("/test")
    public String test(){
        return "SpringCloud 的服务提供者";
    }
}
