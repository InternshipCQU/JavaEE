package com.example.demo.mapper;

import com.example.demo.entity.User;

import java.util.List;

public interface userinfoallMapper {
    List<User> getallfollow(Integer userId);
}
