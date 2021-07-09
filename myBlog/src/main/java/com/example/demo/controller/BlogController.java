package com.example.demo.controller;

import com.example.demo.entity.Blog;
import com.example.demo.service.BlogService;
import com.example.demo.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

//这个是利用restful去数据库寻找数据 将其传给前端 博客展示界面
@Controller
public class BlogController {

    @Resource
    private BlogService blogService;

    @RequestMapping("blogs/{userID}/{blogID}")
    public String blog(@PathVariable("userID") String userID, @PathVariable("blogID") String blogID, Model model){
        Blog blog = blogService.findBlog(userID,blogID);
        model.addAttribute("blog",blog);
        return "blog";
    }
}
