package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.profileMapper;
import com.example.demo.service.getService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("getService")
public class getServiceImpl implements getService {
<<<<<<< HEAD
    @Autowired
    private profileMapper profileMapper;
=======
    @Resource
    private com.example.demo.mapper.profileMapper profileMapper;
>>>>>>> c076d2d27a7369173f4b8d8e26adba4aac944611

    @Override
    public User getuserprofile(int userID){
        User userprofile=profileMapper.getUser(userID);
        return userprofile;
    }





}
