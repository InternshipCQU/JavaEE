package com.example.demo.controller;

import com.example.demo.entity.BlogInfo;
import com.example.demo.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

//这个是利用restful去数据库寻找数据 将其传给前端 博客展示界面
@Controller
public class BlogController {

    @RequestMapping("blogpage")
    public String blog(){
        return "blogpage";
    }
    @Resource
    private BlogService blogService;

    @RequestMapping("/blogs/{blogId}")
    public String blog(@PathVariable("blogId") int blogId, Model model){
        BlogInfo blog = blogService.getBlog(blogId);
        model.addAttribute("blog",blog);
        return "test-blog";
    }

    @RequestMapping("/like")
    public void like(@RequestParam("blogId") int blogId, @RequestParam("userId") int userId, @RequestParam("tagId") int tagId){
        blogService.like(blogId);
        blogService.updateMarkWhenLike(tagId, userId);
    }

    @RequestMapping("/cancelLike")
    public void cancelLike(@RequestParam("blogId") int blogId, @RequestParam("userId") int userId, @RequestParam("tagId") int tagId){
        blogService.cancelLike(blogId);
        blogService.updateMarkWhenCancelLike(tagId, userId);
    }

    @RequestMapping("/comment")
    public void comment(@RequestParam("blogId") int blogId, @RequestParam("userId") int userId,
                        @RequestParam("tagId") int tagId,@RequestParam("comment") String comment){
        blogService.comment(blogId, userId, comment);
        blogService.updateMarkWhenComment(tagId, userId);
    }

    @RequestMapping("/forward")
    public void forward(@RequestParam("blogId") int blogId, @RequestParam("userId") int userId,
                        @RequestParam("tagId") int tagId){
        blogService.forward(blogId, userId);
        blogService.updateMarkWhenForward(tagId, userId);
    }

    @RequestMapping("/collect")
    public void collect(@RequestParam("blogId") int blogId, @RequestParam("userId") int userId,
                        @RequestParam("tagId") int tagId){
        blogService.collect(blogId, userId);
        blogService.updateMarkWhenCollect(tagId, userId);
    }
}
