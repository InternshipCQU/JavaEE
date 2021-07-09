package com.example.demo.service;

import com.example.demo.entity.Blog;


public interface BlogService {
    Blog findBlog(String userID,String BlogID);
}
