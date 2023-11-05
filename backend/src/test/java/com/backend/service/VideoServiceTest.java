package com.backend.service;

import com.backend.dto.VideoUserDto;
import com.backend.entity.Video;
import com.backend.mapper.UserMapper;
import com.backend.mapper.VideoMapper;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@SpringBootTest
public class VideoServiceTest {

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
        String localFilePath = "D:\\qiniuyun_data\\videos";//这里输入
        videoService.uploadVideo(localFilePath);}


    @Resource
    private VideoMapper videoMapper;


    @Test
    void testcommend(){
        for (VideoUserDto videoUserDto : videoService.recommendVideos(1).getData()) {
            System.out.println(videoUserDto);
        }
    }

    @Resource(name = "myAuth")
    private Auth auth;
    @Test
    void uploadtoken(){
        String upToken = auth.uploadToken("xzqmsgh");
        System.out.println(upToken);
    }

}
