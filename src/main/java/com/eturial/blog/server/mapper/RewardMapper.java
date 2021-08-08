package com.eturial.blog.server.mapper;

import com.eturial.blog.server.pojo.Reward;
import com.eturial.blog.server.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Entity com.eturial.blog.server.pojo.Reward
*/
@Mapper
public interface RewardMapper {

    List<Reward> getAllReward();

    void addReward(@Param("reward") Reward reward);
}
