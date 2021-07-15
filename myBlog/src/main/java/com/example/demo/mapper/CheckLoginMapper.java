package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CheckLoginMapper {
    String checkPassword(String username);

    String userExist(String username);   // 检查用户名是否存在
}
