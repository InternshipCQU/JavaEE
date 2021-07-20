//package com.example.demo.controller;
//
//import com.example.demo.service.HomeService;
//import com.example.demo.service.impl.SensitiveFilterService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.annotation.Resource;
//
//@Controller
//public class SensitiveController {
//    @Resource
//    private SensitiveFilterService sensitiveFilterService;
//
//
//    @RequestMapping("/blogs/comment/{sensitiveString}")
//    public String sensitiveFilt(@PathVariable("sensitiveString") String commentString) {
//        //屏蔽敏感词汇，用“*”替换
//        String dealedString = sensitiveFilterService.getInstance().replaceSensitiveWord(commentString, 1, "*");
//        System.out.println(dealedString);   // 处理后的string
//        return "test-sensitive";
//    }
//
//}
