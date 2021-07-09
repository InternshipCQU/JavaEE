package com.example.demo.controller;

import com.example.demo.service.PersonalSpaceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class PersonalSpaceController {
    @Resource
    private PersonalSpaceService personalSpaceService;

    @RequestMapping("/space/{userID}")
    public String space(@PathVariable("userID") String userID, Model model){
        
        return "space";//html文件
    }
}
