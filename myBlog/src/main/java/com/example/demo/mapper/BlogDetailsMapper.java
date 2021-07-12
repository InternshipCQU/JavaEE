package com.example.demo.mapper;

import com.example.demo.entity.BlogComment;
import com.example.demo.entity.BlogCommentVo;
import com.example.demo.entity.BlogInfoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
// 展示博客概述及评论详情
public interface BlogDetailsMapper {
    BlogInfoVo showBlogPart(int blogId);

    List<BlogCommentVo> showBlogComment(int blogId);
}
