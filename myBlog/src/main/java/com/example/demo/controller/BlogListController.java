package com.example.demo.controller;

import com.example.demo.mapper.BlogListMapper;
import com.example.demo.service.BloglistService;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.ImagingOpException;
import java.io.IOException;

@Controller
public class BlogListController {
    @Resource
    private BlogListMapper blogListMapper;

    @Resource
    BloglistService bloglistService;

    @RequestMapping("bloglist")
    public String bloglist(HttpServletRequest request){
        bloglistService.Init(request);

        return "bloglist";
    }

    @RequestMapping("/manageBlog")
    @ResponseBody
    public String manageBlog(){

    }

    @RequestMapping(value="/deletemyblog",method = RequestMethod.POST)
    public void deletemyblog(@RequestBody Integer userId, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, JSONException
    {

    }
}
