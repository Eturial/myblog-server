package com.eturial.blog.server.service;

import com.eturial.blog.server.pojo.LoginUser;
import org.springframework.stereotype.Service;


public interface LoginService {
    LoginUser findByUsername(LoginUser loginUser);

    LoginUser findUserById(Long userId);
}
