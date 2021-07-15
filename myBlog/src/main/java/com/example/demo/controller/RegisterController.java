package com.example.demo.controller;

import com.example.demo.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RegisterController {

    @Resource
    private RegisterService registerService;

    @GetMapping("/register")
    public String register(){//注册界面
        return "form-singup";
    }

    @RequestMapping("/register/{username}/{password}")     //点击标签后查询对应标签的博客
    public String addUser(@PathVariable("username") String username, @PathVariable("password") String password, Model model){
        registerService.addUser(username, password);
        return "test-register";
    }

    @RequestMapping("/toRegist")//这里连接前端的注册按钮
    @ResponseBody
    public String ajax(@RequestParam("username") String a){//TODO:这里的参数是注册信息 有多个 暂时先写一个 记得在前端进行success之后的页面跳转
        return "login";
    }
}
