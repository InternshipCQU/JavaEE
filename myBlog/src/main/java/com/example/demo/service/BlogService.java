package com.example.demo.service;

import com.example.demo.entity.blogInfo;


public interface BlogService {
    blogInfo getBlog(int blogId);
    String like(int blogId, int currentLikes);          //点赞
    void cancelLike(int blogId, int currentLikes);    //取消点赞
    String comment(int blogId, int userId, String comment);     //评论
    String forward(int blogId, int userId);       //转发
    String collect(int blogId, int userId);      //收藏
}
