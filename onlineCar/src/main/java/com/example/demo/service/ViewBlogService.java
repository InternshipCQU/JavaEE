package com.example.demo.service;

//浏览博客时，操作博客的相关功能
public interface ViewBlogService {
    void like(String username);         //点赞
    String comment(String username);    //评论
    void forward(String username);      //转发
    void favorite(String username);     //收藏
}
