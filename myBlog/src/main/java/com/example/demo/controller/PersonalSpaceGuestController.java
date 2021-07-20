package com.example.demo.controller;

import com.example.demo.entity.BlogInfo;
import com.example.demo.entity.User;
import com.example.demo.service.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class PersonalSpaceGuestController {

    public PersonalSpaceGuestController(getService getss) {
        this.getss = getss;
    }

//    @RequestMapping("personalspaceguest")
//    public String personalSpaceGuest(){
//        return "personalspaceguest";
//    }

    @Resource
    private getService getss;

    @Resource
    PersonalSpaceGuestService personalSpaceGuestService;

    @Resource
    HomeService homeService;

    @Resource
    getService getservice;

    @RequestMapping("/personalspaceguest/{userId}")
    public String personalspaceguest(@PathVariable("userId") int userID, Model model, HttpServletRequest request) {
        personalSpaceGuestService.PersonalSpaceGuestInit(userID,model,request);
        homeService.setBlogger(request,model);

//        User user = getservice.getuserprofile(userID);
//
//        model.addAttribute("user",user);
        return "personalspaceguest";
    }

    @RequestMapping("/getPersonalBlog")
    @ResponseBody
    public String getPersonalBlog(HttpServletRequest request){
        String s = personalSpaceGuestService.giveTheBlogToPersonal(request);
        System.out.println("personal: " + s);
        return s;
    }
}
