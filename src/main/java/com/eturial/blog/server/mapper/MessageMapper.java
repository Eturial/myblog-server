package com.eturial.blog.server.mapper;

import com.eturial.blog.server.pojo.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Entity com.eturial.blog.server.pojo.Message
*/
@Mapper
public interface MessageMapper {


    Message getOneById(@Param("id") Long id);

    List<Message> getAllMessage();

    void addMessage(@Param("message") Message message);

    void deleteOne(@Param("id") Long id);
}
