package com.example.demo.entity.view;

import java.util.List;

public class HomeBlogView {

    private int blogId;
    private int userId;
    private String avater;
    private String username;
    private String blogTitle;
    private String blogContent;
    private String createTime;
    private int clickNum;
    private int likesNum;
    private int commentNum;
    private int forwardNum;
    private int collectNum;
    private List<CommentView> commentList;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getClickNum() {
        return clickNum;
    }

    public void setClickNum(int clickNum) {
        this.clickNum = clickNum;
    }

    public int getLikesNum() {
        return likesNum;
    }

    public void setLikesNum(int likesNum) {
        this.likesNum = likesNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public int getForwardNum() {
        return forwardNum;
    }

    public void setForwardNum(int forwardNum) {
        this.forwardNum = forwardNum;
    }

    public int getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(int collectNum) {
        this.collectNum = collectNum;
    }

    public List<CommentView> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentView> commentList) {
        this.commentList = commentList;
    }

    public void setAvater(String avater) {
        this.avater = avater;
    }

    public String getAvater() {
        return avater;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }
}
