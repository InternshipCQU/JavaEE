package com.example.demo.service;

import com.example.demo.entity.BlogInfo;
import com.example.demo.entity.BlogLike;
import com.example.demo.entity.UserLike;

import java.util.List;

public interface BlogService {
    BlogInfo getBlog(int blogId);
    String like(int blogId);              //点赞
    boolean isliked(int blogId,int userId);
    void writelikerecord(int blogId,int userId);
    void deletelikerecord(int blogId,int userId);
    void cancelLike(int blogId);          //取消点赞
    String comment(int blogId, int userId, String comment); //评论
    String forward(int blogId, int userId);                 //转发
    String collect(int blogId, int userId);                 //收藏

    List<BlogLike> searchLikeBlog(int userId);    // 根据用户id搜索其点赞过的博客id

    //以下函数是在用户进行点赞等操作时，更新用户对相应标签的喜爱程度
    void updateMarkWhenLike(int tagId, int userId);
    void updateMarkWhenCancelLike(int tagId, int userId);
    void updateMarkWhenComment(int tagId, int userId);
    void updateMarkWhenForward(int tagId, int userId);
    void updateMarkWhenCollect(int tagId, int userId);

}
