package com.example.demo.service;

import com.example.demo.entity.user;

public interface setService {
    boolean setalias(String new_alias, String username);
    String getalias(String username);
    boolean setname(String new_name,String old_name);
    boolean setgender(String gender,String username);
}
