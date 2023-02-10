package com.chenxing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ZuulGatewayController
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 10/02/2023 16:40
 */
@RestController
public class ZuulGatewayController {
    @RequestMapping("/api/local")
    public String local(){
        return "API网关的内置控制器方法";
    }
}
