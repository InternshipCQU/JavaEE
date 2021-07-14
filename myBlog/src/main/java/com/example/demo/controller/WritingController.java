package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WritingController {
    @RequestMapping("/writing")//TODO:记得加入filter中 现在不加 为了测试
    public String writing(){
        return "writing";
    }
}
