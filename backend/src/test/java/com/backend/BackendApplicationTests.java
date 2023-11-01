package com.backend;

import com.backend.dto.UserDto;
import com.backend.entity.User;
import com.backend.entity.Video;
import com.backend.mapper.UserMapper;
import com.backend.mapper.VideoMapper;
import com.backend.service.UserService;
import com.backend.service.VideoService;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.DownloadUrl;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@SpringBootTest
class BackendApplicationTests {

    @Resource
    private UserMapper userMapper;
    @Test
    void contextLoads() {
//        System.out.println(userMapper.getAllUsers());
    }

//    @Resource
//    private ModelMapper modelMapper;

    @Test
    void modelMapper(){
//        for (User user : userMapper.getAllUsers()) {
//            System.out.println(modelMapper.map(user, UserDto.class));
//        }
    }

    @Test
    void getUserById(){
//        System.out.println(userMapper.getUserById(1));
    }

    @Resource
    private UserService userService;
    @Test
    void getUser(){
//        System.out.println(userService.getUserById(1));
    }


    @Test
    void testUpload(){
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region2());
        cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;// 指定分片上传版本
//...其他参数参考类注释

        UploadManager uploadManager = new UploadManager(cfg);
//...生成上传凭证，然后准备上传
        String accessKey = "w3VdBuR5aZoHP-v3NIjNJiOh0DwEq5Fh9EtQj1rM";
        String secretKey = "Aog2_0SGoZ0IXNltTpn9pPcxsl0R7oPkNW_AMQGO";
        String bucket = "xzqmsgh";
//如果是Windows情况下，格式是 D:\\qiniu\\test.png
        String localFilePath = "D:\\test_qiniu\\animal_mysql\\animal.sql";
//默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);//上传到的七牛云文件名
        } catch (QiniuException ex) {
            ex.printStackTrace();
            if (ex.response != null) {
                System.err.println(ex.response);

                try {
                    String body = ex.response.toString();
                    System.err.println(body);
                } catch (Exception ignored) {
                }
            }
        }

    }


//    @Test
//    void testDownload(){
//
//        // domain   下载 domain, eg: qiniu.com【必须】
//// useHttps 是否使用 https【必须】
//// key      下载资源在七牛云存储的 key【必须】
//        DownloadUrl url = new DownloadUrl(domain, useHttps, key);
//        url.setAttname(attname) // 配置 attname
//                .setFop(fop) // 配置 fop
//                .setStyle(style, styleSeparator, styleParam) // 配置 style
//
//// 带有效期
//        long expireInSeconds = 3600;//1小时，可以自定义链接过期时间
//        long deadline = System.currentTimeMillis()/1000 + expireInSeconds;
//        Auth auth = Auth.create("your access key", "your secret key");
//        String urlString = url.buildURL(auth, deadline);
//        System.out.println(urlString);
//
//    }

    @Test
    void testFile(){
        File file=new File("D:\\test_qiniu\\animal_mysql");
        for (File listFile : file.listFiles()) {
            System.out.println(listFile.getAbsolutePath());
        }
    }

    @Resource
    private VideoMapper videoMapper;


    @Resource
    private Auth auth;

    @Resource
    private UploadManager uploadManager;
    @Test
    public void uploadVideo() throws UnsupportedEncodingException {
        String bucket="xzqmsgh";
        String key=null;
        String upToken = auth.uploadToken(bucket);
//如果是Windows情况下，格式是 D:\\qiniu\\test.png
        String localFilePath = "D:\\qiniuyun_data\\videos";
        File file=new File(localFilePath);
        for (File listFile : file.listFiles()) {
            try {
                Response response = uploadManager.put(listFile.getAbsolutePath(), key, upToken);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                Video video = new Video();
                video.setVideoUrl(putRet.key);
                videoMapper.insert(video);

            } catch (QiniuException ex) {
                ex.printStackTrace();
                if (ex.response != null) {
                    System.err.println(ex.response);

                    try {
                        String body = ex.response.toString();
                        System.err.println(body);
                    } catch (Exception ignored) {
                    }
                }
            }
        }

    }

    @Test
    void getUrl(String key) throws UnsupportedEncodingException {
        String fileName = "FpLhreYOpPbFyL_j1Pk0H8ZMT4Mq";//上传视频之后会返回文件名（key）
        String domainOfBucket = "http://s3c51zvtx.hn-bkt.clouddn.com"; //测试外链
        String encodedFileName = URLEncoder.encode(fileName, "utf-8").replace("+", "%20");
        String publicUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
        String accessKey = "w3VdBuR5aZoHP-v3NIjNJiOh0DwEq5Fh9EtQj1rM";//对象空间ak
        String secretKey = "Aog2_0SGoZ0IXNltTpn9pPcxsl0R7oPkNW_AMQGO";//对象空间sk
        Auth auth = Auth.create(accessKey, secretKey);
        long expireInSeconds = 3600;//1小时，可以自定义链接过期时间
        String finalUrl = auth.privateDownloadUrl(publicUrl, expireInSeconds);
        System.out.println(finalUrl);
    }

    @Resource
    private VideoService videoService;
    @Test
    void testupload(){
        String localFilePath = "D:\\qiniuyun_data\\videos";
        videoService.uploadVideo(localFilePath);
    }


    @Test
    void testAuth(){
        System.out.println(auth);
    }


}
