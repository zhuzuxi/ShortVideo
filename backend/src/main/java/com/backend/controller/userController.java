package com.backend.controller;

import com.backend.dto.UserDto;
import com.backend.entity.Result;
import com.backend.entity.User;
import com.backend.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class userController {

    @Resource
    private UserService userService;

    @GetMapping("/{id}")
    public Result<UserDto> getUserById(@PathVariable Integer id){
//        return userService.getUserById(id);
    return null;
    }
}
