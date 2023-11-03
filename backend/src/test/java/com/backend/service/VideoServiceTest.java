package com.backend.service;

import com.backend.entity.Video;
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
        videoService.uploadVideo(localFilePath);
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


}
