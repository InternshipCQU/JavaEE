package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface profileMapper{
    public User getUser(int userID);
    public User setuser(User user);

}
