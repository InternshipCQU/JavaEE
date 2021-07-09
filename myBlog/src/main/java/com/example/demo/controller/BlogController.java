package com.example.demo.controller;

import com.example.demo.entity.Blog;
import com.example.demo.entity.blogInfo;
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

    @RequestMapping("blogs/{userId}/{blogId}")
    public String getBlog(@PathVariable("userId") String userId, @PathVariable("blogId") String blogId, Model model){
        blogInfo blog = blogService.getBlog(userId, blogId);
        model.addAttribute("blog",blog);
        return "blog";
    }

}
