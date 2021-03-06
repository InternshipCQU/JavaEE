package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.entity.view.CommentView;
import com.example.demo.entity.view.HomeBlogView;
import com.example.demo.mapper.BlogDetailsMapper;
import com.example.demo.mapper.BlogMapper;
import com.example.demo.mapper.HomeMapper;
import com.example.demo.mapper.profileMapper;
import com.example.demo.service.HomeService;
import com.example.demo.utils.SplitString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.demo.utils.SplitString.splitId;

@Service("HomeService")
public class HomeServiceImpl implements HomeService {

    @Resource
    private HomeMapper homeMapper;

    @Resource
    private profileMapper profileMapper;

    @Resource
    private BlogMapper blogMapper;

    @Resource
    BlogDetailsMapper blogDetailsMapper;

    @Override
    public List<HomeBlogView> tagToBlogs(String tagName) {
        return homeMapper.tagToBlogs(tagName);
    }

    @Override
    public ArrayList<BlogInfo> searchBlogs(String keyword) {
        return homeMapper.searchBlogs(keyword);
    }

    @Override
    public List<BlogInfo> getBlogs() {
        return homeMapper.getBlogs();
    }

    @Override
    public List<User> showHotBlogger() {
        return homeMapper.showHotBlogger();
    }

    @Override
    // 【登陆后】根据关注的人，推荐关注列表热门博主
    public ArrayList<User> showRecommendBlogger(int userId) {
        return homeMapper.showRecommendBlogger(userId);
    }

    @Override
    public String getTheClass(String s) {
        return null;
    }


    @Override
    public void setRecommendBlogger(HttpServletRequest request,Model model){
        if(request.getAttribute("userID")!=null){
            model.addAttribute("recommendBlogger",showRecommendBlogger(((Integer)request.getAttribute("userID"))));
        }else{
            model.addAttribute("recommendBlogger",showHotBlogger());
        }
    }

    @Override
    public void setBlogger(HttpServletRequest request, Model model) { //在前端页面上设置右上角头像和链接
        HttpSession session = request.getSession();
        if(session.getAttribute("userID")!=null){
            int userId = (Integer) session.getAttribute("userID");
            //System.out.println("userId: " + session.getAttribute("userID"));


            User user = profileMapper.getUser(userId);
            System.out.println("user: " + user);
            model.addAttribute("bloggerPath","/userinfo");
            model.addAttribute("spacePath","/blogManager");
            model.addAttribute("username",user.getUsername());
            model.addAttribute("bloggerAvatar",user.getAvatar());
            model.addAttribute("hiddenLogout","false");
            model.addAttribute("hiddenLogin","true");
            if(homeMapper.countRead(userId) != null){
                model.addAttribute("number",homeMapper.countRead(userId));
            }else {
                model.addAttribute("number",0);
            }


        }else{
            model.addAttribute("bloggerAvatar","https://bucket-myblog.oss-cn-beijing.aliyuncs.com/avatar/defaultAvatar.jpg");
            model.addAttribute("bloggerPath","/login");
            model.addAttribute("spacePath","/login");
            model.addAttribute("username","login please");
            model.addAttribute("hiddenLogout","true");
            model.addAttribute("hiddenLogin","false");
            model.addAttribute("number",0);

        }
        //System.out.println(model.getAttribute("bloggerAvatar"));

    }

    @Override
    // 主页推荐people you may want to see
    public ArrayList<User> showWantBlogger(int userId) {
        return homeMapper.showWantBlogger(userId);
    }

    @Override
    public void submitfollowing(HttpServletRequest request,int userId){
        HttpSession session=request.getSession();
        Integer fansId=(Integer) session.getAttribute("userID");
        homeMapper.submitfollowing_1(userId,fansId);
        homeMapper.submitfollowing_2(userId);
    }

    @Override
    // 主页展示点击量最高的博客对应的标签(#trending)，需要进行去重
    public ArrayList<BlogTag> getTrending(Model model) {
        ArrayList<BlogTag> tags = homeMapper.getTrending();
        model.addAttribute("trendings",tags);
        return tags;
    }

    //test
    @Override
    public ArrayList<HomeBlogView> getBlogViews() {
        ArrayList<HomeBlogView> blogList = homeMapper.getBlogViews();
        for (int i = 0; i < blogList.size(); i++) {
            int blogId = blogList.get(i).getBlogId();
            List<CommentView> commentList = homeMapper.getCommentViews(blogId);
            blogList.get(i).setCommentList(commentList);
        }
        return blogList;
    }


    @Override
    public void Init(String cla, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(cla.equals("ALL")){
            if(session.getAttribute("userID") != null){
                System.out.println("个性推荐启动");
                if(getRecommendBlogViews((Integer) session.getAttribute("userID")) == null){
                    session.setAttribute("blogs", getBlogViews());
                }else{
                    session.setAttribute("blogs", getRecommendBlogViews((Integer) session.getAttribute("userID")));
                }
                System.out.println( "here is the blogs: "  + session.getAttribute("blogs"));
            }else{
                session.setAttribute("blogs", getBlogViews());
                //System.out.println(getBlogViews());
            }
        }else{
            System.out.println("筛选的标签为：" + cla);
            System.out.println(tagToBlogs(cla));
            session.setAttribute("blogs", tagToBlogs(cla));
        }


        ArrayList<HomeBlogView> s1 = (ArrayList<HomeBlogView>) session.getAttribute("blogs");
        System.out.println(s1.size());
        session.setAttribute("count", 0);
        session.setAttribute("size", s1.size());
    }

