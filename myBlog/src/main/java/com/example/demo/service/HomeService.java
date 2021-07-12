package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.BlogInfo;

import java.util.List;

//博客主页相关功能
public interface HomeService {
    List<BlogInfo> tagToBlogs(int tagId);   // 根据标签查找对应的博客
    List<BlogInfo> searchBlogs(String keyword);  // 根据关键词搜索博客
    // 用户未登录时，推送热门博主【全站点赞数top6】
    List<User> showHotBlogger();
    // 用户登录后，推送其关注的博主【关注博主中点赞数top6】
    List<User> showRecommendBlogger(int userId);
    List<BlogInfo> getBlogs();    // 主页展示全站点击数top10博客
}
