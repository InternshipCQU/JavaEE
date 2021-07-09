package com.example.demo.service.impl;

import com.example.demo.entity.Blog;
import com.example.demo.entity.blogInfo;
import com.example.demo.mapper.BlogMapper;
import com.example.demo.service.BlogService;
import com.example.demo.utils.GetTime;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Service("BlogService")
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogMapper blogMapper;

    @Override
    public blogInfo getBlog(String userId, String blogId) {
        return blogMapper.getBlog(userId, blogId);
    }

    @Override
    public String like(String blogId, String currentLikes) {
        int i = Integer.getInteger(currentLikes) + 1;
        blogMapper.like(blogId, Integer.toString(i));
        return "点赞成功";
    }

    @Override
    public void cancelLike(String blogId, String currentLikes) {
        int i = Integer.getInteger(currentLikes) -1;
        blogMapper.cancelLike(blogId, Integer.toString(i));
    }

    @Override
    public String comment(String blogId, String userId, String comment) {
        GetTime getTime = new GetTime();
        blogMapper.comment(blogId, userId, getTime.getCurrentTime(), comment);
        return "评论成功";
    }

    @Override
    public String forward(String blogId, String userId) {
        GetTime getTime = new GetTime();
        blogMapper.forward(blogId, userId, getTime.getCurrentTime());
        return "转发成功";
    }

    @Override
    public String collect(String blogId, String userId) {
        GetTime getTime = new GetTime();
        blogMapper.collect(blogId, userId, getTime.getCurrentTime());
        return "收藏成功";
    }
}
