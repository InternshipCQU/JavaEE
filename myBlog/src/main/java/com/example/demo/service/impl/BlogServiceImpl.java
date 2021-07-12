package com.example.demo.service.impl;

import com.example.demo.entity.BlogInfo;
import com.example.demo.mapper.BlogMapper;
import com.example.demo.service.BlogService;
import com.example.demo.utils.GetTime;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Component
@Service("BlogService")
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogMapper blogMapper;

    @Override
    public BlogInfo getBlog(int blogId) {
        return blogMapper.getBlog(blogId);
    }

    @Override
    public String like(int blogId, int currentLikes) {
        int i = currentLikes + 1;
        blogMapper.like(blogId, i);
        return "点赞成功";
    }

    @Override
    public void cancelLike(int blogId, int currentLikes) {
        int i = currentLikes -1;
        blogMapper.cancelLike(blogId, i);
    }

    @Override
    public String comment(int blogId, int userId, String comment) {
        GetTime getTime = new GetTime();
        blogMapper.comment(blogId, userId, getTime.getCurrentTime(), comment);
        return "评论成功";
    }

    @Override
    public String forward(int blogId, int userId) {
        GetTime getTime = new GetTime();
        blogMapper.forward(blogId, userId, getTime.getCurrentTime());
        return "转发成功";
    }

    @Override
    public String collect(int blogId, int userId) {
        GetTime getTime = new GetTime();
        blogMapper.collect(blogId, userId, getTime.getCurrentTime());
        return "收藏成功";
    }
}
