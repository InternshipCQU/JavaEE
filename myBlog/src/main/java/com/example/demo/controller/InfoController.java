package com.example.demo.controller;
import com.example.demo.entity.User;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Controller
public class InfoController {
    @Autowired
    private setService setss;
    private getService getss;

    @RequestMapping("/timeline")
    public String to(){return "timeline";}
    @GetMapping("/infocenter")
    public String setuser(@RequestParam("username") String username, @RequestParam("gender") String gender,
                          @RequestParam("password") String password, @RequestParam("userID") Integer userID,
                          @RequestParam("email") String email, @RequestParam("telephone") String telephone,
                          @RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
                          @RequestParam("avatar") String avatar, @RequestParam("lastlogin")String lastlogin,
                          @RequestParam("fansnum") Integer fansnum, @RequestParam("likesnum")Integer likesnum,
                          @RequestParam("blogsnum") Integer blogsnum, @RequestParam("userregtime") String userregtime,
                          @RequestParam("birthdate") String birthdate, @RequestParam("introduce")String introduce,
                          @RequestParam("area") String area, Model model, HttpServletRequest request)
    {
        User newuser=new User();

        newuser.setUserID(userID);
        newuser.setUsername(username);
        newuser.setPassword(password);
        newuser.setGender(gender);
        newuser.setEmail(email);
        newuser.setTelephone(telephone);
        newuser.setFirstname(firstname);
        newuser.setLastname(lastname);
        newuser.setAvatar(avatar);
        newuser.setLastLogin(lastlogin);
        newuser.setFansNum(fansnum);
        newuser.setLikesNum(likesnum);
        newuser.setBlogsNum(blogsnum);
        newuser.setUserRefisiterTime(userregtime);
        newuser.setBirthdate(birthdate);
        newuser.setProfile(introduce);
        newuser.setArea(area);

        setss.setuser(newuser);
        model.addAttribute(newuser);
        boolean submitstatue=setss.checksetinfo(newuser);
        if (submitstatue) return "Set user profile succeed.";
        else return "Set user profile failed.";
    }

    public User getuser(@RequestParam("userID") int userID)
    {
        User getuser=getss.getuserprofile(userID);
        return getuser;
    }





}
