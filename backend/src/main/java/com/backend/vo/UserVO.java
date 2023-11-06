package com.backend.vo;

import lombok.Data;

/**
 * 简单用户视图实体
 */
@Data
public class UserVO {
    private Long id;    //用户id
    private String username;    //用户名
    private String img;         //用户头像
    private Integer followStatus;  //关注状态
}
