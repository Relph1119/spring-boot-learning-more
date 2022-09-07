package com.teapot.controller;

import com.teapot.pojo.User;
import com.teapot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private IUserService service;

    @RequestMapping("/user/query")
    public String query(Model model) {
        model.addAttribute("list", service.query(null));
        return "user";
    }

    @RequestMapping("/user/save")
    public String addUser(User user) {
        service.addUser(user);
        return "redirect:/user/query";
    }

    /**
     * 基础页面的请求
     *
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }

    @RequestMapping("/user/updateInfo")
    public String updateInfo(Integer id, Model model) {
        User user = service.queryById(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @RequestMapping("/user/update")
    public String updateUser(User user) {
        service.updateUser(user);
        return "redirect:/user/query";
    }

    @RequestMapping("/user/deleteUser")
    public String deleteUser(Integer id) {
        service.deleteUserById(id);
        return "redirect:/user/query";
    }
}
