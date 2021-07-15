package com.example.demo.service;

import javax.servlet.http.HttpServletRequest;

public interface BloglistService {

    void deleteblog(Integer blogId);

    void Init(HttpServletRequest request);

    String manageTheBlogs(HttpServletRequest request);

}
