package com.example.demo.entity;

// 博客转发表
public class blogForward {
    public int forwardBlogId;     // 博客转发ID
    public String createTime;        // 转发创建时间
    public int blogId;            // 被转发博客ID
    public int userId;            // 转发用户ID

    public int getForwardBlogId() {
        return forwardBlogId;
    }

    public void setForwardBlogId(int forwardBlogId) {
        this.forwardBlogId = forwardBlogId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
