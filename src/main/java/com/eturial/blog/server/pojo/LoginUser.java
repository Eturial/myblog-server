package com.eturial.blog.server.pojo;

import lombok.Data;

@Data
public class LoginUser {
    private Long uid;
    private String username;
    private String password;
}
