package com.eturial.blog.server.pojo;

import java.util.Date;
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
    private Date time;
}