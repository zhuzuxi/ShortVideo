package com.backend.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName user_follows 用户关注表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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
     * 关注状态
     * user_id = A
     * follow_id = B
     * status = 0 -> B未关注A，1 -> AB相互关注
     */
    private Integer follow_status;

    /**
     * 关注时间
     */
    private Date follow_time;

    private static final long serialVersionUID = 1L;

}