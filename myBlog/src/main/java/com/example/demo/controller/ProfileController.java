package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {
    @RequestMapping("/profile")
    public String profile(){
        return "profile";
    }

    @RequestMapping("/blogger/{bloggerName}/{bloggerID}")
    public String blogger(@PathVariable("bloggerID") int bloggerID,@PathVariable("bloggerName") String bloggerName){
        return "profile";
    }
}
