package com.chenxing.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName AuthFilter
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 10/02/2023 16:42
 */
@Component
public class AuthFilter extends ZuulFilter {
    @Override
    public String filterType() {
        // 指定过滤器
        /**
         * pre:前置
         * post:后置
         * routing:请求路由
         * error:错误、异常
         */
        return "pre";
    }

    @Override
    public int filterOrder() {
        // 过滤器优先级
        // 返回的数值越小，表示优先级越高
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 过滤器开关，true表示开启，false表示关闭
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 过滤的具体动作，做权限的验证

        System.out.println("AuthFilter is running ....");

        System.out.println(1 / 0);
        // 获取请求上下文对象
        RequestContext context = RequestContext.getCurrentContext();
        // 通过上下文对象获取请求对象
        HttpServletRequest request = context.getRequest();
        // 通过请求对象获取请求参数，假设 token 作为权限的认证
        String token = request.getParameter("token");

        if (null == token || !"9527".equals(token)){
            // 不允许向下继续访问，拦截住了，立即返回
            context.setSendZuulResponse(false);
            // 设置响应头信息
            context.addZuulResponseHeader("content-type", "text/html;charset=utf-8");
            // 设置响应数据
            context.setResponseBody("报完名 - 找老邪要个权限吧!~");
        }else {
            System.out.println("Hello 小肆！~");
        }

        return null; // 默认就这么写就行，目前这个返回值只能写NULl
    }
}
