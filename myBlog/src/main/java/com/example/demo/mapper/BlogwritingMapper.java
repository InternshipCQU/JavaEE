package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogwritingMapper {
    void addblog(String blogTitle, String blogContent, String createTime, int tagID, int userID);

}
