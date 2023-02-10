package com.chenxing.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName ErrorFilter
 * @Description: TODO
 * @Author: lichenxingbeijing@163.com
 * @date ：Created in 10/02/2023 16:43
 */
@Component
public class ErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("ErrorFilter is running ....");

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletResponse response = context.getResponse();
        ZuulException zuulException = (ZuulException) context.getThrowable();
        response.setHeader("content-type", "text/html;charset=utf-8");
        response.setStatus(zuulException.nStatusCode);

        System.out.println(zuulException.getMessage());
        System.out.println(zuulException.getCause().getMessage());

        try {
            PrintWriter out = response.getWriter();
            out.print("完啦！~芭比Q啦！~");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
