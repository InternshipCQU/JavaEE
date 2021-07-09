package com.example.demo.utils;

import javax.servlet.http.HttpServletRequest;

public class Statue {//这里是验证是否是登录状态
    public static boolean checkIfLogin(HttpServletRequest req){
        return req.getSession().getAttribute("token") != null;
    }
}
