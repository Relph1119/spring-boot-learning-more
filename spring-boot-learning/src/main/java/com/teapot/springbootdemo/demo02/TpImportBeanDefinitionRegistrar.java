package com.teapot.springbootdemo.demo02;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class TpImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        RootBeanDefinition cache = new RootBeanDefinition(CacheService.class);
        registry.registerBeanDefinition("cache", cache);

        RootBeanDefinition logger = new RootBeanDefinition(LoggerService.class);
        registry.registerBeanDefinition("logger", logger);
    }
}
