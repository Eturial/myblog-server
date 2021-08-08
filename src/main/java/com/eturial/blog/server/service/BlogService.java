package com.eturial.blog.server.service;

import com.eturial.blog.server.pojo.Blog;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
*
*/
public interface BlogService {

    void addArticle(Blog blog, MultipartFile file);

    List<Blog> getAllBlog();

    List<Blog> getTagBlog(Long id);

    void deleteArticle(Long id);

    void updateArticle(Blog blog, MultipartFile file);
}
