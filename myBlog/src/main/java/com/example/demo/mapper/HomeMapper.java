package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.example.demo.entity.blogInfo;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

//对应HomeService中的功能
@Mapper
public interface HomeMapper {
    // 根据标签查询对应博客
    List<blogInfo> tagToBlogs(String tagName);

    // 根据标签或博客标题搜索对应博客
    List<blogInfo> searchBlogs(String keyword);

    //【未登录】展示热门博主(top6)
    List<User> showHotBlogger();

    // 【登录】展示推荐博主(top6)
    List<User> showRecommendBlogger(int userId);

    // 展示热门博客(top10)
    List<blogInfo> getBlogs();

//    List<blogInfo> getBlogs(String username);  //在主页根据用户推送博客
//    List<blogInfo> changeCategory(Integer category);  //改变分类
}
