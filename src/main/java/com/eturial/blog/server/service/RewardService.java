package com.eturial.blog.server.service;

import com.eturial.blog.server.pojo.Reward;
import com.eturial.blog.server.pojo.Tag;

import java.util.List;

/**
*
*/
public interface RewardService {

    List<Reward> getAllReward();

    void addReward(Reward reward);
}
