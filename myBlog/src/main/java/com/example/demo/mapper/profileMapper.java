package com.example.demo.mapper;

import com.example.demo.entity.BlogCollect;
import com.example.demo.entity.User;
import com.example.demo.entity.UserLike;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface profileMapper{
    public User getUser(Integer userId);
    public void setuser(User user);
    public List<UserLike> getfollowing(Integer userId);
    public List<String> getcollect(Integer userId);
    public String getusername(Integer userId);
    void setavatar(String dir,Integer userId);
}
