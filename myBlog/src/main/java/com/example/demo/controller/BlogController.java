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
    @RequestMapping("personalspace")
    public String personalspace(){
        return "personalspace";
    }

    @RequestMapping("blogpage")
    public String blog(){
        return "blogpage";
    }
    @Resource
    private BlogService blogService;

    @RequestMapping("/blogs/{userID}/{blogId}")
    public String blog(@PathVariable("blogId") int blogId,@PathVariable("userID") String userID, Model model){
        BlogInfo blog = blogService.getBlog(blogId);
        model.addAttribute("blog",blog);

        return "blogpage";
    }


    @RequestMapping("/blogs/like")
    public void like(@RequestParam("blogId") int blogId, @RequestParam("userId") int userId, @RequestParam("tagId") int tagId){
        blogService.like(blogId);
        blogService.updateMarkWhenLike(tagId, userId);
    }

    @RequestMapping("/blogs/cancelLike")
    public void cancelLike(@RequestParam("blogId") int blogId, @RequestParam("userId") int userId, @RequestParam("tagId") int tagId){
        blogService.cancelLike(blogId);
        blogService.updateMarkWhenCancelLike(tagId, userId);
    }

    @RequestMapping("/blogs/comment")
    public void comment(@RequestParam("blogId") int blogId, @RequestParam("userId") int userId,
                        @RequestParam("tagId") int tagId,@RequestParam("comment") String comment){

        blogService.comment(blogId, userId, comment);
        blogService.updateMarkWhenComment(tagId, userId);
    }


    @RequestMapping("/blogs/forward")
    public void forward(@RequestParam("blogId") int blogId, @RequestParam("userId") int userId,
                        @RequestParam("tagId") int tagId){

        blogService.forward(blogId, userId);
        blogService.updateMarkWhenForward(tagId, userId);
    }

    @RequestMapping("/blogs/collect")
    public void collect(@RequestParam("blogId") int blogId, @RequestParam("userId") int userId,
                        @RequestParam("tagId") int tagId){
        blogService.collect(blogId, userId);
        blogService.updateMarkWhenCollect(tagId, userId);
    }

    @RequestMapping("/blogs/follow")
    @ResponseBody
    public void follow(@PathVariable("blogId") int blogId, @PathVariable("userId") int userId){
        //TODO:这里向数据库写转发信息
        blogService.forward(blogId, userId);
    }

    @RequestMapping("/blogs/{userId}")
    // 根据userId查找该用户点赞过的所有博客id
    public String searchLikeBlog(@PathVariable("userId") int userId, Model model) {
        model.addAttribute("searchLikeBlogList", blogService.searchLikeBlog(userId));
        return "test-searchLikeBlog";
    }
}
