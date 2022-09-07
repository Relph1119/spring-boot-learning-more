package com.teapot.springbootdemo.service.impl;

import com.teapot.springbootdemo.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public String query() {
        return "UserService 单元测试";
    }
}
