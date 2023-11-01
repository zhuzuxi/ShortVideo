package com.backend.config;

import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class qnConfig {

    @Value("${qiniu.accessKey}")
    private String accessKey;

    @Value("${qiniu.secretKey}")
    private String secretKey;
    @Bean
    public Auth auth(){
        return Auth.create(accessKey,secretKey);
    }

    @Bean
    public UploadManager uploadManager(){
        //构造一个带指定 Region 对象的配置类
        com.qiniu.storage.Configuration cfg = new com.qiniu.storage.Configuration(Region.region2());
        cfg.resumableUploadAPIVersion = com.qiniu.storage.Configuration.ResumableUploadAPIVersion.V2;// 指定分片上传版本
//...其他参数参考类注释

        UploadManager uploadManager = new UploadManager(cfg);
        return uploadManager;
    }


}
