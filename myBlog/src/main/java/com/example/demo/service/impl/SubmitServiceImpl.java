package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.service.SubmitService;
import com.example.demo.utils.code;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service("SubmitService")
public class SubmitServiceImpl implements SubmitService {
    @Override
    public void submitInfo(User user) throws NoSuchAlgorithmException {
        //TODO:记得在这里将密码进行加密处理 ,暂时将其用password代替
        String password = "s";
        code.encode(password);
        //TODO:这里去利用DAO层的新建用户操作进行创建

    }
}
