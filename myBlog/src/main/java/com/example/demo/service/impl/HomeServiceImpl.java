package com.example.demo.service.impl;

import com.example.demo.entity.BlogInfo;
import com.example.demo.entity.TagMark;
import com.example.demo.entity.User;
import com.example.demo.entity.view.CommentView;
import com.example.demo.entity.view.HomeBlogView;
import com.example.demo.mapper.HomeMapper;
import com.example.demo.service.HomeService;
import com.example.demo.utils.SplitString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo.utils.SplitString.splitId;

@Service("HomeService")
public class HomeServiceImpl implements HomeService {

    @Resource
    private HomeMapper homeMapper;

    @Override
    public List<BlogInfo> tagToBlogs(String tagName) {
        return homeMapper.tagToBlogs(tagName);
    }

    @Override
    public List<BlogInfo> searchBlogs(String keyword) {
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
        if(request.getAttribute("token").equals("yes")){
            model.addAttribute("recommendBlogger",showRecommendBlogger(((Integer)request.getAttribute("userID"))));
        }else{
            model.addAttribute("recommendBlogger",showHotBlogger());
        }
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
        if(session.getAttribute("Token").equals("yes")){
            session.setAttribute("blogs", getRecommendBlogViews((Integer) session.getAttribute("userID")));
        }else{
            session.setAttribute("blogs", getBlogViews());
        }

        ArrayList<HomeBlogView> s1 = (ArrayList<HomeBlogView>) session.getAttribute("blogs");
        session.setAttribute("count", 0);
        session.setAttribute("size", s1.size());
    }

    @Override
    public String giveTheBlogToIndex(String cla, HttpServletRequest request) {
        HttpSession session = request.getSession();
        int count = (Integer) session.getAttribute("count");
        int size = (Integer) session.getAttribute("size");
        ArrayList<HomeBlogView> blogs = (ArrayList<HomeBlogView>) session.getAttribute("blogs");


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
        //====
        comments = "[" + comments + "]";
        System.out.println(comments);

        String link = "/blogs/" + username + "/" + blogId;

        if (count == size - 1) {
            return "{\"noMore\":\"true\"}";
        } else {
            System.out.println("Hello");
            session.setAttribute("count", count + 1);
            return "{\"clickNumber\":\""+clickNumber+"\",\"userAvater\":\""+userAvater +"\",\"createTime\":\""+createTime+"\",\"blogContent\":\"" + blogContent + "\",\"blogTitle\":\"" + blogTitle + "\",\"username\":\"" + username + "\",\"likeNumber\":\"" + likeNumber + "\",\"commentNumber\":\"" + commentNumber + "\",\"forwardNumber\":\"" + forwardNumber + "\",\"saveNumber\":\"" + saveNumber + "\",\"comments\":" + comments + ",\"link\":\"" + link + "\"}";
        }


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