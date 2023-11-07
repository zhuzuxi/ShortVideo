package com.backend.mapper;

import com.backend.entity.Video;
import com.backend.vo.MyWorksVO;
import com.backend.vo.VideoVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author oo
* @description 针对表【video】的数据库操作Mapper
* @createDate 2023-10-31 11:10:08
* @Entity com.backend.entity.Video
*/
//@Mapper
public interface VideoMapper extends BaseMapper<Video> {

    @Select("select * from video")
    public List<Video> selectAllVideo();

    /**
     * 根据作者Id查询用户作品
     * @param authorId
     * @return
     */
    @Select("select id, video_url, cover from video where author_id = #{authorId}")
    public List<MyWorksVO> selectMyWorksVOByAuthorId(Long authorId);

    /**
     * 多个视频Id查询视频列表
     * @param videoIds
     * @return
     */
    List<VideoVO> selectVideosByIds(@Param("videoIds") List<Long> videoIds);

}




