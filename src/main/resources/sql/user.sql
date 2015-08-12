/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : business

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2015-08-12 09:32:45
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `enable` int(11) DEFAULT '1' COMMENT '账号是否有限 1. 是 0.否',
  `community_id` int(11) DEFAULT '0' COMMENT '区小id',
  `email` varchar(100) DEFAULT 'jobs@apple.com' COMMENT '电子邮箱',
  `mobile` varchar(20) DEFAULT '1' COMMENT '手机',
  `real_name` varchar(100) NOT NULL COMMENT '真实姓名',
  `person_id` varchar(50) DEFAULT '1' COMMENT '身份证号',
  `sex` varchar(10) DEFAULT '男' COMMENT '性别',
  `birthday` varchar(50) DEFAULT NULL COMMENT '生日',
  `create_date` datetime DEFAULT NULL COMMENT '建创时间',
  `head_pic_id` bigint(20) DEFAULT '0' COMMENT '头像id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'xianzaishi', '123123', '1', '1', 'xian@gmail.com', '186', '张三', '150402', '男', '2014-11-20', '2014-11-07 00:00:00', '11');
INSERT INTO `user` VALUES ('3', 'zxczxc', 'admin', '1', '1', 'zxcz', 'czxc', 'zxczxc', 'zxczxc', '男', '2014-11-11', '2014-11-07 00:00:00', '19');
INSERT INTO `user` VALUES ('4', 'zxczxcasdxasd', 'admasdin', '1', '1', 'asd', 'asd', 'asd', 'asd', '男', '2014-11-07', '2014-11-07 00:00:00', '1');
INSERT INTO `user` VALUES ('5', 'qweqwe', 'admin', '1', '1', 'qweqwe', 'qweqwe', 'qweqwe', 'qweqwe', '男', '2014-11-27', '2014-11-07 00:00:00', '0');
INSERT INTO `user` VALUES ('6', 'qweqwesda', 'admin', '1', '1', 'asd', 'asd', 'zxcasd', 'asd', '男', '2014-11-07', '2014-11-07 00:00:00', '1');
INSERT INTO `user` VALUES ('7', 'zaqzaq', 'admin', '1', '1', 'asd', 'asd', 'asd', 'asd', '男', '2014-11-07', '2014-11-07 00:00:00', '1');
INSERT INTO `user` VALUES ('8', 'cvbdf', 'admin', '1', '1', 'sdf', 'sdf', 'dsf', 'df', '男', '2014-11-07', '2014-11-07 00:00:00', '1');
INSERT INTO `user` VALUES ('9', 'ertert', 'admin', '1', '1', 'ert', 'ert', 'ert', 'ert', '男', '2014-11-07', '2014-11-07 00:00:00', '1');
INSERT INTO `user` VALUES ('10', 'ertert', 'admin', '1', '1', 'ert', 'ert', 'ert', 'ert', '男', '2014-11-07', '2014-11-07 00:00:00', '1');
INSERT INTO `user` VALUES ('11', 'fghfgh', 'admin', '1', '1', 'fgh', 'fgh', 'fgh', 'fgh', '男', '2014-11-07', '2014-11-07 00:00:00', '1');
INSERT INTO `user` VALUES ('12', 'rtyrty', 'admin', null, '1', 'rty', 'rty', 'rty', 'rty', '男', '2014-11-07', '2014-11-07 00:00:00', '1');
INSERT INTO `user` VALUES ('13', '用户名', '用户名用户名', '1', '0', '用户名', '用户名', '用户名', '用户名', '男', null, null, '0');
INSERT INTO `user` VALUES ('14', 'asdasdasdasdzxc', 'admin', '1', '0', 'asd', 'asd', 'asdasd', 'asd', '男', null, null, '0');
INSERT INTO `user` VALUES ('15', '用户名', '用户名用户名用户名', '1', '0', '用户名', '用户名', '用户名', '用户名', '男', null, '2014-12-02 16:07:39', '0');
