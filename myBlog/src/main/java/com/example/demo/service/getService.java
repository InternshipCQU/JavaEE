package com.example.demo.service;

import com.example.demo.entity.BlogCollect;
import com.example.demo.entity.User;
import com.example.demo.entity.UserLike;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface getService {
    User getuserprofile( Integer userID);
    List<UserLike> getfollowing(Integer userID);
    List<String> getcollect(Integer userID);
    String getusername(Integer userID);
    String getbackgroundurl(Integer userId);
    String getintroduction(Integer userId);
}

