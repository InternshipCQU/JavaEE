package com.example.demo.controller;

import com.example.demo.entity.BlogInfo;
import com.example.demo.mapper.BlogMapper;
import com.example.demo.mapper.HomeMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class BlogPageController {

    @Resource
    BlogMapper blogMapper;

    @RequestMapping("/blogpage")
    public String blogpage(Model model){
        BlogInfo blogInfo = blogMapper.getBlog(1);

        String content = blogInfo.blogContent;
        String title = blogInfo.blogTitle;
        String category = blogInfo.tagName;

        model.addAttribute("content", content);
        model.addAttribute("title", title);
        model.addAttribute("category", category);
        return "blogpage";
    }
}
