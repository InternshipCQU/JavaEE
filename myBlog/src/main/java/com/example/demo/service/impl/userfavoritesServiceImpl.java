package com.example.demo.service.impl;

import com.example.demo.entity.BlogInfo;
import com.example.demo.entity.User;
import com.example.demo.mapper.userinfoallMapper;
import com.example.demo.service.getService;
import com.example.demo.service.userfavoritesService;
import com.example.demo.service.userinfoallService;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service("userfavoritesService")
public class userfavoritesServiceImpl implements userfavoritesService {
    @Resource
    userinfoallMapper userinfoallMapper;

    @Resource
    getService getService;

    @Override
    public void Init(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        int userId=-1;
        if(session.getAttribute("userID")==null){
            System.out.println("没有登录，请登录");
        }
        else{
            userId=(Integer) session.getAttribute("userID");
        }


        List<BlogInfo> userfavorites=userinfoallMapper.getallfavorites(userId);

        System.out.println(userfavorites);
        session.setAttribute("favoriteslist",userfavorites);
        session.setAttribute("favoritescount",0);
        session.setAttribute("favoritessize",userfavorites.size());

    }

    @Override
    public String getallfavorites(HttpServletRequest request){
        HttpSession session=request.getSession();
        int favoritescount=(Integer) session.getAttribute("favoritescount");
        int favoritessize=(Integer) session.getAttribute("favoritessize");
        ArrayList<BlogInfo> favoriteslist=(ArrayList<BlogInfo>) session.getAttribute("favoriteslist");

        if(favoritessize==0||favoritescount==favoritessize)
        {
            return "{\"noMore\":\"true\"}";
        }

        String blogname=favoriteslist.get(favoritescount).getBlogTitle();
        int blogid=favoriteslist.get(favoritescount).getBlogId();
        int bloggeruserid=favoriteslist.get(favoritescount).getUserId();
        String bloggername=getService.getusername(bloggeruserid);

        session.setAttribute("favoritescount",favoritescount+1);
        System.out.println("OUTPUT FAVORITES:"+"{\"blogname\":\""+blogname+"\",\"blogid\":\""+blogid+"\",\"username\":\""+bloggername+"\"}");

        return "{\"blogname\":\""+blogname+"\",\"blogid\":\""+blogid+"\",\"bloggername\":\""+bloggername+"\"}";

    }
}
