package com.teapot.springbootdemo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class FirstListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("FirstListener:Servlet容器初始化...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("FirstListener:Servlet容器被销毁了");
    }
}
