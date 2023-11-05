package com.backend.controller;

import com.backend.dto.VideoUserDto;
import com.backend.entity.Result;
import com.backend.entity.Video;
import com.backend.mapper.VideoMapper;
import com.backend.service.VideoService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/video")
public class videoController {

    @Resource
    private VideoMapper videoMapper;

    @Resource
    private VideoService videoService;
    @GetMapping("/all")
    public Result<List<Video>> getAllVideo(){
        return Result.SUCCEED("获取全部视频资源",videoMapper.selectAllVideo());
    }


    /**
     *
     * @param pagenum 页数
     * @return
     */
    @GetMapping("/recommend")
    public Result<List<VideoUserDto>> recommendVideos(@RequestParam(defaultValue = "1") Integer pagenum){
        return videoService.recommendVideos(pagenum);
    }

    @Resource(name = "myAuth")
    private Auth auth;
    //新增视频
    @GetMapping("/uploadtoken")
    public Result<String> getUpLoadToken(@RequestParam String bucket){
        String upToken = auth.uploadToken(bucket);
        return Result.SUCCEED("上传凭证",upToken);
    }

}
