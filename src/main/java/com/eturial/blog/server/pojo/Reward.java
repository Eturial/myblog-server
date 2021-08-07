package com.eturial.blog.server.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName reward
 */
@Data
public class Reward implements Serializable {
    /**
     * 
     */
    private Long rewardId;

    /**
     * 
     */
    private Long uid;

    /**
     * 赞赏时间
     */
    private Date time;

    private static final long serialVersionUID = 1L;
}