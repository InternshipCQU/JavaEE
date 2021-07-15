package com.example.demo.controller;

import com.example.demo.entity.view.HomeBlogView;
import com.example.demo.service.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


//与原来的homeController进行了合并

@Controller
public class IndexController {

    @Resource
    private HomeService homeService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/index/{cla}")
    public String index1(@PathVariable("cla") String cla,HttpServletRequest request,Model model){
        homeService.Init(cla,request);
        homeService.setRecommendBlogger(request,model);
        homeService.getTrendings(request,model);
        homeService.setBlogger(request,model);
        return "index";
    }


    @RequestMapping("/classify")
    @ResponseBody
    public String classify(@RequestParam("class") String cla){//获取ajax发的信号
        //TODO:向数据库中索取所有的分类为cla的博客 取回之后做成json格式

        return "{\"test\" : cla}";
    }//做ajax测试用 记得删除 这个可以用作点赞等功能的实现

    @RequestMapping("/so")
    public String so(@RequestParam("search") String keyword,Model model){
        model.addAttribute("blogListFilteredByKeyword", homeService.searchBlogs(keyword));
        return "search";
    }

    @RequestMapping("/getTheBlogs")
    @ResponseBody
    public String ajax(@RequestParam("class") String str, HttpServletRequest request){//获取ajax发的信号
        //TODO:在这里向数据库寻找数据进行返回 这个str是类需要用这个确定查询的博客的类别进行加载 预计使用session进行值的记录 防止重复推送
        //如果没有推文了 需要传回一个没有的json数据 {none:true}
        String s = homeService.giveTheBlogToIndex(str,request);
        //System.out.println(s);
        return s;
    }


    public ArrayList<HomeBlogView> getBlogs(){
        return homeService.getBlogViews();
    }


}