package com.backend.mapper;

import com.backend.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author oo
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-10-31 11:10:01
* @Entity com.backend.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




