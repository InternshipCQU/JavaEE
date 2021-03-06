package com.example.demo.service.impl;

import com.example.demo.entity.BlogInfo;
import com.example.demo.entity.User;
import com.example.demo.entity.BlogInfo;
import com.example.demo.mapper.PersonalSpaceMapper;

import com.example.demo.service.PersonalSpaceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("PersonalSpaceService")
public class PersonalSpaceServiceImpl implements PersonalSpaceService{

    @Resource
    private PersonalSpaceMapper personalSpaceMapper;

    @Override
    public List<BlogInfo> showCalendarFigure(String username)
    {
        return personalSpaceMapper.showCalendarFigure(username);
    }

    @Override
    public List<BlogInfo> blogs(int userID){
        //TODO:这里需要用到mapper 在数据库里面查找他的博客
        List<BlogInfo> blogs = new ArrayList<>();
        return blogs;
    }

    @Override
    public List<User> users(int userID){
        List<User> users = new ArrayList<>();
        return users;
    }
}
