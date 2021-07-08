package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface profileMapper{
    String getalias(String username);
    void setalias(int userID,String new_alias);
    void setgender(String gender, int userID);
    void setname(String newname,String oldname,int userID);
    void setprofile(String profiledate,int userID);
    void setregion(String new_region,int userID);
    void setdateofbirth(String date,int userID);

}
