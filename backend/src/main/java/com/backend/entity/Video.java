package com.backend.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName video
 */
@Data
public class Video implements Serializable {
    /**
     * 视频id
     */
    private Integer id;

    /**
     * 
     */
    private Integer userid;

    /**
     * 视频标题
     */
    private String title;

    /**
     * 视频描述
     */
    private String desc;

    /**
     * 视频资源地址
     */
    private String address;

    private static final long serialVersionUID = 1L;
}