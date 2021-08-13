package com.eturial.blog.server.service.impl;

import com.eturial.blog.server.mapper.TagMapper;
import com.eturial.blog.server.pojo.Blog;
import com.eturial.blog.server.pojo.Tag;
import com.eturial.blog.server.service.BlogService;
import com.eturial.blog.server.mapper.BlogMapper;
import com.eturial.blog.server.utils.SavePicture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
*
*/
@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    BlogMapper blogMapper;

    @Autowired
    TagMapper tagMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void addArticle(Blog blog, MultipartFile file) {
        SavePicture savePicture = new SavePicture();
        try {
            blog.setFirstPicture(savePicture.pictureToUrl(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        blogMapper.addArticle(blog);
    }

    @Override
    public String getAllBlog() {
        String blogListData = redisTemplate.boundValueOps("blog.getAllBlog").get();
        if (null == blogListData) {

            List<Blog> list = blogMapper.getAllBlog();
            for(int i = 0; i < list.size();i++){
                Blog blog = list.get(i);
                Long tagId = blog.getTagId();
                Tag tag = tagMapper.getTagById(tagId);
                blog.setTagName(tag.getTagName());
                list.set(i,blog);
            }

            //转换成json格式字符串
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                blogListData = objectMapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            //将数据存储到redis中
            redisTemplate.boundValueOps("blog.getAllBlog").set(blogListData);
        }

        return blogListData;
    }

    @Override
    public List<Blog> getTagBlog(Long id) {
        List<Blog> list = blogMapper.getTagBlog(id);
        for(int i = 0; i < list.size();i++){
            Blog blog = list.get(i);
            Long tagId = blog.getTagId();
            Tag tag = tagMapper.getTagById(tagId);
            blog.setTagName(tag.getTagName());
            list.set(i,blog);
        }
        return list;
    }

    @Override
    public void deleteArticle(Long id) {
        blogMapper.deleteArticle(id);
    }

    @Override
    public void updateArticle(Blog blog, MultipartFile file) {

        SavePicture savePicture = new SavePicture();

        String url = blog.getFirstPicture();

        int begin = url.indexOf("images");
        int length = url.length();
        String filePath = "F:/" + url.substring(begin, length);

        savePicture.deletePicture(filePath);
        try {
            blog.setFirstPicture(savePicture.pictureToUrl(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        blogMapper.updateArticle(blog);

        List<Blog> list = blogMapper.getAllBlog();
        String blogListData = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            blogListData = objectMapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        redisTemplate.boundValueOps("blog.getAllBlog").set(blogListData);
    }

    @Override
    public void updateThumb(Long id) {
        blogMapper.updateThumb(id);
    }

//    @Override
//    public void updateCollection(Long id) {
//        blogMapper.updateCollection(id);
//    }

    @Override
    public void updateView(Long id) {
        blogMapper.updateView(id);
    }

    @Override
    public List<Blog> getMostViews() {
        return blogMapper.getMostViews();
    }

    @Override
    public Blog getBlogById(Long id) {
        Blog blog = blogMapper.getBlogById(id);
        Long tagId = blog.getTagId();
        Tag tag = tagMapper.getTagById(tagId);
        blog.setTagName(tag.getTagName());
        return blog;
    }

//    @Override
//    public void updateComment(Long id) {
//        blogMapper.updateComment(id);
//    }
}
