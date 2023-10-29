package com.backend.service.impl;

import com.backend.entity.User;
import com.backend.service.UserService;
import com.backend.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* @author oo
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-10-29 10:55:40
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
implements UserService{

}
