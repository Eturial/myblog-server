package com.eturial.blog;


import com.eturial.blog.server.mapper.BlogMapper;
import com.eturial.blog.server.pojo.Blog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void test() throws JsonProcessingException {
        //从redis缓存中获得指定的数据
        String blogListData = redisTemplate.boundValueOps("blog.getAllBlog").get();
        //如果redis中没有数据的话
        if (null == blogListData) {

            List<Blog> list = blogMapper.getAllBlog();
            //转换成json格式字符串
            ObjectMapper objectMapper = new ObjectMapper();
            blogListData = objectMapper.writeValueAsString(list);

            //将数据存储到redis中
            redisTemplate.boundValueOps("blog.getAllBlog").set(blogListData);
            System.out.println("从数据库");
        } else {
            System.out.println("从redis缓存");
        }
        System.out.println(blogListData);
    }
}
