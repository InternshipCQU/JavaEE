package com.example.demo.controller;

import com.example.demo.entity.BlogInfo;
import com.example.demo.service.BlogService;
import com.example.demo.service.BlogWritingService;
import com.example.demo.service.HomeService;
import net.sf.json.JSON;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


//这个是利用restful去数据库寻找数据 将其传给前端 博客展示界面
@Controller
public class BlogController {


    @RequestMapping("personalspace")
    public String personalspace(){
        return "personalspace";
    }

    @Resource
    private BlogWritingService blogWritingService;

    @RequestMapping("blogpage")
    public String blog(){
        return "blogpage";
    }
    @Resource
    private BlogService blogService;
    @Resource
    HomeService homeService;

    @RequestMapping("/blogs/{userID}/{blogId}")
    public String blog(@PathVariable("blogId") int blogId,@PathVariable("userID") String userID, Model model,HttpServletRequest request){
        BlogInfo blog = blogService.getBlog(blogId);
        blog.blogId= blogId;
        model.addAttribute("blog",blog);
        blogService.Init(blogId,request);

        //System.out.println(blog.getUserId());
        blogService.getAuthorName(blog.getUserId(),model);
        homeService.setBlogger(request,model);

        return "blogpage";
    }
    @RequestMapping("/blogs/querylike")
    public void querylike(@RequestParam("blogId") int blogId, @RequestParam("userId") int userId,  HttpServletResponse response) throws JSONException, IOException{
        boolean f=blogService.isliked(blogId,userId);
        System.out.println("is like?:"+f);
        JSONObject object=new JSONObject();
        object.put("IsLiked",f);
        response.getWriter().write(object.toString());
    }

    @RequestMapping("/blogs/like")
    public void like(@RequestParam("blogId") int blogId, @RequestParam("userId") int userId, @RequestParam("tagId") int tagId, @RequestParam("likenumber")int num, HttpServletResponse response) throws JSONException, IOException {
        blogService.like(blogId);
        blogService.writelikerecord(blogId,userId);
        System.out.println("im in like");
        JSONObject object=new JSONObject();
        response.getWriter().write(object.toString());

    }

    @RequestMapping("/blogs/cancelLike")
    public void cancelLike(@RequestParam("blogId") int blogId, @RequestParam("userId") int userId, @RequestParam("tagId") int tagId,@RequestParam("likenumber")int num,HttpServletResponse response) throws JSONException,IOException {
        JSONObject object=new JSONObject();
        blogService.cancelLike(blogId);
        blogService.deletelikerecord(blogId,userId);
        System.out.println("im in dislike");
        response.getWriter().write(object.toString());

    }

    @RequestMapping("/blogs/comment")
    @ResponseBody
    public String comment(@RequestParam("blogId") int blogId,
                        @RequestParam("tagId") int tagId,@RequestParam("comment") String comment,HttpServletRequest request){


        System.out.println("comment here");
        HttpSession session = request.getSession();
        if(session.getAttribute("userID") == null){
            return "{\"login\":\"false\"}";
        }
        int userId = (Integer)session.getAttribute("userID");


        blogService.comment(blogId, userId, comment);
        blogService.updateMarkWhenComment(tagId, userId);
        return "{\"login\":\"true\"}";//TODO:记得写到Service里
    }


    @RequestMapping("/blogs/forward")
    @ResponseBody
    public String forward(@RequestParam("blogId") int blogId,
                        @RequestParam("tagId") int tagId,HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("userID") == null){
            return "{\"login\":\"false\"}";
        }
        int userId = (Integer)session.getAttribute("userID");
        BlogInfo blog = blogService.getBlog(blogId);
        blogWritingService.addBlog(blog.blogTitle,blog.blogContent,blog.createTime,blog.tagName,1,blog.blogSummary,request);
        blogService.forward(blogId, userId);
        blogService.updateMarkWhenForward(tagId, userId);
        return "{\"login\":\"true\"}";//TODO:记得写到Service里
    }

    @RequestMapping("/blogs/isCollect")
    public void isCollect(@RequestParam("blogId") int blogId, @RequestParam("userId") int userId,
                          @RequestParam("tagId") int tagId, Model model)
    {
        boolean isCollect = blogService.isCollect(blogId, userId);
        model.addAttribute("isCollect",isCollect);
//        System.out.println(model.getAttribute("isCollect"));
    }


    @RequestMapping("/blogs/collect")
    public void collect(@RequestParam("blogId") int blogId, @RequestParam("userId") int userId,
                        @RequestParam("tagId") int tagId, Model model){

        blogService.collect(blogId, userId);
        blogService.addCollectNum(blogId);
        blogService.updateMarkWhenCollect(tagId, userId);


    }

    @RequestMapping("/blogs/cancelCollect")
    public void cancelCollect (@RequestParam("blogId") int blogId, @RequestParam("userId") int userId,
                               @RequestParam("tagId") int tagId, Model model)
    {

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


    @RequestMapping("/getComments")
    @ResponseBody
    public String getComments(@RequestParam("blogId") int blogId, HttpServletRequest request){
        String s = blogService.giveTheCommentsToBlog(blogId,request);
        //System.out.println("s:"  + s);
        return s;
    }

}
