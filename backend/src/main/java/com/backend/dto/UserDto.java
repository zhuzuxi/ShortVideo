package com.backend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private Integer id;

    /**
     *
     */
    private String username;

    /**
     *
     */

    /**
     *
     */
    private String sex;

    /**
     *
     */
    private Integer age;

    /**
     * 用户喜欢的类型或者发布视频的类型 用','分隔
     */
    private String type;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;
}
