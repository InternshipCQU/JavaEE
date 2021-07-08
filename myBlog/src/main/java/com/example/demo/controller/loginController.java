package com.example.demo.controller;

import com.example.demo.entity.user;
import com.example.demo.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

//@Controller 传递页面
//@RestController 传递json

@Controller
public class loginController {

    @Resource
    private loginService loginSer;

    @ModelAttribute
    public user userModel(@RequestParam("username") String username, @RequestParam("password") String password){
        user user = new user();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }


    @GetMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @ModelAttribute("userModel") user user, Model model){
        model.addAttribute("user",user);
        boolean submitStatue = loginSer.checkTheInfo(username,password);
        if(submitStatue){
            return "personal.html";//TODO:这里是需要转成个人博客界面（需要像数据库索取数据 用Model传值）
        }
        return "login.html";//TODO:返回登录页面
    }

}
