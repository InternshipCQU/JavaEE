package com.example.demo.controller;

import com.example.demo.entity.view.HomeBlogView;
import com.example.demo.mapper.BlogListMapper;
import com.example.demo.service.BlogManagerService;
import com.example.demo.service.HomeService;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class BlogManagerController {
    @Resource
    private BlogListMapper blogListMapper;

    @Resource
    HomeService HomeService;

    @Resource
    BlogManagerService blogManagerService;

    @RequestMapping("/blogManager")
    public String bloglist(HttpServletRequest request, Model model){
        HomeService.setBlogger(request,model);
        blogManagerService.Init(request);
        return "blogManager";
    }

    @RequestMapping("/manageBlog")
    @ResponseBody
    public String manageBlog(HttpServletRequest request){

        String s = blogManagerService.manageTheBlogs(request);
        System.out.println(s);
        return s;
    }

    @RequestMapping(value="/deletemyblog",method = RequestMethod.GET)
    public void deletemyblog(@RequestParam("userId") Integer userId,@RequestParam("blogId") Integer blogId, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, JSONException
    {
        blogManagerService.deleteblog(blogId,userId);
    }
}
