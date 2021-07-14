package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class BlogListController {
    @RequestMapping("bloglist")
    public String bloglist(){
        return "bloglist";
    }

    @RequestMapping(value="/deletemyblog",method = RequestMethod.GET)
    public void deletemyblog(HttpServletRequest request, HttpServletResponse response,){}
}
