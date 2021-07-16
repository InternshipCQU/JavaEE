package com.example.demo.service;


import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

public interface PersonalSpaceGuestService {
    void PersonalSpaceGuestInit(String userID, Model model, HttpServletRequest request);
    String giveTheBlogToPersonal(HttpServletRequest request);
}
