package com.example.demo.controller;

import com.example.demo.entity.BlogInfo;
import com.example.demo.mapper.BlogMapper;
import com.example.demo.mapper.HomeMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class BlogPageController {

    @Resource
    BlogMapper blogMapper;

    @RequestMapping("/blogpage")
    public String blogpage(Model model){
        BlogInfo blogInfo = blogMapper.getBlog(1);

        String content = blogInfo.blogContent;
        String title = blogInfo.blogTitle;
        String category = "博文分类：" + blogInfo.tagName;


        String test = "<p><img src=\"https://bucket-myblog.oss-cn-beijing.aliyuncs.com/blogimg/2021-07-12/3cfe08c898b84eb1a6bb8870741aaf80-Snipaste_2021-07-08_23-59-28.png\" alt=\"\"></p>\n" +
                "<h1 id=\"h1-u6D4Bu8BD5u6587u672C\"><a name=\"测试文本\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>测试文本</h1><h2 id=\"h2--1\"><a name=\"测试1\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>测试1</h2><h3 id=\"h3-u6D4Bu8BD5\"><a name=\"测试\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>测试</h3><p><em>测试3</em></p>";
        int num = 95;
        String postDate = "发布时间：" + "2021-7-12";
        model.addAttribute("test",test);
        model.addAttribute("postDate",postDate);
        model.addAttribute("num",num);

        model.addAttribute("content", content);
        model.addAttribute("title", title);
        model.addAttribute("category", category);

        return "blogpage";
    }
}
