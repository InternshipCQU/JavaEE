package com.example.demo.controller;
import com.example.demo.entity.User;
import com.example.demo.service.*;
import com.example.demo.utils.UploadAvatarUtil;
import net.sf.json.JSON;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;


@Controller
public class InfoController {
    @Autowired
    private setService setss;
    private getService getss;

    @RequestMapping("/timeline")
    public String to(){return "timeline";}


    @RequestMapping(value="/upload")
    public String testUpload(@RequestParam("file")MultipartFile file,@RequestParam("userId") String userId, Model model){
        UploadAvatarUtil aliyunOssUtil=new UploadAvatarUtil();
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
                    String url = aliyunOssUtil.upLoad(newFile,userId);
                    System.out.println(url);
                    model.addAttribute("url",url );
                    System.out.println("UPLOAD SUCCESSFULLY");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "timeline";
    }

    @RequestMapping("/success")
    public String to_2(){
        return "timeline";
    }
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
    }//根据session中的userId去数据库查询对应的属性值，生成json格式
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

    @RequestMapping(value="/getfollow",method=RequestMethod.POST)
    public void getfollowusrlist(@RequestBody String userId, HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, JSONException{

        JSONObject object=new JSONObject();
        //TODO:查询关注列表
        object.put("NUM",2);
        for(int i=1;i<=3;i++)
        {
//            System.out.println(i);
            object.put("FOLLOW"+Integer.toString(i),"USER "+Integer.toString(i));
            object.put("LINK"+Integer.toString(i),"#");
        }
        object.put("FOLLOW4","");
        object.put("LINK4","");
        response.getWriter().write(object.toString());
    }

    @RequestMapping(value="/getfavorites",method=RequestMethod.POST)
    public void getfavoriteslist(@RequestBody String userId, HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, JSONException{
        JSONObject object=new JSONObject();
        //TODO:查询喜欢列表
        object.put("NUM",2);
        for(int i=1;i<=3;i++)
        {
//            System.out.println(i);
            object.put("LIKES"+Integer.toString(i),"BLOG "+Integer.toString(i));
            object.put("LINK"+Integer.toString(i),"#");
        }
        object.put("LIKES4","");
        object.put("LINK4","");
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

    public User getuser(@RequestParam("userID") int userID)
    {
        User getuser=getss.getuserprofile(userID);
        return getuser;
    }

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
