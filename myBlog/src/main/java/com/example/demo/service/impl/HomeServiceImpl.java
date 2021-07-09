package com.example.demo.service.impl;

import com.example.demo.entity.Blog;
import com.example.demo.mapper.HomeMapper;
import com.example.demo.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("HomeService")
public class HomeServiceImpl implements HomeService {

    @Resource
    private HomeMapper homeMapper;

    @Override
    public List<Blog> getBlogs(String username) {
        return homeMapper.getBlogs(username);
    }

    @Override
    public List<Blog> changeCategory(Integer category) {
        return homeMapper.changeCategory(category);
    }

    @Override
    public List<Blog> searchBlogs(String keyword) {
        return homeMapper.searchBlogs(keyword);
    }
}
