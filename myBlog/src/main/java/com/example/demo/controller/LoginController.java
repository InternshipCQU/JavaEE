package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

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

//    @RequestMapping("/login")
//    public String to(){
//        return "form-login";
//    }
    @RequestMapping("/login")
    public ModelAndView login(ModelAndView modelAndView)
    {
        modelAndView.setViewName("form-login");
        return modelAndView;
    }


    //TODO:记得改成转发形式 不要停留在这个路径
    @PostMapping("/tologin")
    public ModelAndView login(ModelAndView modelAndView, Model model, HttpServletResponse response, HttpServletRequest request, @RequestParam("username") String username, @RequestParam("password") String password, User user) throws IOException {
//        User user = new User();

        boolean submitStatue1 = loginSer.checkTheInfo(username,password);
        boolean submitStatue2 = loginSer.checkUser(username);
//        System.out.println(bindingResult.hasErrors());
        if (username.equals(""))
        {
            modelAndView.addObject("error_username","请输入用户名");
            modelAndView.setViewName("form-login");
            return modelAndView;
        }

        System.out.println("sub2: "+submitStatue2);
        if (!submitStatue2)
        {
            modelAndView.addObject("error_username", "用户不存在");
            modelAndView.setViewName("form-login");
            return modelAndView;
        }

        if (password.equals(""))
        {
            modelAndView.addObject("error_password", "请输入密码");
            modelAndView.setViewName("form-login");
            return modelAndView;
        }

//        if (bindingResult.hasErrors())
//        {
//            modelAndView.addObject("error", bindingResult.getFieldError().getDefaultMessage());
//            modelAndView.setViewName("form-login");
//            System.out.println("用户名或密码为空");
//            return modelAndView;
//        }

        System.out.println("sub1: "+submitStatue1);
        if (!submitStatue1)
        {
            System.out.println("submitStatue1");
            modelAndView.addObject("error_password", "密码错误");
            modelAndView.setViewName("form-login");
            return modelAndView;
        }

//        if(submitStatue1 && submitStatue2){
//            loginSer.setToken(username,password,response,request);
//            response.sendRedirect("/index");
//            return ;//
//            // TODO:这里是需要转成个人博客界面（需要像数据库索取数据 用Model传值）
//        }
        user.setUsername(username);
        user.setPassword(password);
        model.addAttribute("user",user);
        loginSer.setToken(username, password, response , request);
        modelAndView.setViewName("index");
        response.sendRedirect("/index");//TODO:返回登录页面
        return modelAndView;
    }

}
