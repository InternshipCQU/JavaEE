package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.entity.ResponseResult;
import com.example.demo.utils.AliyunOssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
@RequestMapping("/oss")
public class AliyunOssController {
    private final Logger logger = LoggerFactory.getLogger(AliyunOssController.class);

    @Autowired
    private AliyunOssUtil aliyunOssUtil;

    @RequestMapping("/upload")
    @ResponseBody
    public ResponseResult testUpload(@RequestParam("editormd-image-file")MultipartFile file, Model model){
        logger.info("文件上传");
        ResponseResult responseResult = new ResponseResult();
        String filename = file.getOriginalFilename();
        System.out.println(filename);
        try {
            if(file != null){
                if(!"".equals(filename.trim())){
                    File newFile = new File(filename);
                    FileOutputStream outputStream = new FileOutputStream(newFile);
                    outputStream.write(file.getBytes());
                    outputStream.close();
                    file.transferTo(newFile);
                    String url = aliyunOssUtil.upLoad(newFile);
                    responseResult.setSuccess(1);
                    responseResult.setUrl(url);
                    responseResult.setMessage("上传成功");
                }
            }
        } catch (FileNotFoundException e) {
            responseResult.setSuccess(0);
            responseResult.setMessage("上传失败");
            e.printStackTrace();
        } catch (IOException e) {
            responseResult.setSuccess(0);
            responseResult.setMessage("上传失败");
            e.printStackTrace();
        }
        return responseResult;
    }


//    public String testUpload(@RequestParam("file") MultipartFile file, Model model){
//        String filename = file.getOriginalFilename();
//        System.out.println(filename);
//        try {
//            if(file != null){
//                if(!"".equals(filename.trim())){
//                    File newFile = new File(filename);
//                    FileOutputStream outputStream = new FileOutputStream(newFile);
//                    outputStream.write(file.getBytes());
//                    outputStream.close();
//                    file.transferTo(newFile);
//                    //返回图片的URL
//                    String url = aliyunOssUtil.upLoad(newFile);
//                    model.addAttribute("url",url );
//                }
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "success";
//    }
}

