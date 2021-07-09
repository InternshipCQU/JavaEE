package com.example.demo.service.impl;

import com.example.demo.entity.Blog;
import com.example.demo.service.BlogService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service("BlogService")
public class BlogServiceImpl implements BlogService {
    public Blog findBlog(String userID, String BlogID){
        //TODO:这里需要去向后端找博客的信息返回前端
        //BlogMapper here
        Blog blog = new Blog();
        return blog;
    }
}
