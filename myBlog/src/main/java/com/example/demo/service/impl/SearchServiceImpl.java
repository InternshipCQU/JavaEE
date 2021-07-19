package com.example.demo.service.impl;

import com.example.demo.entity.BlogInfo;
import com.example.demo.entity.view.CommentView;
import com.example.demo.entity.view.HomeBlogView;
import com.example.demo.mapper.BlogMapper;
import com.example.demo.mapper.profileMapper;
import com.example.demo.service.HomeService;
import com.example.demo.service.SearchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service("SearchService")
public class SearchServiceImpl implements SearchService {
    @Resource
    HomeService homeService;

    @Resource
    profileMapper profileMapper;

    @Resource
    BlogMapper blogMapper;


    @Override
    public void setSearch(HttpServletRequest request,String keyword) {
        HttpSession session = request.getSession();
        ArrayList<BlogInfo> s1 = new ArrayList<>();
        s1 = homeService.searchBlogs(keyword);
        session.setAttribute("blogs",s1);
        session.setAttribute("count",0);
        session.setAttribute("size",s1.size());
        System.out.println("s1.size(): " + s1.size());
    }


    @Override
    public String giveTheBlogToSearch(String cla, HttpServletRequest request) {
        HttpSession session = request.getSession();
        int count = (Integer) session.getAttribute("count");
        int size = (Integer) session.getAttribute("size");
        ArrayList<BlogInfo> blogs = (ArrayList<BlogInfo>) session.getAttribute("blogs");

        System.out.println(size);
        System.out.println(count);

        if(size == 0 || count == size){
            return "{\"noMore\":\"true\"}";
        }

        int blogId = blogs.get(count).getBlogId();
        int userId = blogs.get(count).getUserId();
        String blogTitle = blogs.get(count).getBlogTitle();
        BlogInfo blogInfo =  blogMapper.getBlog(blogId);
        String blogContent = blogInfo.summary;
        String createTime = blogs.get(count).getCreateTime();
        int clickNumber = blogs.get(count).getClickNum();
        int likeNumber = blogs.get(count).getLikesNum();

//        private String username;
//        private String commentContent;

        //====生成comment json
        String comments = "";
        String username = profileMapper.getusername(userId);

        //====
        comments = "[" + comments + "]";
        System.out.println(comments);

        String link = "/blogs/" + username + "/" + blogId;

        System.out.println("Hello");
        session.setAttribute("count", count + 1);
        if(blogContent.length() >=66){
            blogContent = blogContent.substring(0,65);
        }


        return "{\"clickNumber\":\""+clickNumber+"\",\"createTime\":\""+createTime+"\",\"blogContent\":\"" + blogContent + "\",\"blogTitle\":\"" + blogTitle + "\",\"username\":\"" + username + "\",\"likeNumber\":\"" + likeNumber + "\",\"comments\":" + comments + ",\"link\":\"" + link + "\"}";

    }

}
