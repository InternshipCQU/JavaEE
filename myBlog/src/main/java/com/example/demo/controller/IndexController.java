package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/classify")
    @ResponseBody
    public String classify(@RequestParam("class") String cla){//获取ajax发的信号
        //TODO:向数据库中索取所有的分类为cla的博客 取回之后做成json格式

        return "{\"test\" : cla}";
    }//做ajax测试用 记得删除 这个可以用作点赞等功能的实现

    @RequestMapping("/getTheBlogs")
    @ResponseBody
    public String ajax(@RequestParam("class") String cla){//获取ajax发的信号
        //TODO:在这里向数据库寻找数据进行返回

        return "{\"username\":\"cjy\",\"likeNumber\":\"10\",\"commentNumber\":\"5\",\"forwardNumber\":\"6\",\"saveNumber\":\"7\"}";
    }


}