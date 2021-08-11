package com.eturial.blog.server.service;

import com.eturial.blog.server.pojo.Comment;
import com.eturial.blog.server.pojo.Message;

import java.util.List;

/**
*
*/
public interface CommentService {

    void addComment(Comment comment);

    Comment getOneById(Long id);

    List<Comment> getAllComment();

    void deleteOne(Long id);
}
