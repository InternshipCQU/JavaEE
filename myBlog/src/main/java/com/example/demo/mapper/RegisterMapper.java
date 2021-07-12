package com.example.demo.mapper;

import com.example.demo.entity.User;

import java.util.List;

public interface RegisterMapper {
    List<User> addUser(String username, String password);
}
