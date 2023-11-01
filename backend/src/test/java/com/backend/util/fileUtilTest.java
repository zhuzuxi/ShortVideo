package com.backend.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class fileUtilTest {
    @Test
    void testGetAllFiles(){
        System.out.println(fileUtils.getAllFileAbsolutePathFromDirectory("D:\\qiniuyun_data\\videos", "mp4"));
    }
}
