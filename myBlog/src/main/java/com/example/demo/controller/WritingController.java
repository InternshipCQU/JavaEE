package com.example.demo.controller;

import com.example.demo.entity.BlogDraft;
import com.example.demo.entity.BlogInfo;
import com.example.demo.service.BlogManagerService;
import com.example.demo.service.BlogService;
import com.example.demo.service.BlogWritingService;

import com.example.demo.service.HomeService;
import com.huawei.shade.com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Controller
public class WritingController {

    @Resource
    private BlogWritingService blogWritingService;

    @Resource
    private BlogManagerService blogManagerService;

    @Resource
    HomeService homeService;

    @RequestMapping("/writing")//TODO:记得加入filter中 现在不加 为了测试
    public String writing(HttpServletRequest request, Model model){
        homeService.setBlogger(request, model);
        int userID = (Integer) request.getSession().getAttribute("userID");
        BlogDraft draft = blogWritingService.getDraft(userID);

        model.addAttribute("draft",draft);

        return "writing";
    }


    @RequestMapping("/submitarticle")
    @ResponseBody
    public String submitArticle(@RequestParam("blogTitle") String blogTitle, @RequestParam("blogContent") String blogContent,
                                @RequestParam("tagName") String tagName, @RequestParam("createTime") String createTime,
                                @RequestParam("summaryContent") String summaryContent, HttpServletRequest request) throws UnsupportedEncodingException {
        JSONObject result = new JSONObject();

        blogTitle = URLDecoder.decode(blogTitle,"utf-8");
        blogContent = URLDecoder.decode(blogContent,"utf-8");
        createTime = URLDecoder.decode(createTime,"utf-8");
        summaryContent = URLDecoder.decode(summaryContent,"utf-8");

        System.out.println(blogTitle);
        System.out.println(blogContent);
        System.out.println(createTime);
        System.out.println(tagName);

        try{

            blogWritingService.submitBlog(blogTitle, blogContent, createTime, tagName, 0, summaryContent,request);
//            System.out.println("here");
            result.put("result","success");
            return result.toJSONString();
        } catch (Exception e){
//            error("保存文章报错:{}"+e);
            System.out.println(e);
            result.put("result","error");
            return result.toJSONString();
        }
    }


    @RequestMapping("/submitmodificaation")
    @ResponseBody
    public String submitModification(@RequestParam("blogID") int blogID, @RequestParam("blogTitle") String blogTitle, @RequestParam("blogContent") String blogContent,
                                @RequestParam("tagName") String tagName, @RequestParam("createTime") String createTime,
                                @RequestParam("summaryContent") String summaryContent, HttpServletRequest request) throws UnsupportedEncodingException {
        JSONObject result = new JSONObject();

        blogTitle = URLDecoder.decode(blogTitle,"utf-8");
        blogContent = URLDecoder.decode(blogContent,"utf-8");
        createTime = URLDecoder.decode(createTime,"utf-8");
        summaryContent = URLDecoder.decode(summaryContent,"utf-8");

        System.out.println(blogTitle);
        System.out.println(blogContent);
        System.out.println(createTime);
        System.out.println(tagName);
        int userID = (Integer) request.getSession().getAttribute("userID");

        try{
            //先提交一篇新的博客
            blogWritingService.submitBlog(blogTitle, blogContent, createTime, tagName, 0, summaryContent,request);
            System.out.println("发布新博客成功");
            //然后将旧的博客删掉
            blogManagerService.deleteblog(blogID, userID);
            System.out.println("删除旧博客成功");

            result.put("result","success");
            return result.toJSONString();
        } catch (Exception e){
            System.out.println(e);
            result.put("result","error");
            return result.toJSONString();
        }
    }


    @RequestMapping("submitdraft")
    @ResponseBody
    public String submitDraft(@RequestParam("draftTitle") String draftTitle, @RequestParam("draftContent") String draftContent,
                              @RequestParam("draftTagName") String draftTagName, HttpServletRequest request) throws UnsupportedEncodingException {
        JSONObject result = new JSONObject();

        draftTitle = URLDecoder.decode(draftTitle,"utf-8");
        draftContent = URLDecoder.decode(draftContent,"utf-8");


        try{
            blogWritingService.submitDraft(draftTitle, draftContent, draftTagName, request);
//            System.out.println("here");
            result.put("result","success");
            return result.toJSONString();
        } catch (Exception e){
//            error("保存文章报错:{}"+e);
            System.out.println(e);
            result.put("result","error");
            return result.toJSONString();
        }
    }

    @RequestMapping("editblog/{blogId}")
    public String editDraft(@PathVariable("blogId") int blogID, HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {
        BlogInfo blog = blogWritingService.getBlog(blogID);
        homeService.setBlogger(request,model);
        if(request.getSession().getAttribute("userID") == null){
            response.sendRedirect("/login");
            return null;
        }
        int userID = (Integer) request.getSession().getAttribute("userID");
        model.addAttribute("blog",blog);
        if(userID == blog.userId) return "editblog";
        else return "index";
    }

}
