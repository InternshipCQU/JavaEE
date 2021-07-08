package com.example.demo.controller;

import com.example.demo.service.LogoutService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller()
public class LogoutController {

    @Resource
    private LogoutService logoutSer;

    @RequestMapping("/logout")
    public String logout(){
        return "logout";
    }

    @RequestMapping("/tologout")
    public String tologout(HttpServletRequest request, HttpServletResponse response){
        logoutSer.logout(request,response);
        //TODO:这里应该转成重定向到mainpage
        return "mainpage";
    }
}
