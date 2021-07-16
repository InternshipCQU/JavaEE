package com.example.demo.entity;

// 博客评论表
public class BlogCommentVo {
    public Integer commentId;        // 博客评论ID
    public String commentContent;   // 博客评论内容
    public String createTime;       // 评论创建时间
    public Integer blogId;           // 被评论的博客ID
    public Integer userId;           // 发布评论的用户ID

    private String username;
    private String avatar;

    public Integer getcommentId() {
        return commentId;
    }

    public void setcommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContext) {
        this.commentContent = commentContext;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
