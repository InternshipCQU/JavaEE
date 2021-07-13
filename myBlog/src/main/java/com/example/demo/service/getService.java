package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.UserLike;

import java.util.List;

public interface getService {
    User getuserprofile( Integer userID);
    List<UserLike> getfollowing(Integer userID);
    String getusername(Integer userID);
}