    @Override
    public String giveTheBlogToIndex(String cla, HttpServletRequest request) {
        HttpSession session = request.getSession();
        int count = (Integer) session.getAttribute("count");
        int size = (Integer) session.getAttribute("size");
        System.out.println(size);
        System.out.println(count);
        ArrayList<HomeBlogView> blogs = (ArrayList<HomeBlogView>) session.getAttribute("blogs");



        if(size == 0 || count == size){
            return "{\"noMore\":\"true\"}";
        }

        int blogId = blogs.get(count).getBlogId();
        int userId = blogs.get(count).getUserId();
        User user = profileMapper.getUser(userId);
        String userAvater = user.getAvatar();
        String userLink = "/personalspaceguest/" + userId;
        String username = blogs.get(count).getUsername();
        String blogTitle = blogs.get(count).getBlogTitle();
        BlogInfo blog =blogMapper.getBlog(blogId);
        System.out.println("blog: " + blog);
        String blogContent = blog.summary;
        String createTime = blogs.get(count).getCreateTime();
        int clickNumber = blogs.get(count).getClickNum();
        int likeNumber = blogs.get(count).getLikesNum();
        int commentNumber = blogs.get(count).getCommentNum();
        int forwardNumber = blogs.get(count).getForwardNum();
        int saveNumber = blogs.get(count).getCollectNum();
        //List<CommentView> commentList = blogs.get(count).getCommentList();//TODO:这里要做一个json 在前面通过循环方式进行添加
        int isliked;
        int iscollect;
        if(request.getSession().getAttribute("userID") != null){
            System.out.println("user exist");
            if(blogMapper.isliked(blogId,userId) == null){
                isliked = 0;
            }else {
                isliked = blogMapper.isliked(blogId,userId);
            }
            //isliked = blogMapper.isliked(blogId,userId);
            if(blogMapper.isCollect(blogId,userId) == null ){
                iscollect = 0;
            }else {
                iscollect = blogMapper.isCollect(blogId,userId);
            }


        }else{
            isliked = -1;
            iscollect = -1;
        }

        System.out.println("isliked: "+ isliked);

        System.out.println("userAvater: "+ userAvater);
        System.out.println("userId: " + userId);
//        private String username;
//        private String commentContent;

        //====生成comment json
        String comments = "";
        String comment = "";
        int commentCount = 0;

        List<BlogCommentVo> commentList = blogDetailsMapper.showBlogComment(blogId);

        if(commentList != null){
            for (BlogCommentVo cv : commentList) {

                if (commentCount == 3) {
                    break;
                }
                comment = "\"username\":" + "\"" + cv.getUsername() + "\"" + "," + "\"commentContent\":" + "\"" + cv.getCommentContent() + "\""+ "," + "\"commentTime\":" + "\"" + cv.getCreateTime() + "\""+ "," + "\"commentAvater\":" + "\"" + cv.getAvatar() + "\"";
                comment = "{" + comment + "}";
                System.out.println(comment);
                if (commentCount == 0) {
                    comments = comments + comment;
                } else {
                    comments = comments + "," + comment;
                }
                commentCount++;
            }
        }

        //====
        comments = "[" + comments + "]";
        //System.out.println(comments);
        //System.out.println(blogContent);

        String link = "/blogs/" + username + "/" + blogId;
        if(blogContent.length() >=66){
            blogContent = blogContent.substring(0,65);
        }

        System.out.println("Hello");
        session.setAttribute("count", count + 1);
        return "{\"iscollect\":\""+iscollect+"\",\"isliked\":\""+isliked+"\",\"tagId\":\"" + blog.tagId+ "\",\"userId\":\"" + userId+"\",\"blogId\":\""+ blogId +"\",\"userLink\":\""+userLink +"\",\"clickNumber\":\""+clickNumber+"\",\"userAvater\":\""+userAvater +"\",\"createTime\":\""+createTime+"\",\"blogContent\":\"" + blogContent + "\",\"blogTitle\":\"" + blogTitle + "\",\"username\":\"" + username + "\",\"likeNumber\":\"" + likeNumber + "\",\"commentNumber\":\"" + commentNumber + "\",\"forwardNumber\":\"" + forwardNumber + "\",\"saveNumber\":\"" + saveNumber + "\",\"comments\":" + comments + ",\"link\":\"" + link + "\"}";

    }

    @Override
    public ArrayList<HomeBlogView> getRecommendBlogViews(int userId) {
        System.out.println(userId);
        TagMark tagMark = homeMapper.getTagMark(userId);
        int tagId = tagMark.getRecommendTag();
        System.out.println("_________________________");
        System.out.println(tagId);
        ArrayList<HomeBlogView> blogList = homeMapper.getRecommendBlogViews(tagId);
        for (int i = 0; i < blogList.size(); i++) {
            int blogId = blogList.get(i).getBlogId();
            List<CommentView> commentList = homeMapper.getCommentViews(blogId);
            blogList.get(i).setCommentList(commentList);
        }
        return blogList;
    }

    @Override
    public TagMark getTagMark(int userId) {
        return homeMapper.getTagMark(userId);

    }

    @Override
    public void getTrendings(HttpServletRequest request, Model model){
        //TODO:找到搜索或者点击量最大的几个标签或者搜索词
        model.addAttribute("trendingOne","TrendingOne");
        model.addAttribute("trendingTwo","TrendingOne");
        model.addAttribute("trendingThree","TrendingOne");
    }//得到向前端发送的trendings
}