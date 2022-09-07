package com.teapot.springbootdemo.demo02;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import(TpImportSelector.class)
@Import(TpImportBeanDefinitionRegistrar.class)
public @interface EnableTpDefine {

}
