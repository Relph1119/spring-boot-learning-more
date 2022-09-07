package com.teapot.config;

import com.teapot.realm.AuthcRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    // 散列算法
    private String hashAlgorithmName = "md5";
    // 迭代次数
    private Integer hashIterations = 1024;

    /**
     * 获取凭证匹配器
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName(hashAlgorithmName);
        matcher.setHashIterations(hashIterations);
        return matcher;
    }

    /**
     * 获取自定义的Realm
     * @return
     */
    @Bean
    @DependsOn("hashedCredentialsMatcher")
    public AuthcRealm authcRealm(HashedCredentialsMatcher matcher) {
        AuthcRealm realm = new AuthcRealm();
        realm.setCredentialsMatcher(matcher);
        return realm;
    }

    /**
     * 获取SecurityManager对象
     * @param realm
     * @return
     */
    @Bean
    @DependsOn("authcRealm")
    public SecurityManager securityManager(AuthcRealm realm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(realm);
        return manager;
    }

    /**
     * 注册ShiroFilterFactoryBean
     * @param manager
     * @return
     */
    @Bean
    @DependsOn("securityManager")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager manager) {
        ShiroFilterFactoryBean filter = new ShiroFilterFactoryBean();
        filter.setSecurityManager(manager);
        filter.setLoginUrl("/login.do");
        filter.setSuccessUrl("/success.html");
        filter.setUnauthorizedUrl("/refuse.html");

        //设置过滤器链
        Map<String, String> map = new HashMap<>();
        map.put("/css/*","anon");
        map.put("/js/**","anon");
        map.put("/img/**","anon");
        map.put("/login","anon");
        map.put("/login.do","authc");
        map.put("/**","authc");
        filter.setFilterChainDefinitionMap(map);
        return filter;
    }

    /**
     * 开始Shiro注解授权操作
     * @param manager
     * @return
     */
    @Bean
    @DependsOn("securityManager")
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager manager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        return advisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }
}
