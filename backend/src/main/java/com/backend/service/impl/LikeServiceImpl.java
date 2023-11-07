package com.backend.service.impl;

import com.backend.mapper.VideoMapper;
import com.backend.service.VideoService;
import com.backend.vo.VideoVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.backend.entity.Likes;
import com.backend.service.LikeService;
import com.backend.mapper.LikesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.Date;
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

    /**
     * 用户点赞或取消点赞
     * @param userId
     * @param videoId
     */
    @Override
    public Integer likeOrCancel(Long userId, Long videoId) {
        //获取当前视频的原始点赞状态
        QueryWrapper<Likes> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId).eq("video_id", videoId);
        int count = Math.toIntExact(likesMapper.selectCount(queryWrapper));
        if(count == 1){
            likesMapper.delete(queryWrapper);
            return 0;   //取消点赞
        }else{
            likesMapper.insert(new Likes(userId,videoId,new Date()));
            return 1;   //点赞
        }
    }
}




