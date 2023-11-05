package com.backend.service.impl;

import com.backend.mapper.VideoMapper;
import com.backend.service.VideoService;
import com.backend.vo.VideoVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.backend.entity.Likes;
import com.backend.service.LikeService;
import com.backend.mapper.LikesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;

/**
* @author oo
* @description 针对表【like】的数据库操作Service实现
* @createDate 2023-10-31 11:09:46
*/
@Service
public class LikeServiceImpl extends ServiceImpl<LikesMapper, Likes>
    implements LikeService{

    @Autowired
    private LikesMapper likesMapper;

    @Autowired
    private VideoService videoService;

    /**
     * 获取用户点赞过的视频
     * @param userId
     * @return
     */
    @Override
    public List<VideoVO> getLikeVideosByUserId(Long userId) {
        List<Long> videoIds = likesMapper.getLikeVideoIdsByUserId(userId);
        if(videoIds.isEmpty()){
            return null;    //没有点赞过视频
        }
        return videoService.getVideoVOByIds(videoIds);
    }
}




