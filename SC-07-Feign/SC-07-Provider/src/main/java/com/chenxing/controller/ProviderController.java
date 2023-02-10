package com.chenxing.controller;

import com.chenxing.domain.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ProviderController
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 10/02/2023 15:24
 */
@RestController
public class ProviderController {
    @RequestMapping("/test01")
    public Object test01(){
        System.out.println(1 / 0);
        return "服务提供者 test01 info";
    }

    @RequestMapping("/test02")
    public User test02(){
        return new User("IT老邪", 17);
    }

    @RequestMapping("/test03")
    public List test03(){
        ArrayList<User> userList = new ArrayList<>();

        userList.add(new User("IT老邪", 17));
        userList.add(new User("IT老秦", 17));
        userList.add(new User("IT小邪", 16));
        userList.add(new User("IT小肆", 15));

        return userList;
    }

    @RequestMapping("/test04")
    public User test04(String name, Integer age){
        return new User(name, age);
    }

    @RequestMapping("/test05")
    public User test05(@RequestBody User user){
        user.setName(user.getName() + "Provider");
        return user;
    }
}
