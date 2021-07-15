package com.example.demo.controller;

import com.example.demo.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Controller
public class RegisterController {

    @Resource
    private RegisterService registerService;

    @GetMapping("/register")
    public String register(){//注册界面
        return "form-singup";
    }

    @RequestMapping("/toRegister")
    public ModelAndView checkRegister(ModelAndView modelAndView, @RequestParam("sign-username") String signUsername, @RequestParam("sign-password") String signPassword,
                                      @RequestParam("sign-email") String signEmail, @RequestParam("confirm-password") String confirmPassword)
    {
        boolean userExits = registerService.checkUser(signUsername);
        boolean checkPassword = registerService.checkPassword(signPassword, confirmPassword);
//        System.out.println("signUsername: "+signUsername);
        if (signUsername.equals(""))
        {
            modelAndView.addObject("userError", "请输入用户名");
            modelAndView.setViewName("form-singup");
            return modelAndView;
        }

//        System.out.println("userExits:"+userExits);
        if (userExits)
        {
            modelAndView.addObject("userError", "用户已存在");
            modelAndView.setViewName("form-singup");
            return modelAndView;
        }

//        System.out.println("signEmail:"+signEmail);
        if (signEmail.equals(""))
        {
            modelAndView.addObject("emailError","请输入邮箱");
            modelAndView.setViewName("form-singup");
            return modelAndView;
        }

//        System.out.println("signPassword:"+signPassword);
//        System.out.println("confirmPassword:"+confirmPassword);
        if (signPassword.equals(""))
        {
            modelAndView.addObject("passwordError","请输入密码");
            modelAndView.setViewName("form-singup");
            return modelAndView;
        }

        if (signPassword.length() < 6 || signPassword.length()>20)
        {
            modelAndView.addObject("passwordError","密码长度必须是6-20位");
            modelAndView.setViewName("form-singup");
            return modelAndView;
        }

//        System.out.println("checkPassword:"+checkPassword);
        if (!checkPassword)
        {
            modelAndView.addObject("passwordError","请确认密码是否一致");
            modelAndView.setViewName("form-singup");
            return modelAndView;
        }

        Calendar calendar = Calendar.getInstance(); // gets current instance of the calendar
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String userRegisterTime = formatter.format(calendar.getTime());
//        System.out.println(userRegisterTime);

        registerService.addUser(signUsername, signPassword, userRegisterTime);
        modelAndView.setViewName("redirect:/login");
        return modelAndView;

    }
//    @RequestMapping("/register/{username}/{password}")     //点击标签后查询对应标签的博客
//    public String addUser(@PathVariable("username") String username, @PathVariable("password") String password, Model model) {
//        registerService.addUser(username, password);
//        return "test-register";
//    }

    @RequestMapping("/toRegist")//这里连接前端的注册按钮
    @ResponseBody
    public String ajax(@RequestParam("username") String a){//TODO:这里的参数是注册信息 有多个 暂时先写一个 记得在前端进行success之后的页面跳转
        return "login";
    }

//    @RequestMapping("/toRegist")//这里连接前端的注册按钮
//    @ResponseBody
//    public String ajax(@RequestParam("username") String a){//TODO:这里的参数是注册信息 有多个 暂时先写一个 记得在前端进行success之后的页面跳转
//        return "login";
//    }
}
