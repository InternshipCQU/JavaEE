package com.example.demo.entity;

// 博客转发表
public class blogForward {
    public String forwardBlogId;     // 博客转发ID
    public String createTime;        // 转发创建时间
    public String blogId;            // 被转发博客ID
    public String userId;            // 转发用户ID

    public String getForwardBlogId() {
        return forwardBlogId;
    }

    public void setForwardBlogId(String forwardBlogId) {
        this.forwardBlogId = forwardBlogId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
