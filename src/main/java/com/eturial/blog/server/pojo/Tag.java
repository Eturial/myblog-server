package com.eturial.blog.server.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName tag
 */
@Data
public class Tag implements Serializable {
    /**
     * 
     */
    private Long tagId;

    /**
     * 
     */
    private String tagName;

    private static final long serialVersionUID = 1L;
}