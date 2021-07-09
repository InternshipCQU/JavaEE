package com.example.demo.mapper;

import com.example.demo.entity.Blog;

import java.util.List;

//对应HomeService中的功能
public interface HomeMapper {
    List<Blog> getBlogs(String username);  //在主页根据用户推送博客
    List<Blog> changeCategory(Integer category);  //改变分类
    List<Blog> searchBlogs(String keyword); //根据关键词搜索博客
}
