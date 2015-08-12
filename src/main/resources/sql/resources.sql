/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : business

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2015-08-12 09:32:38
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `resources`
-- ----------------------------
DROP TABLE IF EXISTS `resources`;
CREATE TABLE `resources` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `enable` int(11) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `url` varchar(500) DEFAULT NULL,
  `desc` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resources
-- ----------------------------
INSERT INTO `resources` VALUES ('1', '1', 'url', '/repair/index/page/*', '设备报修模块');
INSERT INTO `resources` VALUES ('2', '1', 'url', '/repair/index/handled/page/*', '设备报修模块');
INSERT INTO `resources` VALUES ('3', '1', 'url', '/repair/detail/id/*', '设备报修模块');
INSERT INTO `resources` VALUES ('4', '1', 'url', '/repair/reply', '设备报修模块');
INSERT INTO `resources` VALUES ('5', '1', 'url', '/user//index/page/*', '用户模块');
INSERT INTO `resources` VALUES ('6', '1', 'url', '/user/add', '用户模块');
INSERT INTO `resources` VALUES ('7', '1', 'url', '/user/add/submit', '用户模块');
INSERT INTO `resources` VALUES ('8', '1', 'url', '/user/edit/id/*', '用户模块');
INSERT INTO `resources` VALUES ('9', '1', 'url', '/user/edit/submit', '用户模块');
INSERT INTO `resources` VALUES ('10', '1', 'url', '/user/upload/headpic/user/id/*', '用户模块');
INSERT INTO `resources` VALUES ('11', '1', 'url', '/user/head/pic/id/*', '用户模块');
INSERT INTO `resources` VALUES ('12', '1', 'url', '/user/delete/id/*', '用户模块');
