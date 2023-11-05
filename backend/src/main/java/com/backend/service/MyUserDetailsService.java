package com.backend.service;

import com.backend.entity.User;
import com.backend.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //调用userMapper方法，根据用户查询数据库
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        User user= userMapper.selectOne(wrapper);       //获取用户实体
        //判断
        if (user==null){//数据库没有用户名，认证失败
            throw  new UsernameNotFoundException("用户名不存在！");
        }
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("admins");
        //从查询数据库返回users对象，得到用户名和密码返回
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),auths);
    }
}
