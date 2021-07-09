package com.example.demo.entity;

// 博客标签信息表（用于连接博客信息表与博客标签表）
public class tagBlogInfo {
    public String tbId;     // 博客标签表ID
    public String tagId;    // 博客标签ID
    public String blogId;   // 博客信息ID

    public String getTbId() {
        return tbId;
    }

    public void setTbId(String tbId) {
        this.tbId = tbId;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }
}
