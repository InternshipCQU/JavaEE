package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String register(){//注册界面
        return "form-singup";
    }

    @RequestMapping("/toRegist")//这里连接前端的注册按钮
    @ResponseBody
    public String ajax(@RequestParam("username") String a){//TODO:这里的参数是注册信息 有多个 暂时先写一个 记得在前端进行success之后的页面跳转

        return "login";
    }
}
