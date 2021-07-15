package com.example.demo.service;

import javax.servlet.http.HttpServletRequest;

public interface SearchService {
    void setSearch(HttpServletRequest request,String keyword);
    String giveTheBlogToSearch(String cla, HttpServletRequest request);
}
