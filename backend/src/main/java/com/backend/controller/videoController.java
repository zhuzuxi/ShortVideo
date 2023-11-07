package com.backend.controller;

import com.backend.dto.VideoUserDto;
import com.backend.entity.Result;
import com.backend.entity.User;
import com.backend.entity.Video;
import com.backend.mapper.VideoMapper;
import com.backend.service.VideoService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
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

    /**
     * 通过关键字模糊查询视频并分页
     * @param key   关键字
     * @param pagenum
     * @return
     */
    @GetMapping("/search")
    public Result<List<VideoUserDto>> searchVideos( @RequestParam(defaultValue = "") String key, @RequestParam(defaultValue = "1") Integer pagenum){
        return videoService.searchVideos(key,pagenum);
    }

    @Resource(name = "myAuth")
    private Auth auth;
    //新增视频
    @GetMapping("/uploadtoken")
    public Result<String> getUpLoadToken(@RequestParam String bucket){
        String upToken = auth.uploadToken(bucket);
        return Result.SUCCEED("上传凭证",upToken);
    }

    /**
     * 用户上传视频
     * @param session
     * @param video
     * @return
     */
    @PostMapping("/add")
    public Result addVideo(HttpSession session, Video video){
        User user = (User)session.getAttribute("user");
        //补充视频作者信息
        video.setAuthorId(user.getId());
        if(videoService.addVideo(video)){
            return Result.SUCCEED("上传成功");
        }
        return Result.ERR("上传失败");
    }
}
