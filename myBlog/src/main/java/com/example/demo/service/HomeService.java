package com.example.demo.service;

import com.example.demo.entity.Blog;
import com.example.demo.entity.User;
import com.example.demo.entity.blogInfo;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

//博客主页相关功能
public interface HomeService {
    List<blogInfo> getBlogs(String username);  //在主页根据用户推送博客
    List<blogInfo> changeCategory(Integer category);  //改变分类
    List<blogInfo> searchBlogs(String keyword); //根据关键词搜索博客
    List<User> recommendUsers(String username); //推荐用户
}
