package com.backend.service.impl;

import com.backend.service.VideoCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.backend.entity.Video;
import com.backend.service.VideoService;
import com.backend.mapper.VideoMapper;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
* @author oo
* @description 针对表【video】的数据库操作Service实现
* @createDate 2023-10-31 11:10:08
*/
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video>
    implements VideoService{

    @Value("${qiniu.domainOfBucket}")
    private String domainOfBucket;

    @Resource
    private Auth auth;//七牛云空间对象认证

    @Resource
    private UploadManager uploadManager;

    @Resource
    private VideoMapper videoMapper;

    String localFilePath = "D:\\qiniuyun_data\\videos";

    @Override
    //D:\qiniuyun_data\videos 该路径下直接是视频了 你可以优化一下 做个递归获取这个路径下所有视频文件
    public void uploadVideo(String localFilePath) {
        String bucket="xzqmsgh";
        String key=null;
        String upToken = auth.uploadToken(bucket);
//如果是Windows情况下，格式是 D:\\qiniu\\test.png
        File file=new File(localFilePath);
        for (File listFile : file.listFiles()) {
            try {
                Response response = uploadManager.put(listFile.getAbsolutePath(), key, upToken);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                Video video = new Video();
                video.setVideoUrl(getUrl(putRet.key));
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

    @Override
//    这个是做资源链接拼接
    public String getUrl(String key) {
        String encodedFileName = null;
        try {
            encodedFileName = URLEncoder.encode(key, "utf-8").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String publicUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
        long expireInSeconds = 3600;//1小时，可以自定义链接过期时间
        String finalUrl = auth.privateDownloadUrl(publicUrl, expireInSeconds);
        return finalUrl;
    }
}




