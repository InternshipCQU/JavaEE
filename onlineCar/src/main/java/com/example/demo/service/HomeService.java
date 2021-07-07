package com.example.demo.service;

import com.example.demo.entity.Blog;
import java.util.List;

//博客主页相关功能
public interface HomeService {
    List<Blog> getBlogs(String username);  //在主页根据用户推送博客
    List<Blog> changeCategory(String category);  //改变分类
    List<Blog> searchBlogs(String keyword); //根据关键词搜索博客
}
