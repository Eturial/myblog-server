package com.eturial.blog.server.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName message
 */
@Data
public class Message implements Serializable {
    /**
     * 
     */
    private Long messageId;

    /**
     * 
     */
    private Long uid;

    /**
     * 留言内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 
     */
    private Long parentMessageId;

    private static final long serialVersionUID = 1L;
}