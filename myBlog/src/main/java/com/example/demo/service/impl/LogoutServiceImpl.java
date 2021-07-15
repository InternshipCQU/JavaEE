package com.example.demo.service.impl;

import com.example.demo.service.LogoutService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service("LogoutService")
public class LogoutServiceImpl implements LogoutService {
    @Override
    public void logout(HttpServletRequest  request, HttpServletResponse response){
        HttpSession session = request.getSession();
        //清除session信息
        session.removeAttribute("token");
        session.removeAttribute("userID");
        session.removeAttribute("username");

//        //===   清除cookie
//        Cookie cookieLoginStatue = new Cookie("loginStatue", null);
//        cookieLoginStatue.setMaxAge(0);
//        response.addCookie(cookieLoginStatue);
//
//        Cookie cookieName = new Cookie("ID", null);
//        cookieName.setMaxAge(0);
//        response.addCookie(cookieName);
//        //===

    }
}
