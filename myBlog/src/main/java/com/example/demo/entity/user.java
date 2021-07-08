package com.example.demo.entity;
public class user {
    /*basic profile*/
    public String username;
    public String password;
    public String gender;
    public String profile;
    public String region;
    /*the value DATE OF BIRTH includes three parts named yy mm dd*/
    public int yy;
    public int mm;
    public int dd;

    /*education*/



    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username){
        this.username = username;
    }
}
