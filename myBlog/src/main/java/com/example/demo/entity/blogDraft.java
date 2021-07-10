package com.example.demo.entity;


// 博客草稿表
public class blogDraft {
    public int blogDraftId;    // 博客草稿ID
    public String draftContext;   // 草稿内容
    public int userId;        // 用户ID

    public int getBlogDraftId() {
        return blogDraftId;
    }

    public void setBlogDraftId(int blogDraftId) {
        this.blogDraftId = blogDraftId;
    }

    public String getDraftContext() {
        return draftContext;
    }

    public void setDraftContext(String draftContext) {
        this.draftContext = draftContext;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
