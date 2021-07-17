package com.example.demo.service.impl;


import com.example.demo.entity.User;
import com.example.demo.mapper.userinfoallMapper;
import com.example.demo.service.userinfoallService;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;
import com.example.demo.mapper.userinfoallMapper;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service("userinfoallService")
public class userinfoallServiceImpl implements userinfoallService {

    @Resource
    userinfoallMapper userinfoallMapper;

    @Override
    public void Init(HttpServletRequest request){
        HttpSession session = request.getSession();
        int userId=-1;
        if(session.getAttribute("userID")==null){
            System.out.println("没有登录，请登录");
        }
        else{
            userId=(Integer) session.getAttribute("userID");
        }

        List<User> userfollow=userinfoallMapper.getallfollow(userId);

        System.out.println(userfollow);
        session.setAttribute("followings",userfollow);
        session.setAttribute("followcount",0);
        session.setAttribute("followsize",userfollow.size());

    }

    @Override
    public String getallfollow(HttpServletRequest request){
        HttpSession session=request.getSession();
        int followcount=(Integer) session.getAttribute("followcount");
        int followsize=(Integer) session.getAttribute("followsize");
        ArrayList<User> followuser=(ArrayList<User>) session.getAttribute("followings");
        if(followsize==0||followcount==followsize)
        {
            return "{\"noMore\":\"true\"}";
        }

        int followings_userId=followuser.get(followcount).getUserId();
        String followings_username=followuser.get(followcount).getUsername();
        String followings_avatar=followuser.get(followcount).getAvatar();

        //生成json

        session.setAttribute("followcount",followcount+1);

        return "{\"userId\":\""+followings_userId+"\",\"username\":\""+followings_username+"\",\"avatar\":\""+followings_avatar+"\"}";


    }


}
