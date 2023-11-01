package com.backend.mapper;

import com.backend.entity.UserFollows;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author oo
* @description 针对表【user_follows】的数据库操作Mapper
* @createDate 2023-10-31 11:10:05
* @Entity com.backend.entity.UserFollows
*/
@Mapper
public interface UserFollowsMapper extends BaseMapper<UserFollows> {

}




