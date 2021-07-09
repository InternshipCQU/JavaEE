package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.profileMapper;
import com.example.demo.service.getService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("getService")
public class getServiceImpl implements getService {
    @Autowired
    private profileMapper profileMapper;

    @Override
    public User getuserprofile(int userID){
        User userprofile=profileMapper.getUser(userID);
        return userprofile;
    }





}
