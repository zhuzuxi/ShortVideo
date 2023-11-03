package com.backend.service;

import com.backend.entity.VideoCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author oo
* @description 针对表【video_category】的数据库操作Service
* @createDate 2023-10-31 11:10:11
*/
public interface VideoCategoryService extends IService<VideoCategory> {
    List<VideoCategory> getAll();
}
