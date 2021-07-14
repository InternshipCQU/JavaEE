package com.example.demo.controller;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.ImagingOpException;
import java.io.IOException;

@Controller
public class BlogListController {
    @Resource
    private

    @RequestMapping("bloglist")
    public String bloglist(){
        return "bloglist";
    }

    @RequestMapping(value="/deletemyblog",method = RequestMethod.POST)
    public void deletemyblog(@RequestBody Integer userId, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, JSONException
    {

    }
}
