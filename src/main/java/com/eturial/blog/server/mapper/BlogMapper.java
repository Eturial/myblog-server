package com.eturial.blog.server.mapper;

import com.eturial.blog.server.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Entity com.eturial.blog.server.pojo.Blog
*/
@Mapper
public interface BlogMapper{

    void addArticle(@Param("blog") Blog blog);

    List<Blog> getAllBlog();

    List<Blog> getTagBlog(@Param("id") Long id);

    void deleteArticle(@Param("id") Long id);

    void updateArticle(@Param("blog") Blog blog);
}
