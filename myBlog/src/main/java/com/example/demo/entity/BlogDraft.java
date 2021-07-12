package com.example.demo.entity;


// 博客草稿表
public class BlogDraft {
    public Integer blogDraftId;    // 博客草稿ID
    public String draftContext;   // 草稿内容
    public Integer userId;        // 用户ID

    public Integer getBlogDraftId() {
        return blogDraftId;
    }

    public void setBlogDraftId(Integer blogDraftId) {
        this.blogDraftId = blogDraftId;
    }

    public String getDraftContext() {
        return draftContext;
    }

    public void setDraftContext(String draftContext) {
        this.draftContext = draftContext;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
