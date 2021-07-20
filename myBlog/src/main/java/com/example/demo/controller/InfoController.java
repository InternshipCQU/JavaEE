package com.example.demo.controller;
import com.aliyun.oss.OSSClient;
import com.example.demo.entity.User;
import com.example.demo.entity.UserLike;

import com.example.demo.service.*;
import com.example.demo.utils.UploadAvatarUtil;
import com.example.demo.utils.UploadBackgroundUtil;
//import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Controller
public class InfoController {
    @Resource
    private setService setss;
    private getService getss;

    @Resource
    HomeService homeService;

    public InfoController(getService getss,setService setss) {
        this.getss = getss;
        this.setss= setss;
    }

    @RequestMapping("/userinfo")
    public String to(HttpServletRequest request, Model model)
    {
        homeService.setBlogger(request, model);
        return "userinfo";
    }


    @RequestMapping(value="/upload")
    public String testUpload(@RequestParam("file")MultipartFile file,@RequestParam("userId") String userId, Model model){
        UploadAvatarUtil UploadAvatarUtil=new UploadAvatarUtil();
        String filename = file.getOriginalFilename();

        try {
            if(file != null){
                if(!"".equals(filename.trim())){
                    File newFile = new File(filename);
                    FileOutputStream outputStream = new FileOutputStream(newFile);
                    outputStream.write(file.getBytes());
                    outputStream.close();
                    file.transferTo(newFile);
                    //返回图片的URL
                    String url = UploadAvatarUtil.upLoad(newFile,userId);
                    System.out.println(url);
                    model.addAttribute("url",url );
                    setss.setavatar(url,Integer.valueOf(userId));
                    System.out.println("UPLOAD SUCCESSFULLY");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/userinfo";
    }

    @RequestMapping("/success")
    public String to_2(){
        return "userinfo";
    }

    @RequestMapping(value="/getusersess",method= RequestMethod.GET)
    public void setusersession( HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException, JSONException {

        OSSClient ossClient = new OSSClient("oss-cn-beijing.aliyuncs.com","LTAI5t8boD5MgHBWXNNMJGmm","8f7SV8lmL4B9hdQbbMqzXCWUxf9BXR");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Integer userId= (Integer) request.getSession().getAttribute("userID");
        System.out.println(userId);
        User userobj=getss.getuserprofile(userId);

        String username=userobj.getUsername();
        String userprofile=userobj.getProfile();
        String email=userobj.getEmail();
        String gender;
        if(userobj.getGender()==null)
        {
            gender="未设置";
        }
        else if(userobj.getGender().equals("M"))
        {
            gender="1";
        }
        else{
            gender="0";
        }
        String background=userobj.getBackground();
        String lastname=userobj.getLastname();
        String firstname=userobj.getFirstname();
        String area=userobj.getArea();
        String telephone=userobj.getTelephone();
        String lastLogin=userobj.getLastLogin();
        String userrefisitertime=userobj.getUserRefisiterTime();
        Integer likesnum=userobj.getLikesNum();
        Integer blogsnum=userobj.getBlogsNum();
        Integer fansnum=userobj.getFansNum();
        String birthdate;
        if(userobj.getBirthdate()==null)
        {
            birthdate="undefined";
        }
        else{
            birthdate=userobj.getBirthdate();
        }
//        String birthdate=userobj.getBirthdate();
        String avatar=userobj.getAvatar();
        JSONObject object=new JSONObject();
        object.put("userId",userId);
        object.put("username",username);
        object.put("userprofile",userprofile);
        object.put("email",email);
        object.put("radioval",gender);
        object.put("lastname",lastname);
        object.put("firstname",firstname);
        object.put("area",area);
        object.put("telephone",telephone);
        object.put("lastlogin",lastLogin);
        object.put("userRefisiterTime",userrefisitertime);
        object.put("likesNum",Integer.toString(likesnum));
        object.put("blogsNum",Integer.toString(blogsnum));
        object.put("fansNum",Integer.toString(fansnum));
        object.put("birthdate",birthdate);
        object.put("avatar",avatar);
        object.put("background",background);
        response.getWriter().write(object.toString());
    }

    @RequestMapping(value="/changecontent" ,method=RequestMethod.GET)
    public void changestat(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, JSONException {
        JSONObject object=new JSONObject();
        object.put("flag","true");
        response.getWriter().write(object.toString());
    }

    @RequestMapping(value="/changebackground")
    public String testUpload_2(@RequestParam("file_2")MultipartFile file,@RequestParam("userId") String userId, HttpServletRequest request,HttpServletResponse response,HttpSession session ,Model model) throws IOException, JSONException{
        UploadBackgroundUtil UploadBackgroundUtil=new UploadBackgroundUtil();
        String filename = file.getOriginalFilename();
        System.out.println("IM COMING IN CHANGEBACKGROUND");
        try {
            if(file != null){
                if(!"".equals(filename.trim())){
                    File newFile = new File(filename);
                    FileOutputStream outputStream = new FileOutputStream(newFile);
                    outputStream.write(file.getBytes());
                    outputStream.close();
                    file.transferTo(newFile);
                    //返回图片的URL
                    String url = UploadBackgroundUtil.upLoad(newFile,userId);
                    System.out.println(url);
                    model.addAttribute("url",url );
                    setss.setbackground(url,Integer.valueOf(userId));
                    System.out.println("UPLOAD SUCCESSFULLY");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/userinfo";
    }
    @RequestMapping(value="/submitinfo",method=RequestMethod.POST)
    public ResponseEntity submitdata(@RequestBody User user,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException,JSONException{
        String ps=getss.getuserprofile(user.userId).getPassword();
        user.setPassword(ps);
        setss.setuser(user);//通过setuser，将新数据存到数据库

        return new ResponseEntity("Register OK", HttpStatus.OK);
    }

    @RequestMapping(value="/getintroduction",method = RequestMethod.GET)
    public void getintroduction(@RequestParam("userId") String userId,HttpServletRequest request,HttpServletResponse response)throws  IOException,JSONException{
        System.out.println("GET USERID="+userId);
        JSONObject object=new JSONObject();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String introres=getss.getintroduction(Integer.valueOf(userId));
        object.put("rec",introres);
        response.getWriter().write(object.toString());

    }

    @RequestMapping(value="/getfollow",method=RequestMethod.POST)
    public void getfollowusrlist(@RequestBody String userId, HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, JSONException{
        JSONObject object=new JSONObject();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        List<UserLike> listuserlike=getss.getfollowing(Integer.valueOf(userId));
        object.put("NUM",2);
//        object.put("FOLLOW1","ABC");
        int size=listuserlike.size();
        List<String> list=new ArrayList<String>();
        for(UserLike s: listuserlike)
        {
            list.add(Integer.toString(s.getUserId()));
        }
//        System.out.println(list);
        List<String> usernamelist=new ArrayList<String>();
        List<Integer> useridlist=new ArrayList<Integer>();
        for(String s:list)
        {
            usernamelist.add(getss.getusername(Integer.valueOf(s)));
            useridlist.add(Integer.valueOf(s));
        }
//        System.out.println(usernamelist);
        for(int i=1;i<=usernamelist.size();i++)
        {
            object.put("FOLLOW"+i,usernamelist.get(i-1));
            object.put("LINK"+i,"/personalspaceguest/"+useridlist.get(i-1));
        }
        response.getWriter().write(object.toString());
    }

    @RequestMapping(value="/getfavorites",method=RequestMethod.POST)
    public void getfavoriteslist(@RequestBody String userId, HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, JSONException{
        JSONObject object=new JSONObject();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        List<String> listfavorites=getss.getcollect(Integer.valueOf(userId));
        object.put("NUM",2);
        int size=listfavorites.size();
        List<String> list=new ArrayList<String>();
        for(String s: listfavorites)
        {
            list.add(s);
        }
//        System.out.println(list);
        for(int i=1;i<=list.size();i++)
        {

            object.put("LIKES"+i,list.get(i-1));
            object.put("LINK"+i,"#");
        }
        response.getWriter().write(object.toString());
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

//    public User getuser(@RequestParam("userID") String userID)
//    {
//        User getuser=getss.getuserprofile(userID);
//        return getuser;
//    }

//    @RequestMapping("/uploadavatar")
//    public String uploadavatar(@RequestParam("file")MultipartFile file,Model model){
//        String filename=file.getOriginalFilename();
//        try{
//            if(file!=null){
//                if(!"".equals(filename.trim())){
//                    File newfile=new File(filename);
//                    FileOutputStream opStream=new FileOutputStream(newfile);
//                    opStream.write(file.getBytes());
//                    opStream.close();
//                    file.transferTo(newfile);
//                    String url= UploadAvatarUtil.upLoad(newfile);
//                    model.addAttribute("url",url);
//                }
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "success";
//    }

    @RequestMapping(value = "/imgUpload")
    @ResponseBody
    public synchronized String imgUpload(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException {
        String tishi="no";
        System.out.println("arrive here");
        if(!file.isEmpty()) {
            //System.out.println(file.getOriginalFilename());
            String message = System.currentTimeMillis() + file.getOriginalFilename();//现在的文件名是时间戳加原文件名，出现图片相同时，读取不出来的bug
            String realPath = request.getSession().getServletContext().getRealPath("/upload/");//将文件保存在当前工程下的一个upload文件
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath, message));//将文件的输入流输出到一个新的文件
            message="upload/"+message;
            HttpSession session=request.getSession();
            Integer id=(Integer)session.getAttribute("userid");//在session中获得用户id
//            User user=userService.get(id);//在dao层保存数据，也就是图片的地址
//            user.setPhoto(message);
//            userService.update(user);
            System.out.println(id);
            tishi="yes";//返回yes,表示存储成功，可以使用try,catch来捕捉错误，这里偷懒不用
        }
        return tishi;
    }


}
