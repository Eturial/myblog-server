package com.eturial.blog.server.service.impl;

import com.eturial.blog.server.pojo.Reward;
import com.eturial.blog.server.service.RewardService;
import com.eturial.blog.server.mapper.RewardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*
*/
@Service
public class RewardServiceImpl implements RewardService {
    @Autowired
    RewardMapper rewardMapper;

    @Override
    public List<Reward> getAllReward() {
        return rewardMapper.getAllReward();
    }

    @Override
    public void addReward(Reward reward) {
        if(reward.getNickname() == null)
            reward.setNickname("游客");
        rewardMapper.addReward(reward);
    }
}
