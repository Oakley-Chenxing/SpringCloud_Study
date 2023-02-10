package com.chenxing.service;

import com.chenxing.hystrix.MyHystrix;
import domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName TestService
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 10/02/2023 15:30
 */
@FeignClient(name = "SC-07-Provider", fallback = MyHystrix.class)
public interface TestService {
    @RequestMapping("/test01")
        // 此处的返回值类型需要根据服务消费者具体的返回值类型而定，直接写 Object 的话容易出现问题
    String test01();

    @RequestMapping("/test02")
    User test02();

    @RequestMapping("/test03")
    List<User> test03();

    @RequestMapping("/test04")
    User test04(@RequestParam("name") String name, @RequestParam("age") Integer age);

    @RequestMapping("/test05")
    User test05(@RequestBody User user);
}

