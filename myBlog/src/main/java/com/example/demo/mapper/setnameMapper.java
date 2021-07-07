package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface setnameMapper {
    void setname(String newname,String oldname);
}
