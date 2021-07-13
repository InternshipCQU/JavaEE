package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.example.demo.entity.BlogInfo;

import java.util.List;

public interface UserSettingsMapper {
    // 展示个人头像，名称，粉丝数，点赞数，博客数，用户注册时间
    List<User> showUser(int userId);

    // 展示个人资料
    User showUserInfo(int userId);

    // 【修改个人资料】
    // 修改用户名称
    void changeUsername(int userId, String username);

    // 修改用户密码
    void changePassword(int userId, String password);

    // 修改用户性别
    void changeGender(int userId, String gender);

    // 修改邮箱
    void changeEmail(int userId, String email);

    // 修改手机号码
    void changeTel(int userId, String tel);

    // 修改姓
    void changeFirstname(int userId, String firstname);

    // 修改名
    void changeLastname(int userId, String lastname);

    // 修改头像
    void changeAvatar(int userId, String avatar);

    // 修改出生日期
    void changeBirthdate(int userId, String birthdate);

    // 修改个人简介
    void changeProfile(int userId, String profile);

    // 修改用户所在地区
    void changeArea(int userId, String area);

    // 展示用户关注博主（top6）
    List<User> showLikeBlogger(int userId);

    // 展示用户收藏
    List<BlogInfo> showCollectBlog(int userId);
}
