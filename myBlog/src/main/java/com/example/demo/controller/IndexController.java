package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping("/index/{cla}")
    public String index1(@PathVariable("cla") String cla){
        return "index";
    }


    @RequestMapping("/classify")
    @ResponseBody
    public String classify(@RequestParam("class") String cla){//获取ajax发的信号
        //TODO:向数据库中索取所有的分类为cla的博客 取回之后做成json格式

        return "{\"test\" : cla}";
    }//做ajax测试用 记得删除 这个可以用作点赞等功能的实现

    @RequestMapping("/so")
    public String so(@RequestParam("search") String s,Model model){

        return "search";
    }

    @RequestMapping("/getTheBlogs")
    @ResponseBody
    public String ajax(@RequestParam("class") String str){//获取ajax发的信号
        //TODO:在这里向数据库寻找数据进行返回 这个str是类需要用这个确定查询的博客的类别进行加载 预计使用session进行值的记录 防止重复推送
        //如果没有推文了 需要传回一个没有的json数据 {none:true}

        return "{\"username\":\"cjy\",\"likeNumber\":\"10\",\"commentNumber\":\"5\",\"forwardNumber\":\"6\",\"saveNumber\":\"7\",\"commentUser\":\"TJN\",\"commentText\":\"for Messi\",\"commentTime\":\"1d\",\"link\":\"/blogs/{userId}/{blogId}\"}";
    }


}