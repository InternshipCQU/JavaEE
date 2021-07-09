package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

//对应ViewBlogService中的功能
@Mapper
public interface ViewBlogMapper {
    void like(Integer blogId, Integer currentLikes);          //点赞
    void cancelLike(Integer blogId, Integer currentLikes);    //取消点赞
    void comment(Integer blogId, Integer userId, String createDate, String comment);     //评论
    void forward(Integer blogId, Integer userId, String createDate);       //转发
    void collect(Integer blogId, Integer userId, String createDate);      //收藏
}
