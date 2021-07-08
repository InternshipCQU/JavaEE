package com.example.demo.mapper;

import com.example.demo.entity.user;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface getaliasMapper {
    String getalias(String username);
}
