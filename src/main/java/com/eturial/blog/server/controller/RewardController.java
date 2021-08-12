package com.eturial.blog.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.eturial.blog.server.jwt.UserLoginToken;
import com.eturial.blog.server.pojo.Reward;
import com.eturial.blog.server.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/reward")
public class RewardController {
    @Autowired
    RewardService rewardService;

    @GetMapping(value = "/getAllReward")
    @ResponseBody
//    @UserLoginToken
    // 查看赞赏记录
    public List<Reward> getAllReward() {
        return rewardService.getAllReward();
    }

    @PostMapping(value = "/addReward")
    @ResponseBody
    // 赞赏
    public void addReward(@RequestBody JSONObject object) {
        Reward reward = new Reward();
        reward.setNickname(object.getString("nickname"));
        reward.setTime(object.getDate("time"));
        reward.setMoney(object.getInteger("money"));

        rewardService.addReward(reward);
    }
}
