package com.teapot;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

@SpringBootApplication
@MapperScan("com.teapot.mapper")
public class SpringBootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisApplication.class, args);
    }

    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        properties.setProperty("AuthorizationException", "/refuse");
        resolver.setExceptionMappings(properties);
        return resolver;
    }

    // 添加一个Thymeleaf的模板
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}
