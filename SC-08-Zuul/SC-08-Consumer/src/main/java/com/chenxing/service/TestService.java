package com.chenxing.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName TestService
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 10/02/2023 16:26
 */
@FeignClient(name = "SC-08-ZuulGateway/api-zuul")

public interface TestService {
    @RequestMapping("/test01?token=9527")
    String test01();
}
