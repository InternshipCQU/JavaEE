package com.example.demo.service.impl;

import com.example.demo.service.loginService;
import org.springframework.stereotype.Service;

@Service("loginService")
public class loginServiceImpl implements loginService {
    @Override
    public boolean checkTheInfo(String username,String passowrd){
        //TODO:这里需要增加学生端接口
        if(username.equals(passowrd))return true;
        return false;
    }
}
