package com.backend.mapper;

import com.backend.entity.Collections;
import com.backend.entity.Likes;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CollectionsMapper extends BaseMapper<Collections> {

    /**
     * 获取用户收藏的所有视频id
     * @param userId
     * @return
     */
    @Select("select video_id from collections where user_id = #{userId}")
    List<Long> getCollectVideoIdsByUserId(Long userId);
}
