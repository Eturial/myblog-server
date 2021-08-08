package com.eturial.blog.server.pojo;

import lombok.Data;

/**
 * 
 * @TableName tag
 */
@Data
public class Tag {
    /**
     * id
     */
    private Long tagId;

    /**
     * 标签名
     */
    private String tagName;
}