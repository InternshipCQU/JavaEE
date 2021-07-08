package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.service.LoginService;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Override
    public boolean checkTheInfo(String username,String passowrd){
        //TODO:这里需要增加学生端接口
        if(username.equals(passowrd))return true;
        return false;
    }

    @Override
    public boolean checkTheCookie(String userID,String cookie,HttpServletRequest request){
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

        Cookie cookieLoginStatue = new Cookie("loginStatue", "Yes");
        response.addCookie(cookieLoginStatue);

        Cookie cookieName = new Cookie("ID", name);
        response.addCookie(cookieName);

    }


}
