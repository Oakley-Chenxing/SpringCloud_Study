package com.chenxing.controller;

import com.chenxing.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @ClassName ProviderController
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 09/02/2023 20:37
 */
@RestController
public class ProviderController {
    @RequestMapping("/test00")
    public String test00(){
        return "服务提供者 test00() Info";
    }

    @RequestMapping("/test01")
    public Object test01(){
        return "我是 Provider 返回的一个字符串";
    }

    @RequestMapping("/test02")
    public Object test02(){
        return new User("IT老邪", 17);
    }

    @RequestMapping("/test03")
    public Object test03(){
        ArrayList<User> userList = new ArrayList<>();

        userList.add(new User("IT老邪", 17));
        userList.add(new User("IT小邪", 16));
        userList.add(new User("IT小肆", 15));

        return userList;
    }

    @RequestMapping("/test04")
    public Object test04(String name, Integer age){
        return new User(name, age);
    }

    @RequestMapping("/test05")
    public Object test05(){
        return new User("IT小邪", 13);
    }

    @PostMapping("/test06")
    public void test06(User user){
        System.out.println(user.getName() + " 被成功插入了！~");
    }

    @PutMapping("/test07")
    public void test07(User user){
        System.out.println(user.getName() + " 被成功修改了！~");
    }

    @DeleteMapping("/test08")
    public void test08(User user){
        System.out.println(user.getName() + " 被成功删除了！~");
    }
}
