/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : business

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2015-08-12 09:32:32
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `resource_role`
-- ----------------------------
DROP TABLE IF EXISTS `resource_role`;
CREATE TABLE `resource_role` (
  `resource_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`resource_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource_role
-- ----------------------------
INSERT INTO `resource_role` VALUES ('1', '1');
INSERT INTO `resource_role` VALUES ('1', '2');
INSERT INTO `resource_role` VALUES ('2', '1');
INSERT INTO `resource_role` VALUES ('2', '2');
INSERT INTO `resource_role` VALUES ('3', '1');
INSERT INTO `resource_role` VALUES ('3', '2');
INSERT INTO `resource_role` VALUES ('4', '1');
INSERT INTO `resource_role` VALUES ('4', '2');
INSERT INTO `resource_role` VALUES ('5', '1');
INSERT INTO `resource_role` VALUES ('5', '2');
INSERT INTO `resource_role` VALUES ('6', '1');
INSERT INTO `resource_role` VALUES ('6', '2');
INSERT INTO `resource_role` VALUES ('7', '1');
INSERT INTO `resource_role` VALUES ('7', '2');
INSERT INTO `resource_role` VALUES ('8', '1');
INSERT INTO `resource_role` VALUES ('8', '2');
INSERT INTO `resource_role` VALUES ('9', '1');
INSERT INTO `resource_role` VALUES ('9', '2');
INSERT INTO `resource_role` VALUES ('10', '1');
INSERT INTO `resource_role` VALUES ('10', '2');
INSERT INTO `resource_role` VALUES ('11', '1');
INSERT INTO `resource_role` VALUES ('11', '2');
INSERT INTO `resource_role` VALUES ('12', '1');
INSERT INTO `resource_role` VALUES ('12', '2');
