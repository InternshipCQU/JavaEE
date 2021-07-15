package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegisterMapper {
    // 用户注册时，将用户名和密码写入数据库
    void addUser(String username, String password);
}
