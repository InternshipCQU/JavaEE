package com.example.demo.entity;

import javax.validation.constraints.NotEmpty;

public class User {
    public Integer userId;     // 用户ID

    @NotEmpty(message = "请输入用户名")
    public String username;   // 用户名称

    @NotEmpty(message = "请输入密码")
    public String password;   // 密码
    public String gender;     // 性别，M代表男性，F代表女性
    public String email;      // 邮箱
    public String telephone;  // 手机号码
    public String firstname;  // 姓
    public String lastname;   // 名
    public String avatar;     // 头像base64码 更改成路径
    public String lastLogin;  // 上一次登陆时间
    public Integer fansNum;    // 粉丝数
    public Integer likesNum;   // 点赞数
    public Integer blogsNum;   // 博客数
    public String userRegisterTime;   // 用户注册时间
    public String birthdate;   // 用户出生日期
    public String profile;   // 用户个人简介
    public String area;        // 用户所在地区
    public String background; //背景图片
    public String selfIntroduction; //个人简介

    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }

    public String getBackground(){return background;}
    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Integer getFansNum() {
        return fansNum;
    }

    public void setFansNum(Integer fansNum) {
        this.fansNum = fansNum;
    }

    public Integer getLikesNum() {
        return likesNum;
    }

    public void setLikesNum(Integer likesNum) {
        this.likesNum = likesNum;
    }

    public Integer getBlogsNum() {
        return blogsNum;
    }

    public void setBlogsNum(Integer blogsNum) {
        this.blogsNum = blogsNum;
    }

    public String getUserRefisiterTime() {
        return userRegisterTime;
    }

    public void setUserRefisiterTime(String userRefisiterTime) {
        this.userRegisterTime = userRefisiterTime;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setUserID(Integer userID) {
        this.userId = userID;
    }
}
