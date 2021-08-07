package com.eturial.blog.server.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@Data
public class User implements Serializable {
    /**
     * 
     */
    private Long uid;

    /**
     * 
     */
    private String nickname;

    /**
     * 
     */
    private String gender;

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String avatar;

    private static final long serialVersionUID = 1L;
}