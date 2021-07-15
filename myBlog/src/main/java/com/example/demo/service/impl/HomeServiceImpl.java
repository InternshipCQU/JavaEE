package com.example.demo.service.impl;

import com.example.demo.entity.BlogInfo;
import com.example.demo.entity.TagMark;
import com.example.demo.entity.User;
import com.example.demo.entity.view.CommentView;
import com.example.demo.entity.view.HomeBlogView;
import com.example.demo.mapper.HomeMapper;
import com.example.demo.mapper.profileMapper;
import com.example.demo.service.HomeService;
import com.example.demo.utils.SplitString;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public List<BlogInfo> tagToBlogs(String tagName) {
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
        if(request.getAttribute("token")!=null){
            model.addAttribute("recommendBlogger",showRecommendBlogger(((Integer)request.getAttribute("userID"))));
        }else{
            model.addAttribute("recommendBlogger",showHotBlogger());
        }
    }

    @Override
    public void setBlogger(HttpServletRequest request, Model model) { //在前端页面上设置右上角头像和链接
        if(request.getAttribute("userID")!=null){
            User user = profileMapper.getUser((Integer)request.getAttribute("userID"));
            model.addAttribute("bloggerAvatar",user.getAvatar());
            model.addAttribute("bloggerPath","/blogger/" + user.getUsername() + "/" + user.getUserId());
            model.addAttribute("spacePath","/space/"+user.getUserId());
            model.addAttribute("username",user.getUsername());
            model.addAttribute("hiddenLogout","false");
            model.addAttribute("hiddenLogin","true");

        }else{
            model.addAttribute("bloggerAvatar","https://bucket-myblog.oss-cn-beijing.aliyuncs.com/avatar/defaultAvatar.jpg");
            model.addAttribute("bloggerPath","/login");
            model.addAttribute("spacePath","/login");
            model.addAttribute("username","login please");
            model.addAttribute("hiddenLogout","true");
            model.addAttribute("hiddenLogin","false");
        }
        //System.out.println(model.getAttribute("bloggerAvatar"));

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
            if(session.getAttribute("Token") != null){
                session.setAttribute("blogs", getRecommendBlogViews((Integer) session.getAttribute("userID")));
            }else{
                System.out.println("加载所有的博客");

                session.setAttribute("blogs", getBlogViews());
            }
        }else{
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
        ArrayList<HomeBlogView> blogs = (ArrayList<HomeBlogView>) session.getAttribute("blogs");

        System.out.println(size);
        System.out.println(count);

        if(size == 0 || count == size){
            return "{\"noMore\":\"true\"}";
        }

        int blogId = blogs.get(count).getBlogId();
        String userAvater = blogs.get(count).getAvater();
        String username = blogs.get(count).getUsername();
        String blogTitle = blogs.get(count).getBlogTitle();
        String blogContent = blogs.get(count).getBlogContent();
        String createTime = blogs.get(count).getCreateTime();
        int clickNumber = blogs.get(count).getClickNum();
        int likeNumber = blogs.get(count).getLikesNum();
        int commentNumber = blogs.get(count).getCommentNum();
        int forwardNumber = blogs.get(count).getForwardNum();
        int saveNumber = blogs.get(count).getCollectNum();
        List<CommentView> commentList = blogs.get(count).getCommentList();//TODO:这里要做一个json 在前面通过循环方式进行添加

//        private String username;
//        private String commentContent;

        //====生成comment json
        String comments = "";
        String comment = "";
        int commentCount = 0;

        if(commentList != null){
            for (CommentView cv : commentList) {

                if (commentCount == 3) {
                    break;
                }
                comment = "\"username\":" + "\"" + cv.getUsername() + "\"" + "," + "\"commentContent\":" + "\"" + cv.getCommentContent() + "\""+ "," + "\"commentTime\":" + "\"" + cv.getCommentTime() + "\""+ "," + "\"userAvater\":" + "\"" + cv.getUseravater() + "\"";
                comment = "{" + comment + "}";
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
        if(blogContent.length() > 32){
            blogContent =  blogContent.substring(0,30);
        }
        blogContent = "你好 世界";
        String link = "/blogs/" + username + "/" + blogId;

        System.out.println("Hello");
        session.setAttribute("count", count + 1);
        return "{\"clickNumber\":\""+clickNumber+"\",\"userAvater\":\""+userAvater +"\",\"createTime\":\""+createTime+"\",\"blogContent\":\"" + blogContent + "\",\"blogTitle\":\"" + blogTitle + "\",\"username\":\"" + username + "\",\"likeNumber\":\"" + likeNumber + "\",\"commentNumber\":\"" + commentNumber + "\",\"forwardNumber\":\"" + forwardNumber + "\",\"saveNumber\":\"" + saveNumber + "\",\"comments\":" + comments + ",\"link\":\"" + link + "\"}";

    }

    @Override
    public ArrayList<HomeBlogView> getRecommendBlogViews(int tagId) {
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