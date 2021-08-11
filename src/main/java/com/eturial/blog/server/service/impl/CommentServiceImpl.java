package com.eturial.blog.server.service.impl;

import com.eturial.blog.server.mapper.BlogMapper;
import com.eturial.blog.server.pojo.Comment;
import com.eturial.blog.server.pojo.Message;
import com.eturial.blog.server.service.CommentService;
import com.eturial.blog.server.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*
*/
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Autowired
    BlogMapper blogMapper;

    @Override
    public void addComment(Comment comment) {
        if(comment.getParentCommentId() == null)
            comment.setParentCommentId(0L);
        blogMapper.updateComment(comment.getBlogId());
        commentMapper.addComment(comment);
    }

    @Override
    public Comment getOneById(Long id) {
        return commentMapper.getOneById(id);
    }

    @Override
    public List<Comment> getAllComment() {
        return commentMapper.getAllComment();
    }

    @Override
    public void deleteOne(Long id) {
        commentMapper.deleteOne(id);
    }
}
