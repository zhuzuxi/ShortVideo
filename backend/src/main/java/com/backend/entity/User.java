package com.backend.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName user
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 
     */
    private String phone;

    /**
     * 头像url
     */
    private String img;

    /**
     * 帐号状态 0禁用 1正常
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 粉丝数
     */
    private Long fansCnt;

    /**
     * 关注数
     */
    private Long follows;

    private static final long serialVersionUID = 1L;
}