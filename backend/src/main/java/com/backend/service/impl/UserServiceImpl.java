package com.backend.service.impl;

import com.backend.vo.UserVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.backend.entity.User;
import com.backend.service.UserService;
import com.backend.mapper.UserMapper;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
* @author oo
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-10-31 11:10:01
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    @Override
    public User getUserByUsername(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        User user =  userMapper.selectOne(wrapper);       //获取用户实体
        user.setPassword("");//将密码置为空
        return user;
    }

    /**
     * 获取用户关注列表
     * @param userId
     * @return
     */
    @Override
    public List<UserVO> getFollows(Long userId) {
        return userMapper.getFollowsByUserId(userId);
    }

    /**
     * 获取粉丝列表
     * @param userId
     * @return
     */
    @Override
    public List<UserVO> getFans(Long userId) {
        return userMapper.getFansByUserId(userId);
    }
}




