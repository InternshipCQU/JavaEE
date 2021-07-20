package com.example.demo.mapper;

import com.example.demo.entity.*;

import com.example.demo.entity.view.CommentView;
import com.example.demo.entity.view.HomeBlogView;

import org.apache.ibatis.annotations.Mapper;


import java.util.ArrayList;
import java.util.List;

//对应HomeService中的功能
@Mapper
public interface HomeMapper {
    // 根据标签查询对应博客
    List<HomeBlogView> tagToBlogs(String tagName);

    // 根据标签或博客标题搜索对应博客
    ArrayList<BlogInfo> searchBlogs(String keyword);

    // 展示热门博客(top10)
    List<BlogInfo> getBlogs();

    //【未登录】展示热门博主(top6)
    List<User> showHotBlogger();

    // 【登录】展示推荐博主(top6)
    ArrayList<User> showRecommendBlogger(int userId);

    //【未登录】展示热门博客，根据前端页面的格式查询
    // 【登录】根据userId展示热门博客
    List<CommentView> getCommentViews(int blogId);

    ArrayList<HomeBlogView> getBlogViews();

    ArrayList<HomeBlogView> getRecommendBlogViews(int tagId);

    TagMark getTagMark(int userId);

    // 主页推荐people you may want to see
    ArrayList<User> showWantBlogger(int userId);

    // 判断userId是否在关注列表
    String checkIsLikeUser(int userId);

    // 主页展示点击量最高的博客对应的标签(#trending)，需要进行去重
    ArrayList<BlogTag> getTrending();



    //get notification
    ArrayList<news> getNews(int fansId);

    void changeNews(int newsId);

    void addNews(int userId,int fansId,String newsContent);

    void submitfollowing_1(int userId,int fansId);
    void submitfollowing_2(int userId);


}
