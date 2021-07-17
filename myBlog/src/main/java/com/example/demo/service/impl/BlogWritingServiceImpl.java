package com.example.demo.service.impl;

import com.example.demo.constants.MapofTagNameAndTagID;
import com.example.demo.entity.BlogDraft;
import com.example.demo.entity.BlogInfo;
import com.example.demo.mapper.BlogMapper;
import com.example.demo.mapper.BlogwritingMapper;
import com.example.demo.service.BlogWritingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service("BlogWritingService")
public class BlogWritingServiceImpl implements BlogWritingService {

    @Resource
    private BlogwritingMapper blogWritingMapper;

    @Resource
    private BlogMapper blogmapper;


    @Override

    public void addBlog(String blogTitle, String blogContent,String createTime, String tagName,int isForward, String summaryContent, HttpServletRequest request) {


        System.out.println(tagName.getClass().getName().toString());
        MapofTagNameAndTagID map = new MapofTagNameAndTagID();

        System.out.println(tagName);
        int tagID = map.getTagID(tagName);

        //再通过session获取一下用户ID，等后面用户id写入session
        int userID = (int)request.getSession().getAttribute("userID");

        //int userID = 1;

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
