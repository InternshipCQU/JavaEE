package com.example.demo.mapper;

import com.example.demo.entity.user;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface setaliasMapper {
    void setalias(String username,String new_alias);
}
