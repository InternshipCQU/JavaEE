package com.example.demo.service;

import com.example.demo.entity.Blog;
import com.example.demo.entity.User;

import java.util.List;

public interface PersonalSpaceService {
    List<Blog> blogs(int userID);
    List<User> users(int userID);
}
