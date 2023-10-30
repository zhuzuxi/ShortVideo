package com.backend.service;

import com.backend.dto.UserDto;
import com.backend.entity.Result;
import com.backend.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author oo
* @description 针对表【user】的数据库操作Service
* @createDate 2023-10-29 11:53:21
*/
public interface UserService extends IService<User> {

    public Result<List<User>> getAllUsers();

    public Result<UserDto> getUserById(Integer id);
}
