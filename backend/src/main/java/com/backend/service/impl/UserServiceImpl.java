package com.backend.service.impl;

import com.backend.dto.UserDto;
import com.backend.entity.Result;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.backend.entity.User;
import com.backend.service.UserService;
import com.backend.mapper.UserMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.annotation.Resource;
import java.beans.Beans;
import java.util.List;
import java.util.Objects;

/**
* @author oo
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-10-29 11:53:21
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Resource
    private ModelMapper modelMapper;
    @Resource
    private UserMapper userMapper;
    @Override
    public Result<List<User>> getAllUsers() {
        List<User> users = userMapper.getAllUsers();
        return new Result<List<User>>(200,"成功",users);

    }

    @Override
    public Result<UserDto> getUserById(Integer id) {
        UserDto user = userMapper.getUserById(id);
        if (!Objects.isNull(user)) {
            return Result.SUCCEED("获取用户信息成功", user);
        }else {
            return Result.ERR(500,"获取用户失败,请输入正确的用户id",null);
        }
    }
}




