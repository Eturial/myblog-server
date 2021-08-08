package com.eturial.blog.server.pojo;

import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName blog
 */
@Data
public class Blog {
    /**
     * 博客id
     */
    private Long blogId;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 首图
     */
    private String firstPicture;

    /**
     * 点赞数
     */
    private Integer thumbs;

    /**
     * 浏览次数
     */
    private Integer views;

    /**
     * 评论数
     */
    private Integer comment;

    /**
     * 收藏数
     */
    private Integer collection;

    /**
     * 标签id
     */
    private Long tagId;
}