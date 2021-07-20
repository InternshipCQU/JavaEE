package com.example.demo.controller;

import com.example.demo.entity.BlogInfo;
import com.example.demo.service.HomeService;
import com.example.demo.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class SearchPageController {
    @Resource
    HomeService homeService;

    @Resource
    SearchService searchService;

    @RequestMapping("/searchpage")
    public String blogpage(Model model,HttpServletRequest request){
        homeService.setBlogger(request,model);
        return "searchpage";
    }

    @RequestMapping("/search")
    // 根据关键词（标题，标签名）模糊搜索博客，
    public String searchBlogs(@RequestParam("keyword")  String keyword, HttpServletRequest request,Model model) {
        searchService.setSearch(request,keyword);
        homeService.setBlogger(request,model);
        System.out.println("blogs.size(): " + homeService.searchBlogs(keyword));
        return "searchpage";
    }

    @RequestMapping("/getTheSearchBlogs")
    @ResponseBody
    public String ajax(@RequestParam("class") String str, HttpServletRequest request){//获取ajax发的信号
        //TODO:在这里向数据库寻找数据进行返回 这个str是类需要用这个确定查询的博客的类别进行加载 预计使用session进行值的记录 防止重复推送
        //如果没有推文了 需要传回一个没有的json数据 {none:true}
        System.out.println("I'm here 2");
        String s = searchService.giveTheBlogToSearch(str,request);
        System.out.println(s);
        return s;
    }


}
