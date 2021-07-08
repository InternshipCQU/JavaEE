package com.example.demo.controller;
import com.example.demo.entity.user;
import com.example.demo.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Date;
/* The module infoController is designed for setting the basic
*  attributes of users ,including alias , name, gender, profile,
*  region and date of birth.
*
*  Every contributor who are planning to use the DATE attribute
*  must follow the format:yyyy-mm-dd ,with the
*  linking token - between each part.
*
*  TODO: It's expected that user can set the region&location by clicking and selecting from the drop down menu.
*   The format of the region should be defined in advance.
*
*
*   TODO: After assigning user's specific profile the front-end webpage should display the message to users telling
*    about whether the procedure of modification is successful.
* */


@Controller
public class InfoController {
    @Resource
    private setService setss;

    @GetMapping("/setalias")
    public String setalias(@RequestParam("newalias") String new_alias,@RequestParam("userID") int userID){
        boolean setaliasstatus=setss.setalias(new_alias,userID);
        if (setaliasstatus)
        {
            return "Set alias succeed.";
        }
        else return "Set alias failed.";
    }

    @GetMapping("/setrealname")
    public String setrealname(@RequestParam("newname") String new_name,@RequestParam("oldname") String old_name,
                              @RequestParam("userID") int userID){
        boolean setnamestatus=setss.setname(new_name,old_name,userID);
        if (setnamestatus)
        {
            return "Set name succeed.";
        }
        else return "Set name failed.";
    }

    @GetMapping("/setgender")
    public String setgender(@RequestParam("newgender") String new_gender,@RequestParam("userID") int userID){
        boolean setgender=setss.setgender(new_gender,userID);
        if(setgender)
        {
            return "Set gender succeed.";
        }
        else return "Set gender failed.";
    }

    @GetMapping("/setprofile")
    public String setprofile(@RequestParam("newprofile") String new_profile,@RequestParam("userID") int userID){
        boolean setprofile=setss.setprofile(new_profile,userID);
        if(setprofile){
            return "Set profile succeed.";
        }
        else return "Set profile failed.";
    }

    @GetMapping("/setregion")
    public String setregion(@RequestParam("newregion") String new_region,@RequestParam("userID") int userID){
        setss.setregion(new_region,userID);
        return "Set region succeed.";
    }

    @GetMapping("/setdateofbirth")
    public String setdateofbirth(@RequestParam("newdate") String newdate,@RequestParam("userID") int userID){
        boolean setdateofbirth=setss.setdateofbirth(newdate,userID);
        if(setdateofbirth) return "Set date of birth succeed.";
        else return "Set date of birth failed.";
    }



}
