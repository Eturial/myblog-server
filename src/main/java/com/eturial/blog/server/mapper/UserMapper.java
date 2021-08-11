package com.eturial.blog.server.mapper;

import com.eturial.blog.server.pojo.LoginUser;
import com.eturial.blog.server.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Entity com.eturial.blog.server.pojo.User
*/
@Mapper
public interface UserMapper {

    LoginUser getUserById(@Param("id") long id);

    LoginUser findByUsername(@Param("username") String username);

    User getUserByUsername(@Param("username") String username);

    List<User> getAllUser();

    void updateUser(@Param("user") User user);

    void updateAvatar(@Param("user") User user);

     User getUserByEmail(@Param("email")String email);

    void addNewUser(@Param("user") User user);
}
