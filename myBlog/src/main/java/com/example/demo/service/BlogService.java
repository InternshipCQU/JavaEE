package com.example.demo.service;

import com.example.demo.entity.Blog;


public interface BlogService {
    Blog findBlog(int userID,int BlogID);
    void like(int userID,int blogID);
    void comment(int userID,int blogID,String comment);
    void forward(int userID,int blogID);
}
