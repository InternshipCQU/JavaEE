package com.example.demo.service;

import com.example.demo.entity.TagMark;
import com.example.demo.entity.User;
import com.example.demo.utils.SplitString;
import org.springframework.data.relational.core.sql.In;

import com.example.demo.entity.view.HomeBlogView;
import com.example.demo.entity.BlogInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

import java.util.List;

//博客主页相关功能
public interface HomeService {
    List<BlogInfo> tagToBlogs(String tagId);                 // 根据标签查找对应的博客
    List<BlogInfo> searchBlogs(String keyword);             // 根据关键词搜索博客
    List<BlogInfo> getBlogs();                              // 主页展示全站点击数top10博客
    List<User> showHotBlogger();                            // 用户未登录时，推送热门博主【全站点赞数top6】
    List<User> showRecommendBlogger(int userId);            // 用户登录后，推送其关注的博主【关注博主中点赞数top6】


    String getTheClass(String s);

    String giveTheBlogToIndex(String cla,HttpServletRequest request);
    void Init(String cla,HttpServletRequest request);



    ArrayList<HomeBlogView> getBlogViews();                      // 按照首页格式查询出对应的博客
    List<HomeBlogView> getRecommendBlogViews(int tagId);    // 按照首页格式，以及推荐算法查询出对应的博客

    TagMark getTagMark(int userId);                         //根据userId获取该用户的标签评分

}
