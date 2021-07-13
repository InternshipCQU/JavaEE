package com.example.demo.service.impl;

import com.example.demo.entity.BlogComment;
import com.example.demo.entity.BlogCommentVo;
import com.example.demo.entity.BlogInfoVo;
import com.example.demo.mapper.BlogDetailsMapper;
import com.example.demo.service.BlogDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Component
@Service("BlogDetails")
public class BlogDetailsServiceImpl implements BlogDetailsService {
    @Resource
    private BlogDetailsMapper blogDetailsMapper;

    @Override
    public BlogInfoVo showBlogPart(int blogId){

        return blogDetailsMapper.showBlogPart(blogId);
    }

    @Override
    public List<BlogCommentVo> showBlogComment(int blogId){
        return blogDetailsMapper.showBlogComment(blogId);
    }

}
