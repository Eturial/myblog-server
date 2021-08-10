package com.eturial.blog.server.service.impl;


import com.eturial.blog.server.mapper.UserMapper;
import com.eturial.blog.server.pojo.LoginUser;
import com.eturial.blog.server.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserMapper userMapper;

    @Override
    public LoginUser findByUsername(LoginUser loginUser) {
        return userMapper.findByUsername(loginUser.getUsername());
    }

    @Override
    public LoginUser findUserById(Long userId) {
        return userMapper.getUserById(userId);
    }
}
