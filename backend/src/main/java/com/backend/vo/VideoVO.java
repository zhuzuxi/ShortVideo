package com.backend.vo;

import lombok.Data;

/**
 * 视频视图实体   -   用以搜索结果/个人中心的点赞作品/收藏作品 展示
 * 与MyWorksVO类似
 */
@Data
public class VideoVO {
    private Long id;      //视频id
    private String videoUrl;   //视频地址
    private String cover; //视频封面地址
    private Long likes;    //视频点赞数
}
