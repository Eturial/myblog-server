package com.eturial.blog.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.eturial.blog.server.pojo.LoginUser;
import com.eturial.blog.server.service.LoginService;
import com.eturial.blog.server.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@CrossOrigin
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @ResponseBody
    @PostMapping(value = "/check")
    public Object isLogin(@RequestBody LoginUser loginUser) {
        JSONObject object = new JSONObject();
        LoginUser user = loginService.findByUsername(loginUser);
        if (user == null) {
            object.put("message", false);
        } else {
            if (!Objects.equals(user.getPassword(), loginUser.getPassword())) {
                object.put("message", false);
            } else {
                String token = TokenUtils.token(loginUser);
                object.put("token", token);
                object.put("message", true);
            }
        }
        return object;
    }
}
