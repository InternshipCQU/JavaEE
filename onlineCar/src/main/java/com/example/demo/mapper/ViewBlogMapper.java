package com.example.demo.mapper;

//对应ViewBlogService中的功能
public interface ViewBlogMapper {
    void like(String username);         //点赞
    String comment(String username);    //评论
    void forward(String username);      //转发
    void favorite(String username);     //收藏
}
