package com.backend.controller;

import com.backend.dto.UserDto;
import com.backend.entity.Result;
import com.backend.entity.User;
import com.backend.mapper.UserMapper;
import com.backend.service.MyUserDetailsService;
import com.backend.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class userController {

    @Resource
    private UserService userService;

    @GetMapping("/{id}")
    public Result<UserDto> getUserById(@PathVariable Integer id) {
//        return userService.getUserById(id);
        return null;
    }

    @Resource
    private UserMapper userMapper;

    @GetMapping("/page")
    public Page<User> getUserList(@RequestParam(defaultValue = "1") Integer pageNum,
                                  @RequestParam(defaultValue = "10") Integer pageSize) {
        // 创建分页对象
        Page<User> page = new Page<>(pageNum, pageSize);
        // 执行分页查询
        Page<User> userPage = userMapper.selectPage(page, null);
        return userPage;
    }

    /**
     * 获取登录用户信息
     * @param session
     * @return
     */
    @GetMapping
    public Result<User> getUser(HttpSession session){
        //获取应用上下文
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        //获取登陆用户信息
        User user = userService.getUserByUsername(userDetails.getUsername());
        //将User信息存入当前会话中
        session.setAttribute("user",user);
        return Result.SUCCEED(user);
    }
}
