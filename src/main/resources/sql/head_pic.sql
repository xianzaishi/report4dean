/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : business

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2015-08-12 09:32:11
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `head_pic`
-- ----------------------------
DROP TABLE IF EXISTS `head_pic`;
CREATE TABLE `head_pic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `path` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of head_pic
-- ----------------------------
INSERT INTO `head_pic` VALUES ('1', '/files/2014/11/13170155/Lighthouse.jpg');
INSERT INTO `head_pic` VALUES ('2', '/files/2014/11/13171245/Lighthouse.jpg');
INSERT INTO `head_pic` VALUES ('3', '/files/2014/11/13171343/Desert.jpg');
INSERT INTO `head_pic` VALUES ('4', '/files/2014/11/13172917/Lighthouse.jpg');
INSERT INTO `head_pic` VALUES ('5', '/files/2014/11/13172942/Lighthouse.jpg');
INSERT INTO `head_pic` VALUES ('6', '/files/2014/11/13173452/Lighthouse.jpg');
INSERT INTO `head_pic` VALUES ('7', '/files/2014/11/13173544Koala.jpg');
INSERT INTO `head_pic` VALUES ('8', '/files/2014/11/13173655Lighthouse.jpg');
INSERT INTO `head_pic` VALUES ('9', '/files/2014/11/13173813/Lighthouse.jpg');
INSERT INTO `head_pic` VALUES ('10', '/files/2014/11/19095128/Koala.jpg');
INSERT INTO `head_pic` VALUES ('11', '/files/2014/12/02152431/Hydrangeas.jpg');
INSERT INTO `head_pic` VALUES ('12', '/files/2015/01/21103206/Koala.jpg');
INSERT INTO `head_pic` VALUES ('13', '/files/2015/01/21103432/Koala.jpg');
INSERT INTO `head_pic` VALUES ('14', '/files/2015/01/21104219/Koala.jpg');
INSERT INTO `head_pic` VALUES ('15', '/files/2015/01/21113132/Koala.jpg');
INSERT INTO `head_pic` VALUES ('16', '/files/2015/01/21113132/Koala.jpg');
INSERT INTO `head_pic` VALUES ('17', '/files/2015/01/21113304/Koala.jpg');
INSERT INTO `head_pic` VALUES ('18', '/files/2015/01/21113304/Koala.jpg');
INSERT INTO `head_pic` VALUES ('19', '/files/2015/01/24091431/Koala.jpg');
