/*
Navicat MySQL Data Transfer

Source Server         : mysql80
Source Server Version : 80026
Source Host           : localhost:3306
Source Database       : shortvideo

Target Server Type    : MYSQL
Target Server Version : 80026
File Encoding         : 65001

Date: 2023-11-03 15:32:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `phone` varchar(11) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL COMMENT '头像url',
  `status` int DEFAULT NULL COMMENT '帐号状态 0禁用 1正常',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `fans_cnt` bigint DEFAULT NULL COMMENT '粉丝数',
  `follows` bigint DEFAULT NULL COMMENT '关注数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'test', '$2a$10$5ooQI8dir8jv0/gCa1Six.GpzAdIPf6pMqdminZ/3ijYzivCyPlfK', null, null, null, '2023-11-02 21:23:19', null, null);
INSERT INTO `user` VALUES ('2', '美妆', null, null, null, null, '2023-11-03 10:47:05', null, null);
INSERT INTO `user` VALUES ('3', '生活', null, null, null, null, '2023-11-03 10:16:12', null, null);
INSERT INTO `user` VALUES ('4', '钓鱼', null, null, null, null, '2023-11-03 10:16:11', null, null);
INSERT INTO `user` VALUES ('5', '运动', null, null, null, null, '2023-11-03 10:16:08', null, null);
INSERT INTO `user` VALUES ('6', '科技', null, null, null, null, '2023-11-03 10:16:10', null, null);
INSERT INTO `user` VALUES ('7', '知识分享官', null, null, null, null, '2023-11-03 10:35:20', null, null);
INSERT INTO `user` VALUES ('8', '解压', null, null, null, null, '2023-11-03 10:35:23', null, null);
INSERT INTO `user` VALUES ('9', '新闻热点', null, null, null, null, '2023-11-03 10:35:25', null, null);
INSERT INTO `user` VALUES ('10', '宠物', null, null, null, null, '2023-11-03 10:35:28', null, null);
INSERT INTO `user` VALUES ('11', '搞笑', null, null, null, null, '2023-11-03 10:35:31', null, null);
INSERT INTO `user` VALUES ('12', '帅哥', null, null, null, null, '2023-11-03 10:41:25', null, null);
INSERT INTO `user` VALUES ('13', '美女', null, null, null, null, '2023-11-03 10:41:27', null, null);
INSERT INTO `user` VALUES ('14', '测试用户', null, null, null, null, '2023-11-03 10:47:22', null, null);

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
-- Table structure for user_hobby
-- ----------------------------
DROP TABLE IF EXISTS `user_hobby`;
CREATE TABLE `user_hobby` (
  `user_id` bigint NOT NULL,
  `makeup` int NOT NULL DEFAULT '0',
  `life` int NOT NULL DEFAULT '0',
  `fishing` int NOT NULL DEFAULT '0',
  `sport` int NOT NULL DEFAULT '0',
  `technology` int NOT NULL DEFAULT '0',
  `knowledge` int NOT NULL DEFAULT '0',
  `release` int NOT NULL DEFAULT '0',
  `news` int NOT NULL DEFAULT '0',
  `pet` int NOT NULL DEFAULT '0',
  `funny` int NOT NULL DEFAULT '0',
  `handsome` int NOT NULL DEFAULT '0',
  `beauty` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user_hobby
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
  `id` int NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类',
  `name` varchar(32) NOT NULL COMMENT '分类名',
  `sort` int NOT NULL COMMENT '排序字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of video_category
-- ----------------------------
INSERT INTO `video_category` VALUES ('1', 'makeup', '美妆', '1');
INSERT INTO `video_category` VALUES ('2', 'life', '生活', '2');
INSERT INTO `video_category` VALUES ('3', 'fishing', '钓鱼', '6');
INSERT INTO `video_category` VALUES ('4', 'sport', '运动', '10');
INSERT INTO `video_category` VALUES ('5', 'technology', '科技', '3');
INSERT INTO `video_category` VALUES ('6', 'knowledge', '知识', '4');
INSERT INTO `video_category` VALUES ('7', 'release', '解压', '9');
INSERT INTO `video_category` VALUES ('8', 'news', '新闻', '1');
INSERT INTO `video_category` VALUES ('9', 'pet', '宠物', '10');
INSERT INTO `video_category` VALUES ('10', 'funny', '搞笑', '6');
INSERT INTO `video_category` VALUES ('11', 'handsome', '帅哥', '5');
INSERT INTO `video_category` VALUES ('12', 'beauty', '美女', '10');
