package com.teapot.springbootdemo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

public class SecondListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("SecondListener:Servlet容器初始化...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("SecondListener:Servlet容器被销毁了");
    }
}
