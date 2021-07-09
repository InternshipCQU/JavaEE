package com.example.demo.mapper;

import com.example.demo.entity.blogInfo;
import org.apache.ibatis.annotations.Mapper;

//对应ViewBlogService中的功能
@Mapper
public interface BlogMapper {
    blogInfo getBlog(String userId, String blogId);
    void like(String blogId, String currentLikes);          //点赞
    void cancelLike(String blogId, String currentLikes);    //取消点赞
    void comment(String blogId, String userId, String createTime, String comment);     //评论
    void forward(String blogId, String userId, String createTime);       //转发
    void collect(String blogId, String userId, String createTime);      //收藏
}
