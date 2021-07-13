package com.example.demo.controller;

import com.example.demo.service.PersonalSpaceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.entity.BlogInfo;


import javax.annotation.Resource;
import java.util.List;

@Controller
public class PersonalSpaceController {
    @Resource
    private PersonalSpaceService personalSpaceService;

    @RequestMapping("/space/{username}")
    public List<BlogInfo> showCalendarFigure(@PathVariable("username") String username)
    {
        return personalSpaceService.showCalendarFigure(username);
    }


    @RequestMapping("/space/{userID}")
    public String space(@PathVariable("userID") int userID, Model model)
    {

        return "personalspace";//html文件
    }
}
