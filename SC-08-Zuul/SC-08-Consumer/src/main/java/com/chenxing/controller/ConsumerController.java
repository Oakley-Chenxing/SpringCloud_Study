package com.chenxing.controller;


import com.chenxing.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName ConsumerController
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 10/02/2023 16:23
 */
@RestController
public class ConsumerController {
    @Resource
    private TestService testService;

    @RequestMapping("/test01")
    public String test01(){
        String info = testService.test01();
        return "服务的消费者 test01 正在消费 =>>> " + info;
    }
}
