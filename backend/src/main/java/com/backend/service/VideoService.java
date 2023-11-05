package com.backend.service;

import com.backend.dto.VideoUserDto;
import com.backend.entity.Result;
import com.backend.entity.Video;
import com.backend.vo.MyWorksVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author oo
* @description 针对表【video】的数据库操作Service
* @createDate 2023-10-31 11:10:08
*/
public interface VideoService extends IService<Video> {
    public void uploadVideo(String localFilePath);

    public String getUrl(String key);

    Result<List<VideoUserDto>> recommendVideos(Integer pagenum);

    /**
     * 根据用户id获取用户个人作品
     * @param user_id
     * @return
     */
    List<MyWorksVO> getMyWorksByUserId(Long user_id);
}
