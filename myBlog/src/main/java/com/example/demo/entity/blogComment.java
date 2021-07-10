package com.example.demo.entity;

// 博客评论表
public class blogComment {
    public int commentID;        // 博客评论ID
    public String commentContext;   // 博客评论内容
    public String createTime;       // 评论创建时间
    public int blogId;           // 被评论的博客ID
    public int userId;           // 发布评论的用户ID

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
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
