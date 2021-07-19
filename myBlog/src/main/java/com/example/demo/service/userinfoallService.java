package com.example.demo.service;

import javax.servlet.http.HttpServletRequest;

public interface userinfoallService {

    public String getallfollow(HttpServletRequest request);
    public void cancelfollow(Integer cancelusr,Integer userId);
    void Init(HttpServletRequest request);
}
