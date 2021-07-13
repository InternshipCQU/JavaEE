package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.entity.UserLike;
import com.example.demo.mapper.profileMapper;
import com.example.demo.service.getService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("getService")
public class getServiceImpl implements getService {


    @Resource
    private profileMapper profileMapper;


    @Override
    public User getuserprofile(Integer userID){
        User userprofile=profileMapper.getUser(userID);
        return userprofile;
    }

    @Override
    public List<UserLike> getfollowing(Integer userId){
        List<UserLike> ul=profileMapper.getfollowing(userId);
        return ul;
    }

    @Override
    public String getusername(Integer userId){
        String res=profileMapper.getusername(userId);
        return res;
    }

}
