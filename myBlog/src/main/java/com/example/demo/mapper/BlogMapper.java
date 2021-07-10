package com.example.demo.mapper;

import com.example.demo.entity.blogInfo;
import org.apache.ibatis.annotations.Mapper;

//对应ViewBlogService中的功能
@Mapper
public interface BlogMapper {
    blogInfo getBlog(int blogId);
    void like(int blogId, int currentLikes);          //点赞
    void cancelLike(int blogId, int currentLikes);    //取消点赞
    void comment(int blogId, int userId, String createTime, String comment);     //评论
    void forward(int blogId, int userId, String createTime);       //转发
    void collect(int blogId, int userId, String createTime);      //收藏
}
