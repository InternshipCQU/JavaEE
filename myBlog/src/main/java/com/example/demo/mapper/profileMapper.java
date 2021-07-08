package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface profileMapper{
    String getalias(String username);
    void setalias(String username,String new_alias);
    void setgender(String gender, String username);
    void setname(String newname,String oldname);
}
