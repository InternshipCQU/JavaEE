package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Controller 传递页面
//@RestController 传递json

@Controller
public class LoginController {

    @Resource
    private LoginService loginSer;

//    @ModelAttribute
//    public User userModel(@RequestParam("username") String username, @RequestParam("password") String password){
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//        return user;
//    }

    @RequestMapping("/login")
    public String to(){
        return "form-login";
    }


    @GetMapping("/tologin")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,  Model model, HttpServletResponse response, HttpServletRequest request){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        model.addAttribute("user",user);
        boolean submitStatue = loginSer.checkTheInfo(username,password);
        loginSer.setToken(username,password,response,request);
        if(submitStatue){
            return "personal";//TODO:这里是需要转成个人博客界面（需要像数据库索取数据 用Model传值）
        }
        return "form-login";//TODO:返回登录页面
    }

}
