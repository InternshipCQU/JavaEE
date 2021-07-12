package com.example.demo.service.impl;

import com.example.demo.entity.BlogInfo;
import com.example.demo.entity.TagMark;
import com.example.demo.entity.User;
import com.example.demo.entity.view.CommentView;
import com.example.demo.entity.view.HomeBlogView;
import com.example.demo.mapper.HomeMapper;
import com.example.demo.service.HomeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("HomeService")
public class HomeServiceImpl implements HomeService {

    @Resource
    private HomeMapper homeMapper;

    @Override
    public List<BlogInfo> tagToBlogs(String tagName) {
        return homeMapper.tagToBlogs(tagName);
    }

    @Override
    public List<BlogInfo> searchBlogs(String keyword) {
        return homeMapper.searchBlogs(keyword);
    }

    @Override
    public List<BlogInfo> getBlogs() {
        return homeMapper.getBlogs();
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

    @Override
    public List<HomeBlogView> getRecommendBlogViews(int tagId) {
        List<HomeBlogView> blogList = homeMapper.getRecommendBlogViews(tagId);
        for(int i = 0; i < blogList.size(); i++){
            int blogId = blogList.get(i).getBlogId();
            List<CommentView> commentList = homeMapper.getCommentViews(blogId);
            blogList.get(i).setCommentList(commentList);
        }
        return blogList;
    }

    @Override
    public TagMark getTagMark(int userId) {
        return homeMapper.getTagMark(userId);
    }
}
