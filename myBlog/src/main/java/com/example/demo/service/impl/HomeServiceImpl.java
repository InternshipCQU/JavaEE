package com.example.demo.service.impl;

import com.example.demo.entity.BlogInfo;
import com.example.demo.entity.User;
import com.example.demo.entity.view.CommentView;
import com.example.demo.entity.view.HomeBlogView;
import com.example.demo.mapper.HomeMapper;
import com.example.demo.service.HomeService;
import com.example.demo.utils.SplitString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<BlogInfo> tagToBlogs(int tagId) {
        return homeMapper.tagToBlogs(tagId);
    }

    @Override
    public List<BlogInfo> searchBlogs(String keyword) {
        return homeMapper.searchBlogs(keyword);
    }

    @Override
    public List<User> showHotBlogger() {
        return homeMapper.showHotBlogger();
    }

    @Override
    // 【登陆后】根据关注的人，推荐关注列表热门博主
    public List<User> showRecommendBlogger(int userId) {
        return homeMapper.showRecommendBlogger(userId);
    }

    @Override
    public List<BlogInfo> getBlogs() {
        return homeMapper.getBlogs();
    }

    @Override
    public String getTheClass(String s) {
        String[] strs = SplitString.splitId(s);
        return strs[strs.length - 1];
    }
    //test
    @Override
    public ArrayList<HomeBlogView> getBlogViews(){
        ArrayList<HomeBlogView> blogList = homeMapper.getBlogViews();
        for(int i = 0; i < blogList.size(); i++){
            int blogId = blogList.get(i).getBlogId();
            List<CommentView> commentList = homeMapper.getCommentViews(blogId);
            blogList.get(i).setCommentList(commentList);
        }
        return blogList;
    }


    @Override
    public void Init(String cla,HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("blogs",getBlogViews());
        ArrayList<HomeBlogView> s1 = (ArrayList<HomeBlogView>)session.getAttribute("blogs");
        session.setAttribute("count",0);
        session.setAttribute("size",s1.size());
    }

    @Override
    public String giveTheBlogToIndex(String cla, HttpServletRequest request){
        HttpSession session = request.getSession();
        int count = (Integer)session.getAttribute("count");
        int size = (Integer)session.getAttribute("size");
        ArrayList<HomeBlogView> blogs = (ArrayList<HomeBlogView>)session.getAttribute("blogs");


        int blogId = blogs.get(count).getBlogId();
        String username = blogs.get(count).getUsername();
        String blogTitle = blogs.get(count).getBlogTitle();
        String blogContent = blogs.get(count).getBlogContent();
        String commentTime = blogs.get(count).getCreateTime();
        int clickNum = blogs.get(count).getClickNum();
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


        for(CommentView cv:commentList){

            if(commentCount == 3){
                break;
            }
            comment = "\"username\":" + "\""+cv.getUsername()+ "\"" + "," + "\"commentContent\":" + "\""+cv.getCommentContent()+ "\"";
            comment = "{" + comment + "}";
            if(commentCount==0){
                comments = comments + comment;
            }else{
                comments = comments + "," +comment;
            }
            commentCount++;
        }
        //====
        comments = "[" + comments +"]";
        System.out.println(comments);

        String link = "/blogs/"+ username + "/" + blogId;

        if(count == size-1) {
            return "{\"noMore\":\"true\"}";
        }else{
            System.out.println("Hello");
            session.setAttribute("count",count+1);
            return "{\"blogContent\":\"" + blogContent + "\",\"blogTitle\":\""+blogTitle+"\",\"username\":\""+ username +"\",\"likeNumber\":\"" + likeNumber+ "\",\"commentNumber\":\""+ commentNumber+"\",\"forwardNumber\":\""+forwardNumber+"\",\"saveNumber\":\"" + saveNumber+ "\",\"comments\":" + comments+ ",\"link\":\""+link+"\"}";
        }
    }
}

