package com.example.demo.controller;
import com.example.demo.entity.User;
import com.example.demo.service.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


@Controller
public class InfoController {
    @Autowired
    private setService setss;
    private getService getss;

    @RequestMapping("/timeline")
    public String to(){return "timeline";}

    @RequestMapping(value="/getusersess",method= RequestMethod.GET)
    public void setusersession(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException, JSONException {
//        String userId=String.valueOf(session.getAttribute("userId"));
//        User userobj=getss.getuserprofile(Integer.parseInt(userId));
//        String username=userobj.getUsername();
//        String userprofile=userobj.getProfile();
        JSONObject object=new JSONObject();
        object.put("userId","1890053");
        object.put("username","John Hanson");
        object.put("userprofile","Nothing is impossible.");
        object.put("email","example@net.com");
        object.put("radioval","1");
        object.put("lastname","Nathaniel");
        object.put("firstname","Joseph");
        object.put("area","United States");
        object.put("telephone","13012345678");
        object.put("lastlogin","2021-07-10");
        object.put("userRefisiterTime","2021-03-05");
        object.put("likesNum","803");
        object.put("blogsNum","27");
        object.put("fansNum","102");
        object.put("birthdate","2008-03-05");
        response.getWriter().write(object.toString());
    }//根据session中的userId去数据库查询对应的username，返回username显示在页面前端
    //JSON仅供测试，记得删除

    @RequestMapping(value="/changecontent" ,method=RequestMethod.GET)
    public void changestat(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, JSONException {
        JSONObject object=new JSONObject();
        object.put("flag","true");
        response.getWriter().write(object.toString());
    }

    @RequestMapping(value="/submitinfo",method=RequestMethod.POST)
    public ResponseEntity submitdata(@RequestBody User user,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException,JSONException{
        //获得的数据都存在user这个实体中的(除了password,这个需要访问数据库，前端得不到）
        //将密码更新到user里面
//        String ps=getss.getuserprofile(user.userId).password;
//        user.setPassword(ps);
//        setss.setuser(user);//通过setuser，将新数据存到数据库

        return new ResponseEntity("Register OK", HttpStatus.OK);
    }


    @GetMapping("/infocenter")
    public String setuser(@RequestParam("username") String username, @RequestParam("gender") String gender,
                          @RequestParam("password") String password, @RequestParam("userID") Integer userID,
                          @RequestParam("email") String email, @RequestParam("telephone") String telephone,
                          @RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
                          @RequestParam("avatar") String avatar, @RequestParam("lastlogin")String lastlogin,
                          @RequestParam("fansnum") Integer fansnum, @RequestParam("likesnum")Integer likesnum,
                          @RequestParam("blogsnum") Integer blogsnum, @RequestParam("userregtime") String userregtime,
                          @RequestParam("birthdate") String birthdate, @RequestParam("introduce")String introduce,
                          @RequestParam("area") String area, Model model, HttpServletRequest request)
    {
        User newuser=new User();

        newuser.setUserID(userID);
        newuser.setUsername(username);
        newuser.setPassword(password);
        newuser.setGender(gender);
        newuser.setEmail(email);
        newuser.setTelephone(telephone);
        newuser.setFirstname(firstname);
        newuser.setLastname(lastname);
        newuser.setAvatar(avatar);
        newuser.setLastLogin(lastlogin);
        newuser.setFansNum(fansnum);
        newuser.setLikesNum(likesnum);
        newuser.setBlogsNum(blogsnum);
        newuser.setUserRefisiterTime(userregtime);
        newuser.setBirthdate(birthdate);
        newuser.setProfile(introduce);
        newuser.setArea(area);

        setss.setuser(newuser);
        model.addAttribute(newuser);
        boolean submitstatue=setss.checksetinfo(newuser);
        if (submitstatue) return "Set user profile succeed.";
        else return "Set user profile failed.";
    }

    public User getuser(@RequestParam("userID") int userID)
    {
        User getuser=getss.getuserprofile(userID);
        return getuser;
    }





}
