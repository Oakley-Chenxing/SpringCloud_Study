package com.chenxing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProvideController
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 10/02/2023 12:22
 */
@RestController
public class ProvideController {
    @RequestMapping("/test")
    public Object test(){
        // String str = null;
        // System.out.println(str.length());
        System.out.println(1 / 0);
        // try {
        //     Thread.sleep(10000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        return "服务提供者提供的信息 Info ！~";
    }
}
