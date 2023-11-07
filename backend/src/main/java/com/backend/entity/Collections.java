package com.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @Tablename collections 用户收藏表
 */
@Data
@AllArgsConstructor
public class Collections {
    private Long user_id;
    private Long video_id;
    private Date collect_time;
}
