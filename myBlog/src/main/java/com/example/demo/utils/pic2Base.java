package com.example.demo.utils;

import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.IOException;

//这个类是将上传的图片转化成base64编码
//作用：将base64编码代替图片存储到数据库中
//在前端：<img width="160" height="160" alt="star" th:src="${pic}" /> 这句代码可以将base64转化成图片 ${pic}就是下面函数的return
public class pic2Base {
    public static String pic2base(MultipartFile image) throws IOException {
        BASE64Encoder base64Encoder =new BASE64Encoder();
        String base64EncoderImg = "data:image/png;base64,"+ base64Encoder.encode(image.getBytes());//这里是转化成base64的代码
        return base64EncoderImg;
    }
}




