package com.example.demo.mapper;

import com.example.demo.entity.User;

public interface CheckLoginMapper {
    String checkPassword(String username);

    String userExist(String username);   // 检查用户名是否存在
}
