package com.eturial.blog.server.pojo;

import lombok.Data;

/**
 * 
 * @TableName user
 */
@Data
public class User {
    /**
     * id
     */
    private Long uid;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 性别
     */
    private String gender;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String avatar;
}