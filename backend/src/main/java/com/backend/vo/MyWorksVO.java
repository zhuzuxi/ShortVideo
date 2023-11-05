package com.backend.vo;

import lombok.Data;

/**
 * 用户作品 视图实体
 */
@Data
public class MyWorksVO {
    private Long id;      //视频id
    private String videoUrl;   //视频地址
    private String cover; //视频封面地址
//    private Long play_cnt;    //视频播放数
}
