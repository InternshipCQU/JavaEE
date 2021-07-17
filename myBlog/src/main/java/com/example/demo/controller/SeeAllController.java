package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.userinfoallService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SeeAllController {
    @Resource
    userinfoallService userinfoallService;


    @RequestMapping("/seeAllfollow")
    public String to(HttpServletRequest request){
        HttpSession session = request.getSession();
        userinfoallService.Init(request);
        return "seeallfollow";
    }

    @RequestMapping("/reqfollow")
    @ResponseBody
    public String reqfollow(HttpServletRequest request){
        String s=userinfoallService.getallfollow(request);
        System.out.println(s);
        return s;
    }

}
