package com.example.demo.controller;

import com.example.demo.entity.BlogInfo;
import com.example.demo.service.BlogService;
import com.example.demo.service.BlogWritingService;
import com.example.demo.service.HomeService;
import com.example.demo.service.impl.SensitiveFilterService;
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

    @Resource
    SensitiveFilterService sensitiveFilterService;

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
    public void querylike(@RequestParam("blogId") int blogId, @RequestParam("userId") int userId,  HttpServletResponse response,HttpServletRequest request) throws JSONException, IOException{
        boolean f=blogService.isliked(blogId,userId);
//        System.out.println("is like?:"+f);
        JSONObject object=new JSONObject();
        HttpSession session=request.getSession();
        if(session.getAttribute("token")=="yes") {
            object.put("IsLiked",f);
            object.put("ISLOGIN",true);
        }
        else{
            object.put("IsLiked",false);
            object.put("ISLOGIN",false);
        }
        response.getWriter().write(object.toString());
    }

    @RequestMapping("/blogs/like")
    @ResponseBody
    public void like(@RequestParam("blogId") int blogId, @RequestParam("userId") int userId, @RequestParam("tagId") int tagId, HttpServletResponse response,HttpServletRequest request) throws JSONException, IOException {
        System.out.println("like");
        HttpSession session=request.getSession();
        if(session.getAttribute("token")=="yes") {
            if(blogService.isliked(blogId,userId)){
                return;
            }
            blogService.like(blogId);
            blogService.writelikerecord(blogId, userId);
            blogService.updateMarkWhenLike(tagId,userId);

//            JSONObject object = new JSONObject();
//            response.getWriter().write(object.toString());
        }
    }

    @RequestMapping("/blogs/cancelLike")
    @ResponseBody
    public void cancelLike(@RequestParam("blogId") int blogId, @RequestParam("userId") int userId, @RequestParam("tagId") int tagId,HttpServletResponse response,HttpServletRequest request) throws JSONException,IOException {
        
        System.out.println("cancelLike");
        HttpSession session=request.getSession();
        if(session.getAttribute("token")=="yes") {
            JSONObject object = new JSONObject();
            blogService.cancelLike(blogId);
            blogService.deletelikerecord(blogId, userId);
            blogService.updateMarkWhenCancelLike(tagId, userId);

            response.getWriter().write(object.toString());
        }
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
        comment = SensitiveFilterService.getInstance().replaceSensitiveWord(comment, 1, "*");

        blogService.comment(blogId, userId, comment);
        blogService.updateMarkWhenComment(tagId, userId);
        return "{\"login\":\"true\"}";//TODO:记得写到Service里
    }


    @RequestMapping("/blogs/forward")
    @ResponseBody
    public String forward(@RequestParam("blogId") int blogId,
                        @RequestParam("tagId") int tagId,HttpServletRequest request){
        System.out.println("转发");
        HttpSession session = request.getSession();
        if(session.getAttribute("userID") == null){
            return "{\"login\":\"false\"}";
        }
        int userId = (Integer)session.getAttribute("userID");
        BlogInfo blog = blogService.getBlog(blogId);
        blogWritingService.addBlog(blog.blogTitle,blog.blogContent,blog.createTime,blog.tagName,1,blog.summary,request);
        blogService.forward(blogId, userId);
        blogService.updateMarkWhenForward(tagId, userId);
        return "{\"login\":\"true\"}";//TODO:记得写到Service里
    }

    @RequestMapping("/blogs/isCollect")
    public void isCollect(@RequestParam("blogId") int blogId,
                          @RequestParam("tagId") int tagId, Model model, HttpServletResponse response, HttpServletRequest request) throws JSONException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("userID") == null)
        {
            JSONObject object=new JSONObject();
            object.put("isLogin","no");
            response.getWriter().write(object.toString());
        }
        else
        {
            int userId = (int) session.getAttribute("userID");
            boolean isCollect = blogService.isCollect(blogId, userId);
//        model.addAttribute("isCollect",isCollect);
//        System.out.println("isCollect: "+model.getAttribute("isCollect"));
            JSONObject object=new JSONObject();
            object.put("isCollect",isCollect);
            object.put("isLogin","yes");
            response.getWriter().write(object.toString());
        }

    }


    @RequestMapping("/blogs/collect")
    @ResponseBody
    public void collect(@RequestParam("blogId") int blogId,
                        @RequestParam("tagId") int tagId, Model model, HttpServletRequest request){

        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userID");
        blogService.collect(blogId, userId);
        blogService.addCollectNum(blogId);
//        System.out.println("收藏");
        blogService.updateMarkWhenCollect(tagId, userId);


    }

    @RequestMapping("/blogs/cancelCollect")
    @ResponseBody
    public void cancelCollect (@RequestParam("blogId") int blogId,
                               @RequestParam("tagId") int tagId, Model model, HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userID");
        blogService.cancelCollect(blogId, userId);
//        System.out.println("取消收藏");
        blogService.deductCollectNum(blogId);
//        System.out.println("数量减1");
        blogService.updateMarkWhenCancelCollect(tagId, userId);
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
