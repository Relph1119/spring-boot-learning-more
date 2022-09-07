package com.teapot.service.impl;

import com.teapot.mapper.UserMapper;
import com.teapot.pojo.User;
import com.teapot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> query(User user) {
        return mapper.query(user);
    }

}
