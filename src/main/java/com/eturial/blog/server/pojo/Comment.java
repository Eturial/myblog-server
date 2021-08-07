package com.eturial.blog.server.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName comment
 */
@Data
public class Comment implements Serializable {
    /**
     * 
     */
    private Long commentId;

    /**
     * 
     */
    private Long uid;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 
     */
    private Long blogId;

    /**
     * 
     */
    private Long parentCommentId;

    private static final long serialVersionUID = 1L;
}