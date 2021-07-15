package com.example.demo.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

public interface BlogWritingService {
    public void addblog(String blogTitle, String blogContent, String createTime, String tagName, HttpServletRequest request);
}
