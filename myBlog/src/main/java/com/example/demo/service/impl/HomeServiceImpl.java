package com.example.demo.service.impl;

import com.example.demo.entity.Blog;
import com.example.demo.entity.User;
import com.example.demo.entity.blogInfo;
import com.example.demo.mapper.HomeMapper;
import com.example.demo.service.HomeService;
import com.example.demo.utils.SplitString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.example.demo.utils.SplitString.splitId;

@Service("HomeService")
public class HomeServiceImpl implements HomeService {

    @Resource
    private HomeMapper homeMapper;

    public List<blogInfo> tagToBlogs(int tagId) {
        return homeMapper.tagToBlogs(tagId);
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

    @Override
    public String getTheClass(String s){
        String[] strs =  SplitString.splitId(s);
        return strs[strs.length-1];
    }
}
