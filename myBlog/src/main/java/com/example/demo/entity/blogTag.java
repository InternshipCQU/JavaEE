package com.example.demo.entity;

// 博客标签表
public class blogTag {
    public int tagId;    // 博客标签ID
    public String tagName;  // 博客标签名称

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
