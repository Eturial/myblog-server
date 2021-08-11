package com.eturial.blog.server.mapper;

import com.eturial.blog.server.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Entity com.eturial.blog.server.pojo.Comment
*/
@Mapper
public interface CommentMapper {

    void addComment(@Param("comment") Comment comment);

    Comment getOneById(@Param("id") Long id);

    List<Comment> getAllComment();

    void deleteOne(@Param("id") Long id);
}
