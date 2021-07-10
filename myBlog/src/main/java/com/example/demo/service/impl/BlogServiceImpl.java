package com.example.demo.service.impl;

import com.example.demo.entity.Blog;
import com.example.demo.service.BlogService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service("BlogService")
public class BlogServiceImpl implements BlogService {
    @Override
    public Blog findBlog(int userID, int BlogID){
        //TODO:这里需要去向后端找博客的信息返回前端
        //BlogMapper here
        Blog blog = new Blog();
        return blog;
    }

    @Override
    public void like(int userID,int blogID){
        //TODO:找mapper去写信息
    }

    @Override
    public void comment(int userID,int blogID,String comment){
        //TODO:找mapper去写信息
    }

    @Override
    public void forward(int userID,int blogID){
        //TODO:找mapper去写信息
    }
}
