package com.example.demo.service.impl;

import com.example.demo.mapper.profileMapper;
import com.example.demo.service.getService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("getService")
public class getServiceImpl implements getService {
    @Autowired
    private com.example.demo.mapper.profileMapper profileMapper;

    @Override
    public String getalias(int userID){
        String alias=profileMapper.getalias(userID);
        return alias;
    }
    @Override
    public String getusername(int userID){
        String username=profileMapper.getusername(userID);
        return username;
    }
}
