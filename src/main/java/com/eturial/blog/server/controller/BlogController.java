package com.eturial.blog.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.eturial.blog.server.pojo.Blog;
import com.eturial.blog.server.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping(value = "/getAllBlog")
    @ResponseBody
    // 查看所有博客
    public List<Blog> getAllBLog() {
        return blogService.getAllBlog();
    }

    @GetMapping(value = "/getTagBlog")
    @ResponseBody
    // 归档中查看博客
    public List<Blog> getTagBLog(@RequestParam("id") Long id) {
//        System.out.println(id);
        return blogService.getTagBlog(id);
    }

    @PostMapping(value = "/addArticle")
    @ResponseBody
    // 添加新文章
    public void addArticle( @RequestParam("blogStr") String blogStr,
                           @RequestParam("file") MultipartFile file) {
        Blog blog = new Blog();
//        System.out.println(blogStr);
        JSONObject object = JSONObject.parseObject(blogStr);

        blog.setTitle(object.getString("title"));
        blog.setDescription(object.getString("description"));
        blog.setContent(object.getString("content"));
//        blog.setCreateTime(object.getDate("time"));
//        blog.setFirstPicture(object.getString("url"));
        blog.setTagId(object.getLong("tagId"));

        blogService.addArticle(blog, file);
    }

    @PostMapping(value = "/deleteArticle")
    @ResponseBody
    // 删除文章
    public void deleteArticle( @RequestParam("id") Long id) {
        blogService.deleteArticle(id);
    }

    @PostMapping(value = "/updateArticle")
    @ResponseBody
    // 修改文章
    public void updateArticle( @RequestParam("blogStr") String blogStr,
                            @RequestParam("file") MultipartFile file) {
        Blog blog = new Blog();
//        System.out.println(blogStr);
        JSONObject object = JSONObject.parseObject(blogStr);

        blog.setBlogId(object.getLong("id"));
        blog.setTitle(object.getString("title"));
        blog.setDescription(object.getString("description"));
        blog.setContent(object.getString("content"));
        blog.setFirstPicture(object.getString("url"));
        blog.setTagId(object.getLong("tagId"));

        blogService.updateArticle(blog, file);
    }
}
