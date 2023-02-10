package com.chenxing.controller;

import com.chenxing.service.TestService;
import domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ConsumerController
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 10/02/2023 15:32
 */
@RestController
public class ConsumerController {
    @Resource
    private TestService testService;

    @RequestMapping("/test01")
    public Object test01(){
        String info = testService.test01();

        return "服务消费者 test01 正在消费 ====> " + info;
    }

    @RequestMapping("/test02")
    public Object test02(){
        User user = testService.test02();

        System.out.println(user.getClass());
        System.out.println(user.getName() + " <==> " + user.getAge());

        return "服务消费者 test02 正在消费 ====> " + user;
    }

    @RequestMapping("/test03")
    public Object test03(){
        List<User> userList = testService.test03();

        for (User user : userList) {
            System.out.println(user.getClass() + " : " + user);
        }

        return "服务消费者 test03 正在消费 ====> " + userList;
    }

    @RequestMapping("/test04")
    public Object test04(){
        User user = testService.test04("IT老邪", 17);
        return "服务消费者 test04 正在消费 ====> " + user;
    }

    @RequestMapping("/test05")
    public Object test05(){
        User user = testService.test05(new User("IT老邪", 17));
        return "服务消费者 test05 正在消费 ====> " + user;
    }


}

