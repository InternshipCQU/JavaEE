package com.example.demo.controller;

import com.example.demo.entity.blogInfo;
import com.example.demo.service.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class HomeController {

    @Resource
    private HomeService homeService;

    @RequestMapping("/home")    //加载主页显示的博客
    public List<blogInfo> getBlogs(@RequestBody String username){
        return homeService.getBlogs(username);
    }

    @RequestMapping(value = "/{tagId}")     //点击标签后查询对应标签的博客
    public  List<blogInfo> changeCategory(@PathVariable("tagId") Integer tagId){
        return homeService.changeCategory(tagId);
    }

    @RequestMapping("/search")
    public List<blogInfo> searchBlogs(@RequestBody String keyword){
        return homeService.searchBlogs(keyword);
    }

}
