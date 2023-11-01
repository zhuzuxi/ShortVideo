package com.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.backend.entity.User;
import com.backend.service.UserService;
import com.backend.mapper.UserMapper;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
* @author oo
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-10-31 11:10:01
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




