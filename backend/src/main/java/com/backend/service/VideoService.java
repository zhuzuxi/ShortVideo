package com.backend.service;

import com.backend.entity.Video;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author oo
* @description 针对表【video】的数据库操作Service
* @createDate 2023-10-31 11:10:08
*/
public interface VideoService extends IService<Video> {
    public void uploadVideo(String localFilePath);

    public String getUrl(String key);

}
