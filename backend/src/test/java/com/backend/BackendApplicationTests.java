package com.backend;

import com.backend.dto.UserDto;
import com.backend.entity.User;
import com.backend.mapper.UserMapper;
import com.backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class BackendApplicationTests {

    @Resource
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        System.out.println(userMapper.getAllUsers());
    }

    @Resource
    private ModelMapper modelMapper;

    @Test
    void modelMapper(){
        for (User user : userMapper.getAllUsers()) {
            System.out.println(modelMapper.map(user, UserDto.class));
        }
    }

    @Test
    void getUserById(){
        System.out.println(userMapper.getUserById(1));
    }

    @Resource
    private UserService userService;
    @Test
    void getUser(){
        System.out.println(userService.getUserById(1));
    }

}
