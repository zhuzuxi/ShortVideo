package com.backend.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName video_category
 */
@Data
public class VideoCategory implements Serializable {
    /**
     * 分类id
     */
    private Integer id;

    //类型
    private String type;

    /**
     * 分类名
     */
    private String name;

    /**
     * 排序字段
     */
    private Integer sort;

    private static final long serialVersionUID = 1L;
}