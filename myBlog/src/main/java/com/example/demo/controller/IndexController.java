package com.example.demo.controller;

import com.example.demo.service.HomeService;
import com.example.demo.utils.SplitString;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {

    @Resource
    HomeService homeService;

    @RequestMapping("/index")
    public String index(){
        return "login";
    }

    @RequestMapping("/classify")
    @ResponseBody
    public String classify(@RequestParam("class") String cla){//获取ajax发的信号
        //TODO:向数据库中索取所有的分类为cla的博客 取回之后做成json格式

        return "{\"test\" : cla}";
    }//做ajax测试用 记得删除 这个可以用作点赞等功能的实现

    @RequestMapping("/getTheBlogs")
    @ResponseBody
    public String ajax(@RequestParam("url") String url){//获取ajax发的信号
        //TODO:在这里向数据库寻找数据进行返回
        //homeService.getTheClass(url);//获得该网页的最后一个参数进行查找

        return "{\"username\":\"cjy\",\"likeNumber\":\"10\",\"commentNumber\":\"5\",\"forwardNumber\":\"6\",\"saveNumber\":\"7\",\"commentUser\":\"TJN\",\"commentText\":\"for Messi\",\"commentTime\":\"1d\",\"link\":\"/blogs/{userId}/{blogId}\"}";
    }


}