package com.example.demo.service;

import com.example.demo.entity.Blog;


public interface BlogService {
    Blog findBlog(String userID,String BlogID);
    void like(String userID,String blogID);
    void comment(String userID,String blogID,String comment);
    void forward(String userID,String blogID);
}
