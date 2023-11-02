package com.backend.controller;

import com.backend.dto.UserDto;
import com.backend.entity.Result;
import com.backend.entity.User;
import com.backend.mapper.UserMapper;
import com.backend.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
}
