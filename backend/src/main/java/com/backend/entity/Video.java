package com.backend.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 
 * @TableName video
 */
@Data
public class Video implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 视频url
     */
    private String videoUrl;

    /**
     * 视频描述
     */
    private String description;

    /**
     * 视频封面图片url
     */
    private String cover;

    /**
     * 点赞次数
     */
    private Long likes;

    /**
     * 分享次数
     */
    private Long shares;

    /**
     * 收藏次数
     */
    private Long collection;

    /**
     * 视频标签
     */
    private String flag;

    /**
     * 视频分类
     */
    private Integer categoryId;

    /**
     * 视频状态 0 待审核 1 已发布
     */
    private Integer video_status;

    /**
     * 视频权限0 仅自己 1 仅朋友 2 仅粉丝 3 所有人
     */
    private Integer permission;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 作者id
     */
    private Long authorId;

    private static final long serialVersionUID = 1L;
}