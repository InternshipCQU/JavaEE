package com.example.demo.controller;


import com.example.demo.entity.BlogInfo;

import com.example.demo.entity.view.HomeBlogView;
import com.example.demo.service.HomeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private HomeService homeService;

    @RequestMapping("/test")
    public List<HomeBlogView> Test(){
        return homeService.getBlogViews();
    }
}
