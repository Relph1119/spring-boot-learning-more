package com.teapot.service;

import com.teapot.pojo.User;

import java.util.List;

public interface IUserService {

    public List<User> query(User user);
}
