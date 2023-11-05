package com.backend.mapper;

import com.backend.entity.Likes;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author oo
* @description 针对表【like】的数据库操作Mapper
* @createDate 2023-10-31 11:09:46
* @Entity com.backend.entity.Like
*/
@Mapper
public interface LikesMapper extends BaseMapper<Likes> {

    /*获取用户收藏的所有视频id*/
    @Select("select video_id from likes where user_id = #{userId}")
    public List<Long> getLikeVideoIdsByUserId(Long UserId);
}




