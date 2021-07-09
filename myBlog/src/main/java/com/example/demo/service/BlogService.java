package com.example.demo.service;

import com.example.demo.entity.Blog;
import com.example.demo.entity.blogInfo;


public interface BlogService {
    blogInfo getBlog(String userId, String blogId);
    String like(String blogId, String currentLikes);          //点赞
    void cancelLike(String blogId, String currentLikes);    //取消点赞
    String comment(String blogId, String userId, String comment);     //评论
    String forward(String blogId, String userId);       //转发
    String collect(String blogId, String userId);      //收藏
}
