package com.example.demo.service.impl;

import com.example.demo.entity.Blog;
import com.example.demo.entity.blogInfo;
import com.example.demo.mapper.HomeMapper;
import com.example.demo.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeMapper homeMapper;

    @Override
    public List<blogInfo> getBlogs(String username) {
        return homeMapper.getBlogs(username);
    }

    @Override
    public List<blogInfo> changeCategory(Integer category) {
        return homeMapper.changeCategory(category);
    }

    @Override
    public List<blogInfo> searchBlogs(String keyword) {
        return homeMapper.searchBlogs(keyword);
    }
}
