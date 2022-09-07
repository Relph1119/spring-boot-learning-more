package com.teapot.mapper;

import com.teapot.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    public List<User> query(User user);

    public Integer addUser(User user);

    public User queryById(Integer id);

    public Integer updateUser(User user);

    public Integer deleteUserById(Integer id);
}
