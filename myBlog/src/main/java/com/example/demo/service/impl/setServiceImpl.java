package com.example.demo.service.impl;

import com.example.demo.mapper.profileMapper;
import com.example.demo.service.setService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.Arrays;
import java.util.List;

@Service("setService")
public class setServiceImpl implements setService {
    @Autowired
    private profileMapper profileMapper;
    @Override
    public boolean setalias(String new_alias, String username){
        if (StringUtils.isEmpty(new_alias))
        {
            return false;
        }
        else{
            profileMapper.setalias(username,new_alias);
            return true;
        }
    }
   @Override
    public String getalias(String username){
        String alias=profileMapper.getalias(username);
        return alias;
   }

   @Override
    public boolean setname(String newname,String oldname){
        if (StringUtils.isEmpty(newname))
            return false;
        else {
            profileMapper.setname(newname, oldname);
            return true;
        }
   }

   @Override
    public boolean setgender(String gender,String username){
        String[] strArr=new String[]{"M","W"};//M->Men, W->Women
       List<String> testgender= Arrays.asList(strArr);
        if(!testgender.contains(gender))
        {
            return false;
        }
        else {
            profileMapper.setgender(gender,username);
            return true;
        }
   }

}
