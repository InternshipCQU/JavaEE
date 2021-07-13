package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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


    //TODO:记得改成转发形式 不要停留在这个路径
    @PostMapping("/tologin")
    public void login(@RequestParam("username") String username, @RequestParam("password") String password,  Model model, HttpServletResponse response, HttpServletRequest request) throws IOException {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        model.addAttribute("user",user);
        boolean submitStatue1 = loginSer.checkTheInfo(username,password);
        boolean submitStatue2 = loginSer.checkUser(username);

        if(submitStatue1 && submitStatue2){
            loginSer.setToken(username,password,response,request);
            response.sendRedirect("/index");
            return ;//
            // TODO:这里是需要转成个人博客界面（需要像数据库索取数据 用Model传值）
        }
        response.sendRedirect("/login");//TODO:返回登录页面
        return;
    }

}
