package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface setgenderMapper {
    void setgender(String gender, String username);
}
