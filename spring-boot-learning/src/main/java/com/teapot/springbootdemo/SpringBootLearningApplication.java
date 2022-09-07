package com.teapot.springbootdemo;

import com.teapot.springbootdemo.filter.SecondFilter;
import com.teapot.springbootdemo.listener.SecondListener;
import com.teapot.springbootdemo.servlet.SecondServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

@SpringBootApplication
// 在SpringBoot启动的时候会扫描WebServlet注解
@ServletComponentScan()
public class SpringBootLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLearningApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean getServletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
        bean.addUrlMappings("/second");
        return bean;
    }

    @Bean
    public FilterRegistrationBean getFilterRegistrationBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFilter());
        bean.addUrlPatterns("/second");
        return bean;
    }

    @Bean
    public ServletListenerRegistrationBean getListenerRegistrationBean(){
        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean(new SecondListener());
        return bean;
    }

    /**
     * 该方法必须要有返回值。返回值类型必须是：
     SimpleMappingExceptionResolver
     */
    @Bean
    public SimpleMappingExceptionResolver
    getSimpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver resolver = new
                SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        /**
         * 参数一：异常的类型，注意必须是异常类型的全名
         * 参数二：视图名称
         */
        mappings.put("java.lang.NullPointerException","error1");
        mappings.put("java.lang.ArithmeticException", "error2");
        //设置异常与视图映射信息的
        resolver.setExceptionMappings(mappings);
        return resolver;
    }

}
