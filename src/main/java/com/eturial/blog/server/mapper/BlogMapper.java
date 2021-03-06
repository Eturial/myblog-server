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

    void updateThumb(@Param("id") Long id);

//    void updateCollection(@Param("id") Long id);

    void updateView(@Param("id") Long id);

    void updateComment(@Param("id") Long id);

    List<Blog> getMostViews();

    Blog getBlogById(@Param("id") Long id);
}
