package com.eturial.blog.server.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 
 * @TableName reward
 */
@Data
public class Reward {
    /**
     * id
     */
    private Long rewardId;


    private String nickname;
    /**
     * 赞赏时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date time;
}