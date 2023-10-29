package com.backend.entity;

import java.io.Serializable;
import java.util.Date;
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
     * 类型 暂时一个视频只有一个类型
     */
    private String type;

    /**
     * 视频资源地址
     */
    private String address;

    /**
     * 上传时间
     */
    private Date uploadDatetime;

    /**
     * 上传位置 省市
     */
    private String uploadLocation;

    private static final long serialVersionUID = 1L;
}