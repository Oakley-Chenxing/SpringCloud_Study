package com.chenxing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProviderController
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 10/02/2023 16:19
 */
@RestController
public class ProviderController {
    @RequestMapping("/test01")
    public String test01(){
        return "Zuul 服务提供者提供的数据 info";
    }

    @RequestMapping("/test02")
    public String test02(){
        return "Zuul 服务提供者 test02 提供的数据 info";
    }
}
