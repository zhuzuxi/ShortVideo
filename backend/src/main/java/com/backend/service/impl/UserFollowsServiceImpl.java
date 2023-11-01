package com.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.backend.entity.UserFollows;
import com.backend.service.UserFollowsService;
import com.backend.mapper.UserFollowsMapper;
import org.springframework.stereotype.Service;

/**
* @author oo
* @description 针对表【user_follows】的数据库操作Service实现
* @createDate 2023-10-31 11:10:05
*/
@Service
public class UserFollowsServiceImpl extends ServiceImpl<UserFollowsMapper, UserFollows>
    implements UserFollowsService{

}




