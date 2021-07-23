package com.example.demo.mapper;

import com.example.demo.entity.BlogDraft;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogwritingMapper {

    void addblog(String blogTitle, String blogContent, String createTime, int tagID, int userID,int isForward, String summaryContent);

    void addBlogNum(int userID);

    void addDraft(String draftTitle, String draftContent, String draftTagName, int userID);

    void updateDraft(String draftTitle, String draftContent, String draftTagName, int userID);

    void modifyBlog();

    Integer draftNum(int userID);

    BlogDraft getDraft(int userID);

    void updateDraft(int userID, String draftTitle, String draftContent, String draftTagName);

    void deleteDraft(int userID);
}
