package com.example.demo.controller;

import com.example.demo.service.BlogService;
import com.example.demo.service.BlogWritingService;

import com.huawei.shade.com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Controller
public class WritingController {

    @Resource
    private BlogWritingService blogWritingService;

    @RequestMapping("/writing")//TODO:记得加入filter中 现在不加 为了测试
    public String writing(){
        return "writing";
    }

    @RequestMapping("/submitarticle")
    @ResponseBody
    public String submitArticle(@RequestParam("blogTitle") String blogTitle, @RequestParam("blogContent") String blogContent,
                                @RequestParam("tagName") String tagName, @RequestParam("createTime") String createTime, HttpServletRequest request) throws UnsupportedEncodingException {
        JSONObject result = new JSONObject();

        blogTitle = URLDecoder.decode(blogTitle,"utf-8");
        blogContent = URLDecoder.decode(blogContent,"utf-8");
        createTime = URLDecoder.decode(createTime,"utf-8");
//        tagName = URLDecoder.decode(tagName,"utf-8");

        System.out.println(blogTitle);
        System.out.println(blogContent);
        System.out.println(createTime);
        System.out.println(tagName);

        try{
            blogWritingService.addblog(blogTitle, blogContent, createTime, tagName, 0, request);
            System.out.println("here");
            result.put("result","success");
            return result.toJSONString();
        } catch (Exception e){
//            error("保存文章报错:{}"+e);
            System.out.println(e);
            result.put("result","error");
            return result.toJSONString();
        }
    }

}
