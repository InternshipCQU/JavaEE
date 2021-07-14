
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
import com.example.demo.entity.view.HomeBlogView;
import com.example.demo.service.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class HomeController {

    @Resource
    private HomeService homeService;

//    @RequestMapping("/home/{tagId}")     //点击标签后查询对应标签的博客
//    public String tagToBlogs(@PathVariable("tagId") int tagId, Model model) {
//        model.addAttribute("blogListFilteredByTag", homeService.tagToBlogs(tagId));
//        return "123";
//    }
//<<<<<<< HEAD
//    @RequestMapping("/home")    //加载主页显示的博客
//    public String getBlogs(@RequestBody String username, Model model){
//        model.addAttribute("blogList", homeService.getBlogs(username));
//        return "index";
//    }
//=======

//    @RequestMapping("/home")
//    public String getBlogs(Model model)
//    {
//        model.addAttribute("blogList", homeService.getBlogs());
//        return "test-home1";
//    }
//
//>>>>>>> 72381607e5eb73cdd5ddfb2836690cb0caa011d3

    @RequestMapping("/home/{tagName}")     //点击标签后查询对应标签的博客
    public String tagToBlogs(@PathVariable("tagName") String tagName, Model model){
        model.addAttribute("blogListFilteredByTag", homeService.tagToBlogs(tagName));
        return "test-home2";
    }

    @RequestMapping("/search/{keyword}")
    // 根据关键词（标题，标签名）模糊搜索博客，
    public String searchBlogs(@PathVariable("keyword")  String keyword, Model model) {
        model.addAttribute("blogListFilteredByKeyword", homeService.searchBlogs(keyword));
        return "test-home3";
    }

//    @RequestMapping("/search")
//    public String searchBlogs(@RequestParam("keyword")  String keyword, Model model) {
//        model.addAttribute("blogListFilteredByKeyword", homeService.searchBlogs(keyword));
//        return "test-home3";
//    }

    //根据前端格式返回JSON数据
    @RequestMapping("/home")
    public List<HomeBlogView> getBlogs(){
        return homeService.getBlogViews();
    }

    @RequestMapping("/recommend")
    public List<HomeBlogView> getRecommendBlogs(@RequestParam("userId") int userId){
        int tagId = homeService.getTagMark(userId).getRecommendTag();
        return homeService.getRecommendBlogViews(tagId);
    }
}