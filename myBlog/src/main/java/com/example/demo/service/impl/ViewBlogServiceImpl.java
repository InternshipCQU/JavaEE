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
    public String like(int blogId, int currentLikes) {
        viewBlogMapper.like(blogId, currentLikes + 1);
        return "点赞成功";
    }

    @Override
    public void cancelLike(int blogId, int currentLikes) {
        viewBlogMapper.cancelLike(blogId, currentLikes - 1);
    }

    @Override
    public String comment(int blogId, int userId, String comment) {
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        viewBlogMapper.comment(blogId, userId, ft.format(dNow), comment);
        return "评论成功";
    }

    @Override
    public void forward(int blogId, int userId) {
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        viewBlogMapper.forward(blogId, userId, ft.format(dNow));
    }

    @Override
    public void collect(int blogId, int userId) {
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        viewBlogMapper.collect(blogId, userId, ft.format(dNow));
    }
}
