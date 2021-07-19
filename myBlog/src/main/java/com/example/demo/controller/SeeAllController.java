package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.BlogService;
import com.example.demo.service.getService;
import com.example.demo.service.userfavoritesService;
import com.example.demo.service.userinfoallService;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SeeAllController {
    @Resource
    userinfoallService userinfoallService;

    @Resource
    userfavoritesService userfavoritesService;

    @Resource
    BlogService blogService;


    @RequestMapping("/seeAllfollow")
    public String to(HttpServletRequest request){
        HttpSession session = request.getSession();
        userinfoallService.Init(request);
        return "seeallfollow";
    }

    @RequestMapping("/seeAllfavorites")
    public String to_2(HttpServletRequest request){
        HttpSession session=request.getSession();
        userfavoritesService.Init(request);
        return "seeallfavorites";
    }

    @RequestMapping("/reqfollow")
    @ResponseBody
    public String reqfollow(HttpServletRequest request){
        String s=userinfoallService.getallfollow(request);
        System.out.println("GET:"+s);
        return s;
    }

    @RequestMapping("/reqdelfollow")
    @ResponseBody
    public String reqdelfollow(@RequestParam("userId") Integer userId,HttpServletRequest request ){
        HttpSession session=request.getSession();
        Integer rel_userId=(Integer)session.getAttribute("userID");
        userinfoallService.cancelfollow(userId,rel_userId);
        return "seeAllfollow";
    }


    @RequestMapping("/reqfavorites")
    @ResponseBody
    public String reqfavorites(HttpServletRequest request){
        String s= userfavoritesService.getallfavorites(request);
        System.out.println("controller");
        return s;
    }

    @RequestMapping(value="/cancelFavorites",method = RequestMethod.GET)
    @ResponseBody
    public void cancelFavorites(@RequestParam("userId") int userId, @RequestParam("blogId") int blogId)
    {
        blogService.cancelCollect(blogId,userId);

        System.out.println("取消收藏");
        blogService.deductCollectNum(blogId);
    }
}
