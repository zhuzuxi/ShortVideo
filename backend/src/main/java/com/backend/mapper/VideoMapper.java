package com.backend.mapper;

import com.backend.entity.Video;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
* @author oo
* @description 针对表【video】的数据库操作Mapper
* @createDate 2023-10-31 11:10:08
* @Entity com.backend.entity.Video
*/
@Mapper
public interface VideoMapper extends BaseMapper<Video> {


}




