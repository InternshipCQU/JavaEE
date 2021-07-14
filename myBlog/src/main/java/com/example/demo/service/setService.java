package com.example.demo.service;


import com.example.demo.entity.User;

public interface setService {
//    boolean setalias(String new_alias,int userID);
    void setuser(User user);
    boolean checksetinfo(User user);
    void setavatar(String dir,Integer userId);
    void setbackground(String dir,Integer userId);
}
