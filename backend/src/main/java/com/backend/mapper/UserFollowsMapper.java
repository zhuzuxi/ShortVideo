package com.backend.mapper;

import com.backend.entity.UserFollows;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
* @author oo
* @description 针对表【user_follows】的数据库操作Mapper
* @createDate 2023-10-31 11:10:05
* @Entity com.backend.entity.UserFollows
*/
@Mapper
public interface UserFollowsMapper extends BaseMapper<UserFollows> {
    /**
     * 更新用户间关注状态
     */
    @Update("update user_follows set follow_status = #{followStatus} where user_id = #{userId} and follow_id = #{followId}")
    int updateFollowStatus(Long userId, Long followId, Integer followStatus);

    /**
     * 删除一条关注记录
     */
    @Delete("delete from user_follows where user_id = #{userId} and follow_id = #{followId}")
    int deleteFollows(Long userId, Long followId);
}




