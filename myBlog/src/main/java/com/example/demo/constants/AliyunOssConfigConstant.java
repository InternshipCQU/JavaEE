package com.example.demo.constants;
/**
 * @Auther: SnailClimb
 * @Date: 2018/12/4 15:09
 * @Description: 阿里云OSS存储的相关常量配置.我这里通过常量类来配置的，当然你也可以通过.properties 配置文件来配置，
 * 然后利用 SpringBoot 的@ConfigurationProperties 注解来注入
 */
public class AliyunOssConfigConstant {
    //私有构造方法 禁止该类初始化
//    private AliyunOSSConfigConstant() {
//    }

    //仓库名称
    public static final String BUCKE_NAME = "bucket-myblog";
    //地域节点
    public static final String END_POINT = "oss-cn-beijing.aliyuncs.com";
    //AccessKey ID
    public static final String AccessKey_ID = "";
    //Access Key Secret
    public static final String AccessKey_Secret = "";
    //仓库中的某个文件夹
    public static final String FILE_HOST = "blogimg";
    //仓库中的头像文件夹
    public static final String Avatar_HOST = "avatar";
    //仓库中的背景文件夹
    public static final String Background_HOST="background";

}

