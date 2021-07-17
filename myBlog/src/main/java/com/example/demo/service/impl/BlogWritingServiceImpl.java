package com.example.demo.service.impl;

import com.example.demo.constants.MapofTagNameAndTagID;
import com.example.demo.entity.BlogInfo;
import com.example.demo.mapper.BlogMapper;
import com.example.demo.mapper.BlogwritingMapper;
import com.example.demo.service.BlogWritingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service("BlogWritingService")
public class BlogWritingServiceImpl implements BlogWritingService {

    @Resource
    private BlogwritingMapper blogWritingMapper;

    @Override
    public void addblog(String blogTitle, String blogContent,String createTime, String tagName, int isForward,HttpServletRequest request) {

        System.out.println(tagName.getClass().getName().toString());
        MapofTagNameAndTagID map = new MapofTagNameAndTagID();

        System.out.println(tagName);
        int tagID = map.getTagID(tagName);

        //再通过session获取一下用户ID，等后面用户id写入session
        int userID = (int)request.getSession().getAttribute("userID");

        //int userID = 1;

        blogWritingMapper.addblog(blogTitle, blogContent, createTime, tagID, userID,isForward);


    }
}
