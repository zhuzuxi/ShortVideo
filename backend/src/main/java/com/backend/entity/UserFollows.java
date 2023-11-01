package com.backend.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName user_follows
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

    private static final long serialVersionUID = 1L;
}