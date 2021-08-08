package com.eturial.blog.server.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName comment
 */
@Data
public class Comment {
    /**
     * id
     */
    private Long commentId;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 博客id
     */
    private Long blogId;

    /**
     * 上级评论id
     */
    private Long parentCommentId;

}