package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WritingController {
    @RequestMapping("/writing")
    public String writing(){
        return "writing";
    }
}
