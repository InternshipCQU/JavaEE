
//package com.example.demo.controller;
//
//import org.springframework.stereotype.Controller;
//
//import javax.annotation.Resource;
//
//@Controller
//public class HomeController {
//@Resource
//    private
//
//}

package com.example.demo.controller;


import com.example.demo.entity.BlogInfo;
import com.example.demo.entity.BlogTag;
import com.example.demo.entity.User;
import com.example.demo.entity.news;
import com.example.demo.entity.view.HomeBlogView;
import com.example.demo.mapper.HomeMapper;
import com.example.demo.service.HomeService;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Resource
    public HomeService homeService;

    @Resource
    HomeMapper homeMapper;

    @RequestMapping("/home")
    public String home(){
        return "home";
    }


    @RequestMapping("/home/{tagName}")     //点击标签后查询对应标签的博客
    public String tagToBlogs(@PathVariable("tagName") String tagName, Model model){
        model.addAttribute("blogListFilteredByTag", homeService.tagToBlogs(tagName));
        return "test-home2";
    }


//    @RequestMapping("/search")
//    public String searchBlogs(@RequestParam("keyword")  String keyword, Model model) {
//        model.addAttribute("blogListFilteredByKeyword", homeService.searchBlogs(keyword));
//        return "test-home3";
//    }

    //根据前端格式返回JSON数据
//    @RequestMapping("/home")
//    public List<HomeBlogView> getBlogs(){
//        return homeService.getBlogViews();
//    }

    @RequestMapping("/recommend")
    public List<HomeBlogView> getRecommendBlogs(@RequestParam("userId") int userId){
        int tagId = homeService.getTagMark(userId).getRecommendTag();
        return homeService.getRecommendBlogViews(tagId);
    }

    @RequestMapping("/mayknowpeople")
    @ResponseBody
    // 主页推荐people you may want to see
    public List<User> showWantBlogger(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println("session.getAttribute(): " +session.getAttribute("userID"));
        if(session.getAttribute("userID") != null){
            int userId = (Integer) session.getAttribute("userID");
            System.out.println("here is the data: " + homeService.showWantBlogger(userId));
            return homeService.showWantBlogger(userId);
        }

        return null;
    }


    @RequestMapping("/notification")
    @ResponseBody
    // 主页推荐people you may want to see
    public List<news> notification(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("userID") != null){
            int userId = (Integer) session.getAttribute("userID");
            return homeMapper.getNews(userId);
        }
        return null;
    }

    @RequestMapping("/deleteNotification")
    @ResponseBody
    // 主页推荐people you may want to see
    public void notification(@RequestParam("iden") int id,HttpServletRequest request) {
        System.out.println("iden: " + id);
        homeMapper.changeNews(id);
    }

//
//    @RequestMapping("/trending")
//    // 主页展示点击量最高的博客对应的标签(#trending)，需要进行去重
//    public ArrayList<BlogTag> getTrending() {
//        return homeService.getTrending();
//    }

    @RequestMapping("/submitfollow")
    @ResponseBody
    public void submitfollow(@RequestParam("userId") Integer userId, HttpServletRequest request){
        homeService.submitfollowing(request,userId);
    }

}