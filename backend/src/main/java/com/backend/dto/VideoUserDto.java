package com.backend.dto;

import com.backend.entity.User;
import com.backend.entity.Video;
import com.backend.mapper.VideoMapper;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 用于填充视频播放页面的信息
 */
@Data
@AllArgsConstructor
public class VideoUserDto {
    private Video video;
    private User user;
}
