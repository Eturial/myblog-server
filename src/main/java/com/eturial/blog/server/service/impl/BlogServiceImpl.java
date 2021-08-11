package com.eturial.blog.server.service.impl;

import com.eturial.blog.server.pojo.Blog;
import com.eturial.blog.server.service.BlogService;
import com.eturial.blog.server.mapper.BlogMapper;
import com.eturial.blog.server.utils.SavePicture;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Blog> getAllBlog() {
        return blogMapper.getAllBlog();
    }

    @Override
    public List<Blog> getTagBlog(Long id) {
        return blogMapper.getTagBlog(id);
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
    }

    @Override
    public void updateThumb(Long id) {
        blogMapper.updateThumb(id);
    }

    @Override
    public void updateCollection(Long id) {
        blogMapper.updateCollection(id);
    }

    @Override
    public void updateView(Long id) {
        blogMapper.updateView(id);
    }
}
