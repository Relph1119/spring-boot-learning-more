package com.teapot.springbootdemo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/first")
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("-----first init-------");

        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("--------First过滤器执行之前-------------");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("--------First过滤器执行之后-------------");
    }

    @Override
    public void destroy() {
        System.out.println("******destory******");
        Filter.super.destroy();
    }
}
