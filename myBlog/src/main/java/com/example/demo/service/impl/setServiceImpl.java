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
    public boolean setalias(String new_alias, int userID){
        if (StringUtils.isEmpty(new_alias))
        {
            return false;
        }
        else{
            profileMapper.setalias(userID,new_alias);
            return true;
        }
    }

   @Override
    public boolean setname(String newname,String oldname,int userID){
        if (StringUtils.isEmpty(newname))
            return false;
        else {
            profileMapper.setname(newname, oldname,userID);
            return true;
        }
   }

   @Override
    public boolean setgender(String gender,int userID){
        String[] strArr=new String[]{"M","W"};//M->Men, W->Women
       List<String> testgender= Arrays.asList(strArr);
        if(!testgender.contains(gender))
        {
            return false;
        }
        else {
            profileMapper.setgender(gender,userID);
            return true;
        }
   }

   @Override
    public boolean setprofile(String profiledata,int userID){
        if(StringUtils.isEmpty(profiledata)){
            return false;
        }
        else{
            profileMapper.setprofile(profiledata,userID);
            return true;
        }
   }

   /*TODO:The contributor need to reconsider the format of the region.*/
   @Override
    public boolean setregion(String region,int userID){
       String[] regionarr=new String[]{"HK","CN","US","UK"};//FORMAT OF REGION HERE
       List<String> regionlist= Arrays.asList(regionarr);
       if(!regionlist.contains(region))
       {
           return false;
       }
       else{
           profileMapper.setregion(region,userID);
           return true;
       }
   }
}
