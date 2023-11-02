/*
Navicat MySQL Data Transfer

Source Server         : mysql80
Source Server Version : 80026
Source Host           : localhost:3306
Source Database       : short_video

Target Server Type    : MYSQL
Target Server Version : 80026
File Encoding         : 65001

Date: 2023-10-31 00:02:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `phone` varchar(11) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL COMMENT '头像url',
  `status` int DEFAULT NULL COMMENT '帐号状态 0禁用 1正常',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `fans_cnt` bigint DEFAULT NULL COMMENT '粉丝数',
  `follows` bigint DEFAULT NULL COMMENT '关注数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for user_follows
-- ----------------------------
DROP TABLE IF EXISTS `user_follows`;
CREATE TABLE `user_follows` (
  `user_id` bigint NOT NULL COMMENT '关注者用户id',
  `follow_id` bigint DEFAULT NULL COMMENT '被关注者用户id',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user_follows
-- ----------------------------

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `video_url` varchar(255) DEFAULT NULL COMMENT '视频url',
  `description` varchar(255) DEFAULT NULL COMMENT '视频描述',
  `cover` varchar(255) DEFAULT NULL COMMENT '视频封面图片url',
  `like` bigint DEFAULT NULL COMMENT '点赞次数',
  `share` bigint DEFAULT NULL COMMENT '分享次数',
  `collection` bigint DEFAULT NULL COMMENT '收藏次数',
  `flag` varchar(10) DEFAULT NULL COMMENT '视频标签',
  `category_id` int DEFAULT NULL COMMENT '视频分类',
  `status` int DEFAULT NULL COMMENT '视频状态 0 待审核 1 已发布',
  `permission` int DEFAULT NULL COMMENT '视频权限0 仅自己 1 仅朋友 2 仅粉丝 3 所有人',
  `publish_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '发布时间',
  `author_id` bigint DEFAULT NULL COMMENT '作者id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of video
-- ----------------------------

-- ----------------------------
-- Table structure for video_category
-- ----------------------------
DROP TABLE IF EXISTS `video_category`;
CREATE TABLE `video_category` (
  `id` int NOT NULL COMMENT '分类id',
  `name` varchar(32) DEFAULT NULL COMMENT '分类名',
  `sort` int DEFAULT NULL COMMENT '排序字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of video_category
-- ----------------------------
