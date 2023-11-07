package com.backend.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName likes 用户点赞表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Likes implements Serializable {
    /**
     * 序号
     */
//    private Integer id;

    /**
     * 
     */
    private Long user_id;

    /**
     * 
     */
    private Long video_id;

    /**
     * 点赞时间
     */
    private Date like_time;

    private static final long serialVersionUID = 1L;
}