package com.eturial.blog.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.eturial.blog.server.pojo.User;
import com.eturial.blog.server.service.UserService;
import com.eturial.blog.server.utils.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(value = "/register")
@CrossOrigin
public class RegisterController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/verify")
    @ResponseBody
    public int verify(@RequestBody JSONObject object) {
        User user = new User();
        user.setUsername(object.getString("username"));
        user.setPassword(object.getString("password"));
        user.setEmail(object.getString("email"));

        return userService.verify(user);
    }

    @PostMapping(value = "/register")
    @ResponseBody
    public String Register(@RequestBody JSONObject object) {
        User user = new User();
        user.setUsername(object.getString("username"));
        user.setPassword(object.getString("password"));
        user.setEmail(object.getString("email"));
//        System.out.println(object);
        if(!Objects.equals(object.getInteger("code"), object.getInteger("eCode")))
            return "验证码有误";

        userService.register(user);
        return "注册成功";
    }

}
