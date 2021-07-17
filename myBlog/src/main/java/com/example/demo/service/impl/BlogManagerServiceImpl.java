package com.example.demo.service.impl;


import com.example.demo.entity.BlogInfo;
import com.example.demo.mapper.BlogListMapper;
import com.example.demo.mapper.PersonalSpaceMapper;
import com.example.demo.mapper.profileMapper;
import com.example.demo.service.BlogManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service("BloglistService")
public class BlogManagerServiceImpl implements BlogManagerService {

    @Resource
    private BlogListMapper blogss;

    @Resource
    profileMapper profileMapper;

    @Resource
    PersonalSpaceMapper personalSpaceMapper;

    @Override
    public void deleteblog(Integer blogId,Integer userId)
    {
        blogss.deletecollect(blogId,userId);
        blogss.deleteblogcomment(blogId,userId);
        blogss.deletebloglike(blogId,userId);
        blogss.deleteblogforward(blogId,userId);
        blogss.deletetagbloginfo(blogId,userId);
        blogss.deletebloginfo(blogId,userId);
    }

    @Override
    public void Init(HttpServletRequest request) {
        HttpSession session = request.getSession();
        int userId = -1;
        if(session.getAttribute("userID") == null){
            System.out.println("并没有登录");//TODO:这里应该是回到跳转状态

        }else{
            userId = (Integer) session.getAttribute("userID");
        }
        List<BlogInfo> blogs = personalSpaceMapper.showUsersBlog(userId);

        session.setAttribute("blogs",blogs);
        session.setAttribute("count",0);
        session.setAttribute("size",blogs.size());

    }

    @Override
    public String manageTheBlogs(HttpServletRequest request) {

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
        String editPath = "/editblog/" + blogId;

//        private String username;
//        private String commentContent;

        //====生成comment json
        String comments = "";
        String username = profileMapper.getusername(userId);

        //====
        comments = "[" + comments + "]";
        blogContent = "";
        String link = "/blogs/" + username + "/" + blogId;

        session.setAttribute("count", count + 1);
        System.out.println("BlogId:"+blogId);
        System.out.println("UserId:"+userId);

        return "{\"editPath\":\"" + editPath +"\",\"userId\":\""+userId+"\",\"createTime\":\""+createTime+"\",\"blogContent\":\"" + blogContent + "\",\"blogTitle\":\"" + blogTitle + "\",\"username\":\"" + username + "\",\"likeNumber\":\"" + likeNumber + "\",\"comments\":" + comments + ",\"blogId\":\"" + blogId + "\"}";

    }

}
