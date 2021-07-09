package com.example.demo.entity;


// 博客草稿表
public class blogDraft {
    public String blogDraftId;    // 博客草稿ID
    public String draftContext;   // 草稿内容
    public String userId;        // 用户ID

    public String getBlogDraftId() {
        return blogDraftId;
    }

    public void setBlogDraftId(String blogDraftId) {
        this.blogDraftId = blogDraftId;
    }

    public String getDraftContext() {
        return draftContext;
    }

    public void setDraftContext(String draftContext) {
        this.draftContext = draftContext;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
