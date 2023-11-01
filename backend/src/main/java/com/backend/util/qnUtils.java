package com.backend.util;

import com.backend.entity.Video;
import com.backend.mapper.VideoMapper;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.DownloadUrl;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class qnUtils {

    public static String getUrl(String key){
        String fileName = "FpLhreYOpPbFyL_j1Pk0H8ZMT4Mq";//上传视频之后会返回文件名（key）
        String domainOfBucket = "http://s3c51zvtx.hn-bkt.clouddn.com"; //测试外链
        String encodedFileName = null;
        try {
            encodedFileName = URLEncoder.encode(fileName, "utf-8").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String publicUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
        String accessKey = "w3VdBuR5aZoHP-v3NIjNJiOh0DwEq5Fh9EtQj1rM";//对象空间ak
        String secretKey = "Aog2_0SGoZ0IXNltTpn9pPcxsl0R7oPkNW_AMQGO";//对象空间sk
        Auth auth = Auth.create(accessKey, secretKey);
        long expireInSeconds = 3600;//1小时，可以自定义链接过期时间
        String finalUrl = auth.privateDownloadUrl(publicUrl, expireInSeconds);
        return finalUrl;
    }



}
