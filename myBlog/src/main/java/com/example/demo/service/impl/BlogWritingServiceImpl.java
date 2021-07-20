package com.example.demo.service.impl;

import com.example.demo.constants.MapofTagNameAndTagID;
import com.example.demo.entity.BlogDraft;
import com.example.demo.entity.BlogInfo;
import com.example.demo.mapper.BlogMapper;
import com.example.demo.mapper.BlogwritingMapper;
import com.example.demo.mapper.HomeMapper;
import com.example.demo.mapper.UserFansMapper;
import com.example.demo.service.BlogWritingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Service("BlogWritingService")
public class BlogWritingServiceImpl implements BlogWritingService {

    @Resource
    private BlogwritingMapper blogWritingMapper;

    @Resource
    private BlogMapper blogmapper;

    @Resource
    private UserFansMapper fansMapper;

    @Resource
    private HomeMapper homeMapper;

    @Override
    public ArrayList<Integer> getfansid(int userID) {
        ArrayList<Integer> fanslist = fansMapper.getfansid(userID);
        return fanslist;
    }

    @Override

    public void addBlog(String blogTitle, String blogContent,String createTime, String tagName,int isForward, String summaryContent, HttpServletRequest request) {


        MapofTagNameAndTagID map = new MapofTagNameAndTagID();

        int tagID = map.getTagID(tagName);

        //再通过session获取一下用户ID，等后面用户id写入session
        int userID = (int)request.getSession().getAttribute("userID");
        String userName = (String) request.getSession().getAttribute("username");


        //首先生成这条新闻
        String news = userName + " has just released a blog:《" + blogTitle + "》";
        //然后查询返回一个这个用户的粉丝列表
        ArrayList<Integer> fanslist = getfansid(userID);
        //然后循环该粉丝列表
        int len = fanslist.size();
        System.out.println("fansnum:"+len);
        for(int i=0; i<len; i++){
            int fansID = fanslist.get(i);
            System.out.println(fansID);
//            向数据库中的news表插入数据
            homeMapper.addNews(userID, fansID, news);
        }

        blogWritingMapper.addblog(blogTitle, blogContent, createTime, tagID, userID,isForward,summaryContent);

    }

    @Override
    public void addDraft(String draftTitle, String draftContent, String draftTagName, HttpServletRequest request){
        int userID = (Integer) request.getSession().getAttribute("userID");
        blogWritingMapper.addDraft(draftTitle, draftContent, draftTagName, userID);
    }


    @Override
    public BlogInfo getBlog(int blogID){
        return blogmapper.getBlog(blogID);
    }

    @Override
    public Integer draftNum(int userID){
        Integer num = blogWritingMapper.draftNum(userID);
        return num;
    }

    @Override
    public BlogDraft getDraft(int userID){
        BlogDraft draft = new BlogDraft();
        if(this.draftNum(userID) == 1){ //有草稿的话，就将草稿对象赋值给draft
            draft = blogWritingMapper.getDraft(userID);
        }
        //没有草稿的话，这个草稿对象中的标题、正文等信息就是默认的空字符串
        return draft;
    }

    @Override
    public void updateDraft(int userID, String draftTitle, String draftContent, String draftTagName){
        blogWritingMapper.updateDraft(userID, draftTitle,draftContent, draftTagName);

    }

    @Override
    public void submitDraft(String draftTitle, String draftContent, String draftTagName, HttpServletRequest request){
        int userID = (Integer) request.getSession().getAttribute("userID");
        if(this.draftNum(userID) == 1){
            //有草稿的话，就在数据库中直接update它
            this.updateDraft(userID, draftTitle,draftContent, draftTagName);
        }
        else {
            //之前没有草稿，直接插入一条新的草稿记录
            this.addDraft(draftTitle, draftContent, draftTagName, request);
        }
    }

    @Override
    public void submitBlog(String blogTitle, String blogContent, String createTime, String tagName, int isForward,String summaryContent, HttpServletRequest request){

        int userID = (Integer) request.getSession().getAttribute("userID");

        addBlog(blogTitle, blogContent, createTime, tagName, isForward,summaryContent, request);

        if(this.draftNum(userID) >= 1){
            //有草稿的话，因为要发表了，所i有就在数据库中直接把这条草稿记录删了
            this.deleteDraft(userID);
        }
    }

    @Override
    public void deleteDraft(int userID){
        blogWritingMapper.deleteDraft(userID);
    }
}
