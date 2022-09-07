package com.teapot.service;

import com.teapot.pojo.User;

import java.util.List;

public interface IUserService {

    public List<User> query(User user);

    public Integer addUser(User user);

    public User queryById(Integer id);

    public Integer updateUser(User user);

    public Integer deleteUserById(Integer id);
}
