package com.example.demo.service.impl;

import com.example.demo.mapper.setaliasMapper;
import com.example.demo.mapper.getaliasMapper;
import com.example.demo.mapper.setnameMapper;
import com.example.demo.mapper.setgenderMapper;
import com.example.demo.service.setService;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service("setService")
public class setServiceImpl implements setService {
    @Resource
    private setaliasMapper setaliasMapper;
    private getaliasMapper getaliasMapper;
    private setnameMapper setnameMapper;
    private setgenderMapper setgenderMapper;
    @Override
    public boolean setalias(String new_alias, String username){
        if (StringUtils.isEmpty(new_alias))
        {
            return false;
        }
        else{
            setaliasMapper.setalias(username,new_alias);
            return true;
        }
    }
   @Override
    public String getalias(String username){
        String alias=getaliasMapper.getalias(username);
        return alias;
   }

   @Override
    public boolean setname(String newname,String oldname){
        if (StringUtils.isEmpty(newname))
            return false;
        else {
            setnameMapper.setname(newname, oldname);
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
            setgenderMapper.setgender(gender,username);
            return true;
        }
   }

}
