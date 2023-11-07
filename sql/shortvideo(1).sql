/*
Navicat MySQL Data Transfer

Source Server         : mysql80
Source Server Version : 80026
Source Host           : localhost:3306
Source Database       : shortvideo

Target Server Type    : MYSQL
Target Server Version : 80026
File Encoding         : 65001

Date: 2023-11-07 13:43:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for collections
-- ----------------------------
DROP TABLE IF EXISTS `collections`;
CREATE TABLE `collections` (
  `user_id` bigint NOT NULL,
  `video_id` bigint NOT NULL,
  `collect_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of collections
-- ----------------------------
INSERT INTO `collections` VALUES ('1', '1', '2023-11-07 09:48:19');
INSERT INTO `collections` VALUES ('1', '2', '2023-11-07 09:49:34');
INSERT INTO `collections` VALUES ('1', '3', '2023-11-07 09:49:42');
INSERT INTO `collections` VALUES ('2', '4', '2023-11-07 09:49:50');
INSERT INTO `collections` VALUES ('2', '2', '2023-11-07 09:49:54');
INSERT INTO `collections` VALUES ('1', '4', '2023-11-07 09:50:00');
INSERT INTO `collections` VALUES ('1', '10', '2023-11-07 12:46:57');

-- ----------------------------
-- Table structure for likes
-- ----------------------------
DROP TABLE IF EXISTS `likes`;
CREATE TABLE `likes` (
  `user_id` bigint NOT NULL,
  `video_id` bigint NOT NULL,
  `like_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of likes
-- ----------------------------
INSERT INTO `likes` VALUES ('1', '1', '2023-11-07 09:48:19');
INSERT INTO `likes` VALUES ('1', '2', '2023-11-07 09:48:27');
INSERT INTO `likes` VALUES ('1', '3', '2023-11-07 09:48:31');
INSERT INTO `likes` VALUES ('1', '4', '2023-11-07 09:48:39');
INSERT INTO `likes` VALUES ('2', '1', '2023-11-07 09:48:46');
INSERT INTO `likes` VALUES ('2', '3', '2023-11-07 09:48:52');
INSERT INTO `likes` VALUES ('1', '5', '2023-11-07 09:49:03');

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
  `likes` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'test', '$2a$10$5ooQI8dir8jv0/gCa1Six.GpzAdIPf6pMqdminZ/3ijYzivCyPlfK', null, 'https://sky-itcast.oss-cn-beijing.aliyuncs.com/41bfcacf-7ad4-4927-8b26-df366553a94c.png', '1', '2023-11-07 10:10:00', '0', '0', '0');
INSERT INTO `user` VALUES ('2', '美妆', null, null, 'https://sky-itcast.oss-cn-beijing.aliyuncs.com/41bfcacf-7ad4-4927-8b26-df366553a94c.png', '1', '2023-11-07 10:10:00', '0', '0', '0');
INSERT INTO `user` VALUES ('3', '生活', null, null, 'https://sky-itcast.oss-cn-beijing.aliyuncs.com/41bfcacf-7ad4-4927-8b26-df366553a94c.png', '1', '2023-11-07 10:10:00', '0', '0', '0');
INSERT INTO `user` VALUES ('4', '钓鱼', null, null, 'https://sky-itcast.oss-cn-beijing.aliyuncs.com/41bfcacf-7ad4-4927-8b26-df366553a94c.png', '1', '2023-11-07 10:10:00', '0', '0', '0');
INSERT INTO `user` VALUES ('5', '运动', null, null, 'https://sky-itcast.oss-cn-beijing.aliyuncs.com/41bfcacf-7ad4-4927-8b26-df366553a94c.png', '1', '2023-11-07 10:10:00', '0', '0', '0');
INSERT INTO `user` VALUES ('6', '科技', null, null, 'https://sky-itcast.oss-cn-beijing.aliyuncs.com/41bfcacf-7ad4-4927-8b26-df366553a94c.png', '1', '2023-11-07 10:10:00', '0', '0', '0');
INSERT INTO `user` VALUES ('7', '知识分享官', null, null, 'https://sky-itcast.oss-cn-beijing.aliyuncs.com/41bfcacf-7ad4-4927-8b26-df366553a94c.png', '1', '2023-11-07 10:10:00', '0', '0', '0');
INSERT INTO `user` VALUES ('8', '解压', null, null, 'https://sky-itcast.oss-cn-beijing.aliyuncs.com/41bfcacf-7ad4-4927-8b26-df366553a94c.png', '1', '2023-11-07 10:10:00', '0', '0', '0');
INSERT INTO `user` VALUES ('9', '新闻热点', null, null, 'https://sky-itcast.oss-cn-beijing.aliyuncs.com/41bfcacf-7ad4-4927-8b26-df366553a94c.png', '1', '2023-11-07 10:10:00', '0', '0', '0');
INSERT INTO `user` VALUES ('10', '宠物', null, null, 'https://sky-itcast.oss-cn-beijing.aliyuncs.com/41bfcacf-7ad4-4927-8b26-df366553a94c.png', '1', '2023-11-07 10:10:00', '0', '0', '0');
INSERT INTO `user` VALUES ('11', '搞笑', null, null, 'https://sky-itcast.oss-cn-beijing.aliyuncs.com/41bfcacf-7ad4-4927-8b26-df366553a94c.png', '1', '2023-11-07 10:10:00', '0', '0', '0');
INSERT INTO `user` VALUES ('12', '帅哥', null, null, 'https://sky-itcast.oss-cn-beijing.aliyuncs.com/41bfcacf-7ad4-4927-8b26-df366553a94c.png', '1', '2023-11-07 10:10:00', '0', '0', '0');
INSERT INTO `user` VALUES ('13', '美女', null, null, 'https://sky-itcast.oss-cn-beijing.aliyuncs.com/41bfcacf-7ad4-4927-8b26-df366553a94c.png', '1', '2023-11-07 10:10:00', '0', '0', '0');
INSERT INTO `user` VALUES ('14', '测试用户', null, null, 'https://sky-itcast.oss-cn-beijing.aliyuncs.com/41bfcacf-7ad4-4927-8b26-df366553a94c.png', '1', '2023-11-07 10:10:00', '0', '0', '0');

-- ----------------------------
-- Table structure for user_follows
-- ----------------------------
DROP TABLE IF EXISTS `user_follows`;
CREATE TABLE `user_follows` (
  `user_id` bigint NOT NULL COMMENT '关注者用户id',
  `follow_id` bigint NOT NULL COMMENT '被关注者用户id',
  `follow_status` tinyint(1) NOT NULL COMMENT '未关注0 已关注1',
  `follow_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user_follows
-- ----------------------------
INSERT INTO `user_follows` VALUES ('1', '4', '1', '2023-11-07 00:53:45');
INSERT INTO `user_follows` VALUES ('1', '3', '0', '2023-11-07 00:52:57');
INSERT INTO `user_follows` VALUES ('1', '2', '1', '2023-11-07 00:53:28');
INSERT INTO `user_follows` VALUES ('2', '1', '1', '2023-11-07 00:53:40');
INSERT INTO `user_follows` VALUES ('5', '1', '0', '2023-11-07 00:53:55');
INSERT INTO `user_follows` VALUES ('10', '1', '0', '2023-11-07 13:42:55');

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
  `video_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '视频url',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '视频描述',
  `cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '视频封面图片url',
  `likes` bigint NOT NULL DEFAULT '0' COMMENT '点赞次数',
  `shares` bigint NOT NULL DEFAULT '0' COMMENT '分享次数',
  `collection` bigint NOT NULL DEFAULT '0' COMMENT '收藏次数',
  `flag` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '视频标签',
  `category_id` int NOT NULL COMMENT '视频分类',
  `video_status` int NOT NULL DEFAULT '1' COMMENT '视频状态 0 待审核 1 已发布',
  `permission` int NOT NULL DEFAULT '3' COMMENT '视频权限0 仅自己 1 仅朋友 2 仅粉丝 3 所有人（默认）',
  `publish_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '发布时间',
  `author_id` bigint NOT NULL COMMENT '作者id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=173 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('1', 'FgUhpPIfL4p52qt2jUQzudGvkBpT', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#解压', '10', '1', '3', '2023-11-04 16:36:19', '8');
INSERT INTO `video` VALUES ('2', 'FgjzaRmqG7LZ6Hk5KuibU8MRbqYO', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#生活', '10', '1', '3', '2023-11-04 16:36:19', '3');
INSERT INTO `video` VALUES ('3', 'Fgy9edFD4XU2BrDm-lVbb2-zBiPM', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#新闻热点', '10', '1', '3', '2023-11-04 16:36:19', '9');
INSERT INTO `video` VALUES ('4', 'Fhv2FPjesEqdH-FxY075jPZvIP6F', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#科技', '10', '1', '3', '2023-11-04 16:36:19', '6');
INSERT INTO `video` VALUES ('5', 'Fi014mT-qiJmLOV1UbUOXxcnY69G', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#搞笑', '10', '1', '3', '2023-11-04 16:36:19', '11');
INSERT INTO `video` VALUES ('6', 'Fi4cAXzz80be1EqWYMa2j3dYHF6m', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#美女', '10', '1', '3', '2023-11-04 16:36:19', '2');
INSERT INTO `video` VALUES ('7', 'FickB6E5qKwflNc_nVA6PFDDyy_L', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#美妆', '10', '1', '3', '2023-11-04 16:36:19', '13');
INSERT INTO `video` VALUES ('8', 'FjDVk8WePQqvrq4gP9vts6sW9eN7', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#测试用户', '10', '1', '3', '2023-11-04 16:36:19', '14');
INSERT INTO `video` VALUES ('9', 'FjN2LP7MhapGlOjXVK4JJ8g5d4t6', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#解压', '10', '1', '3', '2023-11-04 16:36:19', '8');
INSERT INTO `video` VALUES ('10', 'FjiW-fQAEby3WzTa3JGGUD1Wa1ij', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#美妆', '10', '1', '3', '2023-11-04 16:36:19', '13');
INSERT INTO `video` VALUES ('11', 'FkCCG7eNUXHPH1yEmvHolKVxPnpe', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#运动', '10', '1', '3', '2023-11-04 16:36:19', '5');
INSERT INTO `video` VALUES ('12', 'FkV991-GnTaxFzUM3YD2OYxbHUJV', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#知识分享官', '10', '1', '3', '2023-11-04 16:36:19', '7');
INSERT INTO `video` VALUES ('13', 'FkrrEg7Z-4q_33wL8S3RDI7WmGRi', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#解压', '10', '1', '3', '2023-11-04 16:36:19', '8');
INSERT INTO `video` VALUES ('14', 'FlD82B3-iaW_nS1jGpu3q45jkZDb', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#新闻热点', '10', '1', '3', '2023-11-04 16:36:19', '9');
INSERT INTO `video` VALUES ('15', 'FlhNn0Ltwp6AJ9hGbeNvkgtrBlWJ', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#解压', '10', '1', '3', '2023-11-04 16:36:19', '8');
INSERT INTO `video` VALUES ('16', 'FmA-Tin_U9per70a94b7atBBZ30a', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#生活', '10', '1', '3', '2023-11-04 16:36:19', '3');
INSERT INTO `video` VALUES ('17', 'FmTORL__sYm17lFyWZaHdDzNSyGA', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#生活', '10', '1', '3', '2023-11-04 16:36:19', '3');
INSERT INTO `video` VALUES ('18', 'Fm_EImNJ98WR-ns4OrXNBFqWXfLE', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#搞笑', '10', '1', '3', '2023-11-04 16:36:19', '11');
INSERT INTO `video` VALUES ('19', 'FmiTHbvY7LWKZ05lQUFwVh1B-MT3', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#搞笑', '10', '1', '3', '2023-11-04 16:36:19', '11');
INSERT INTO `video` VALUES ('20', 'FmwogJeQlmp7TQb5Tyxdm-HQ6IH5', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#钓鱼', '10', '1', '3', '2023-11-04 16:36:19', '4');
INSERT INTO `video` VALUES ('21', 'FnTsmvVUTuQobjrLyEQo7wxJ3D3i', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#解压', '10', '3', '3', '2023-11-04 16:36:19', '8');
INSERT INTO `video` VALUES ('22', 'FneNRDSoPc4aDBBzEnEhc0t2lEFA', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#美妆', '10', '3', '3', '2023-11-04 16:36:19', '13');
INSERT INTO `video` VALUES ('23', 'FnoHKRbcUYjxH6w6HfRsO0YhrxrU', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#钓鱼', '10', '3', '3', '2023-11-04 16:36:19', '4');
INSERT INTO `video` VALUES ('24', 'FnoL7qL_5VfUYR70LPhni5loESKr', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#知识分享官', '10', '3', '3', '2023-11-04 16:36:19', '7');
INSERT INTO `video` VALUES ('25', 'Fo38M01KqbC1nahyaeemOf96lBKd', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#运动', '10', '3', '3', '2023-11-04 16:36:19', '5');
INSERT INTO `video` VALUES ('26', 'Fo4m3mV9wYDsdziDN-OEBr9cyxHY', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#测试用户', '10', '3', '3', '2023-11-04 16:36:19', '14');
INSERT INTO `video` VALUES ('27', 'FoK7e7tPh38t14KTQ4Zr7POQJj6-', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#搞笑', '10', '3', '3', '2023-11-04 16:36:19', '11');
INSERT INTO `video` VALUES ('28', 'Fp7jnWIhjXQPFH5S-cm28gRuGz-5', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#运动', '10', '3', '3', '2023-11-04 16:36:19', '5');
INSERT INTO `video` VALUES ('29', 'FpD65IThzRwqBaGZKtoh0ephYSMy', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#测试用户', '10', '3', '3', '2023-11-04 16:36:19', '14');
INSERT INTO `video` VALUES ('30', 'FpLhreYOpPbFyL_j1Pk0H8ZMT4Mq', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#钓鱼', '10', '3', '3', '2023-11-04 16:36:19', '4');
INSERT INTO `video` VALUES ('31', 'FptTbk-Bx0jgkDGuUe-JkewLbeEK', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#运动', '10', '3', '3', '2023-11-04 16:36:19', '5');
INSERT INTO `video` VALUES ('32', 'Fq-3V_bVB97yRrAaf7NYgtjDCUSN', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#测试用户', '10', '3', '3', '2023-11-04 16:36:19', '14');
INSERT INTO `video` VALUES ('33', 'Fq7NdYJKq-zyLK2MQSY1HzNadIur', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#钓鱼', '10', '3', '3', '2023-11-04 16:36:19', '4');
INSERT INTO `video` VALUES ('34', 'Fq7mEPhxauUBtSXg9BAGqzfdNOei', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#解压', '10', '3', '3', '2023-11-04 16:36:19', '8');
INSERT INTO `video` VALUES ('35', 'FqE4bWLsvvApS6b4-4eNroMm2RRW', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#宠物', '10', '3', '3', '2023-11-04 16:36:19', '10');
INSERT INTO `video` VALUES ('36', 'FqG6ERyaPSxjSJ5fAyQ7A-Z7-7Uj', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#搞笑', '10', '3', '3', '2023-11-04 16:36:19', '11');
INSERT INTO `video` VALUES ('37', 'FqpiC2GNGk5MiWZQNMT5cdpqtcr7', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#测试用户', '10', '3', '3', '2023-11-04 16:36:19', '14');
INSERT INTO `video` VALUES ('38', 'Fr2fOHuP-aYWdmr7CsQnSN75Ur-H', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#测试用户', '10', '3', '3', '2023-11-04 16:36:19', '14');
INSERT INTO `video` VALUES ('39', 'Fr2rUjfdobjBh5CYPHHP36ZlAjWb', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#帅哥', '10', '3', '3', '2023-11-04 16:36:19', '12');
INSERT INTO `video` VALUES ('40', 'Fr9XaVL2z1I2uOH2f7MzzqN_2o0P', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#解压', '10', '3', '3', '2023-11-04 16:36:19', '8');
INSERT INTO `video` VALUES ('41', 'FrBmaEQkKH8iwT4Nh4r1zVPlepuH', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#测试用户', '10', '3', '3', '2023-11-04 16:36:19', '14');
INSERT INTO `video` VALUES ('42', 'FrXfISLaqE8o0TedoHO1iC2VLL_O', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#生活', '10', '3', '3', '2023-11-04 16:36:19', '3');
INSERT INTO `video` VALUES ('43', 'FremQ_2uVNaTpRb1Pl5e1XunFoif', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#新闻热点', '10', '3', '3', '2023-11-04 16:36:19', '9');
INSERT INTO `video` VALUES ('44', 'Fs1RJSYTqAQKGVpOIeTWbI649MqX', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#美妆', '10', '3', '3', '2023-11-04 16:36:19', '13');
INSERT INTO `video` VALUES ('45', 'FsH-xe-t_cye_g4_RXfe5Aa0rEi_', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#钓鱼', '10', '3', '3', '2023-11-04 16:36:19', '4');
INSERT INTO `video` VALUES ('46', 'FskuVo1HYefMa9Zp5GLg3G5CZ6bH', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#新闻热点', '10', '3', '3', '2023-11-04 16:36:19', '9');
INSERT INTO `video` VALUES ('47', 'FsrXvxaqMi1cv81gP2wc_jOuiMOj', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#生活', '10', '3', '3', '2023-11-04 16:36:19', '3');
INSERT INTO `video` VALUES ('48', 'Fswb421szsLxck-8bwVI_8-AmHaF', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#知识分享官', '10', '3', '3', '2023-11-04 16:36:19', '7');
INSERT INTO `video` VALUES ('49', 'Ft2rxQF7OYiYbxl832bMFXd_Byr8', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#新闻热点', '10', '3', '3', '2023-11-04 16:36:19', '9');
INSERT INTO `video` VALUES ('50', 'FtDyhopjZU54E4_b6xElCbM-vHxT', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#钓鱼', '10', '3', '3', '2023-11-04 16:36:19', '4');
INSERT INTO `video` VALUES ('51', 'FtIT5-d2VzOnxamf4MG2Vd2ay2rD', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#测试用户', '10', '3', '3', '2023-11-04 16:36:19', '14');
INSERT INTO `video` VALUES ('52', 'Ft_38c5AKTg_9ql_s3yo3M5RnSqg', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#生活', '10', '3', '3', '2023-11-04 16:36:19', '3');
INSERT INTO `video` VALUES ('53', 'Fto5o-5ea0sNMlW_75VgGJCv2AcJ', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#知识分享官', '10', '3', '3', '2023-11-04 16:36:19', '7');
INSERT INTO `video` VALUES ('54', 'FuCj9gjFFFnI99shir8ufyoI1ptx', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#解压', '10', '3', '3', '2023-11-04 16:36:19', '8');
INSERT INTO `video` VALUES ('55', 'Fujue9FN1k-RzPmQKMjSXWz1Uemw', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#美妆', '10', '3', '3', '2023-11-04 16:36:19', '13');
INSERT INTO `video` VALUES ('56', 'Fv5wxvLRaPTtOhuM4nVgmCKar3Wf', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#测试用户', '10', '3', '3', '2023-11-04 16:36:19', '14');
INSERT INTO `video` VALUES ('57', 'Fv5xkTtb24xk3iniWsEhsfPdr1LK', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#测试用户', '10', '3', '3', '2023-11-04 16:36:19', '14');
INSERT INTO `video` VALUES ('58', 'FvA8FVdlSPZ-ClDxJ4j8xk343fYT', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#运动', '10', '3', '3', '2023-11-04 16:36:19', '5');
INSERT INTO `video` VALUES ('59', 'FvC1qiHSfgBepw7rm6z2SEyROHjb', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#美女', '10', '3', '3', '2023-11-04 16:36:19', '2');
INSERT INTO `video` VALUES ('60', 'FvLL0ny7vKrcsQ6-_UH0YWellVGs', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#运动', '10', '3', '3', '2023-11-04 16:36:19', '5');
INSERT INTO `video` VALUES ('61', 'FvSET2Ypm3Hz2RzxK__YfCyYJzc_', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#生活', '10', '3', '3', '2023-11-04 16:36:19', '3');
INSERT INTO `video` VALUES ('62', 'FvWF1XhpnzWBKxHGgcX4fXt50tcn', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#帅哥', '10', '3', '3', '2023-11-04 16:36:19', '12');
INSERT INTO `video` VALUES ('63', 'Fves5HKM3CVsERn2eMbdm1w4GW3_', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#搞笑', '10', '3', '3', '2023-11-04 16:36:19', '11');
INSERT INTO `video` VALUES ('64', 'lgF9ZOvDF-33OvMxA_-f-ARkOmtZ', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#新闻热点', '10', '3', '3', '2023-11-04 16:36:19', '9');
INSERT INTO `video` VALUES ('65', 'lgNDfJJzwet1nQg4_SBhNO-FnRCs', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#知识分享官', '10', '3', '3', '2023-11-04 16:36:19', '7');
INSERT INTO `video` VALUES ('66', 'lgVaQYWk3-TJDrdbAXalBu5K4xRF', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#生活', '10', '3', '3', '2023-11-04 16:36:19', '3');
INSERT INTO `video` VALUES ('67', 'lgwu-BOy-cp193JtiVAckfDHZrpK', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#科技', '10', '3', '3', '2023-11-04 16:36:19', '6');
INSERT INTO `video` VALUES ('68', 'lgwv5vg3HrMWlj2oqOWxmpYwZClJ', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#美女', '10', '3', '3', '2023-11-04 16:36:19', '2');
INSERT INTO `video` VALUES ('69', 'lgxdhHYYy17XhcZF9KoiMIyolZnB', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#测试用户', '10', '3', '3', '2023-11-04 16:36:19', '14');
INSERT INTO `video` VALUES ('70', 'lgzcBwkKLvr0eYrxnHyaIzmxpIjM', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#钓鱼', '10', '3', '3', '2023-11-04 16:36:19', '4');
INSERT INTO `video` VALUES ('71', 'lh2jOmVxiMk_VIJQj5U6MBxXZk7b', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#科技', '10', '3', '3', '2023-11-04 16:36:19', '6');
INSERT INTO `video` VALUES ('72', 'lh6lk02nV_BmSEcWJ0QOeODogm0R', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#科技', '10', '3', '3', '2023-11-04 16:36:19', '6');
INSERT INTO `video` VALUES ('73', 'lhCkso8ivNy8xe8vaPr86V8zaell', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#新闻热点', '10', '3', '3', '2023-11-04 16:36:19', '9');
INSERT INTO `video` VALUES ('74', 'lhEesyYgoX1SjU0-CoBIunSfrnOl', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#宠物', '10', '3', '3', '2023-11-04 16:36:19', '10');
INSERT INTO `video` VALUES ('75', 'lhPRoQXNx_H9WSjdVqeE5pObBCi7', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#搞笑', '10', '3', '3', '2023-11-04 16:36:19', '11');
INSERT INTO `video` VALUES ('76', 'lhcOqx9afr-jVE_REYkuw-QXQlIO', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#知识分享官', '10', '3', '3', '2023-11-04 16:36:19', '7');
INSERT INTO `video` VALUES ('77', 'lhd6lIWzPfx3sy04igkpjS0FUKxC', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#宠物', '10', '3', '3', '2023-11-04 16:36:19', '10');
INSERT INTO `video` VALUES ('78', 'lhekpkNM6IlI1dULIJ90r0vUVkQV', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#新闻热点', '10', '3', '3', '2023-11-04 16:36:19', '9');
INSERT INTO `video` VALUES ('79', 'lhf_Q88klC2XWMp1IdRI26ABJTtT', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#美女', '10', '3', '3', '2023-11-04 16:36:19', '2');
INSERT INTO `video` VALUES ('80', 'lhj_smis2iMXE_WM6xh068BPSqyz', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#新闻热点', '10', '3', '3', '2023-11-04 16:36:19', '9');
INSERT INTO `video` VALUES ('81', 'liEl4b4CwMt0zEKbl0OJ-Yz52NaG', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#美妆', '10', '3', '3', '2023-11-04 16:36:19', '13');
INSERT INTO `video` VALUES ('82', 'liHR89UBTQG9EwCN3GgfQX5sgf9u', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#美妆', '10', '3', '3', '2023-11-04 16:36:19', '13');
INSERT INTO `video` VALUES ('83', 'liJ5BE0R1WGX5c499c_BPLtgbvEs', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#新闻热点', '10', '3', '3', '2023-11-04 16:36:19', '9');
INSERT INTO `video` VALUES ('84', 'liKRYfqz4vGDGsi3KHHwKJrZ82X_', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#生活', '10', '3', '3', '2023-11-04 16:36:19', '3');
INSERT INTO `video` VALUES ('85', 'liXA3YC_ZQ2SD4LVMuQfQgGRlx9h', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#科技', '10', '3', '3', '2023-11-04 16:36:19', '6');
INSERT INTO `video` VALUES ('86', 'lig3hj39o9iOFSm96GHrGq8bYPKk', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#科技', '10', '3', '3', '2023-11-04 16:36:19', '6');
INSERT INTO `video` VALUES ('87', 'ligfsxIOx6MyvYfahzm65vRcBWWg', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#测试用户', '10', '3', '3', '2023-11-04 16:36:19', '14');
INSERT INTO `video` VALUES ('88', 'linN5YancpI__fiuBsDc0t6_Yvdj', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#帅哥', '10', '3', '3', '2023-11-04 16:36:19', '12');
INSERT INTO `video` VALUES ('89', 'lisbto8OArT9G-1kP7vK1BURZ8NW', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#美妆', '10', '3', '3', '2023-11-04 16:36:19', '13');
INSERT INTO `video` VALUES ('90', 'lj0LjhBwsOVwq8hRzfzoxAONlJo-', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#运动', '10', '3', '3', '2023-11-04 16:36:19', '5');
INSERT INTO `video` VALUES ('91', 'ljP5kREyyhgsYc_GWXZcr1YVpyJo', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#新闻热点', '10', '3', '3', '2023-11-04 16:36:19', '9');
INSERT INTO `video` VALUES ('92', 'ljeXTmEtk8m8UdJd22_QKEja2RyD', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#测试用户', '10', '3', '3', '2023-11-04 16:36:19', '14');
INSERT INTO `video` VALUES ('93', 'ljfkWrh0cUqJOK6tnDp6eDBVigrA', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#运动', '10', '3', '3', '2023-11-04 16:36:19', '5');
INSERT INTO `video` VALUES ('94', 'ljqo45KSe4a8lIrsmY8fyA4Y0Yrh', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#美妆', '10', '3', '3', '2023-11-04 16:36:19', '13');
INSERT INTO `video` VALUES ('95', 'ljrKh0FlEST0HabSRn2wSGufiowu', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#解压', '10', '3', '3', '2023-11-04 16:36:19', '8');
INSERT INTO `video` VALUES ('96', 'ljzWkpSWpYRuKPE6pTlX_EROTqhP', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#知识分享官', '10', '3', '3', '2023-11-04 16:36:19', '7');
INSERT INTO `video` VALUES ('97', 'lk4eCc0DUnE4tjPSAYEEalURqT2t', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#美女', '10', '3', '3', '2023-11-04 16:36:19', '2');
INSERT INTO `video` VALUES ('98', 'lkHOuc74deGDxcK79K5o94mZq51Y', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#宠物', '10', '3', '3', '2023-11-04 16:36:19', '10');
INSERT INTO `video` VALUES ('99', 'lkQfIgqmExVVRpw8wZvjlFtcVbX-', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#运动', '10', '3', '3', '2023-11-04 16:36:19', '5');
INSERT INTO `video` VALUES ('100', 'lkn9OaoOQcK3JUH_-YaaqJwzRkDN', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#解压', '10', '3', '3', '2023-11-04 16:36:19', '8');
INSERT INTO `video` VALUES ('101', 'll2mdpmAoZkAzKrKLrApTc4ePRIK', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#解压', '10', '3', '3', '2023-11-04 16:36:19', '8');
INSERT INTO `video` VALUES ('102', 'llBh5_IAGmZ6fQEZ170PBZooRSm8', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#知识分享官', '10', '3', '3', '2023-11-04 16:36:19', '7');
INSERT INTO `video` VALUES ('103', 'llFX0ZmfKEbEB8GaGgmVmNQ5KFR5', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#运动', '10', '3', '3', '2023-11-04 16:36:19', '5');
INSERT INTO `video` VALUES ('104', 'llKO0yYqCMik44cTCacDr2-WVGGz', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#搞笑', '10', '3', '3', '2023-11-04 16:36:19', '11');
INSERT INTO `video` VALUES ('105', 'llUxWa6LbOcfJo6pAREM7y6L6VXJ', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#解压', '10', '3', '3', '2023-11-04 16:36:19', '8');
INSERT INTO `video` VALUES ('106', 'llm4cHk97FqGJRj1YJLBOMHVBFKv', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#美女', '10', '3', '3', '2023-11-04 16:36:19', '2');
INSERT INTO `video` VALUES ('107', 'llpCD5mnuolMTlSFCXv6H4OuilHo', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#美妆', '10', '3', '3', '2023-11-04 16:36:19', '13');
INSERT INTO `video` VALUES ('108', 'llwu67RSO9Q4IeMPkGEmhsMBAZkE', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#美妆', '10', '3', '3', '2023-11-04 16:36:19', '13');
INSERT INTO `video` VALUES ('109', 'llzFn8WNYBXTMluHPtMo7dzW0yJ1', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#钓鱼', '10', '3', '3', '2023-11-04 16:36:19', '4');
INSERT INTO `video` VALUES ('110', 'lm2SLxFWLB44WIj0fhEjnlmWVzOW', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#搞笑', '10', '3', '3', '2023-11-04 16:36:19', '11');
INSERT INTO `video` VALUES ('111', 'lmFn9vCgDy0gNB3SeCrmhWvEPFZq', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#美妆', '10', '3', '3', '2023-11-04 16:36:19', '13');
INSERT INTO `video` VALUES ('112', 'lmMewl_oXjIPtQPmfQ26JDQ-VQ5u', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#测试用户', '10', '3', '3', '2023-11-04 16:36:19', '14');
INSERT INTO `video` VALUES ('113', 'lmYoKZUFJYmi2hOG87gVJcwbEE41', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#知识分享官', '10', '3', '3', '2023-11-04 16:36:19', '7');
INSERT INTO `video` VALUES ('114', 'lmZg6u-JOP3y2yuD3QoGJH-g7nbg', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#解压', '10', '3', '3', '2023-11-04 16:36:19', '8');
INSERT INTO `video` VALUES ('115', 'lmkdk8Xzv9L8gXvaszBY7Y6IizSU', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#科技', '10', '3', '3', '2023-11-04 16:36:19', '6');
INSERT INTO `video` VALUES ('116', 'lmlr5ERl0Jjxj_JaNvMeeJy2A4CH', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#美女', '10', '3', '3', '2023-11-04 16:36:19', '2');
INSERT INTO `video` VALUES ('117', 'lmqvoijGINqATRhqWFP8YQ5Gmw-L', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#搞笑', '10', '3', '3', '2023-11-04 16:36:19', '11');
INSERT INTO `video` VALUES ('118', 'lmsQ2A040Ifb5v4ehKvtvX18QVDA', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#钓鱼', '10', '3', '3', '2023-11-04 16:36:19', '4');
INSERT INTO `video` VALUES ('119', 'lnGyoSQU7I76Yn597V0KITb0ir_F', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#生活', '10', '3', '3', '2023-11-04 16:36:19', '3');
INSERT INTO `video` VALUES ('120', 'lnUHIIrvMv2KpTG_016_ulRadQL4', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#解压', '10', '3', '3', '2023-11-04 16:36:19', '8');
INSERT INTO `video` VALUES ('121', 'lnjJ37vYWskMjNUQNyrIYe5avq3f', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#新闻热点', '10', '3', '3', '2023-11-04 16:36:19', '9');
INSERT INTO `video` VALUES ('122', 'lnoFsjXwK0hdth3q4b9cxfok2J80', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#生活', '10', '3', '3', '2023-11-04 16:36:19', '3');
INSERT INTO `video` VALUES ('123', 'lntZnW3lQxjxqOvNa5_Gf38hNS61', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#宠物', '10', '3', '3', '2023-11-04 16:36:19', '10');
INSERT INTO `video` VALUES ('124', 'lnxJB8osCGBy5X7ar3xvDwx2VVPZ', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#帅哥', '10', '3', '3', '2023-11-04 16:36:19', '12');
INSERT INTO `video` VALUES ('125', 'loFjTXQo8dq5WCztnGZTK8gQ62oi', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#搞笑', '10', '3', '3', '2023-11-04 16:36:19', '11');
INSERT INTO `video` VALUES ('126', 'loItNJJnudatzc0sQB0BZ7RaLzn1', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#帅哥', '10', '3', '3', '2023-11-04 16:36:19', '12');
INSERT INTO `video` VALUES ('127', 'loWemLZItq1J_KqPCBiZ0BjJcE84', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#美妆', '10', '3', '3', '2023-11-04 16:36:19', '13');
INSERT INTO `video` VALUES ('128', 'loXs6K_TkIDgFuud35vNs7AKw7H2', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#知识分享官', '10', '3', '3', '2023-11-04 16:36:19', '7');
INSERT INTO `video` VALUES ('129', 'lofTrY5NuEBRGzixt5J9RC05zTP5', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#搞笑', '10', '3', '3', '2023-11-04 16:36:19', '11');
INSERT INTO `video` VALUES ('130', 'loh2ZCbkd3E3iah_6EPDXmZKtskZ', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#搞笑', '10', '3', '3', '2023-11-04 16:36:19', '11');
INSERT INTO `video` VALUES ('131', 'loyW0HjdGMts62oTcuYKmPA2k5IG', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#测试用户', '10', '3', '3', '2023-11-04 16:36:19', '14');
INSERT INTO `video` VALUES ('132', 'lpnBKVgPV_D5jHbHv3P6OCTZN9I_', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#解压', '10', '3', '3', '2023-11-04 16:36:19', '8');
INSERT INTO `video` VALUES ('133', 'lppeb_SZBZjmAUri-gOs9kUfp9iq', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#知识分享官', '10', '3', '3', '2023-11-04 16:36:19', '7');
INSERT INTO `video` VALUES ('134', 'lpy7qWIX3VqAAwXTJKSsVwKh3Yh4', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#解压', '10', '3', '3', '2023-11-04 16:36:19', '8');
INSERT INTO `video` VALUES ('135', 'lq6l-uvC4EEOqlg4n4gxuG6vZVjJ', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#新闻热点', '10', '3', '3', '2023-11-04 16:36:19', '9');
INSERT INTO `video` VALUES ('136', 'lqDQoaTiUcTbX5ia4va5dY9wnvU-', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#测试用户', '10', '3', '3', '2023-11-04 16:36:19', '14');
INSERT INTO `video` VALUES ('137', 'lqDqNLjTfN6PllPK55iE8D2iQ991', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#美妆', '10', '3', '3', '2023-11-04 16:36:19', '13');
INSERT INTO `video` VALUES ('138', 'lqX6sfKiHiJwNBZbFDCJHPTrJUOC', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#钓鱼', '10', '3', '3', '2023-11-04 16:36:19', '4');
INSERT INTO `video` VALUES ('139', 'lqXvdA16bLNQ4EaPDE24sZ6irkuW', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#帅哥', '10', '3', '3', '2023-11-04 16:36:19', '12');
INSERT INTO `video` VALUES ('140', 'lqnGkem4oTOIx72NPMH6lyJDHHOk', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#钓鱼', '10', '3', '3', '2023-11-04 16:36:19', '4');
INSERT INTO `video` VALUES ('141', 'lqt6w49l2R6VQrKTNMfoq8_SuuSa', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#测试用户', '10', '3', '3', '2023-11-04 16:36:19', '14');
INSERT INTO `video` VALUES ('142', 'lr0bzjnKJ1gLZP7iP-4dHH8uV84e', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#测试用户', '10', '3', '3', '2023-11-04 16:36:19', '14');
INSERT INTO `video` VALUES ('143', 'lrBnpSxPZBUTbbeMfxKu7mPN7Xqv', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#科技', '10', '3', '3', '2023-11-04 16:36:19', '6');
INSERT INTO `video` VALUES ('144', 'lrM7Dt5rIGn_7xzNEoKc9JhZitSS', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#钓鱼', '10', '3', '3', '2023-11-04 16:36:19', '4');
INSERT INTO `video` VALUES ('145', 'lrcQpxAAyr_RhJnRRrnhqoTqRoLn', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#帅哥', '10', '3', '3', '2023-11-04 16:36:19', '12');
INSERT INTO `video` VALUES ('146', 'lrnH-_8DuQVn3cMze9XAARS5PhLq', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#科技', '10', '3', '3', '2023-11-04 16:36:19', '6');
INSERT INTO `video` VALUES ('147', 'lrxNdIGeHbkxvyovouFy0ApKBiPT', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#运动', '10', '3', '3', '2023-11-04 16:36:19', '5');
INSERT INTO `video` VALUES ('148', 'ls9aQnyuuewu4BJoYlEmD6jW9M07', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#美妆', '10', '3', '3', '2023-11-04 16:36:19', '13');
INSERT INTO `video` VALUES ('149', 'lsB4bVPyAnSmGcRosoqAnop9mPih', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#帅哥', '10', '3', '3', '2023-11-04 16:36:19', '12');
INSERT INTO `video` VALUES ('150', 'lsWiFwo_hIpAwFYqt4NlavwjDi8N', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#科技', '10', '3', '3', '2023-11-04 16:36:19', '6');
INSERT INTO `video` VALUES ('151', 'lsnRvLGbHKz1N1r3-uhaoVp4DKaS', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#测试用户', '10', '3', '3', '2023-11-04 16:36:19', '14');
INSERT INTO `video` VALUES ('152', 'lsu7TUISW6KZC51b-9jZ8CHRcpty', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#钓鱼', '10', '3', '3', '2023-11-04 16:36:19', '4');
INSERT INTO `video` VALUES ('153', 'lt3V1obljjyLPkyo04kIDRoz0YF-', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#测试用户', '10', '3', '3', '2023-11-04 16:36:19', '14');
INSERT INTO `video` VALUES ('154', 'lt3a64nAYloQzsBOmZ7_1OdK-xii', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#生活', '10', '3', '3', '2023-11-04 16:36:19', '3');
INSERT INTO `video` VALUES ('155', 'ltJhgMquF6Qh1F3E82TdIAD_3WU0', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#新闻热点', '10', '3', '3', '2023-11-04 16:36:19', '9');
INSERT INTO `video` VALUES ('156', 'lt_76oufXPgnDQrwUmS-CqPTd3D5', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#帅哥', '10', '3', '3', '2023-11-04 16:36:19', '12');
INSERT INTO `video` VALUES ('157', 'ltbAzFnKPEu3t3Pn83uUxxHvg-d9', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#宠物', '10', '3', '3', '2023-11-04 16:36:19', '10');
INSERT INTO `video` VALUES ('158', 'ltrlyVvmc22SsbYeyj1yP-CRE6tO', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#帅哥', '10', '3', '3', '2023-11-04 16:36:19', '12');
INSERT INTO `video` VALUES ('159', 'lu2T20QKUcEoGRlsXSeIrHq170dd', '藏族老六_#搞笑视频_#谢谢你妈妈_#集结吧光合创作者_@快手热点(O3xddgkd5fav5if9)', '', '0', '0', '0', '#运动', '10', '3', '3', '2023-11-04 16:36:19', '5');
INSERT INTO `video` VALUES ('171', 'FjDVk8WePQqvrq4gP9vts6sW9eN7', '这是一条测试视频', 'https://sky-itcast.oss-cn-beijing.aliyuncs.com/76752350-2121-44d2-b477-10791c23a8ec.png', '0', '0', '0', '#测试', '1', '1', '3', '2023-11-07 10:18:54', '1');
INSERT INTO `video` VALUES ('172', 'FjDVk8WePQqvrq4gP9vts6sW9eN7', '这是一条测试视频', 'https://sky-itcast.oss-cn-beijing.aliyuncs.com/76752350-2121-44d2-b477-10791c23a8ec.png', '0', '0', '0', '#测试', '1', '1', '3', '2023-11-07 10:19:21', '1');

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
