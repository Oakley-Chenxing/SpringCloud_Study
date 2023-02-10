package com.chenxing.hystrix;

import com.chenxing.service.TestService;
import domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName MyHystrix
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 10/02/2023 15:31
 */
@Component
public class MyHystrix implements TestService {
    @Override
    public String test01() {
        return "test01 完啦！~芭比Q啦！~";
    }

    @Override
    public User test02() {
        return null;
    }

    @Override
    public List<User> test03() {
        return null;
    }

    @Override
    public User test04(String name, Integer age) {
        return null;
    }

    @Override
    public User test05(User user) {
        return null;
    }
}