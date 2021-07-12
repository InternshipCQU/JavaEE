
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

//    @RequestMapping("/home")
//    public String getBlogs(Model model){
//        model.addAttribute("blogList", homeService.getBlogs());
//        return "test-home1";
//    }


    @RequestMapping("/home/{tagId}")     //点击标签后查询对应标签的博客
    public String tagToBlogs(@PathVariable("tagId") int tagId, Model model){
        model.addAttribute("blogListFilteredByTag", homeService.tagToBlogs(tagId));
        return "test-home2";
    }

    @RequestMapping("/search")
    public String searchBlogs(@RequestParam("keyword")  String keyword, Model model) {
        model.addAttribute("blogListFilteredByKeyword", homeService.searchBlogs(keyword));
        return "test-home3";
    }

    //根据前端格式返回JSON数据
    @RequestMapping("/home")
    public List<HomeBlogView> getBlogs(){
        return homeService.getBlogViews();
    }
}