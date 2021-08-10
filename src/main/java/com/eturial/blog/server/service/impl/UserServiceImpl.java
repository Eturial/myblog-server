package com.eturial.blog.server.service.impl;

import com.eturial.blog.server.pojo.User;
import com.eturial.blog.server.service.UserService;
import com.eturial.blog.server.mapper.UserMapper;
import com.eturial.blog.server.utils.SavePicture;
import com.eturial.blog.server.utils.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
*
*/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void updateAvatar(MultipartFile file, String username) {
        SavePicture savePicture = new SavePicture();
        String existUrl = userMapper.getUserByUsername(username).getAvatar();
        if(existUrl != null) {
            int begin = existUrl.indexOf("images");
            int length = existUrl.length();
            String filePath = "F:/" + existUrl.substring(begin, length);
            savePicture.deletePicture(filePath);
        }
        String url = null;
        try {
            url = savePicture.pictureToUrl(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        User user = new User();
        user.setUsername(username);
        user.setAvatar(url);
        userMapper.updateAvatar(user);
    }

    @Override
    public int verify(User user) {
        if(userMapper.getUserByUsername(user.getUsername()) != null ||
                userMapper.getUserByEmail(user.getEmail()) != null)
            return -1;

        return SendMail.sendMail(user.getEmail());
    }
}
