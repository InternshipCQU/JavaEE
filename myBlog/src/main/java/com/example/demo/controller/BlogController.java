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

    @Resource
    private BlogService blogService;

    @RequestMapping("/blogs/{userID}/{blogId}")
    public String blog(@PathVariable("blogId") int blogId,@PathVariable("userID") String userID, Model model){
        BlogInfo blog = blogService.getBlog(blogId);
        model.addAttribute("blog",blog);

        return "blogpage";
    }

    @RequestMapping("/getTheBlogs")
    @ResponseBody
    public int like(@PathVariable("blogId") int blogId, @PathVariable("currentLikes") int currentLikes){
        //TODO:这里向数据库写点赞信息 之后应该进行刷新操作
        blogService.like(blogId, currentLikes + 1);
        return currentLikes + 1;
    }

    @RequestMapping("/getTheBlogs")
    @ResponseBody
    public int cancelLike(@PathVariable("blogId") int blogId, @PathVariable("currentLikes") int currentLikes){
        //TODO:这里向数据库写取消点赞信息 之后应该进行刷新操作
        blogService.cancelLike(blogId, currentLikes - 1);
        return currentLikes - 1;
    }

    @RequestMapping("/getTheBlogs")
    @ResponseBody
    public void comment(@PathVariable("blogId") int blogId, @PathVariable("userId") int userId, @RequestBody String comment){
        //TODO:这里向数据库写评论信息 之后应该进行刷新操作
        blogService.comment(blogId, userId, comment);
    }

    @RequestMapping("/getTheBlogs")
    @ResponseBody
    public void forward(@PathVariable("blogId") int blogId, @PathVariable("userId") int userId){
        //TODO:这里向数据库写转发信息
        blogService.forward(blogId, userId);
    }

    @RequestMapping("/blogs/follow")
    @ResponseBody
    public void follow(@PathVariable("blogId") int blogId, @PathVariable("userId") int userId){
        //TODO:这里向数据库写转发信息
        blogService.forward(blogId, userId);
    }
}
