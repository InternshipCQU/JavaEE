package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.blogInfo;

import java.util.List;

public interface PersonalSpaceService {
    List<blogInfo> blogs(int userID);
    List<User> users(int userID);
}
