package com.example.demo.service.impl;

import com.example.demo.entity.user;
import com.example.demo.mapper.setaliasMapper;
import com.example.demo.mapper.getaliasMapper;
import com.example.demo.mapper.setnameMapper;
import com.example.demo.service.setService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

@Service("setService")
public class setServiceImpl implements setService {
    @Autowired
    private setaliasMapper setaliasMapper;
    private getaliasMapper getaliasMapper;
    private setnameMapper setnameMapper;
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

}
