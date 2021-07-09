package com.example.demo.entity;

// 博客点赞表
public class blogLike {
    public String likeBlogId;    // 博客点赞ID
    public String blogId;        // 被点赞博客ID
    public String useId;         // 点赞用户ID

    public String getLikeBlogId() {
        return likeBlogId;
    }

    public void setLikeBlogId(String likeBlogId) {
        this.likeBlogId = likeBlogId;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getUseId() {
        return useId;
    }

    public void setUseId(String useId) {
        this.useId = useId;
    }
}
