package com.example.demo.mapper;

import com.example.demo.entity.User;

public interface CheckLoginMapper {
    User checkPassword(String username);
}
