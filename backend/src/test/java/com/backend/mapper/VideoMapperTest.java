package com.backend.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class VideoMapperTest {
    @Resource
    private VideoMapper videoMapper;

    @Test
    void test01(){
        System.out.println(videoMapper.selectAllVideo());
    }

}
