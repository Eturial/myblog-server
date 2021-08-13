# 个人博客（实验室大二考核项目）

**首先回答一下这个问题：为什么要做博客？（灵魂拷问）**

因为想不到做什么好的东西，~~都是增删改查~~(蒟蒻太菜了)。然后之前一直想搭个个人博客，也比较实用吧，就做了这个。（~~而且还做的挺拉跨的~~）

### 简介 

一个平平无奇的个人博客，前端（Vue.js + Element-UI）、后端（Springboot + Mybatis）

因为实在是太菜了，前端实在不会写，学了一段时间Vue，然后github上找了一个比较好康的页面，这里放上链接。（[Write the Code. Change the World. (mangoya.cn)](http://mangoya.cn/#/)）管理端的页面自己搞了下，但是没搞完~~就跟没有一样~~，晚上挣扎了一下......挣扎不动了。登录、注册、评论、留言这几个功能都没接好(后端接口都写好了……)

- feature：
  - marked.js 完成对markdown格式文章的解析。

后端 基本的springboot+mybaitis，除了普通的增删改查

- feature：
  - 注册通过QQ邮箱验证。
  - JWT授权用户登录。
  - Redis缓存热点资源。

### 遇到的问题

1.springboot接口 接收参数为Json对象和MultipartFile对象时报错（415）。

HTTP请求分为了消息头和消息体，头信息里面的Content-Type字段定义了消息体的请求格式，传Json数据的http请求头里为: "Content-Type: application/json"

利用@RequestParam接受了字符串，之后再转为Json对象。

```Java
@PostMapping(value = "/addArticle")
    @ResponseBody
    // 添加新文章
    public void addArticle( @RequestParam("blogStr") String blogStr,
                           @RequestParam("file") MultipartFile file) {
        Blog blog = new Blog();
//        System.out.println(blogStr);
        JSONObject object = JSONObject.parseObject(blogStr);
        ......
        blogService.addArticle(blog, file);
    }
```

2.上传图片报错 超出图片大小限制

tomcat默认设置1MB，在application.properties中设置

```properties
spring.servlet.multipart.maxFileSize = 5MB
```

3.保存图片到本地并转化为url 存入数据库

```
http://localhost:14000/images/2021/08/08/c1f74d5287bf449d9c659fd09df97c77.png
```

通过url访问图片 需要配置访问位置

```properties
spring.web.resources.static-locations=file:F://
```

4.前端解析markdown格式（换了好多种方法……）

```javascript
<script>
    import axios from 'axios';
    import markdown from 'marked';
    export default {
    data () { 
      return {
        detailObj: {},//返回详情数据
        md:''
      }
    },
    mounted(){
        axios({
            url : `http://localhost:14000/blog/getOneBlog?id=${this.$route.params.id}`,
            method : 'get',
        }).then((res)=>{
            this.detailObj = res.data;
            this.md = markdown(this.detailObj.content);
        })
    },
}
</script>
```

5.学习Redis缓存热点资源，做了单元测试

```java
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
```

### will do

- 完善未完成的接口和功能
- 部署到服务器
