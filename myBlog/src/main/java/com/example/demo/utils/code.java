package com.example.demo.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class code {
    public static String encode(String password) throws NoSuchAlgorithmException {//在这里利用SHA加密算法 我们在数据库存储的时候存储加密之后的密码
        MessageDigest md = MessageDigest.getInstance("SHA");
        md.update(password.getBytes());
        return new String(md.digest().toString());
    }

}
