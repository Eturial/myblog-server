package com.eturial.blog.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.eturial.blog.server.jwt.UserLoginToken;
import com.eturial.blog.server.pojo.Blog;
import com.eturial.blog.server.pojo.Reward;
import com.eturial.blog.server.pojo.User;
import com.eturial.blog.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "getOne")
    @ResponseBody
    public User getUser(@RequestParam("username") String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping(value = "getAllUser")
    @ResponseBody
    @UserLoginToken
    // 查看所有用户
    public List<User> getAllReward() {
        return userService.getAllUser();
    }

    @PostMapping(value = "/updateUser")
    @ResponseBody
    // 修改用户信息
    public void updateUser( @RequestBody JSONObject object) {
        User user = new User();

        user.setUid(userService.getUserByUsername(object.getString("username")).getUid());
        user.setUsername(object.getString("username"));
        user.setNickname(object.getString("nickname"));
        user.setPassword(object.getString("password"));
        user.setEmail(object.getString("email"));
        user.setGender(object.getString("gender"));

        userService.updateUser(user);
    }

    @PostMapping(value = "/updateAvatar")
    @ResponseBody
    // 修改用户信息
    public void updateAvatar(@RequestParam("username") String username,
                             @RequestParam("file") MultipartFile file) {
        userService.updateAvatar(file,username);
    }
}
