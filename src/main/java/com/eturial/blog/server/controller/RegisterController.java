package com.eturial.blog.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.eturial.blog.server.pojo.User;
import com.eturial.blog.server.service.UserService;
import com.eturial.blog.server.utils.SendMail;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/register")
@Api
@CrossOrigin
public class RegisterController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/verify")
    @ResponseBody
    public Boolean verify(@RequestBody JSONObject object) {
        User user = new User();
        user.setUsername(object.getString("username"));
        user.setPassword(object.getString("password"));
        user.setEmail(object.getString("email"));

        return userService.verify(user);
    }

}
