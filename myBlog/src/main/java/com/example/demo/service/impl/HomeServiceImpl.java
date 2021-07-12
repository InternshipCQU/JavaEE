package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.entity.blogInfo;
import com.example.demo.entity.view.CommentView;
import com.example.demo.entity.view.HomeBlogView;
import com.example.demo.mapper.HomeMapper;
import com.example.demo.service.HomeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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


    //test
    @Override
    public List<HomeBlogView> getBlogViews(){
        List<HomeBlogView> blogList = homeMapper.getBlogViews();
        for(int i = 0; i < blogList.size(); i++){
            int blogId = blogList.get(i).getBlogId();
            List<CommentView> commentList = homeMapper.getCommentViews(blogId);
            blogList.get(i).setCommentList(commentList);
        }
        return blogList;
    }
}
