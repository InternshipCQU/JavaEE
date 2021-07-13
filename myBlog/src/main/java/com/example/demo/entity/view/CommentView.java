package com.example.demo.entity.view;

public class CommentView {

    private String username;
    private String commentContent;
    private String useravater;
    private String commentTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getUseravater(){return useravater;}

    public void setUseravater(String useravater) {
        this.useravater = useravater;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }
}
