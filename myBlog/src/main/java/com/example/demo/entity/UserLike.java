package com.example.demo.entity;

// 粉丝关注表
public class UserLike {
    public Integer userLikeId;    // 用户关注ID
    public Integer userId;        // 被关注用户ID
    public Integer fansId;       // 粉丝ID

    public Integer getUserLikeId() {
        return userLikeId;
    }

    public void setUserLikeId(Integer userLikeId) {
        this.userLikeId = userLikeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFansId() {
        return fansId;
    }

    public void setFansId(Integer fansId) {
        this.fansId = fansId;
    }
}
