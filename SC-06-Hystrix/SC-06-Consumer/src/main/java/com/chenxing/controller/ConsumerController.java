package com.chenxing.controller;

import com.chenxing.hystrix.MyHystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName ConsumerController
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 10/02/2023 13:06
 */
@RestController
public class ConsumerController {
    @Resource
    private RestTemplate restTemplate;

    public String error(Throwable throwable){
        // 如果看到了 HttpServerErrorException$InternalServerError
        // 就表示是远程服务出现了问题，并且不是超时问题

        // 如果看到了 HystrixTimeoutException
        // 就表示远程服务出现了延迟问题（超时了）
        System.out.println(throwable.getClass());
        System.out.println(throwable.getMessage());
        return "完啦！~……芭比Q啦！~";
    }

    // @HystrixCommand(
    //     fallbackMethod = "error",
    //     commandProperties={
    //             @HystrixProperty(
    //                 name="execution.isolation.thread.timeoutInMilliseconds",
    //                 value="20000"
    //             )
    //     }
    // )
    // 如果消费远程服务的时候出现了问题，也会导致当前的服务调用出现问题
    // 就会执行 fallbackMethod 对用的 毁掉方法，实现服务的降级
    // 用 fallbackMethod 指向的方法，来替换当前要访问的服务
    // @HystrixCommand(fallbackMethod = "error", ignoreExceptions = {NullPointerException.class})
    @HystrixCommand(fallbackMethod = "error")
    @RequestMapping("/test")
    public String test(){
        // 只有消费者本地服务出现异常，才会显示具体的异常信息
        // System.out.println(1 / 0);

        // 在当前服务消费者的控制器中制造一个空指针，看看是否能忽略的了
        // String str = null;
        // System.out.println(str.length());

        String URL = "http://SC-06-Provider/test";

        String info = restTemplate.getForObject(URL, String.class);

        return "Hystrix 消费者正在消费 ====> " + info;
    }

    @RequestMapping("/test01")
    public String test01(){
        String URL = "http://SC-06-Provider/test";

        MyHystrixCommand myHystrixCommand = new MyHystrixCommand(URL, restTemplate);

        String info = myHystrixCommand.execute();

        return "Hystrix 消费者正在消费 ====> " + info;
    }
}
