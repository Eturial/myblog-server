package com.eturial.blog.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.eturial.blog.server.jwt.UserLoginToken;
import com.eturial.blog.server.pojo.Reward;
import com.eturial.blog.server.pojo.User;
import com.eturial.blog.server.service.UserService;
import com.eturial.blog.server.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
}
