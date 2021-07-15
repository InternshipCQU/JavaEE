package com.example.demo.utils;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.example.demo.constants.AliyunOssConfigConstant;
import org.springframework.stereotype.Component;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

@Component
public class UploadAvatarUtil {
    private static String File_URL;
    private static String bucketName=AliyunOssConfigConstant.BUCKE_NAME;
    private static String endPoint= AliyunOssConfigConstant.END_POINT;
    private static String accessKeyId= AliyunOssConfigConstant.AccessKey_ID;
    private static String accessKeySecret = AliyunOssConfigConstant.AccessKey_Secret;
    private static String fileHost=AliyunOssConfigConstant.Avatar_HOST;


    public static String upLoad(File file,String userId){
        boolean isImage=true;
        try{
            Image image= ImageIO.read(file);
            isImage= image != null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(file==null){
            return null;
        }
        OSSClient ossClient=new OSSClient(endPoint,accessKeyId,accessKeySecret);
        try{
            if(!ossClient.doesBucketExist(bucketName)){
                ossClient.createBucket(bucketName);
                CreateBucketRequest createBucketRequest=new CreateBucketRequest(bucketName);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            String filename=file.getName();
            String fileUrl=fileHost+"/"+userId+filename.substring(filename.length()-4);

            if(isImage){
                File_URL="https://"+bucketName+"."+endPoint+"/"+fileUrl;
            }
            else{
                File_URL="非图片。文件路径："+fileUrl;
            }
            //上传文件
            PutObjectResult result=ossClient.putObject(new PutObjectRequest(bucketName,fileUrl,file));
            ossClient.setBucketAcl(bucketName,CannedAccessControlList.PublicRead);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if(ossClient !=null){
                ossClient.shutdown();
            }

        }
        return File_URL;
    }
}
