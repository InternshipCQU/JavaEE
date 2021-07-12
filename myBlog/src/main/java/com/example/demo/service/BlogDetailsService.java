package com.example.demo.service;

import com.example.demo.entity.BlogComment;
import com.example.demo.entity.BlogCommentVo;
import com.example.demo.entity.BlogInfo;
import com.example.demo.entity.BlogInfoVo;

import java.util.List;

public interface BlogDetailsService {
    // 展示博客部分内容（默认仅展示开头的200字，具体字数可在xml里修改）；
    // 创建时间；点赞、评论、转发、收藏数；用户姓名；用户头像
    BlogInfoVo showBlogPart(int blogId);

    // 展示博客评论用户，用户姓名，评论时间，评论内容
    List<BlogCommentVo> showBlogComment(int blogId);
}
