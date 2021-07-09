package com.example.demo.service.impl;


import com.example.demo.entity.User;
import com.example.demo.mapper.profileMapper;

import com.example.demo.service.setService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Service("setService")
public class setServiceImpl implements setService {

    @Resource
    private profileMapper profileMapper;
   @Override
    public void setuser(User user)
   {
       profileMapper.setuser(user);
   }
   @Override
    public boolean checksetinfo(User user)
   {
       String username=user.username;
       String password=user.password;
       String gender=user.gender;
       String email=user.email;
       String telephone=user.telephone;
       String firstname=user.firstname;
       String lastname=user.lastname;
       String birthdate=user.birthdate;

       if(username.isEmpty()) return false;
       else if(password.isEmpty()) return false;
       else if(!gender.equals("M") && !gender.equals("W")) return false;
       else if(email.isEmpty()) return false;
       else if(telephone.length() != 11) return false;
       else if(firstname.isEmpty()) return false;
       else if (lastname.isEmpty()) return false;

       String[] datesplit=birthdate.split("-");
       String[] tstarr={"01","03","05","07","08","10","12"};

       if(datesplit[1]=="02"){
           if(Integer.parseInt(datesplit[0]) %4==0)
           {
               if(datesplit[2]=="30"||datesplit[2]=="31"){
                   return false;
               }
           }
           else
           {
               if(datesplit[2]=="29"||datesplit[2]=="30"||datesplit[2]=="31")
               {
                   return false;
               }
           }
       }

       if(Arrays.asList(tstarr).contains(datesplit[1]))
       {
           return true;
       }
       else
       {
           if(datesplit[2]=="31") return false;
           else return true;
       }


   }
}
