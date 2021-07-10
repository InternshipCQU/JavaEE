package com.example.demo.controller;

import com.example.demo.entity.Blog;
import com.example.demo.entity.blogInfo;
import com.example.demo.service.BlogService;
import com.example.demo.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        return "blog-test";
    }

    @GetMapping("/like")
    public void like(@PathVariable("userId") String userId, @PathVariable("blogId") String blogId){
        //TODO:这里向数据库写点赞信息 之后应该进行刷新操作
        blogService.like(blogId, currentLikes);

    }

    @GetMapping("/comment")
    public void like(@PathVariable("userId") String userId, @PathVariable("blogId") String blogId,@PathVariable("comment") String comment){
        //TODO:这里向数据库写评论信息 之后应该进行刷新操作

    }

    @GetMapping("/forward")
    public void forward(@PathVariable("userId") String userId, @PathVariable("blogId") String blogId){
        //TODO:这里向数据库写转发信息

    }
}
