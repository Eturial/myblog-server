package com.eturial.blog.server.service;

import com.eturial.blog.server.pojo.LoginUser;
import com.eturial.blog.server.pojo.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
*
*/
public interface UserService {
    User getUserByUsername(String username);

    List<User> getAllUser();

    void updateUser(User user);

    void updateAvatar(MultipartFile file, String username);

    int verify(User user);
}
