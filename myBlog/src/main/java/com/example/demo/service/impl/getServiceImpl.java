package com.example.demo.service.impl;

import com.example.demo.mapper.profileMapper;
import com.example.demo.service.getService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("getService")
public class getServiceImpl implements getService {
    @Resource
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

    @Override
    public char getgender(int userID){
        char gender=profileMapper.getgender(userID);
        return gender;
    }

    @Override
    public String getprofile(int userID){
        String profile=profileMapper.getprofile(userID);
        return profile;
    }

    @Override
    public String getregion(int userID){
        String region=profileMapper.getregion(userID);
        return region;
    }

    @Override
    public String getdateofbirth(int userID){
        String dateofbirth=profileMapper.getregion(userID);
        return dateofbirth;
    }


}
