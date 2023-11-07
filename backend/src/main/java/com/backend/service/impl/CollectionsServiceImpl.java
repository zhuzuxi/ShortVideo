package com.backend.service.impl;

import com.backend.entity.Collections;
import com.backend.entity.Likes;
import com.backend.mapper.CollectionsMapper;
import com.backend.service.CollectionsService;
import com.backend.service.VideoService;
import com.backend.vo.VideoVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CollectionsServiceImpl extends ServiceImpl<CollectionsMapper, Collections>
        implements CollectionsService {

    @Resource
    private CollectionsMapper collectionsMapper;

    @Resource
    private VideoService videoService;

    /**
     * 获取用户收藏的视频
     * @param userId
     * @return
     */
    @Override
    public List<VideoVO> getCollectVideosByUserId(Long userId) {
        List<Long> videoIds = collectionsMapper.getCollectVideoIdsByUserId(userId);
        if(videoIds.isEmpty()){
            return null;    //没有收藏过视频
        }
        return videoService.getVideoVOByIds(videoIds);
    }

    /**
     * 收藏/取消收藏视频
     * @param currUserId
     * @param videoId
     * @return
     */
    @Override
    public Integer collectOrCancel(Long currUserId, Long videoId) {
        //获取当前视频的原始收藏状态
        QueryWrapper<Collections> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", currUserId).eq("video_id", videoId);
        int count = Math.toIntExact(collectionsMapper.selectCount(queryWrapper));
        if(count == 1){
            collectionsMapper.delete(queryWrapper);
            return 0;   //取消收藏
        }else{
            collectionsMapper.insert(new Collections(currUserId,videoId,new Date()));
            return 1;   //收藏
        }
    }
}
