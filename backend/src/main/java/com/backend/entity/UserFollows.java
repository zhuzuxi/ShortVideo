package com.backend.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 
 * @TableName user_follows 用户关注表
 */
@Data
public class UserFollows implements Serializable {
    /**
     * 关注者用户id
     */
    private Long userId;

    /**
     * 被关注者用户id
     */
    private Long followId;

    /**
     * 关注时间
     */
    private Date follow_time;

    private static final long serialVersionUID = 1L;
}