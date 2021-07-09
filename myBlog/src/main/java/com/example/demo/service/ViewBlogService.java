package com.example.demo.service;

import org.springframework.data.relational.core.sql.In;

//浏览博客时，操作博客的相关功能
public interface ViewBlogService {
    String like(Integer blogId, Integer currentLikes);          //点赞
    void cancelLike(Integer blogId, Integer currentLikes);    //取消点赞
    String comment(Integer blogId, Integer userId, String comment);     //评论
    void forward(Integer blogId, Integer userId);       //转发
    void collect(Integer blogId, Integer userId);      //收藏
}
