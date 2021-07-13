package com.example.demo.controller;

import com.example.demo.entity.BlogInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchPageController {
    @RequestMapping("/searchpage")
    public String blogpage(Model model){
        return "searchpage";
    }
}
