package com.example.demo.service;

import com.example.demo.entity.BlogDraft;
import com.example.demo.entity.BlogInfo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

public interface BlogWritingService {
    public void addBlog(String blogTitle, String blogContent, String createTime, String tagName, int isForward,String summary,HttpServletRequest request);

    public BlogInfo getBlog(int blogID);

    public void addDraft(String draftTitle, String draftContent, String draftTagName, HttpServletRequest request);

    public BlogDraft getDraft(int userID);

    public Integer draftNum(int userID);

    public void updateDraft(int userID, String draftTitle, String draftContent, String draftTagName);

    public void submitDraft(String draftTitle, String draftContent, String draftTagName, HttpServletRequest request);

    public void submitBlog(String blogTitle, String blogContent, String createTime, String tagName, int isForward,String summaryContent, HttpServletRequest request);

    public void deleteDraft(int userID);

}
