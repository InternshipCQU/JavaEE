package com.example.demo.service;

import com.example.demo.entity.user;

import java.util.Date;
/*The format of Date is: yyyy-mm-dd ,which is defined in setServiceImpl.*/

public interface setService {
    boolean setalias(String new_alias, String username);
    boolean setname(String new_name,String old_name);
    boolean setgender(String gender,String username);
    boolean setprofile(String profiledata,String username);
    boolean setregion(String regioin,String username);
    boolean setdateofbirth(Date date, String username);
}
