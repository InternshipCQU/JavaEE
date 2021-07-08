package com.example.demo.service;

import com.example.demo.entity.User;

public interface getService {
    String getalias(int userID);
    String getusername(int userID);
    char getgender(int userID);
    String getprofile(int userID);
    String getregion(int userID);
    String getdateofbirth(int userID);
}

