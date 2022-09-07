package com.teapot.springbootdemo.demo02;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;
import java.util.logging.Logger;

public class TpImportSelector implements ImportSelector {
    /**
     *
     * @param importingClassMetadata
     * @return
     *   就是Ioc容器要加载的类型的全路径数组
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                LoggerService.class.getName(),
                CacheService.class.getName(),
        };
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        return ImportSelector.super.getExclusionFilter();
    }
}
