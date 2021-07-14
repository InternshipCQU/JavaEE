package com.example.demo.service.impl;


import com.example.demo.mapper.BlogListMapper;
import com.example.demo.service.BloglistService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("BloglistService")
public class BloglistServiceImpl implements BloglistService {

    @Resource
    private BlogListMapper blogss;

    @Override
    public void deleteblog(Integer blogId)
    {
        blogss.deleteblog(blogId);
    }

}
