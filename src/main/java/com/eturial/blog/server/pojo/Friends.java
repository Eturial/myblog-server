package com.eturial.blog.server.pojo;

import lombok.Data;

/**
 * 
 * @TableName friends
 */
@Data
public class Friends {
    /**
     * id
     */
    private Long friendId;

    /**
     * 
     */
    private String name;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 描述
     */
    private String description;

    /**
     * 链接
     */
    private String link;
}