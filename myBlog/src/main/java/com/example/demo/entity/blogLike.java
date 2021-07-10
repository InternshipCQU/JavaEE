package com.example.demo.entity;

// 博客点赞表
public class blogLike {
    public int likeBlogId;    // 博客点赞ID
    public int blogId;        // 被点赞博客ID
    public int useId;         // 点赞用户ID

    public int getLikeBlogId() {
        return likeBlogId;
    }

    public void setLikeBlogId(int likeBlogId) {
        this.likeBlogId = likeBlogId;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public int getUseId() {
        return useId;
    }

    public void setUseId(int useId) {
        this.useId = useId;
    }
}
