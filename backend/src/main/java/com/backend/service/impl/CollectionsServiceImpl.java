package com.backend.service.impl;

import com.backend.entity.Collections;
import com.backend.mapper.CollectionsMapper;
import com.backend.service.CollectionsService;
import com.backend.service.VideoService;
import com.backend.vo.VideoVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
