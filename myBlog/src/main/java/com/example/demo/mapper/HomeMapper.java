package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.example.demo.entity.blogInfo;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

//对应HomeService中的功能
@Mapper
public interface HomeMapper {
    List<blogInfo> getBlogs();  //在主页根据用户推送博客
    List<blogInfo> changeCategory(Integer category);  //改变分类
    List<blogInfo> searchBlogs(String keyword); //根据关键词搜索博客
    List<User> recommendUsers(String username); //推荐用户
}
