package com.eturial.blog.server.mapper;

import com.eturial.blog.server.pojo.LoginUser;
import com.eturial.blog.server.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
* @Entity com.eturial.blog.server.pojo.User
*/
@Mapper
public interface UserMapper {

    LoginUser getUserById(@RequestParam("id") long id);

    LoginUser findByUsername(@RequestParam("username") String username);

    User getUserByUsername(@RequestParam("username") String username);

    List<User> getAllUser();

    void updateUser(@RequestParam("user") User user);

    void updateAvatar(@RequestParam("user") User user);

     User getUserByEmail(@RequestParam("email")String email);
}
