package com.example.demo.utils;
public class SplitString {
    public static String[] splitId(String CodeId) {
        String[] arr = CodeId.split("/");        //此处以","作为例子，可按需变换
        return arr;
    }

    public static String getComment(String s,char c){
        for(int i = 0;i<=s.length();i++){
            if(s.charAt(i) == c){
                s = s.substring(0,i) + s.substring(i+1);
            }
            i--;
        }
        return s;
    }

}
