package com.example.demo.service.impl;

import com.example.demo.service.LogoutService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service("LogoutService")
public class LogoutServiceImpl implements LogoutService {
    @Override
    public void logout(HttpServletRequest  request, HttpServletResponse response){
        request.getSession().removeAttribute("token");//清除登录状态的token

        //===   清除cookie
        Cookie cookieLoginStatue = new Cookie("loginStatue", null);
        cookieLoginStatue.setMaxAge(0);
        response.addCookie(cookieLoginStatue);

        Cookie cookieName = new Cookie("ID", null);
        cookieName.setMaxAge(0);
        response.addCookie(cookieName);
        //===

    }
}
