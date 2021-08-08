package com.eturial.blog.server.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
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