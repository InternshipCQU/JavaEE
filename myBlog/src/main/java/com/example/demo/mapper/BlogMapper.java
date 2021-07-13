package com.example.demo.mapper;

import com.example.demo.entity.BlogInfo;
import org.apache.ibatis.annotations.Mapper;

//对应ViewBlogService中的功能
@Mapper
public interface BlogMapper {
    BlogInfo getBlog(int blogId);
    void like(int blogId, int currentLikes);          //点赞
    void cancelLike(int blogId, int currentLikes);    //取消点赞
    void comment(int blogId, int userId, String createTime, String comment);  //评论
    void forward(int blogId, int userId, String createTime);       //转发
    void collect(int blogId, int userId, String createTime);      //收藏

    void updateMarkWhenLike(String tagName, int userId);
    void updateMarkWhenCancelLike(String tagName, int userId);
    void updateMarkWhenComment(String tagName, int userId);
    void updateMarkWhenForward(String tagName, int userId);
    void updateMarkWhenCollect(String tagName, int userId);
}
