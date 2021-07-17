package com.example.demo.entity;


// 博客草稿表
public class BlogDraft {
    public Integer blogDraftId;    // 博客草稿ID
    public String draftContent;   // 草稿内容
    public String draftTitle;
    public String draftTagName;
    public Integer userId;        // 用户ID

    public BlogDraft(){
        blogDraftId = 0;
        draftContent = "";
        draftTitle = "";
        draftTagName = "";
        userId = 0;
    }

    public Integer getBlogDraftId() {
        return blogDraftId;
    }

    public void setBlogDraftId(Integer blogDraftId) {
        this.blogDraftId = blogDraftId;
    }

    public String getDraftContext() { return draftContent; }

    public void setDraftContext(String draftContext) {
        this.draftContent = draftContext;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDraftContent() {
        return draftContent;
    }

    public void setDraftContent(String draftContent) {
        this.draftContent = draftContent;
    }

    public String getDraftTitle() {
        return draftTitle;
    }

    public void setDraftTitle(String draftTitle) {
        this.draftTitle = draftTitle;
    }

    public String getDraftTagName() {
        return draftTagName;
    }

    public void setDraftTagName(String draftTagName) {
        this.draftTagName = draftTagName;
    }
}
