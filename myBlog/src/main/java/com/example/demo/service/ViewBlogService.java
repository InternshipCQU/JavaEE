package com.example.demo.service;

import org.springframework.data.relational.core.sql.In;

//浏览博客时，操作博客的相关功能
public interface ViewBlogService {
    String like(int blogId, int currentLikes);          //点赞
    void cancelLike(int blogId, int currentLikes);    //取消点赞
    String comment(int blogId, int userId, String comment);     //评论
    void forward(int blogId, int userId);       //转发
    void collect(int blogId, int userId);      //收藏
}
