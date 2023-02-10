package com.chenxing.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName MyHystrixCommand
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 10/02/2023 13:14
 */
public class MyHystrixCommand extends HystrixCommand<String> {
    // 固定写法
    private String url;
    private RestTemplate restTemplate;

    // 定义一个构造方法，通过参数初始化设置
    public MyHystrixCommand(String url, RestTemplate restTemplate){
        this(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")));
        this.url = url;
        this.restTemplate = restTemplate;
    }
    // =========== 以上为固定写法

    // 为熔断器设置对象
    protected MyHystrixCommand(Setter setter) {
        super(setter);
    }

    @Override
    protected String run() throws Exception {
        return restTemplate.getForObject(url, String.class);
    }

    @Override
    protected String getFallback() {
        // return super.getFallback();
        return "自定义熔断器类！~完啦！~ …… 芭比Q啦！~";
    }
}
