package com.example.demo.entity;

// 博客标签信息表（用于连接博客信息表与博客标签表）
public class tagBlogInfo {
    public int tbId;     // 博客标签表ID
    public int tagId;    // 博客标签ID
    public int blogId;   // 博客信息ID

    public int getTbId() {
        return tbId;
    }

    public void setTbId(int tbId) {
        this.tbId = tbId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }
}
