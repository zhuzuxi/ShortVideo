package com.backend.service;

import com.backend.entity.Collections;
import com.backend.vo.VideoVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface CollectionsService extends IService<Collections> {

    List<VideoVO> getCollectVideosByUserId(Long userId);
}
