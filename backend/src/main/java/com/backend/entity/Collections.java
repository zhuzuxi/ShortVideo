package com.backend.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Tablename collections 用户收藏表
 */
@Data
public class Collections {
    private Long user_id;
    private Long video_id;
    private Date collect_time;
}
