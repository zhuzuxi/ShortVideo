package com.backend.service.impl;

import com.backend.entity.Collections;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.backend.entity.UserFollows;
import com.backend.service.UserFollowsService;
import com.backend.mapper.UserFollowsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
* @author oo
* @description 针对表【user_follows】的数据库操作Service实现
* @createDate 2023-10-31 11:10:05
*/
@Service
public class UserFollowsServiceImpl extends ServiceImpl<UserFollowsMapper, UserFollows>
    implements UserFollowsService{

    @Resource
    private UserFollowsMapper userFollowsMapper;

    /**
     * 关注/取消关注用户
     * @param currUserId    当前登录用户id
     * @param userId        要关注的用户id
     * @return
     */
    @Override
    public Integer followOrCancel(Long currUserId, Long userId) {
        //获取用户间的关注状态
        QueryWrapper<UserFollows> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", currUserId).eq("follow_id", userId);
        int count = Math.toIntExact(userFollowsMapper.selectCount(queryWrapper));
        //获取被关注用户是否已关注当前登录用户
        QueryWrapper<UserFollows> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("follow_id", currUserId).eq("user_id", userId);
        int isUserFollowsMe = Math.toIntExact(userFollowsMapper.selectCount(queryWrapper2));

        if(count == 1){ //已关注
            userFollowsMapper.deleteFollows(currUserId,userId);
            if(isUserFollowsMe==1){
                userFollowsMapper.updateFollowStatus(userId,currUserId,0);
            }
            return 0;   //取消关注
        }else{  //未关注
            if(isUserFollowsMe==1){//被关注的用户已关注了该用户
                userFollowsMapper.insert(new UserFollows(currUserId,userId,1,new Date()));
                userFollowsMapper.updateFollowStatus(userId,currUserId,1);
            }else{//被关注的用户未关注了该用户
                userFollowsMapper.insert(new UserFollows(currUserId,userId,0,new Date()));
            }
            return 1;   //关注
        }
    }
}




