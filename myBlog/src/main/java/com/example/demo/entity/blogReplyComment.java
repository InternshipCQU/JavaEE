package com.example.demo.entity;

// 博客评论回复表
public class blogReplyComment {
    public int replyCommentId;    // 博客评论回复ID
    public String replyCommentContext;  // 博客评论回复内容
    public String createTime;       // 评论回复创建时间
    public int commentId;        // 被回复的博客评论ID
    public int userId;          // 发布回复评论的用户ID

    public int getReplyCommentId() {
        return replyCommentId;
    }

    public void setReplyCommentId(int replyCommentId) {
        this.replyCommentId = replyCommentId;
    }

    public String getReplyCommentContext() {
        return replyCommentContext;
    }

    public void setReplyCommentContext(String replyCommentContext) {
        this.replyCommentContext = replyCommentContext;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
