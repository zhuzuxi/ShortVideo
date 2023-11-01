package com.backend.mapper;

import com.backend.entity.VideoCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author oo
* @description 针对表【video_category】的数据库操作Mapper
* @createDate 2023-10-31 11:10:11
* @Entity com.backend.entity.VideoCategory
*/
@Mapper
public interface VideoCategoryMapper extends BaseMapper<VideoCategory> {

}




