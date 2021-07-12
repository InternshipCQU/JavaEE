package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.CheckLoginMapper;
import com.example.demo.mapper.HomeMapper;
import com.example.demo.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Resource
    private CheckLoginMapper checkLoginMapper;

    @Override
    public boolean checkTheInfo(String username,String password){
        //TODO:这里需要增加学生端接口
        if(password.equals(checkLoginMapper.checkPassword(username)))return true;
        return false;
    }

    @Override
    public boolean checkTheCookie(int userID,String cookie,HttpServletRequest request){
        User user;
        //TODO:检测是否有session
        if(request.getSession().getAttribute("verifyToken")==null){

        }
        //TODO:首先第一步去数据库找到该用户（利用userID）
        //user = findByID(userID) DAO层函数

        //TODO:得到该用户的密码
        //user.password

        //TODO:password看是否等于cookie（等于的话就验证成功，不等于就返回错误值）
        return true;
    }

    @Override
    public void setToken(String name, String password, HttpServletResponse response, HttpServletRequest request){
        HttpSession token = request.getSession();
        token.setAttribute("token","yes");
        token.setAttribute("username", name);

        Cookie cookieLoginStatue = new Cookie("loginStatue", "Yes");
        response.addCookie(cookieLoginStatue);

        //这个name应该是用户名
        Cookie cookieName = new Cookie("ID", name);
        response.addCookie(cookieName);

    }



}
