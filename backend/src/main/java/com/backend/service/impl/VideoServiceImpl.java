package com.backend.service.impl;

import com.backend.entity.Video;
import com.backend.service.VideoService;
import com.backend.mapper.VideoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* @author oo
* @description 针对表【video】的数据库操作Service实现
* @createDate 2023-10-29 10:56:52
*/
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video>
implements VideoService{

}
