package com.example.demo.entity;

// 博客点赞表
public class BlogLike {
    public Integer likeBlogId;    // 博客点赞ID
    public Integer blogId;        // 被点赞博客ID
    public Integer useId;         // 点赞用户ID

    public Integer getLikeBlogId() {
        return likeBlogId;
    }

    public void setLikeBlogId(Integer likeBlogId) {
        this.likeBlogId = likeBlogId;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getUseId() {
        return useId;
    }

    public void setUseId(Integer useId) {
        this.useId = useId;
    }
}
