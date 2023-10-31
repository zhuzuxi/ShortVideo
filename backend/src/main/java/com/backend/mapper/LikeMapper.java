package com.backend.mapper;

import com.backend.entity.Like;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author oo
* @description 针对表【like】的数据库操作Mapper
* @createDate 2023-10-31 11:09:46
* @Entity com.backend.entity.Like
*/
@Mapper
public interface LikeMapper extends BaseMapper<Like> {

}




