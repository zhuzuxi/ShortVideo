package com.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.backend.entity.VideoCategory;
import com.backend.service.VideoCategoryService;
import com.backend.mapper.VideoCategoryMapper;
import org.springframework.stereotype.Service;

/**
* @author oo
* @description 针对表【video_category】的数据库操作Service实现
* @createDate 2023-10-31 11:10:11
*/
@Service
public class VideoCategoryServiceImpl extends ServiceImpl<VideoCategoryMapper, VideoCategory>
    implements VideoCategoryService{

}




