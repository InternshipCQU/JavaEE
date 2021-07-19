package com.example.demo.mapper;

import com.example.demo.entity.BlogInfo;
import com.example.demo.entity.User;

import java.util.List;

public interface userinfoallMapper {
    List<User> getallfollow(Integer userId);
    void cancelfollow(Integer cancelId,Integer userId);
    void reducelikenum(Integer userId);
    List<BlogInfo> getallfavorites(Integer userId);
}
