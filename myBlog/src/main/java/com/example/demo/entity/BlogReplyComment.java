package com.example.demo.entity;

// 博客评论回复表
public class BlogReplyComment {
    public Integer replyCommentId;    // 博客评论回复ID
    public String replyCommentContext;  // 博客评论回复内容
    public String createTime;       // 评论回复创建时间
    public Integer commentId;        // 被回复的博客评论ID
    public Integer userId;          // 发布回复评论的用户ID

    public Integer getReplyCommentId() {
        return replyCommentId;
    }

    public void setReplyCommentId(Integer replyCommentId) {
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

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
