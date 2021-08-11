package com.eturial.blog.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.eturial.blog.server.pojo.Comment;
import com.eturial.blog.server.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping(value = "/addComment")
    @ResponseBody
    // 评论
    public void addMessage(@RequestBody JSONObject object) {
        Comment comment = new Comment();
        comment.setContent(object.getString("content"));
        comment.setNickname(object.getString("nickname"));
        comment.setBlogId(object.getLong("blogId"));
        comment.setParentCommentId(object.getLong("parentId"));

        commentService.addComment(comment);
    }

    @GetMapping(value = "/getOne")
    @ResponseBody
    // 获取单条
    public Comment addComment(@RequestParam("id") Long id) {
        return commentService.getOneById(id);
    }

    @GetMapping(value = "/getAll")
    @ResponseBody
    // 获取全部
    public List<Comment> getAllComment() {
        return commentService.getAllComment();
    }

    @PostMapping(value = "/deleteOne")
    @ResponseBody
    public void deleteOne(@RequestParam("id") Long id) {
        commentService.deleteOne(id);
    }
}
