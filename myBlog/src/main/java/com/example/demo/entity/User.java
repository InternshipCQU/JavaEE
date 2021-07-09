package com.example.demo.entity;

public class User {
    public String userID;//用户ID
    public String username; //用户名称
    public String password;// 用户密码
    public String gender;
    public String email;
    public String telephone;
    public String firstname;
    public String lastname;
    public String avatar;
    public String lastLogin;
    public String fansNum;
    public String likesNum;
    public String blogsNum;
    public String userRegisterTime;
    public String birthdate;
    public String profile;
    public String area;

    public void setUserID(String userID) {this.userID=userID;}
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setGender(String gender ){this.gender=gender;}
    public void setEmail(String email ){this.email=email;}
    public void setTelephone(String telephone){this.telephone=telephone;}
    public void setFirstname(String firstname){this.firstname=firstname;}
    public void setLastname(String lastname){this.lastname=lastname;}
    public void setAvatar(String avatar){this.avatar=avatar;}
    public void setLastLogin(String lastlogintime){this.lastLogin=lastlogintime;}
    public void setfansnum(String fansnum){this.fansNum=fansnum;}
    public void setlikesnum(String likesNum){this.likesNum=likesNum;}
    public void setblogsnum(String blogsNum){this.blogsNum=blogsNum;}
    public void setregtime(String regtime){this.userRegisterTime=regtime;}
    public void setBirthdate(String birthdate) {this.birthdate=birthdate;}
    public void setprofile(String profile){this.profile=profile;}
    public void setarea(String area){this.area=area;}

    public String getPassword(){return password;}
    public String getUsername(){return username;}
    public String getUserID(){return userID;}
    public String getGender(){return gender;}
    public String getEmail(){return email;}
    public String getTelephone(){return telephone;}
    public String getFirstname(){return firstname;}
    public String getLastname(){return lastname;}
    public String getAvatar(){return avatar;}
    public String getLastLogin(){return lastLogin;}
    public String getFansnum(){return fansNum;}
    public String getLikesNum(){return likesNum;}
    public String getBlogsNum(){return blogsNum;}
    public String getRegtime(){return userRegisterTime;}
    public String getBirthdate(){return birthdate;}
    public String getprofile(){return profile;}
    public String getarea(){return area;}



}
