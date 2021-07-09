package com.example.demo.entity;

// 博客评论回复表
public class blogReplyComment {
    public String replyCommentId;    // 博客评论回复ID
    public String replyCommentContext;  // 博客评论回复内容
    public String createTime;       // 评论回复创建时间
    public String commentId;        // 被回复的博客评论ID
    public String userId;          // 发布回复评论的用户ID

    public String getReplyCommentId() {
        return replyCommentId;
    }

    public void setReplyCommentId(String replyCommentId) {
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

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
