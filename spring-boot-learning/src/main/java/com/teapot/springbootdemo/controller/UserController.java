package com.teapot.springbootdemo.controller;
import com.teapot.springbootdemo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Value("${user.username}")
    private String userName;

    @Value("${user.age}")
    private Integer age;

    @Value("${user.address}")
    private String address;

    @Autowired
    private User user;

    @GetMapping("/hello")
    public String hello() {
        return "Hello SpringBoot..." + userName + " " + age + " " + address + "--->" + user;
    }

    @RequestMapping("/show1")
    public String showInfo1() {
        String str = null;
        str.length();
        return "error1";
    }

    @RequestMapping("/show2")
    public String showInfo2() {
        int i = 0;
        int b = 100;
        System.out.println(b/i);
        return "error2";
    }
}
