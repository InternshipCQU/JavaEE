package com.example.demo.entity;

// 博客评论表
public class blogComment {
    public String commentID;        // 博客评论ID
    public String commentContext;   // 博客评论内容
    public String createTime;       // 评论创建时间
    public String blogId;           // 被评论的博客ID
    public String userId;           // 发布评论的用户ID

    public String getCommentID() {
        return commentID;
    }

    public void setCommentID(String commentID) {
        this.commentID = commentID;
    }

    public String getCommentContext() {
        return commentContext;
    }

    public void setCommentContext(String commentContext) {
        this.commentContext = commentContext;
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
