package com.example.demo.service;

import com.example.demo.entity.user;

import java.util.Date;
/*The format of Date is: yyyy-mm-dd ,which is defined in setServiceImpl.*/

public interface setService {
    boolean setalias(String new_alias,int userID);
    boolean setname(String new_name,String old_name,int userID);
    boolean setgender(String gender,int userID);
    boolean setprofile(String profiledata,int userID);
    boolean setregion(String regioin,int userID);
    boolean setdateofbirth(Date date, int userID);
}
