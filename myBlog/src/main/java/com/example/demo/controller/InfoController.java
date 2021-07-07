package com.example.demo.controller;
import com.example.demo.entity.user;
import com.example.demo.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
/* The module basicinfoController is designed for setting the basic
*  attributes of users ,including alias , name, gender, profile,
*  region and date of birth.
*  TODO
*
* */


@Controller
public class InfoController {
    @Resource
    private setService setss;



    @GetMapping("/setalias")
    public String setalias(@RequestParam("newalias") String new_alias,@RequestParam("username") String username){
        boolean setaliasstatus=setss.setalias(new_alias,username);
        if (setaliasstatus)
        {
            return "Set alias succeed.";//TODO: 如果设置昵称成功，则前端弹出对话框显示Set alias succeed.
        }
        else return "Set alias failed.";//TODO: 如果设置失败那么显示Set alias failed.
    }

    @GetMapping("/setrealname")
    public String setrealname(@RequestParam("newname") String new_name,@RequestParam("oldname") String old_name){
        boolean setnamestatus=setss.setname(new_name,old_name);
        if (setnamestatus)
        {
            return "Set name succeed.";
        }
        else return "Set name failed.";
    }


}
