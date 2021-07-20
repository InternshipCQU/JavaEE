package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.RegisterMapper;
import com.example.demo.service.RegisterService;
import com.example.demo.utils.code;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;

@Service("SubmitService")
public class RegisterServiceImpl implements RegisterService {



//    @Override
//    boolean checkUser(String username)
//    {
//
//    }
    @Resource
    private RegisterMapper registerMapper;

    @Override
    public boolean checkUser(String signUsername)
    {
        if(registerMapper.userExist(signUsername) == null) return false;
        else return true;
    }

    @Override
    public boolean checkPassword(String signPassword, String comfirmPassword)
    {
        if (signPassword.equals(comfirmPassword))
        {
            return true;
        }
        else return false;
    }


    @Override
    public void submitInfo(User user) throws NoSuchAlgorithmException {
        //TODO:记得在这里将密码进行加密处理 ,暂时将其用password代替
        String password = "s";
        code.encode(password);
        //TODO:这里去利用DAO层的新建用户操作进行创建
    }



    @Override
    public void addUser(String username, String password, String userRegisterTime) {
        String defaultAvatar = "https://bucket-myblog.oss-cn-beijing.aliyuncs.com/avatar/defaultAvatar.jpg";
        String defaultBackground = "https://bucket-myblog.oss-cn-beijing.aliyuncs.com/background/defaultBackground.jpg";
        registerMapper.addUser(username, password, userRegisterTime, defaultAvatar, defaultBackground);
    }
}
