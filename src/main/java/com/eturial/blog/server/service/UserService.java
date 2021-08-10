package com.eturial.blog.server.service;

import com.eturial.blog.server.pojo.LoginUser;
import com.eturial.blog.server.pojo.User;

import java.util.List;

/**
*
*/
public interface UserService {
    User getUserByUsername(String username);

    List<User> getAllUser();
}
