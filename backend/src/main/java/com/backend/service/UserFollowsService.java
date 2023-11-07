package com.backend.service;

import com.backend.entity.UserFollows;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author oo
* @description 针对表【user_follows】的数据库操作Service
* @createDate 2023-10-31 11:10:05
*/
public interface UserFollowsService extends IService<UserFollows> {

    /**
     * 关注/取消关注用户
     * @param currUserId    当前登录用户id
     * @param userId        要关注的用户id
     * @return
     */
    Integer followOrCancel(Long currUserId, Long userId);
}
