package com.teapot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthcController {

    @RequestMapping("/login.do")
    public String login(HttpServletRequest request){
        // 获取认证失败异常信息
        Object obj = request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        System.out.println("认证失败的信息：" + obj);
        return "login";
    }

    @RequestMapping("/logout.do")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "redirect:/login";
    }
}
