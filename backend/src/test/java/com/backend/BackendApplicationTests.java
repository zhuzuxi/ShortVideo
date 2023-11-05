package com.backend;

import com.backend.dto.UserDto;
import com.backend.entity.User;
import com.backend.entity.Video;
import com.backend.mapper.UserMapper;
import com.backend.mapper.VideoMapper;
import com.backend.service.UserService;
import com.backend.service.VideoService;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.DownloadUrl;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@SpringBootTest
class BackendApplicationTests {

    @Resource
    private UserMapper userMapper;
    @Test
    void contextLoads() {
//        System.out.println(userMapper.getAllUsers());
    }

//    @Resource
//    private ModelMapper modelMapper;

    @Test
    void modelMapper(){
//        for (User user : userMapper.getAllUsers()) {
//            System.out.println(modelMapper.map(user, UserDto.class));
//        }
    }

    @Test
    void getUserById(){
//        System.out.println(userMapper.getUserById(1));
    }

    @Resource
    private UserService userService;
    @Test
    void getUser(){
//        System.out.println(userService.getUserById(1));
    }



    @Test
    void testFile(){
        File file=new File("D:\\test_qiniu\\animal_mysql");
        for (File listFile : file.listFiles()) {
            System.out.println(listFile.getAbsolutePath());
        }
    }

}
