package com.example.demo.service.impl;

import com.example.demo.entity.BlogInfo;
import com.example.demo.entity.User;
import com.example.demo.mapper.PersonalSpaceMapper;
import com.example.demo.mapper.profileMapper;
import com.example.demo.service.PersonalSpaceGuestService;
import com.example.demo.service.getService;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service("PersonalSpaceGuestService")
public class PersonalSpaceGuestServiceImpl implements PersonalSpaceGuestService {

    @Resource
    private getService getss;

    @Resource
    PersonalSpaceMapper personalSpaceMapper;

    @Resource
    profileMapper profileMapper;

    @Override
    public void PersonalSpaceGuestInit(int userID, Model model, HttpServletRequest request){


        //====getTheBlogs=====
        HttpSession session = request.getSession();
        List<BlogInfo> blogs = personalSpaceMapper.showUsersBlog(userID);
        session.setAttribute("blogs",blogs);
        session.setAttribute("count",0);
        session.setAttribute("size",blogs.size());


        //====set the page====
//        User userobj = getss.getuserprofile(userID);
        User user = getss.getuserprofile(userID);
        model.addAttribute("user",user);
//        String username=userobj.getUsername();
//        String userprofile=userobj.getProfile();
//        String email=userobj.getEmail();
//        Integer likesnum=userobj.getLikesNum();
//        Integer blogsnum=userobj.getBlogsNum();
//        Integer fansnum=userobj.getFansNum();
//        String avatar=userobj.getAvatar();
//        String area=userobj.getArea();
//        String background=userobj.getBackground();
//
//        model.addAttribute("userID",userID);
//        model.addAttribute("username",username);
//        model.addAttribute("userprofile",userprofile);
//        model.addAttribute("email",email);
//        model.addAttribute("area",area);
//        model.addAttribute("likesNum",Integer.toString(likesnum));
//        model.addAttribute("blogsNum",Integer.toString(blogsnum));
//        model.addAttribute("fansNum",Integer.toString(fansnum));
//        model.addAttribute("avatar",avatar);
//        model.addAttribute("background",background);
        //=====

    }

    @Override
    public String giveTheBlogToPersonal(HttpServletRequest request) {

        HttpSession session = request.getSession();
        int count = (Integer) session.getAttribute("count");
        int size = (Integer) session.getAttribute("size");
        ArrayList<BlogInfo> blogs = (ArrayList<BlogInfo>) session.getAttribute("blogs");

        System.out.println("size:" + size);
        System.out.println("count" + count);

        if(size == 0 || count == size){
            return "{\"noMore\":\"true\"}";
        }

        int blogId = blogs.get(count).getBlogId();
        int userId = blogs.get(count).getUserId();
        String blogTitle = blogs.get(count).getBlogTitle();
        String blogContent = blogs.get(count).getBlogContent();
        String createTime = blogs.get(count).getCreateTime();
        int clickNumber = blogs.get(count).getClickNum();
        int likeNumber = blogs.get(count).getLikesNum();
        String summary = blogs.get(count).summary;

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


        return "{\"clickNumber\":\""+clickNumber+"\",\"createTime\":\""+createTime+"\",\"blogContent\":\"" + summary + "\",\"blogTitle\":\"" + blogTitle + "\",\"username\":\"" + username + "\",\"likeNumber\":\"" + likeNumber + "\",\"comments\":" + comments + ",\"link\":\"" + link + "\"}";


    }
}
