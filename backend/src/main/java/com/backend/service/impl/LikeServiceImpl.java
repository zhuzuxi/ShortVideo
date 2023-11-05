package com.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.backend.entity.Likes;
import com.backend.service.LikeService;
import com.backend.mapper.LikesMapper;
import org.springframework.stereotype.Service;

/**
* @author oo
* @description 针对表【like】的数据库操作Service实现
* @createDate 2023-10-31 11:09:46
*/
@Service
public class LikeServiceImpl extends ServiceImpl<LikesMapper, Likes>
    implements LikeService{

}




