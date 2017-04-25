/*
Navicat MySQL Data Transfer

Source Server         : mydatebase
Source Server Version : 50087
Source Host           : localhost:3306
Source Database       : sifei

Target Server Type    : MYSQL
Target Server Version : 50087
File Encoding         : 65001

Date: 2017-04-25 09:09:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `toid` int(20) NOT NULL auto_increment,
  `departmentname` varchar(20) collate utf8_bin default NULL,
  `managerid` int(20) default NULL,
  PRIMARY KEY  (`toid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '产品部', '107');
INSERT INTO `department` VALUES ('2', '市场部', '110');
INSERT INTO `department` VALUES ('7', '后勤部', '111');
INSERT INTO `department` VALUES ('8', '营销部', '114');
INSERT INTO `department` VALUES ('9', '测试部', '115');
INSERT INTO `department` VALUES ('10', '销售部', '116');
INSERT INTO `department` VALUES ('11', '推广部', '117');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(20) NOT NULL auto_increment COMMENT '主键，自动增长',
  `from_id` int(20) NOT NULL COMMENT '发信人，来自员工表',
  `to_id` int(20) NOT NULL COMMENT '收信人，来自员工表',
  `content` varchar(250) collate utf8_bin default NULL COMMENT '信息内容',
  `isread` varchar(20) collate utf8_bin default NULL COMMENT '是否已读，0----未读  1---已读',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '107', '115', '4', '0');
INSERT INTO `message` VALUES ('2', '110', '116', 'FHGDR', '1');
INSERT INTO `message` VALUES ('8', '11', '11', '君生你未生', '1');
INSERT INTO `message` VALUES ('9', '22', '33', '我生君已老', '1');
INSERT INTO `message` VALUES ('10', '33', '22', '君恨我生迟', '22');
INSERT INTO `message` VALUES ('11', '4415', '55', '我恨君生早', '22');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `toid` int(20) NOT NULL auto_increment COMMENT '主键，自动增长',
  `custname` varchar(20) collate utf8_bin default NULL COMMENT '客户姓名',
  `custaddress` varchar(50) collate utf8_bin default NULL COMMENT '客户地址',
  `custphone` varchar(20) collate utf8_bin default NULL COMMENT '客户电话',
  `custemail` varchar(20) collate utf8_bin default NULL COMMENT '客户邮箱',
  `odertime` varchar(30) collate utf8_bin default NULL COMMENT '订购时间',
  `productid` int(50) default NULL COMMENT '订购的产品，来自产品表',
  `productcount` int(50) default NULL COMMENT '订购数目',
  `money` float(30,0) default NULL COMMENT '所付金额',
  `createtime` varchar(30) collate utf8_bin default NULL COMMENT '订单新增时间',
  `userid` int(20) default NULL COMMENT '所属销售员工，来自员工表',
  PRIMARY KEY  (`toid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '26162', '3364', '465', '11667', '2286', '3306', '46', '5', '466', '107');
INSERT INTO `orders` VALUES ('2', '1111', '2222', '33', '11', '22', '11', '11', '11', '11', '110');
INSERT INTO `orders` VALUES ('3', '2', '2', '2', '2', '2', '2', '2', '2', '2', '111');
INSERT INTO `orders` VALUES ('5', '223', '3', '3', 'rr', 'r', '22', '3', '4', 'r', '114');
INSERT INTO `orders` VALUES ('6', '11', '11', '11', '11', '111', '11', '11', '11', '11', '11');
INSERT INTO `orders` VALUES ('8', '11', '11', '11', '1', '11', '11', '11', '11', '11', '11');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `toid` int(20) NOT NULL auto_increment COMMENT '主键，自动增长',
  `productname` varchar(20) collate utf8_bin default NULL COMMENT '产品名称',
  `price` float(20,0) default NULL COMMENT '单价',
  PRIMARY KEY  (`toid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '2112', '3');
INSERT INTO `product` VALUES ('2', '11', '22');
INSERT INTO `product` VALUES ('6', '娜娜56', '56');
INSERT INTO `product` VALUES ('8', '2017新款T恤5555', '116');
INSERT INTO `product` VALUES ('9', '热热', '66');
INSERT INTO `product` VALUES ('10', '一样', '88');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `toid` int(20) NOT NULL auto_increment COMMENT '主键，自动增长',
  `username` varchar(20) collate utf8_bin default NULL COMMENT '账号',
  `password` varchar(20) collate utf8_bin default NULL COMMENT '密码',
  `realname` varchar(20) collate utf8_bin default NULL COMMENT '真实姓名',
  `sex` varchar(20) collate utf8_bin default NULL COMMENT '性别，1表示男，0表示女',
  `birthday` date default NULL,
  `email` varchar(20) collate utf8_bin default NULL COMMENT '电子邮箱',
  `address` varchar(50) collate utf8_bin default NULL COMMENT '住址',
  `telphone` varchar(20) collate utf8_bin default NULL COMMENT '电话号码',
  `qq` varchar(20) collate utf8_bin default NULL COMMENT 'qq号码',
  `salary` float(50,0) default NULL COMMENT '薪水',
  `departid` int(40) default NULL COMMENT '所属部门，来自department表',
  `role` varchar(10) character set utf8 default NULL COMMENT 'admin---管理员  manager---部门经理   saler---普通员工（销售人员）',
  `image_url` varchar(50) collate utf8_bin default NULL COMMENT '头像路径',
  PRIMARY KEY  (`toid`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('107', 'admin', '11', '常小兵', '1', '2017-04-06', '1', '1', '1', '11', '1', '1', '12', null);
INSERT INTO `user` VALUES ('110', 'zhangmo', '367', '宇文将', '37', '2017-04-14', '37', '37', '37', '37', '3', '2', '37', null);
INSERT INTO `user` VALUES ('111', 'guest', '8', '米尔', '8', '2017-04-26', '8', '8', '8', '8', '8', '7', '8', null);
INSERT INTO `user` VALUES ('114', 'test', 'er\'t', '猫猫', '5', '2017-04-22', '5', '5', '5', '5', '5', '8', '5', null);
INSERT INTO `user` VALUES ('115', 'test23', '66222', '童言童语r334', '24', '2012-05-06', '266', '277', '288', '29', '2', '9', '20', null);
INSERT INTO `user` VALUES ('116', 'test24', '66222', '童言童语r335', '24', '2012-05-06', '266', '277', '288', '29', '2', '10', '20', null);
INSERT INTO `user` VALUES ('117', 'test235', '66222', '童言童语r336', '24', '2012-05-06', '266', '277', '288', '29', '2', '11', '20', null);
INSERT INTO `user` VALUES ('118', 'test236', '66222', '童言童语r337', '24', '2012-05-06', '266', '277', '288', '29', '2', '12', '20', null);
INSERT INTO `user` VALUES ('119', 'test237', '66222', '童言童语r338', '24', '2012-05-06', '266', '277', '288', '29', '2', '13', '20', null);
