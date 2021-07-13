package com.example.demo.utils;
public class SplitString {
    public static String[] splitId(String CodeId) {
        String[] arr = CodeId.split("/");        //此处以","作为例子，可按需变换
        return arr;
    }

}
