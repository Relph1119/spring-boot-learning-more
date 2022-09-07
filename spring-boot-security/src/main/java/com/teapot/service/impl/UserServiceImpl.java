package com.teapot.service.impl;

import com.teapot.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 模拟数据库操作 根据账号查询
//        String password = "456";
        String password = "$2a$10$MXNgZ0StyaHFRRTqpUXHUeNdJ/MDgyPnhbl8vnXEWEFIBMF440ibq";
        // 假设查询出来的用户的角色
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("USER1"));
        UserDetails userDetails = new User(username, "{noop}" + password, list);
        return userDetails;
    }
}
