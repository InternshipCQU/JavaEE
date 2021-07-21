package com.example.demo.service;

import com.example.demo.entity.User;

import java.security.NoSuchAlgorithmException;

public interface RegisterService {
    void submitInfo(User user) throws NoSuchAlgorithmException;//TODO:这里记得将user改成一串数据，直接接受的是前端数据

    boolean checkUser(String username);

    boolean checkPassword(String signPassword, String comfirmPassword);
    void addUser(String username, String password, String userRegisterTime);

    void addToTagMark(String username);
}
