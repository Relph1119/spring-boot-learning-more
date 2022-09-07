package com.teapot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/show")
    public String showInfo(Model model) {
        model.addAttribute("msg", "Thymeleaf Hello ......");
        return "index";
    }
}
