package com.example.demo.entity;

// 博客转发表
public class BlogForward {
    public Integer forwardBlogId;     // 博客转发ID
    public String createTime;        // 转发创建时间
    public Integer blogId;            // 被转发博客ID
    public Integer userId;            // 转发用户ID

    public Integer getForwardBlogId() {
        return forwardBlogId;
    }

    public void setForwardBlogId(Integer forwardBlogId) {
        this.forwardBlogId = forwardBlogId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
