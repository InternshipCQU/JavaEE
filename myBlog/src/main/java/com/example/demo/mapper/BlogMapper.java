package com.example.demo.mapper;

import com.example.demo.entity.BlogInfo;
import com.example.demo.entity.BlogLike;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//对应ViewBlogService中的功能
@Mapper
public interface BlogMapper {
    BlogInfo getBlog(int blogId);
    void like(int blogId);                              //点赞
    void writelikerecord(int blogId,int userId);
    void deletelikerecord(int blogId,int userId);
    void cancelLike(int blogId);                                                //取消点赞
    void comment(int blogId, int userId, @Param("createTime") String createTime, String comment);    //评论
    void forward(int blogId, int userId, @Param("createTime") String createTime);                    //转发

    void collect(int blogId, int userId, @Param("createTime") String createTime);                    //收藏,插入一条记录
    void addCollectNum(int blogId);                     //收藏数加1
    Integer isCollect(int blogId, int userId);          //是否收藏

    void deductCollectNum(int blogId);                  //收藏数减1
    void cancelCollect(int blogId, int userId);         //删除记录
    void updateMarkWhenCancelCollect(String tagName, int userId);   //取消收藏分数减3
    void cancelCollectByBlogId(int blogId);

    List<BlogLike> searchLikeBlog(int userId);   // 根据用户Id寻找点赞的所有博客id

    void updateMarkWhenLike(String tagName, int userId);
    void updateMarkWhenCancelLike(String tagName, int userId);
    void updateMarkWhenComment(String tagName, int userId);
    void updateMarkWhenForward(String tagName, int userId);
    void updateMarkWhenCollect(String tagName, int userId);

    Integer isliked(int blogId, int userId);
}
