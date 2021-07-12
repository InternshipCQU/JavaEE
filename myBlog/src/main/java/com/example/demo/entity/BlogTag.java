package com.example.demo.entity;

// 博客标签表
public class BlogTag {
    public Integer tagId;    // 博客标签ID
    public String tagName;  // 博客标签名称

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
