package com.backend.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName likes 用户点赞表
 */
@Data
public class Likes implements Serializable {
    /**
     * 序号
     */
    private Integer id;

    /**
     * 
     */
    private Integer user_id;

    /**
     * 
     */
    private Integer video_id;

    /**
     * 点赞时间
     */
    private Date like_time;

    private static final long serialVersionUID = 1L;
}