package com.example.demo.controller;

import com.example.demo.service.LogoutService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller()
public class LogoutController {

    @Resource
    private LogoutService logoutSer;

    @RequestMapping("/tologout")
    public void tologout(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        model.addAttribute("href","login");
        logoutSer.logout(request,response);
        //TODO:这里应该转成重定向到mainpage
        response.sendRedirect("/index/a");
        return ;
    }

    @RequestMapping("/logout")
    public ModelAndView logout(ModelAndView modelAndView, HttpServletRequest  request, HttpServletResponse response)
    {
        logoutSer.logout(request, response);
        //重定向到登录页面
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }

    @RequestMapping("/ajax")
    @ResponseBody
    public String ajax(@RequestParam("class") String cla, HttpServletResponse response,Model model){
        model.addAttribute("test","www.baidu.com");

        Cookie cookieLoginStatue = new Cookie("logout", cla);
        response.addCookie(cookieLoginStatue);
        return "{\"test\" : cla}";
    }//做ajax测试用 记得删除 这个可以用作点赞等功能的实现

}
