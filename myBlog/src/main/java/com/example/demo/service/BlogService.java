package com.example.demo.service;

import com.example.demo.entity.BlogInfo;
import com.example.demo.entity.BlogLike;
import com.example.demo.entity.UserLike;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
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

    String collect(int blogId, int userId);                 //收藏, 插入一条记录
    void cancelCollect(int blogId, int userId);             //取消收藏，删除一条记录
    boolean isCollect(int blogId, int userId);
    void addCollectNum(int blogId);                     //收藏数加1
    void deductCollectNum(int blogId);                  //收藏数减1
    void updateMarkWhenCancelCollect(int tagId, int userId);   //取消收藏分数减3


    List<BlogLike> searchLikeBlog(int userId);    // 根据用户id搜索其点赞过的博客id

    //以下函数是在用户进行点赞等操作时，更新用户对相应标签的喜爱程度
    void updateMarkWhenLike(int tagId, int userId);
    void updateMarkWhenCancelLike(int tagId, int userId);
    void updateMarkWhenComment(int tagId, int userId);
    void updateMarkWhenForward(int tagId, int userId);
    void updateMarkWhenCollect(int tagId, int userId);


    String getAuthorName(int userId, Model model);

    String giveTheCommentsToBlog(int userId, HttpServletRequest request);


    void Init(int blogId, HttpServletRequest request);
}
