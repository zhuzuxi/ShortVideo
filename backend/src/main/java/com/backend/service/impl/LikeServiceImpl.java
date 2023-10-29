package com.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.backend.entity.Like;
import com.backend.service.LikeService;
import com.backend.mapper.LikeMapper;
import org.springframework.stereotype.Service;

/**
* @author oo
* @description 针对表【like】的数据库操作Service实现
* @createDate 2023-10-29 11:53:14
*/
@Service
public class LikeServiceImpl extends ServiceImpl<LikeMapper, Like>
    implements LikeService{

}




