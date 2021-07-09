package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface setaliasMapper {
    void setalias(String username,String new_alias);
}
