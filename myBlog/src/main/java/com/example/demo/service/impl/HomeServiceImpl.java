package com.example.demo.service.impl;

import com.example.demo.entity.Blog;
import com.example.demo.entity.User;
import com.example.demo.entity.blogInfo;
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
    public List<blogInfo> tagToBlogs(String tagName) {
        return homeMapper.tagToBlogs(tagName);
    }

    @Override
    public List<blogInfo> searchBlogs(String keyword) {
        return homeMapper.searchBlogs(keyword);
    }

    @Override
    public List<User> showHotBlogger() {
        return homeMapper.showHotBlogger();
    }

    @Override
    // 【登陆后】根据关注的人，推荐关注列表热门博主
    public List<User> showRecommendBlogger(int userId) {
        return homeMapper.showRecommendBlogger(userId);
    }

    @Override
    public List<blogInfo> getBlogs() {
        return homeMapper.getBlogs();
    }
}
