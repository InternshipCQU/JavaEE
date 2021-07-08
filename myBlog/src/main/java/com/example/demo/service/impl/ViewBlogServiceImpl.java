package com.example.demo.service.impl;

import com.example.demo.mapper.ViewBlogMapper;
import com.example.demo.service.ViewBlogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ViewBlogServiceImpl implements ViewBlogService {

    @Autowired
    private ViewBlogMapper viewBlogMapper;

    @Override
    public String like(Integer blogId, Integer currentLikes) {
        viewBlogMapper.like(blogId, currentLikes + 1);
        return "点赞成功";
    }

    @Override
    public void cancelLike(Integer blogId, Integer currentLikes) {
        viewBlogMapper.cancelLike(blogId, currentLikes - 1);
    }

    @Override
    public String comment(Integer blogId, Integer userId, String comment) {
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        viewBlogMapper.comment(blogId, userId, ft.format(dNow), comment);
        return "评论成功";
    }

    @Override
    public void forward(Integer blogId, Integer userId) {
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        viewBlogMapper.forward(blogId, userId, ft.format(dNow));
    }

    @Override
    public void collect(Integer blogId, Integer userId) {
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        viewBlogMapper.collect(blogId, userId, ft.format(dNow));
    }
}
