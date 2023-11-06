package com.backend.service;

import com.backend.entity.User;
import com.backend.vo.UserVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author oo
* @description 针对表【user】的数据库操作Service
* @createDate 2023-10-31 11:10:01
*/
public interface UserService extends IService<User> {

    User getUserByUsername(String username);

    /**
     * 获取用户关注列表
     * @param userId
     * @return
     */
    List<UserVO> getFollows(Long userId);

    /**
     * 获取粉丝列表
     * @param userId
     * @return
     */
    List<UserVO> getFans(Long userId);
}
