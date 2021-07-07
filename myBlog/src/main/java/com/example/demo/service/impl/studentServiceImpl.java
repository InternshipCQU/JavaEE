package com.example.demo.service.impl;

import com.example.demo.entity.student;
import com.example.demo.mapper.studentMapper;
import com.example.demo.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class studentServiceImpl implements studentService {

    @Autowired
    private studentMapper StudentMapper;

    @Override
    public List<student> findAll() {

        return StudentMapper.findAll();
    }
}