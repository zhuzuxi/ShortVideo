package com.backend.service;

import com.backend.entity.Likes;
import com.backend.vo.VideoVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author oo
* @description 针对表【like】的数据库操作Service
* @createDate 2023-10-31 11:09:46
*/
public interface LikeService extends IService<Likes> {

    /*通过用户id获取点赞过的视频*/
    List<VideoVO> getLikeVideosByUserId(Long userId);

    /**
     * 用户点赞或取消赞
     * @param userId
     * @param videoId
     */
    Integer likeOrCancel(Long userId, Long videoId);

//    public void testUpdate();

}
