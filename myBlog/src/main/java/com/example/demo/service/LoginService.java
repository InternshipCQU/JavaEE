package com.example.demo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;

public interface LoginService {
    boolean checkTheInfo(String username,String password);//用于验证是否密码正确
    boolean checkUser(String username); // 用于验证用户名是否存在
    boolean checkTheCookie(int userID,String cookie,HttpServletRequest request);//用于验证cookie 防止二次登录
    void setToken(String name, String password, String lastLogin, HttpServletResponse response, HttpServletRequest request);//根据用户名和密码设置cookie

}
