package com.eturial.blog.server.service;

import com.eturial.blog.server.pojo.Blog;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
*
*/
public interface BlogService {

    void addArticle(Blog blog, MultipartFile file);

    String getAllBlog();

    List<Blog> getTagBlog(Long id);

    void deleteArticle(Long id);

    void updateArticle(Blog blog, MultipartFile file);

    void updateThumb(Long id);

//    void updateCollection(Long id);

    void updateView(Long id);

//    void updateComment(Long id);

    List<Blog> getMostViews();

    Blog getBlogById(Long id);
}
