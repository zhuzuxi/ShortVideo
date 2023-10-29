package com.backend.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName like
 */
@Data
public class Like implements Serializable {
    /**
     * 序号
     */
    private Integer id;

    /**
     * 
     */
    private Integer userid;

    /**
     * 
     */
    private Integer videoid;

    /**
     * 点赞时间
     */
    private Date likeDatetime;

    private static final long serialVersionUID = 1L;
}