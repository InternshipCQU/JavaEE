package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.BlogInfo;

import java.util.List;

public interface PersonalSpaceService {
    List<BlogInfo> blogs(int userID);
    List<User> users(int userID);
    List<BlogInfo> showCalendarFigure(String username);
}
