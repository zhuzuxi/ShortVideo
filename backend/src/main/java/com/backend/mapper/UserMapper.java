package com.backend.mapper;

import com.backend.dto.UserDto;
import com.backend.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author oo
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-10-29 11:53:21
* @Entity com.backend.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user")
    public List<User> getAllUsers();


    @Select("select * from user where id=#{id}")
    UserDto getUserById(Integer id);
}




