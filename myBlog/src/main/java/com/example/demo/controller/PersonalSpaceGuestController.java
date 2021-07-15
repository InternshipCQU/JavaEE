package com.example.demo.controller;

import com.example.demo.entity.BlogInfo;
import com.example.demo.entity.User;
import com.example.demo.service.BlogService;
import com.example.demo.service.getService;
import com.example.demo.service.setService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
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

    @RequestMapping("/personalspaceguest")
    public String personalspaceguest( Model model) {
        String userID = "1";//写了restful风格的话，加载不出css和js，先用userID=1测试一下

        User userobj = getss.getuserprofile(Integer.parseInt(userID));

        String username=userobj.getUsername();
        String userprofile=userobj.getProfile();
        String email=userobj.getEmail();
        Integer likesnum=userobj.getLikesNum();
        Integer blogsnum=userobj.getBlogsNum();
        Integer fansnum=userobj.getFansNum();
        String avatar=userobj.getAvatar();
        String area=userobj.getArea();

        model.addAttribute("userID",userID);
        model.addAttribute("username",username);
        model.addAttribute("userprofile",userprofile);
        model.addAttribute("email",email);
        model.addAttribute("area",area);
        model.addAttribute("likesNum",Integer.toString(likesnum));
        model.addAttribute("blogsNum",Integer.toString(blogsnum));
        model.addAttribute("fansNum",Integer.toString(fansnum));
        model.addAttribute("avatar",avatar);
        System.out.println(avatar);
        return "personalspaceguest";
    }
}
