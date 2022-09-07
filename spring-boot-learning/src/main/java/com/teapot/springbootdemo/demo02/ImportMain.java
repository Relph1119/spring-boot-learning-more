package com.teapot.springbootdemo.demo02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@EnableTpDefine
public class ImportMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ImportMain.class);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println(beanName);
        }
    }
}
