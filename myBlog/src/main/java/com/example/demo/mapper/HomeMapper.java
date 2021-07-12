package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.example.demo.entity.BlogInfo;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

//对应HomeService中的功能
@Mapper
public interface HomeMapper {
    // 根据标签查询对应博客
    List<BlogInfo> tagToBlogs(int tagId);

    // 根据标签或博客标题搜索对应博客
    List<BlogInfo> searchBlogs(String keyword);

    //【未登录】展示热门博主(top6)
    List<User> showHotBlogger();

    // 【登录】展示推荐博主(top6)
    List<User> showRecommendBlogger(int userId);

    // 展示热门博客(top10)
    List<BlogInfo> getBlogs();

//    List<blogInfo> getBlogs(String username);  //在主页根据用户推送博客
//    List<blogInfo> changeCategory(Integer category);  //改变分类
}
