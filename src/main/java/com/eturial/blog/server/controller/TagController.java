package com.eturial.blog.server.controller;

import com.eturial.blog.server.pojo.Tag;
import com.eturial.blog.server.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/tag")
public class TagController {
    @Autowired
    TagService tagService;

    @GetMapping(value = "/getAllTag")
    @ResponseBody
    // 查看所有标签
    public List<Tag> getAllComment() {
        return tagService.getAllTag();
    }
}
