package com.eturial.blog.server.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName message
 */
@Data
public class Message {
    /**
     * id
     */
    private Long messageId;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 留言内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 上级留言id
     */
    private Long parentMessageId;

}