package com.example.demo.controller;

import com.example.demo.entity.BlogCommentVo;
import com.example.demo.entity.BlogInfoVo;
import com.example.demo.service.BlogDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class BlogDetailsController {
    @Resource
    private BlogDetailsService blogDetailsService;

    @RequestMapping(value = "/testBlogDetails1/{blogId}")
    public String showBlogPart(@PathVariable("blogId") Integer blogId, Model model){
       BlogInfoVo blogInfoVo = blogDetailsService.showBlogPart(blogId);
       model.addAttribute("blogDetailsList1", blogDetailsService.showBlogPart(blogId));
       return "blogDetails1-test";
    }

    @RequestMapping("/testBlogDetails2/{blogId}")
    public String showBlogComment(@PathVariable("blogId") Integer blogId, Model model){
        List<BlogCommentVo> blogCommentVo = blogDetailsService.showBlogComment(blogId);
        model.addAttribute("blogDetailsList2", blogDetailsService.showBlogComment(blogId));
        return "blogDetails2-test";
    }
}
