package com.example.demo.entity;

// 粉丝关注表
public class userLike {
    public String userLikeId;    // 用户关注ID
    public String userId;        // 被关注用户ID
    public String fansId;       // 粉丝ID

    public String getUserLikeId() {
        return userLikeId;
    }

    public void setUserLikeId(String userLikeId) {
        this.userLikeId = userLikeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFansId() {
        return fansId;
    }

    public void setFansId(String fansId) {
        this.fansId = fansId;
    }
}
