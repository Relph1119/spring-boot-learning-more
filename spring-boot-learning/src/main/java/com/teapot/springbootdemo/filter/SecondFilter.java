package com.teapot.springbootdemo.filter;

import javax.servlet.*;
import java.io.IOException;

public class SecondFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("-----second init-------");

        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("--------Second过滤器执行之前-------------");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("--------Second过滤器执行之后-------------");
    }

    @Override
    public void destroy() {
        System.out.println("******destory******");
        Filter.super.destroy();
    }
}
