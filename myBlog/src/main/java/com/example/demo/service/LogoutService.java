package com.example.demo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LogoutService {
    void logout(HttpServletRequest request, HttpServletResponse response);
}
