package com.example.demo.entity;

// 博客标签信息表（用于连接博客信息表与博客标签表）
public class TagBlogInfo {
    public Integer tbId;     // 博客标签表ID
    public Integer tagId;    // 博客标签ID
    public Integer blogId;   // 博客信息ID

    public Integer getTbId() {
        return tbId;
    }

    public void setTbId(Integer tbId) {
        this.tbId = tbId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }
}
