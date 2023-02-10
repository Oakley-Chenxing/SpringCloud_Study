package com.chenxing.controller;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MyErrorHandlerController
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 10/02/2023 16:41
 */
@RestController
public class MyErrorHandlerController implements ErrorController {
    // 返回异常的请求地址
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public String error(){
        ZuulException e = (ZuulException) RequestContext.getCurrentContext().getThrowable();
        return "全局页面错误 === " + e.getCause().getMessage();
    }
}
