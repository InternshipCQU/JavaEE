package com.example.demo.controller;

import com.example.demo.entity.student;
import com.example.demo.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class studentController {

    @Autowired
    private studentService studentService;

    @RequestMapping("/findAll")
    public List<student> findAll(){
        return studentService.findAll();
    }

}
