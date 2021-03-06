/*
Navicat MySQL Data Transfer

Source Server         : 111.230.157.133_3306_ubuntu
Source Server Version : 50721
Source Host           : 111.230.157.133:3306
Source Database       : febs

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-01-28 10:30:38
*/

DROP TABLE IF EXISTS QRTZ_FIRED_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_PAUSED_TRIGGER_GRPS;
DROP TABLE IF EXISTS QRTZ_SCHEDULER_STATE;
DROP TABLE IF EXISTS QRTZ_LOCKS;
DROP TABLE IF EXISTS QRTZ_SIMPLE_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_SIMPROP_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_CRON_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_BLOB_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_JOB_DETAILS;
DROP TABLE IF EXISTS QRTZ_CALENDARS;


CREATE TABLE QRTZ_JOB_DETAILS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    JOB_NAME  VARCHAR(200) NOT NULL,
    JOB_GROUP VARCHAR(200) NOT NULL,
    DESCRIPTION VARCHAR(250) NULL,
    JOB_CLASS_NAME   VARCHAR(250) NOT NULL,
    IS_DURABLE VARCHAR(1) NOT NULL,
    IS_NONCONCURRENT VARCHAR(1) NOT NULL,
    IS_UPDATE_DATA VARCHAR(1) NOT NULL,
    REQUESTS_RECOVERY VARCHAR(1) NOT NULL,
    JOB_DATA BLOB NULL,
    PRIMARY KEY (SCHED_NAME,JOB_NAME,JOB_GROUP)
);

CREATE TABLE QRTZ_TRIGGERS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    JOB_NAME  VARCHAR(200) NOT NULL,
    JOB_GROUP VARCHAR(200) NOT NULL,
    DESCRIPTION VARCHAR(250) NULL,
    NEXT_FIRE_TIME BIGINT(13) NULL,
    PREV_FIRE_TIME BIGINT(13) NULL,
    PRIORITY INTEGER NULL,
    TRIGGER_STATE VARCHAR(16) NOT NULL,
    TRIGGER_TYPE VARCHAR(8) NOT NULL,
    START_TIME BIGINT(13) NOT NULL,
    END_TIME BIGINT(13) NULL,
    CALENDAR_NAME VARCHAR(200) NULL,
    MISFIRE_INSTR SMALLINT(2) NULL,
    JOB_DATA BLOB NULL,
    PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME,JOB_NAME,JOB_GROUP)
        REFERENCES QRTZ_JOB_DETAILS(SCHED_NAME,JOB_NAME,JOB_GROUP)
);

CREATE TABLE QRTZ_SIMPLE_TRIGGERS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    REPEAT_COUNT BIGINT(7) NOT NULL,
    REPEAT_INTERVAL BIGINT(12) NOT NULL,
    TIMES_TRIGGERED BIGINT(10) NOT NULL,
    PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
        REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
);

CREATE TABLE QRTZ_CRON_TRIGGERS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    CRON_EXPRESSION VARCHAR(200) NOT NULL,
    TIME_ZONE_ID VARCHAR(80),
    PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
        REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
);

CREATE TABLE QRTZ_SIMPROP_TRIGGERS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    STR_PROP_1 VARCHAR(512) NULL,
    STR_PROP_2 VARCHAR(512) NULL,
    STR_PROP_3 VARCHAR(512) NULL,
    INT_PROP_1 INT NULL,
    INT_PROP_2 INT NULL,
    LONG_PROP_1 BIGINT NULL,
    LONG_PROP_2 BIGINT NULL,
    DEC_PROP_1 NUMERIC(13,4) NULL,
    DEC_PROP_2 NUMERIC(13,4) NULL,
    BOOL_PROP_1 VARCHAR(1) NULL,
    BOOL_PROP_2 VARCHAR(1) NULL,
    PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
    REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
);

CREATE TABLE QRTZ_BLOB_TRIGGERS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    BLOB_DATA BLOB NULL,
    PRIMARY KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
        REFERENCES QRTZ_TRIGGERS(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
);

CREATE TABLE QRTZ_CALENDARS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    CALENDAR_NAME  VARCHAR(200) NOT NULL,
    CALENDAR BLOB NOT NULL,
    PRIMARY KEY (SCHED_NAME,CALENDAR_NAME)
);

CREATE TABLE QRTZ_PAUSED_TRIGGER_GRPS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    TRIGGER_GROUP  VARCHAR(200) NOT NULL,
    PRIMARY KEY (SCHED_NAME,TRIGGER_GROUP)
);

CREATE TABLE QRTZ_FIRED_TRIGGERS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    ENTRY_ID VARCHAR(95) NOT NULL,
    TRIGGER_NAME VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    INSTANCE_NAME VARCHAR(200) NOT NULL,
    FIRED_TIME BIGINT(13) NOT NULL,
    SCHED_TIME BIGINT(13) NOT NULL,
    PRIORITY INTEGER NOT NULL,
    STATE VARCHAR(16) NOT NULL,
    JOB_NAME VARCHAR(200) NULL,
    JOB_GROUP VARCHAR(200) NULL,
    IS_NONCONCURRENT VARCHAR(1) NULL,
    REQUESTS_RECOVERY VARCHAR(1) NULL,
    PRIMARY KEY (SCHED_NAME,ENTRY_ID)
);

CREATE TABLE QRTZ_SCHEDULER_STATE
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    INSTANCE_NAME VARCHAR(200) NOT NULL,
    LAST_CHECKIN_TIME BIGINT(13) NOT NULL,
    CHECKIN_INTERVAL BIGINT(13) NOT NULL,
    PRIMARY KEY (SCHED_NAME,INSTANCE_NAME)
);

CREATE TABLE QRTZ_LOCKS
  (
    SCHED_NAME VARCHAR(120) NOT NULL,
    LOCK_NAME  VARCHAR(40) NOT NULL,
    PRIMARY KEY (SCHED_NAME,LOCK_NAME)
);

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept` (
  `DEPT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '??????ID',
  `PARENT_ID` bigint(20) NOT NULL COMMENT '????????????ID',
  `DEPT_NAME` varchar(100) NOT NULL COMMENT '????????????',
  `ORDER_NUM` double(20,0) DEFAULT NULL COMMENT '??????',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '????????????',
  `MODIFY_TIME` datetime DEFAULT NULL COMMENT '????????????',
  PRIMARY KEY (`DEPT_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_dept
-- ----------------------------
INSERT INTO `t_dept` VALUES ('1', '0', '?????????', '1', '2018-01-04 15:42:26', '2019-01-05 21:08:27');
INSERT INTO `t_dept` VALUES ('2', '1', '????????????', '1', '2018-01-04 15:42:34', '2019-01-18 00:59:37');
INSERT INTO `t_dept` VALUES ('3', '1', '????????????', '2', '2018-01-04 15:42:29', '2019-01-05 14:09:39');
INSERT INTO `t_dept` VALUES ('4', '0', '?????????', '2', '2018-01-04 15:42:36', '2019-01-23 06:27:56');
INSERT INTO `t_dept` VALUES ('5', '0', '?????????', '3', '2018-01-04 15:42:32', '2019-01-23 06:27:59');
INSERT INTO `t_dept` VALUES ('6', '0', '?????????', '4', '2018-01-04 15:42:38', '2019-01-17 08:15:47');

-- ----------------------------
-- Table structure for t_dict
-- ----------------------------
DROP TABLE IF EXISTS `t_dict`;
CREATE TABLE `t_dict` (
  `DICT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '??????ID',
  `KEYY` bigint(20) NOT NULL COMMENT '???',
  `VALUEE` varchar(100) NOT NULL COMMENT '???',
  `FIELD_NAME` varchar(100) NOT NULL COMMENT '????????????',
  `TABLE_NAME` varchar(100) NOT NULL COMMENT '??????',
  PRIMARY KEY (`DICT_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_dict
-- ----------------------------
INSERT INTO `t_dict` VALUES ('1', '0', '???', 'ssex', 't_user');
INSERT INTO `t_dict` VALUES ('2', '1', '???', 'ssex', 't_user');
INSERT INTO `t_dict` VALUES ('3', '2', '??????', 'ssex', 't_user');
INSERT INTO `t_dict` VALUES ('4', '1', '??????', 'status', 't_user');
INSERT INTO `t_dict` VALUES ('5', '0', '??????', 'status', 't_user');
INSERT INTO `t_dict` VALUES ('6', '0', '??????', 'type', 't_menu');
INSERT INTO `t_dict` VALUES ('7', '1', '??????', 'type', 't_menu');
INSERT INTO `t_dict` VALUES ('30', '0', '??????', 'status', 't_job');
INSERT INTO `t_dict` VALUES ('31', '1', '??????', 'status', 't_job');
INSERT INTO `t_dict` VALUES ('32', '0', '??????', 'status', 't_job_log');
INSERT INTO `t_dict` VALUES ('33', '1', '??????', 'status', 't_job_log');

-- ----------------------------
-- Table structure for t_job
-- ----------------------------
DROP TABLE IF EXISTS `t_job`;
CREATE TABLE `t_job` (
  `JOB_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '??????id',
  `BEAN_NAME` varchar(100) NOT NULL COMMENT 'spring bean??????',
  `METHOD_NAME` varchar(100) NOT NULL COMMENT '?????????',
  `PARAMS` varchar(200) DEFAULT NULL COMMENT '??????',
  `CRON_EXPRESSION` varchar(100) NOT NULL COMMENT 'cron?????????',
  `STATUS` char(2) NOT NULL COMMENT '????????????  0?????????  1?????????',
  `REMARK` varchar(200) DEFAULT NULL COMMENT '??????',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '????????????',
  PRIMARY KEY (`JOB_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_job
-- ----------------------------
INSERT INTO `t_job` VALUES ('1', 'testTask', 'test', 'mrbird', '0/1 * * * * ?1', '1', '????????????????????????', '2018-02-24 16:26:14');
INSERT INTO `t_job` VALUES ('2', 'testTask', 'test1', null, '0/10 * * * * ?', '1', '????????????????????????', '2018-02-24 17:06:23');
INSERT INTO `t_job` VALUES ('3', 'testTask', 'test', 'hello world', '0/1 * * * * ?', '1', '????????????????????????,??????????????????', '2018-02-26 09:28:26');
INSERT INTO `t_job` VALUES ('11', 'testTask', 'test2', null, '0/5 * * * * ?', '1', '????????????', '2018-02-26 11:15:30');

-- ----------------------------
-- Table structure for t_job_log
-- ----------------------------
DROP TABLE IF EXISTS `t_job_log`;
CREATE TABLE `t_job_log` (
  `LOG_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '????????????id',
  `JOB_ID` bigint(20) NOT NULL COMMENT '??????id',
  `BEAN_NAME` varchar(100) NOT NULL COMMENT 'spring bean??????',
  `METHOD_NAME` varchar(100) NOT NULL COMMENT '?????????',
  `PARAMS` varchar(200) DEFAULT NULL COMMENT '??????',
  `STATUS` char(2) NOT NULL COMMENT '????????????    0?????????    1?????????',
  `ERROR` text COMMENT '????????????',
  `TIMES` decimal(11,0) DEFAULT NULL COMMENT '??????(???????????????)',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '????????????',
  PRIMARY KEY (`LOG_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2502 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_job_log
-- ----------------------------
INSERT INTO `t_job_log` VALUES ('2450', '3', 'testTask', 'test', 'hello world', '0', null, '2', '2018-03-20 15:31:52');
INSERT INTO `t_job_log` VALUES ('2451', '3', 'testTask', 'test', 'hello world', '0', null, '0', '2018-03-20 15:31:53');
INSERT INTO `t_job_log` VALUES ('2452', '3', 'testTask', 'test', 'hello world', '0', null, '2', '2018-03-20 15:31:54');
INSERT INTO `t_job_log` VALUES ('2453', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:31:55');
INSERT INTO `t_job_log` VALUES ('2454', '3', 'testTask', 'test', 'hello world', '0', null, '0', '2018-03-20 15:31:56');
INSERT INTO `t_job_log` VALUES ('2455', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:31:57');
INSERT INTO `t_job_log` VALUES ('2456', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:31:59');
INSERT INTO `t_job_log` VALUES ('2457', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:31:59');
INSERT INTO `t_job_log` VALUES ('2458', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:32:00');
INSERT INTO `t_job_log` VALUES ('2459', '3', 'testTask', 'test', 'hello world', '0', null, '0', '2018-03-20 15:32:01');
INSERT INTO `t_job_log` VALUES ('2460', '3', 'testTask', 'test', 'hello world', '0', null, '5', '2018-03-20 15:32:02');
INSERT INTO `t_job_log` VALUES ('2461', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:32:03');
INSERT INTO `t_job_log` VALUES ('2462', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:32:04');
INSERT INTO `t_job_log` VALUES ('2463', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:32:05');
INSERT INTO `t_job_log` VALUES ('2464', '3', 'testTask', 'test', 'hello world', '0', null, '1', '2018-03-20 15:32:06');
INSERT INTO `t_job_log` VALUES ('2465', '11', 'testTask', 'test2', null, '1', 'java.lang.NoSuchMethodException: cc.mrbird.job.task.TestTask.test2()', '0', '2018-03-20 15:32:26');
INSERT INTO `t_job_log` VALUES ('2466', '2', 'testTask', 'test1', null, '0', null, '1', '2018-04-02 15:26:40');
INSERT INTO `t_job_log` VALUES ('2467', '2', 'testTask', 'test1', null, '0', null, '1', '2018-04-02 15:26:50');
INSERT INTO `t_job_log` VALUES ('2468', '2', 'testTask', 'test1', null, '0', null, '1', '2018-04-02 15:27:20');
INSERT INTO `t_job_log` VALUES ('2469', '2', 'testTask', 'test1', null, '0', null, '3', '2018-04-02 17:29:20');
INSERT INTO `t_job_log` VALUES ('2476', '1', 'testTask', 'test', 'mrbird', '0', null, '1', '2019-01-06 08:25:00');
INSERT INTO `t_job_log` VALUES ('2477', '11', 'testTask', 'test2', null, '1', 'java.lang.NoSuchMethodException: cc.mrbird.febs.job.task.TestTask.test2()', '0', '2019-01-06 08:25:25');
INSERT INTO `t_job_log` VALUES ('2478', '1', 'testTask', 'test', 'mrbird', '0', null, '1', '2019-01-06 08:40:15');
INSERT INTO `t_job_log` VALUES ('2479', '1', 'testTask', 'test', 'mrbird', '0', null, '1', '2019-01-06 08:40:15');
INSERT INTO `t_job_log` VALUES ('2480', '1', 'testTask', 'test', 'mrbird', '0', null, '1', '2019-01-06 08:40:15');
INSERT INTO `t_job_log` VALUES ('2481', '1', 'testTask', 'test', 'mrbird', '0', null, '1', '2019-01-06 08:40:15');
INSERT INTO `t_job_log` VALUES ('2482', '1', 'testTask', 'test', 'mrbird', '0', null, '0', '2019-01-06 08:40:15');
INSERT INTO `t_job_log` VALUES ('2483', '1', 'testTask', 'test', 'mrbird', '0', null, '1', '2019-01-06 08:40:15');
INSERT INTO `t_job_log` VALUES ('2484', '1', 'testTask', 'test', 'mrbird', '0', null, '0', '2019-01-06 08:40:15');
INSERT INTO `t_job_log` VALUES ('2485', '1', 'testTask', 'test', 'mrbird', '0', null, '0', '2019-01-06 08:40:15');
INSERT INTO `t_job_log` VALUES ('2486', '1', 'testTask', 'test', 'mrbird', '0', null, '0', '2019-01-06 08:40:15');
INSERT INTO `t_job_log` VALUES ('2487', '1', 'testTask', 'test', 'mrbird', '0', null, '0', '2019-01-06 08:40:15');
INSERT INTO `t_job_log` VALUES ('2488', '1', 'testTask', 'test', 'mrbird', '0', null, '1', '2019-01-06 08:40:16');
INSERT INTO `t_job_log` VALUES ('2489', '1', 'testTask', 'test', 'mrbird', '0', null, '0', '2019-01-06 08:40:17');
INSERT INTO `t_job_log` VALUES ('2490', '1', 'testTask', 'test', 'mrbird', '0', null, '1', '2019-01-06 08:40:18');
INSERT INTO `t_job_log` VALUES ('2491', '1', 'testTask', 'test', 'mrbird', '0', null, '0', '2019-01-06 08:40:19');
INSERT INTO `t_job_log` VALUES ('2492', '1', 'testTask', 'test', 'mrbird', '0', null, '1', '2019-01-06 08:40:20');
INSERT INTO `t_job_log` VALUES ('2493', '1', 'testTask', 'test', 'mrbird', '0', null, '0', '2019-01-06 08:40:21');
INSERT INTO `t_job_log` VALUES ('2494', '1', 'testTask', 'test', 'mrbird', '0', null, '0', '2019-01-06 08:40:22');
INSERT INTO `t_job_log` VALUES ('2495', '11', 'testTask', 'test2', null, '1', 'java.lang.NoSuchMethodException: cc.mrbird.febs.job.task.TestTask.test2()', '2', '2019-01-06 08:40:36');
INSERT INTO `t_job_log` VALUES ('2496', '11', 'testTask', 'test2', null, '1', 'java.lang.NoSuchMethodException: cc.mrbird.febs.job.task.TestTask.test2()', '0', '2019-01-06 08:40:36');
INSERT INTO `t_job_log` VALUES ('2497', '11', 'testTask', 'test2', null, '1', 'java.lang.NoSuchMethodException: cc.mrbird.febs.job.task.TestTask.test2()', '1', '2019-01-06 08:40:40');
INSERT INTO `t_job_log` VALUES ('2498', '2', 'testTask', 'test1', null, '0', null, '1', '2019-01-06 11:36:20');
INSERT INTO `t_job_log` VALUES ('2499', '1', 'testTask', 'test', 'mrbird', '0', null, '30', '2019-01-22 05:41:01');
INSERT INTO `t_job_log` VALUES ('2500', '1', 'testTask', 'test', 'mrbird', '0', null, '9', '2019-01-23 06:28:58');
INSERT INTO `t_job_log` VALUES ('2501', '1', 'testTask', 'test', 'mrbird', '0', null, '12', '2019-01-24 05:39:59');

-- ----------------------------
-- Table structure for t_log
-- ----------------------------
DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '??????ID',
  `USERNAME` varchar(50) DEFAULT NULL COMMENT '????????????',
  `OPERATION` text COMMENT '????????????',
  `TIME` decimal(11,0) DEFAULT NULL COMMENT '??????',
  `METHOD` text COMMENT '????????????',
  `PARAMS` text COMMENT '????????????',
  `IP` varchar(64) DEFAULT NULL COMMENT '?????????IP',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '????????????',
  `location` varchar(50) DEFAULT NULL COMMENT '????????????',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1839 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_log
-- ----------------------------
INSERT INTO `t_log` VALUES ('1815', 'mrbird', '????????????', '301', 'cc.mrbird.febs.system.controller.UserController.deleteUsers()', ' userIds: \"11\"', '127.0.0.1', '2019-01-23 06:26:43', '??????IP|0|0|??????IP|??????IP');
INSERT INTO `t_log` VALUES ('1816', 'mrbird', '????????????/??????', '170', 'cc.mrbird.febs.system.controller.MenuController.updateMenu()', ' menu: \"Menu(menuId=2, parentId=0, menuName=????????????, path=/monitor, component=PageView, perms=null, icon=dashboard, type=0, orderNum=2.0, createTime=null, modifyTime=Wed Jan 23 14:27:12 CST 2019, createTimeFrom=null, createTimeTo=null)\"', '127.0.0.1', '2019-01-23 06:27:13', '??????IP|0|0|??????IP|??????IP');
INSERT INTO `t_log` VALUES ('1817', 'mrbird', '????????????', '90', 'cc.mrbird.febs.system.controller.DeptController.updateDept()', ' dept: \"Dept(deptId=4, parentId=0, deptName=?????????, orderNum=2.0, createTime=null, modifyTime=Wed Jan 23 14:27:55 CST 2019, createTimeFrom=null, createTimeTo=null)\"', '127.0.0.1', '2019-01-23 06:27:56', '??????IP|0|0|??????IP|??????IP');
INSERT INTO `t_log` VALUES ('1818', 'mrbird', '????????????', '596', 'cc.mrbird.febs.system.controller.DeptController.updateDept()', ' dept: \"Dept(deptId=5, parentId=0, deptName=?????????, orderNum=3.0, createTime=null, modifyTime=Wed Jan 23 14:27:59 CST 2019, createTimeFrom=null, createTimeTo=null)\"', '127.0.0.1', '2019-01-23 06:28:00', '??????IP|0|0|??????IP|??????IP');
INSERT INTO `t_log` VALUES ('1819', 'mrbird', '??????????????????', '146', 'cc.mrbird.febs.job.controller.JobController.runJob()', ' jobId: \"1\"', '127.0.0.1', '2019-01-23 06:28:58', '??????IP|0|0|??????IP|??????IP');
INSERT INTO `t_log` VALUES ('1820', 'mrbird', '????????????/??????', '160', 'cc.mrbird.febs.system.controller.MenuController.addMenu()', ' menu: \"Menu(menuId=130, parentId=3, menuName=??????Excel, path=null, component=null, perms=user:export, icon=null, type=1, orderNum=null, createTime=Wed Jan 23 14:35:15 CST 2019, modifyTime=null, createTimeFrom=null, createTimeTo=null)\"', '127.0.0.1', '2019-01-23 06:35:16', '??????IP|0|0|??????IP|??????IP');
INSERT INTO `t_log` VALUES ('1821', 'mrbird', '????????????/??????', '255', 'cc.mrbird.febs.system.controller.MenuController.addMenu()', ' menu: \"Menu(menuId=131, parentId=4, menuName=??????Excel, path=null, component=null, perms=role:export, icon=null, type=1, orderNum=null, createTime=Wed Jan 23 14:35:36 CST 2019, modifyTime=null, createTimeFrom=null, createTimeTo=null)\"', '127.0.0.1', '2019-01-23 06:35:36', '??????IP|0|0|??????IP|??????IP');
INSERT INTO `t_log` VALUES ('1822', 'mrbird', '????????????/??????', '172', 'cc.mrbird.febs.system.controller.MenuController.addMenu()', ' menu: \"Menu(menuId=132, parentId=5, menuName=??????Excel, path=null, component=null, perms=menu:export, icon=null, type=1, orderNum=null, createTime=Wed Jan 23 14:36:04 CST 2019, modifyTime=null, createTimeFrom=null, createTimeTo=null)\"', '127.0.0.1', '2019-01-23 06:36:05', '??????IP|0|0|??????IP|??????IP');
INSERT INTO `t_log` VALUES ('1823', 'mrbird', '????????????/??????', '188', 'cc.mrbird.febs.system.controller.MenuController.addMenu()', ' menu: \"Menu(menuId=133, parentId=6, menuName=??????Excel, path=null, component=null, perms=dept:export, icon=null, type=1, orderNum=null, createTime=Wed Jan 23 14:36:24 CST 2019, modifyTime=null, createTimeFrom=null, createTimeTo=null)\"', '127.0.0.1', '2019-01-23 06:36:25', '??????IP|0|0|??????IP|??????IP');
INSERT INTO `t_log` VALUES ('1824', 'mrbird', '????????????/??????', '186', 'cc.mrbird.febs.system.controller.MenuController.addMenu()', ' menu: \"Menu(menuId=134, parentId=64, menuName=??????Excel, path=null, component=null, perms=dict:export, icon=null, type=1, orderNum=null, createTime=Wed Jan 23 14:36:43 CST 2019, modifyTime=null, createTimeFrom=null, createTimeTo=null)\"', '127.0.0.1', '2019-01-23 06:36:44', '??????IP|0|0|??????IP|??????IP');
INSERT INTO `t_log` VALUES ('1825', 'mrbird', '????????????/??????', '160', 'cc.mrbird.febs.system.controller.MenuController.addMenu()', ' menu: \"Menu(menuId=135, parentId=3, menuName=????????????, path=null, component=null, perms=user:reset, icon=null, type=1, orderNum=null, createTime=Wed Jan 23 14:36:59 CST 2019, modifyTime=null, createTimeFrom=null, createTimeTo=null)\"', '127.0.0.1', '2019-01-23 06:37:00', '??????IP|0|0|??????IP|??????IP');
INSERT INTO `t_log` VALUES ('1826', 'mrbird', '????????????/??????', '181', 'cc.mrbird.febs.system.controller.MenuController.addMenu()', ' menu: \"Menu(menuId=136, parentId=10, menuName=??????Excel, path=null, component=null, perms=log:export, icon=null, type=1, orderNum=null, createTime=Wed Jan 23 14:37:26 CST 2019, modifyTime=null, createTimeFrom=null, createTimeTo=null)\"', '127.0.0.1', '2019-01-23 06:37:27', '??????IP|0|0|??????IP|??????IP');
INSERT INTO `t_log` VALUES ('1827', 'mrbird', '????????????/??????', '146', 'cc.mrbird.febs.system.controller.MenuController.addMenu()', ' menu: \"Menu(menuId=137, parentId=102, menuName=??????Excel, path=null, component=null, perms=job:export, icon=null, type=1, orderNum=null, createTime=Wed Jan 23 14:37:59 CST 2019, modifyTime=null, createTimeFrom=null, createTimeTo=null)\"', '127.0.0.1', '2019-01-23 06:37:59', '??????IP|0|0|??????IP|??????IP');
INSERT INTO `t_log` VALUES ('1828', 'mrbird', '????????????/??????', '164', 'cc.mrbird.febs.system.controller.MenuController.addMenu()', ' menu: \"Menu(menuId=138, parentId=109, menuName=??????Excel, path=null, component=null, perms=jobLog:export, icon=null, type=1, orderNum=null, createTime=Wed Jan 23 14:38:32 CST 2019, modifyTime=null, createTimeFrom=null, createTimeTo=null)\"', '127.0.0.1', '2019-01-23 06:38:33', '??????IP|0|0|??????IP|??????IP');
INSERT INTO `t_log` VALUES ('1829', 'mrbird', '????????????', '3132', 'cc.mrbird.febs.system.controller.RoleController.updateRole()', ' role: \"Role(roleId=1, roleName=?????????, remark=?????????, createTime=null, modifyTime=Wed Jan 23 14:45:28 CST 2019, createTimeFrom=null, createTimeTo=null, menuId=1,3,11,12,13,4,14,15,16,5,17,18,19,6,20,21,22,64,65,66,67,2,8,23,10,24,113,121,122,124,123,125,101,102,103,104,105,106,107,108,109,110,58,59,61,81,82,83,127,128,129,130,135,131,132,133,134,136,137,138)\"', '127.0.0.1', '2019-01-23 06:45:32', '??????IP|0|0|??????IP|??????IP');
INSERT INTO `t_log` VALUES ('1830', 'mrbird', '????????????', '1730', 'cc.mrbird.febs.system.controller.RoleController.updateRole()', ' role: \"Role(roleId=2, roleName=????????????, remark=????????????????????????, createTime=null, modifyTime=Wed Jan 23 15:31:07 CST 2019, createTimeFrom=null, createTimeTo=null, menuId=3,1,4,5,6,64,2,8,10,113,121,122,124,123,125,101,102,109,58,59,61,81,82,83,127,128,129)\"', '127.0.0.1', '2019-01-23 07:31:09', '??????IP|0|0|??????IP|??????IP');
INSERT INTO `t_log` VALUES ('1831', 'mrbird', '????????????', '1997', 'cc.mrbird.febs.system.controller.RoleController.updateRole()', ' role: \"Role(roleId=2, roleName=????????????, remark=???????????????????????????, createTime=null, modifyTime=Wed Jan 23 15:32:20 CST 2019, createTimeFrom=null, createTimeTo=null, menuId=3,1,4,5,6,64,2,8,10,113,121,122,124,123,125,101,102,109,58,59,61,81,82,83,127,128,129,130,14,17,132,20,133,65,134,136,103,137,138)\"', '127.0.0.1', '2019-01-23 07:32:22', '??????IP|0|0|??????IP|??????IP');
INSERT INTO `t_log` VALUES ('1832', 'mrbird', '????????????', '1428', 'cc.mrbird.febs.system.controller.RoleController.addRole()', ' role: \"Role(roleId=72, roleName=????????????, remark=???????????????????????????, createTime=Wed Jan 23 15:33:20 CST 2019, modifyTime=null, createTimeFrom=null, createTimeTo=null, menuId=1,3,4,5,6,64,2,8,10,113,121,122,124,123,127,101,102,109,58,59,61,81,82,83,128,129)\"', '127.0.0.1', '2019-01-23 07:33:22', '??????IP|0|0|??????IP|??????IP');
INSERT INTO `t_log` VALUES ('1833', 'mrbird', '????????????', '338', 'cc.mrbird.febs.system.controller.UserController.addUser()', ' user: \"User(userId=12, username=jack, password=552649f10640385d0728a80a4242893e, deptId=6, deptName=null, email=jack@hotmail.com, mobile=null, status=1, createTime=Wed Jan 23 15:34:05 CST 2019, modifyTime=null, lastLoginTime=null, ssex=0, description=null, avatar=default.jpg, roleId=72, roleName=null, sortField=null, sortOrder=null, createTimeFrom=null, createTimeTo=null, id=null)\"', '127.0.0.1', '2019-01-23 07:34:06', '??????IP|0|0|??????IP|??????IP');
INSERT INTO `t_log` VALUES ('1834', 'mrbird', '????????????', '2160', 'cc.mrbird.febs.system.controller.RoleController.updateRole()', ' role: \"Role(roleId=2, roleName=????????????, remark=???????????????????????????, createTime=null, modifyTime=Wed Jan 23 15:37:08 CST 2019, createTimeFrom=null, createTimeTo=null, menuId=3,1,4,5,6,64,2,8,10,113,121,122,124,123,125,101,102,109,58,59,61,81,82,83,127,128,129,130,14,17,132,20,133,65,134,136,103,137,138,131)\"', '127.0.0.1', '2019-01-23 07:37:11', '??????IP|0|0|??????IP|??????IP');
INSERT INTO `t_log` VALUES ('1835', 'mrbird', '????????????', '169', 'cc.mrbird.febs.system.controller.RoleController.addRole()', ' role: \"Role(roleId=73, roleName=??????xss, remark=<style>body{background:red !important}</style>, createTime=Wed Jan 23 15:47:04 CST 2019, modifyTime=null, createTimeFrom=null, createTimeTo=null, menuId=1,3)\"', '127.0.0.1', '2019-01-23 07:47:04', '??????IP|0|0|??????IP|??????IP');
INSERT INTO `t_log` VALUES ('1836', 'mrbird', '????????????', '54', 'cc.mrbird.febs.system.controller.RoleController.deleteRoles()', ' roleIds: \"73\"', '218.104.237.213', '2019-01-24 03:03:41', '??????|??????|?????????|?????????|??????');
INSERT INTO `t_log` VALUES ('1837', 'mrbird', '????????????', '39', 'cc.mrbird.febs.system.controller.UserController.updateUser()', ' user: \"User(userId=12, username=jack, password=null, deptId=6, deptName=null, email=jack@hotmail.com, mobile=null, status=1, createTime=null, modifyTime=Thu Jan 24 11:08:00 CST 2019, lastLoginTime=null, ssex=0, description=null, avatar=null, roleId=72, roleName=null, sortField=null, sortOrder=null, createTimeFrom=null, createTimeTo=null, id=null)\"', '218.104.237.213', '2019-01-24 03:08:01', '??????|??????|?????????|?????????|??????');
INSERT INTO `t_log` VALUES ('1838', 'mrbird', '??????????????????', '41', 'cc.mrbird.febs.job.controller.JobController.runJob()', ' jobId: \"1\"', '218.104.237.213', '2019-01-24 05:39:59', '??????|??????|?????????|?????????|??????');

-- ----------------------------
-- Table structure for t_login_log
-- ----------------------------
DROP TABLE IF EXISTS `t_login_log`;
CREATE TABLE `t_login_log` (
  `USERNAME` varchar(100) NOT NULL COMMENT '?????????',
  `LOGIN_TIME` datetime NOT NULL COMMENT '????????????',
  `LOCATION` varchar(255) DEFAULT NULL COMMENT '????????????',
  `IP` varchar(100) DEFAULT NULL COMMENT 'IP??????'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_login_log
-- ----------------------------
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-12 03:18:33', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-10 03:18:33', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-09 03:18:33', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-11 03:18:33', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-12 04:23:45', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-15 03:31:18', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-15 03:36:28', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-15 06:05:36', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-15 08:44:39', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-15 09:02:42', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('scott', '2019-01-15 09:24:21', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('scott', '2019-01-15 09:25:16', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-15 10:14:20', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('scott', '2019-01-15 10:48:59', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-14 11:02:04', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('scott', '2019-01-13 11:02:04', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-15 11:02:04', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-16 01:20:24', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-16 02:25:47', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-16 03:25:11', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-16 03:44:23', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-16 05:44:05', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-16 05:51:12', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('scott', '2019-01-16 05:51:21', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-16 05:54:03', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-16 06:18:57', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-16 06:31:19', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-16 07:32:02', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-17 01:10:42', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-17 02:21:12', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-17 06:07:00', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-17 06:45:24', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-17 06:46:40', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-17 06:54:23', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-17 06:54:53', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-17 06:55:38', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-17 07:38:37', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-17 07:39:14', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-17 07:40:48', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-17 07:41:41', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('scott', '2019-01-17 07:42:53', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('scott', '2019-01-17 07:43:39', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-17 08:13:29', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-17 08:39:56', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-17 09:26:19', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-17 09:26:58', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-17 09:30:15', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbirdd', '2019-01-17 10:31:40', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('jack', '2019-01-17 10:41:14', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('abcd', '2019-01-17 10:47:48', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('abcd', '2019-01-17 10:48:06', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('abcd', '2019-01-17 10:48:44', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('abcd', '2019-01-17 10:51:35', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('wuyouzhugu', '2019-01-17 10:54:56', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-17 10:56:53', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-17 10:59:15', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-17 10:59:53', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-17 11:01:54', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-17 11:08:43', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-17 11:12:55', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-17 11:13:21', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-18 00:56:15', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-18 01:21:54', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-18 01:33:06', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-18 02:03:32', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-18 02:27:12', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-18 02:36:26', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-18 02:41:49', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-18 02:53:12', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-18 02:56:00', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-18 03:00:35', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-18 05:36:02', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-18 05:57:39', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-18 06:50:27', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-18 07:09:37', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-18 08:57:02', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-18 09:00:06', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-19 01:13:17', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-19 01:14:42', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-19 01:50:38', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-19 02:05:44', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-19 02:06:52', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-19 02:11:47', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-19 02:12:13', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-19 02:12:27', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-19 02:33:21', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-19 02:40:19', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-21 03:05:20', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-21 03:16:03', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-21 05:43:32', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-21 05:44:20', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-21 06:47:04', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-21 06:49:51', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-21 07:48:30', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-21 07:50:34', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-21 07:55:22', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-21 07:57:39', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-21 08:35:07', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-21 08:58:37', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-21 11:05:26', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-22 00:47:44', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-22 01:02:23', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-22 01:38:19', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-22 02:39:18', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-22 05:39:47', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-22 05:44:25', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-22 06:04:18', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-22 06:04:34', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-22 06:13:00', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-22 06:13:17', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('scott', '2019-01-22 06:13:43', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('scott', '2019-01-22 06:14:41', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('scott', '2019-01-22 06:15:10', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('hello', '2019-01-22 06:15:48', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('hello', '2019-01-22 06:17:19', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('hello', '2019-01-22 06:18:39', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-22 06:19:03', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-22 06:20:48', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-22 07:04:26', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-22 07:06:07', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-22 07:06:57', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-22 08:37:28', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-22 10:29:50', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-23 00:50:47', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-23 01:51:42', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-23 02:58:49', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-23 06:11:14', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('scott', '2019-01-23 06:46:30', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-23 06:48:25', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('scott', '2019-01-23 06:51:20', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-23 07:30:25', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('scott', '2019-01-23 07:34:28', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('jack', '2019-01-23 07:35:56', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-23 07:36:46', '??????IP|0|0|??????IP|??????IP', '127.0.0.1');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-24 01:30:13', '??????|??????|?????????|?????????|??????', '218.104.237.213');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-24 01:42:03', '??????|??????|?????????|?????????|??????', '218.104.237.213');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-24 01:48:10', '??????|??????|?????????|?????????|??????', '218.104.237.213');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-24 01:50:12', '??????|??????|?????????|?????????|??????', '218.104.237.213');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-24 01:50:28', '??????|??????|?????????|?????????|??????', '218.104.237.213');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-24 02:57:48', '??????|??????|?????????|?????????|??????', '218.104.237.213');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-24 03:02:53', '??????|??????|?????????|?????????|??????', '218.104.237.213');
INSERT INTO `t_login_log` VALUES ('scott', '2019-01-24 03:14:51', '??????|??????|?????????|?????????|??????', '120.36.172.239');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-24 03:41:10', '??????|??????|?????????|?????????|??????', '218.104.237.213');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-24 05:38:30', '??????|??????|?????????|?????????|??????', '218.104.237.213');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-24 08:50:44', '??????|??????|?????????|?????????|??????', '218.104.237.213');
INSERT INTO `t_login_log` VALUES ('jack', '2019-01-24 08:52:03', '??????|??????|?????????|?????????|??????', '218.104.237.213');
INSERT INTO `t_login_log` VALUES ('scott', '2019-01-24 08:52:31', '??????|??????|?????????|?????????|??????', '218.104.237.213');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-24 11:12:33', '??????|??????|?????????|?????????|??????', '218.104.237.213');
INSERT INTO `t_login_log` VALUES ('scott', '2019-01-24 11:24:04', '??????|??????|?????????|?????????|??????', '218.104.237.213');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-24 11:47:56', '??????|??????|?????????|?????????|??????', '27.155.195.27');
INSERT INTO `t_login_log` VALUES ('scott', '2019-01-24 11:48:28', '??????|??????|?????????|?????????|??????', '27.155.195.27');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-28 01:53:06', '??????|??????|?????????|?????????|??????', '218.104.237.213');
INSERT INTO `t_login_log` VALUES ('mrbird', '2019-01-28 01:53:58', '??????|??????|?????????|?????????|??????', '218.104.237.213');
INSERT INTO `t_login_log` VALUES ('scott', '2019-01-28 01:54:09', '??????|??????|?????????|?????????|??????', '218.104.237.213');

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `MENU_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '??????/??????ID',
  `PARENT_ID` bigint(20) NOT NULL COMMENT '????????????ID',
  `MENU_NAME` varchar(50) NOT NULL COMMENT '??????/????????????',
  `PATH` varchar(255) DEFAULT NULL COMMENT '????????????path',
  `COMPONENT` varchar(255) DEFAULT NULL COMMENT '??????????????????component',
  `PERMS` varchar(50) DEFAULT NULL COMMENT '????????????',
  `ICON` varchar(50) DEFAULT NULL COMMENT '??????',
  `TYPE` char(2) NOT NULL COMMENT '?????? 0?????? 1??????',
  `ORDER_NUM` double(20,0) DEFAULT NULL COMMENT '??????',
  `CREATE_TIME` datetime NOT NULL COMMENT '????????????',
  `MODIFY_TIME` datetime DEFAULT NULL COMMENT '????????????',
  PRIMARY KEY (`MENU_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=139 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '0', '????????????', '/system', 'PageView', null, 'appstore-o', '0', '1', '2017-12-27 16:39:07', '2019-01-05 11:13:14');
INSERT INTO `t_menu` VALUES ('2', '0', '????????????', '/monitor', 'PageView', null, 'dashboard', '0', '2', '2017-12-27 16:45:51', '2019-01-23 06:27:12');
INSERT INTO `t_menu` VALUES ('3', '1', '????????????', '/system/user', 'system/user/User', 'user:view', '', '0', '1', '2017-12-27 16:47:13', '2019-01-22 06:45:55');
INSERT INTO `t_menu` VALUES ('4', '1', '????????????', '/system/role', 'system/role/Role', 'role:view', '', '0', '2', '2017-12-27 16:48:09', '2018-04-25 09:01:12');
INSERT INTO `t_menu` VALUES ('5', '1', '????????????', '/system/menu', 'system/menu/Menu', 'menu:view', '', '0', '3', '2017-12-27 16:48:57', '2018-04-25 09:01:30');
INSERT INTO `t_menu` VALUES ('6', '1', '????????????', '/system/dept', 'system/dept/Dept', 'dept:view', '', '0', '4', '2017-12-27 16:57:33', '2018-04-25 09:01:40');
INSERT INTO `t_menu` VALUES ('8', '2', '????????????', '/monitor/online', 'monitor/Online', 'user:online', '', '0', '1', '2017-12-27 16:59:33', '2018-04-25 09:02:04');
INSERT INTO `t_menu` VALUES ('10', '2', '????????????', '/monitor/systemlog', 'monitor/SystemLog', 'log:view', '', '0', '2', '2017-12-27 17:00:50', '2018-04-25 09:02:18');
INSERT INTO `t_menu` VALUES ('11', '3', '????????????', '', '', 'user:add', null, '1', null, '2017-12-27 17:02:58', null);
INSERT INTO `t_menu` VALUES ('12', '3', '????????????', '', '', 'user:update', null, '1', null, '2017-12-27 17:04:07', null);
INSERT INTO `t_menu` VALUES ('13', '3', '????????????', '', '', 'user:delete', null, '1', null, '2017-12-27 17:04:58', null);
INSERT INTO `t_menu` VALUES ('14', '4', '????????????', '', '', 'role:add', null, '1', null, '2017-12-27 17:06:38', null);
INSERT INTO `t_menu` VALUES ('15', '4', '????????????', '', '', 'role:update', null, '1', null, '2017-12-27 17:06:38', null);
INSERT INTO `t_menu` VALUES ('16', '4', '????????????', '', '', 'role:delete', null, '1', null, '2017-12-27 17:06:38', null);
INSERT INTO `t_menu` VALUES ('17', '5', '????????????', '', '', 'menu:add', null, '1', null, '2017-12-27 17:08:02', null);
INSERT INTO `t_menu` VALUES ('18', '5', '????????????', '', '', 'menu:update', null, '1', null, '2017-12-27 17:08:02', null);
INSERT INTO `t_menu` VALUES ('19', '5', '????????????', '', '', 'menu:delete', null, '1', null, '2017-12-27 17:08:02', null);
INSERT INTO `t_menu` VALUES ('20', '6', '????????????', '', '', 'dept:add', null, '1', null, '2017-12-27 17:09:24', null);
INSERT INTO `t_menu` VALUES ('21', '6', '????????????', '', '', 'dept:update', null, '1', null, '2017-12-27 17:09:24', null);
INSERT INTO `t_menu` VALUES ('22', '6', '????????????', '', '', 'dept:delete', null, '1', null, '2017-12-27 17:09:24', null);
INSERT INTO `t_menu` VALUES ('23', '8', '????????????', '', '', 'user:kickout', null, '1', null, '2017-12-27 17:11:13', null);
INSERT INTO `t_menu` VALUES ('24', '10', '????????????', '', '', 'log:delete', null, '1', null, '2017-12-27 17:11:45', null);
INSERT INTO `t_menu` VALUES ('58', '0', '????????????', '/web', 'PageView', null, 'compass', '0', '4', '2018-01-12 15:28:48', '2018-01-22 19:49:26');
INSERT INTO `t_menu` VALUES ('59', '58', '????????????', '/web/weather', 'web/Weather', 'weather:view', '', '0', '1', '2018-01-12 15:40:02', '2019-01-22 05:43:19');
INSERT INTO `t_menu` VALUES ('61', '58', '????????????', '/web/dailyArticle', 'web/DailyArticle', 'article:view', '', '0', '2', '2018-01-15 17:17:14', '2019-01-22 05:43:27');
INSERT INTO `t_menu` VALUES ('64', '1', '????????????', '/system/dict', 'system/dict/Dict', 'dict:view', '', '0', '5', '2018-01-18 10:38:25', '2018-04-25 09:01:50');
INSERT INTO `t_menu` VALUES ('65', '64', '????????????', '', '', 'dict:add', null, '1', null, '2018-01-18 19:10:08', null);
INSERT INTO `t_menu` VALUES ('66', '64', '????????????', '', '', 'dict:update', null, '1', null, '2018-01-18 19:10:27', null);
INSERT INTO `t_menu` VALUES ('67', '64', '????????????', '', '', 'dict:delete', null, '1', null, '2018-01-18 19:10:47', null);
INSERT INTO `t_menu` VALUES ('81', '58', '????????????', '/web/movie', 'EmptyPageView', null, null, '0', '3', '2018-01-22 14:12:59', '2019-01-22 05:43:35');
INSERT INTO `t_menu` VALUES ('82', '81', '????????????', '/web/movie/hot', 'web/MovieHot', 'movie:hot', '', '0', '1', '2018-01-22 14:13:47', '2019-01-22 05:43:52');
INSERT INTO `t_menu` VALUES ('83', '81', '????????????', '/web/movie/coming', 'web/MovieComing', 'movie:coming', '', '0', '2', '2018-01-22 14:14:36', '2019-01-22 05:43:58');
INSERT INTO `t_menu` VALUES ('101', '0', '????????????', '/job', 'PageView', null, 'clock-circle-o', '0', '3', '2018-01-11 15:52:57', null);
INSERT INTO `t_menu` VALUES ('102', '101', '????????????', '/job/job', 'quartz/job/Job', 'job:view', '', '0', '1', '2018-02-24 15:53:53', '2019-01-22 05:42:50');
INSERT INTO `t_menu` VALUES ('103', '102', '????????????', '', '', 'job:add', null, '1', null, '2018-02-24 15:55:10', null);
INSERT INTO `t_menu` VALUES ('104', '102', '????????????', '', '', 'job:update', null, '1', null, '2018-02-24 15:55:53', null);
INSERT INTO `t_menu` VALUES ('105', '102', '????????????', '', '', 'job:delete', null, '1', null, '2018-02-24 15:56:18', null);
INSERT INTO `t_menu` VALUES ('106', '102', '????????????', '', '', 'job:pause', null, '1', null, '2018-02-24 15:57:08', null);
INSERT INTO `t_menu` VALUES ('107', '102', '????????????', '', '', 'job:resume', null, '1', null, '2018-02-24 15:58:21', null);
INSERT INTO `t_menu` VALUES ('108', '102', '??????????????????', '', '', 'job:run', null, '1', null, '2018-02-24 15:59:45', null);
INSERT INTO `t_menu` VALUES ('109', '101', '????????????', '/job/log', 'quartz/log/JobLog', 'jobLog:view', '', '0', '2', '2018-02-24 16:00:45', '2019-01-22 05:42:59');
INSERT INTO `t_menu` VALUES ('110', '109', '????????????', '', '', 'jobLog:delete', null, '1', null, '2018-02-24 16:01:21', null);
INSERT INTO `t_menu` VALUES ('113', '2', 'Redis??????', '/monitor/redis/info', 'monitor/RedisInfo', 'redis:view', '', '0', '3', '2018-06-28 14:29:42', null);
INSERT INTO `t_menu` VALUES ('121', '2', '????????????', '/monitor/httptrace', 'monitor/Httptrace', null, null, '0', '4', '2019-01-18 02:30:29', null);
INSERT INTO `t_menu` VALUES ('122', '2', '????????????', '/monitor/system', 'EmptyPageView', null, null, '0', '5', '2019-01-18 02:31:48', '2019-01-18 02:39:46');
INSERT INTO `t_menu` VALUES ('123', '122', 'Tomcat??????', '/monitor/system/tomcatinfo', 'monitor/TomcatInfo', null, null, '0', '2', '2019-01-18 02:32:53', '2019-01-18 02:46:57');
INSERT INTO `t_menu` VALUES ('124', '122', 'JVM??????', '/monitor/system/jvminfo', 'monitor/JvmInfo', null, null, '0', '1', '2019-01-18 02:33:30', '2019-01-18 02:46:51');
INSERT INTO `t_menu` VALUES ('127', '122', '???????????????', '/monitor/system/info', 'monitor/SystemInfo', null, null, '0', '3', '2019-01-21 07:53:43', '2019-01-21 07:57:00');
INSERT INTO `t_menu` VALUES ('128', '0', '????????????', '/others', 'PageView', null, 'coffee', '0', '5', '2019-01-22 06:49:59', '2019-01-22 06:50:13');
INSERT INTO `t_menu` VALUES ('129', '128', '????????????', '/others/excel', 'others/Excel', null, null, '0', '1', '2019-01-22 06:51:36', '2019-01-22 07:06:45');
INSERT INTO `t_menu` VALUES ('130', '3', '??????Excel', null, null, 'user:export', null, '1', null, '2019-01-23 06:35:16', null);
INSERT INTO `t_menu` VALUES ('131', '4', '??????Excel', null, null, 'role:export', null, '1', null, '2019-01-23 06:35:36', null);
INSERT INTO `t_menu` VALUES ('132', '5', '??????Excel', null, null, 'menu:export', null, '1', null, '2019-01-23 06:36:05', null);
INSERT INTO `t_menu` VALUES ('133', '6', '??????Excel', null, null, 'dept:export', null, '1', null, '2019-01-23 06:36:25', null);
INSERT INTO `t_menu` VALUES ('134', '64', '??????Excel', null, null, 'dict:export', null, '1', null, '2019-01-23 06:36:43', null);
INSERT INTO `t_menu` VALUES ('135', '3', '????????????', null, null, 'user:reset', null, '1', null, '2019-01-23 06:37:00', null);
INSERT INTO `t_menu` VALUES ('136', '10', '??????Excel', null, null, 'log:export', null, '1', null, '2019-01-23 06:37:27', null);
INSERT INTO `t_menu` VALUES ('137', '102', '??????Excel', null, null, 'job:export', null, '1', null, '2019-01-23 06:37:59', null);
INSERT INTO `t_menu` VALUES ('138', '109', '??????Excel', null, null, 'jobLog:export', null, '1', null, '2019-01-23 06:38:32', null);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `ROLE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '??????ID',
  `ROLE_NAME` varchar(10) NOT NULL COMMENT '????????????',
  `REMARK` varchar(100) DEFAULT NULL COMMENT '????????????',
  `CREATE_TIME` datetime NOT NULL COMMENT '????????????',
  `MODIFY_TIME` datetime DEFAULT NULL COMMENT '????????????',
  PRIMARY KEY (`ROLE_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '?????????', '?????????', '2017-12-27 16:23:11', '2019-01-23 06:45:29');
INSERT INTO `t_role` VALUES ('2', '????????????', '???????????????????????????', '2019-01-04 14:11:28', '2019-01-23 07:37:08');
INSERT INTO `t_role` VALUES ('72', '????????????', '???????????????????????????', '2019-01-23 07:33:20', null);

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu` (
  `ROLE_ID` bigint(20) NOT NULL,
  `MENU_ID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------
INSERT INTO `t_role_menu` VALUES ('1', '1');
INSERT INTO `t_role_menu` VALUES ('1', '3');
INSERT INTO `t_role_menu` VALUES ('1', '11');
INSERT INTO `t_role_menu` VALUES ('1', '12');
INSERT INTO `t_role_menu` VALUES ('1', '13');
INSERT INTO `t_role_menu` VALUES ('1', '4');
INSERT INTO `t_role_menu` VALUES ('1', '14');
INSERT INTO `t_role_menu` VALUES ('1', '15');
INSERT INTO `t_role_menu` VALUES ('1', '16');
INSERT INTO `t_role_menu` VALUES ('1', '5');
INSERT INTO `t_role_menu` VALUES ('1', '17');
INSERT INTO `t_role_menu` VALUES ('1', '18');
INSERT INTO `t_role_menu` VALUES ('1', '19');
INSERT INTO `t_role_menu` VALUES ('1', '6');
INSERT INTO `t_role_menu` VALUES ('1', '20');
INSERT INTO `t_role_menu` VALUES ('1', '21');
INSERT INTO `t_role_menu` VALUES ('1', '22');
INSERT INTO `t_role_menu` VALUES ('1', '64');
INSERT INTO `t_role_menu` VALUES ('1', '65');
INSERT INTO `t_role_menu` VALUES ('1', '66');
INSERT INTO `t_role_menu` VALUES ('1', '67');
INSERT INTO `t_role_menu` VALUES ('1', '2');
INSERT INTO `t_role_menu` VALUES ('1', '8');
INSERT INTO `t_role_menu` VALUES ('1', '23');
INSERT INTO `t_role_menu` VALUES ('1', '10');
INSERT INTO `t_role_menu` VALUES ('1', '24');
INSERT INTO `t_role_menu` VALUES ('1', '113');
INSERT INTO `t_role_menu` VALUES ('1', '121');
INSERT INTO `t_role_menu` VALUES ('1', '122');
INSERT INTO `t_role_menu` VALUES ('1', '124');
INSERT INTO `t_role_menu` VALUES ('1', '123');
INSERT INTO `t_role_menu` VALUES ('1', '125');
INSERT INTO `t_role_menu` VALUES ('1', '101');
INSERT INTO `t_role_menu` VALUES ('1', '102');
INSERT INTO `t_role_menu` VALUES ('1', '103');
INSERT INTO `t_role_menu` VALUES ('1', '104');
INSERT INTO `t_role_menu` VALUES ('1', '105');
INSERT INTO `t_role_menu` VALUES ('1', '106');
INSERT INTO `t_role_menu` VALUES ('1', '107');
INSERT INTO `t_role_menu` VALUES ('1', '108');
INSERT INTO `t_role_menu` VALUES ('1', '109');
INSERT INTO `t_role_menu` VALUES ('1', '110');
INSERT INTO `t_role_menu` VALUES ('1', '58');
INSERT INTO `t_role_menu` VALUES ('1', '59');
INSERT INTO `t_role_menu` VALUES ('1', '61');
INSERT INTO `t_role_menu` VALUES ('1', '81');
INSERT INTO `t_role_menu` VALUES ('1', '82');
INSERT INTO `t_role_menu` VALUES ('1', '83');
INSERT INTO `t_role_menu` VALUES ('1', '127');
INSERT INTO `t_role_menu` VALUES ('1', '128');
INSERT INTO `t_role_menu` VALUES ('1', '129');
INSERT INTO `t_role_menu` VALUES ('1', '130');
INSERT INTO `t_role_menu` VALUES ('1', '135');
INSERT INTO `t_role_menu` VALUES ('1', '131');
INSERT INTO `t_role_menu` VALUES ('1', '132');
INSERT INTO `t_role_menu` VALUES ('1', '133');
INSERT INTO `t_role_menu` VALUES ('1', '134');
INSERT INTO `t_role_menu` VALUES ('1', '136');
INSERT INTO `t_role_menu` VALUES ('1', '137');
INSERT INTO `t_role_menu` VALUES ('1', '138');
INSERT INTO `t_role_menu` VALUES ('72', '1');
INSERT INTO `t_role_menu` VALUES ('72', '3');
INSERT INTO `t_role_menu` VALUES ('72', '4');
INSERT INTO `t_role_menu` VALUES ('72', '5');
INSERT INTO `t_role_menu` VALUES ('72', '6');
INSERT INTO `t_role_menu` VALUES ('72', '64');
INSERT INTO `t_role_menu` VALUES ('72', '2');
INSERT INTO `t_role_menu` VALUES ('72', '8');
INSERT INTO `t_role_menu` VALUES ('72', '10');
INSERT INTO `t_role_menu` VALUES ('72', '113');
INSERT INTO `t_role_menu` VALUES ('72', '121');
INSERT INTO `t_role_menu` VALUES ('72', '122');
INSERT INTO `t_role_menu` VALUES ('72', '124');
INSERT INTO `t_role_menu` VALUES ('72', '123');
INSERT INTO `t_role_menu` VALUES ('72', '127');
INSERT INTO `t_role_menu` VALUES ('72', '101');
INSERT INTO `t_role_menu` VALUES ('72', '102');
INSERT INTO `t_role_menu` VALUES ('72', '109');
INSERT INTO `t_role_menu` VALUES ('72', '58');
INSERT INTO `t_role_menu` VALUES ('72', '59');
INSERT INTO `t_role_menu` VALUES ('72', '61');
INSERT INTO `t_role_menu` VALUES ('72', '81');
INSERT INTO `t_role_menu` VALUES ('72', '82');
INSERT INTO `t_role_menu` VALUES ('72', '83');
INSERT INTO `t_role_menu` VALUES ('72', '128');
INSERT INTO `t_role_menu` VALUES ('72', '129');
INSERT INTO `t_role_menu` VALUES ('2', '3');
INSERT INTO `t_role_menu` VALUES ('2', '1');
INSERT INTO `t_role_menu` VALUES ('2', '4');
INSERT INTO `t_role_menu` VALUES ('2', '5');
INSERT INTO `t_role_menu` VALUES ('2', '6');
INSERT INTO `t_role_menu` VALUES ('2', '64');
INSERT INTO `t_role_menu` VALUES ('2', '2');
INSERT INTO `t_role_menu` VALUES ('2', '8');
INSERT INTO `t_role_menu` VALUES ('2', '10');
INSERT INTO `t_role_menu` VALUES ('2', '113');
INSERT INTO `t_role_menu` VALUES ('2', '121');
INSERT INTO `t_role_menu` VALUES ('2', '122');
INSERT INTO `t_role_menu` VALUES ('2', '124');
INSERT INTO `t_role_menu` VALUES ('2', '123');
INSERT INTO `t_role_menu` VALUES ('2', '125');
INSERT INTO `t_role_menu` VALUES ('2', '101');
INSERT INTO `t_role_menu` VALUES ('2', '102');
INSERT INTO `t_role_menu` VALUES ('2', '109');
INSERT INTO `t_role_menu` VALUES ('2', '58');
INSERT INTO `t_role_menu` VALUES ('2', '59');
INSERT INTO `t_role_menu` VALUES ('2', '61');
INSERT INTO `t_role_menu` VALUES ('2', '81');
INSERT INTO `t_role_menu` VALUES ('2', '82');
INSERT INTO `t_role_menu` VALUES ('2', '83');
INSERT INTO `t_role_menu` VALUES ('2', '127');
INSERT INTO `t_role_menu` VALUES ('2', '128');
INSERT INTO `t_role_menu` VALUES ('2', '129');
INSERT INTO `t_role_menu` VALUES ('2', '130');
INSERT INTO `t_role_menu` VALUES ('2', '14');
INSERT INTO `t_role_menu` VALUES ('2', '17');
INSERT INTO `t_role_menu` VALUES ('2', '132');
INSERT INTO `t_role_menu` VALUES ('2', '20');
INSERT INTO `t_role_menu` VALUES ('2', '133');
INSERT INTO `t_role_menu` VALUES ('2', '65');
INSERT INTO `t_role_menu` VALUES ('2', '134');
INSERT INTO `t_role_menu` VALUES ('2', '136');
INSERT INTO `t_role_menu` VALUES ('2', '103');
INSERT INTO `t_role_menu` VALUES ('2', '137');
INSERT INTO `t_role_menu` VALUES ('2', '138');
INSERT INTO `t_role_menu` VALUES ('2', '131');

-- ----------------------------
-- Table structure for t_test
-- ----------------------------
DROP TABLE IF EXISTS `t_test`;
CREATE TABLE `t_test` (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT,
  `FIELD1` varchar(20) NOT NULL,
  `FIELD2` int(11) NOT NULL,
  `FIELD3` varchar(100) NOT NULL,
  `CREATE_TIME` datetime NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT = 100 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_test
-- ----------------------------
INSERT INTO `t_test` VALUES (1,'??????1', '1', 'mrbird@gmail.com', '2019-01-22 16:26:51');
INSERT INTO `t_test` VALUES (2,'??????1', '1', 'mrbird0@gmail.com', '2019-01-23 03:01:03');
INSERT INTO `t_test` VALUES (3,'??????1', '2', 'mrbird1@gmail.com', '2019-01-23 03:01:03');
INSERT INTO `t_test` VALUES (4,'??????1', '3', 'mrbird2@gmail.com', '2019-01-23 03:01:03');
INSERT INTO `t_test` VALUES (5,'??????1', '4', 'mrbird3@gmail.com', '2019-01-23 03:01:03');
INSERT INTO `t_test` VALUES (6,'??????1', '5', 'mrbird4@gmail.com', '2019-01-23 03:01:03');
INSERT INTO `t_test` VALUES (7,'??????1', '10', 'mrbird9@gmail.com', '2019-01-23 03:01:03');
INSERT INTO `t_test` VALUES (8,'??????1', '1', 'mrbird0@gmail.com', '2019-01-23 03:03:49');
INSERT INTO `t_test` VALUES (9,'??????1', '2', 'mrbird1@gmail.com', '2019-01-23 03:03:49');
INSERT INTO `t_test` VALUES (10,'??????1', '3', 'mrbird2@gmail.com', '2019-01-23 03:03:49');
INSERT INTO `t_test` VALUES (11,'??????1', '4', 'mrbird3@gmail.com', '2019-01-23 03:03:49');
INSERT INTO `t_test` VALUES (12,'??????1', '5', 'mrbird4@gmail.com', '2019-01-23 03:03:49');
INSERT INTO `t_test` VALUES (13,'??????1', '10', 'mrbird9@gmail.com', '2019-01-23 03:03:49');
INSERT INTO `t_test` VALUES (14,'??????1', '1', 'mrbird0@gmail.com', '2019-01-23 03:07:47');
INSERT INTO `t_test` VALUES (15,'??????1', '2', 'mrbird1@gmail.com', '2019-01-23 03:07:47');
INSERT INTO `t_test` VALUES (16,'??????1', '3', 'mrbird2@gmail.com', '2019-01-23 03:07:47');
INSERT INTO `t_test` VALUES (17,'??????1', '4', 'mrbird3@gmail.com', '2019-01-23 03:07:47');
INSERT INTO `t_test` VALUES (18,'??????1', '5', 'mrbird4@gmail.com', '2019-01-23 03:07:47');
INSERT INTO `t_test` VALUES (19,'??????1', '6', 'mrbird5@gmail.com', '2019-01-23 03:07:47');
INSERT INTO `t_test` VALUES (20,'??????1', '1', 'mrbird0@gmail.com', '2019-01-23 03:08:09');
INSERT INTO `t_test` VALUES (21,'??????1', '2', 'mrbird1@gmail.com', '2019-01-23 03:08:09');
INSERT INTO `t_test` VALUES (22,'??????1', '3', 'mrbird2@gmail.com', '2019-01-23 03:08:09');
INSERT INTO `t_test` VALUES (23,'??????1', '4', 'mrbird3@gmail.com', '2019-01-23 03:08:09');
INSERT INTO `t_test` VALUES (24,'??????1', '5', 'mrbird4@gmail.com', '2019-01-23 03:08:09');
INSERT INTO `t_test` VALUES (25,'??????1', '10', 'mrbird9@gmail.com', '2019-01-23 03:08:09');
INSERT INTO `t_test` VALUES (26,'??????1', '1', 'mrbird0@gmail.com', '2019-01-23 03:19:52');
INSERT INTO `t_test` VALUES (27,'??????1', '2', 'mrbird1@gmail.com', '2019-01-23 03:19:52');
INSERT INTO `t_test` VALUES (28,'??????1', '3', 'mrbird2@gmail.com', '2019-01-23 03:19:52');
INSERT INTO `t_test` VALUES (29,'??????1', '4', 'mrbird3@gmail.com', '2019-01-23 03:19:52');
INSERT INTO `t_test` VALUES (30,'??????1', '5', 'mrbird4@gmail.com', '2019-01-23 03:19:52');
INSERT INTO `t_test` VALUES (31,'??????1', '6', 'mrbird5@gmail.com', '2019-01-23 03:19:52');
INSERT INTO `t_test` VALUES (32,'??????1', '1', 'mrbird0@gmail.com', '2019-01-23 03:20:56');
INSERT INTO `t_test` VALUES (33,'??????1', '2', 'mrbird1@gmail.com', '2019-01-23 03:20:56');
INSERT INTO `t_test` VALUES (34,'??????1', '3', 'mrbird2@gmail.com', '2019-01-23 03:20:56');
INSERT INTO `t_test` VALUES (35,'??????1', '4', 'mrbird3@gmail.com', '2019-01-23 03:20:56');
INSERT INTO `t_test` VALUES (36,'??????1', '5', 'mrbird4@gmail.com', '2019-01-23 03:20:56');
INSERT INTO `t_test` VALUES (37,'??????1', '6', 'mrbird5@gmail.com', '2019-01-23 03:20:56');
INSERT INTO `t_test` VALUES (38,'??????1', '1', 'mrbird0@gmail.com', '2019-01-23 06:12:38');
INSERT INTO `t_test` VALUES (39,'??????1', '2', 'mrbird1@gmail.com', '2019-01-23 06:12:38');
INSERT INTO `t_test` VALUES (40,'??????1', '3', 'mrbird2@gmail.com', '2019-01-23 06:12:38');
INSERT INTO `t_test` VALUES (41,'??????1', '4', 'mrbird3@gmail.com', '2019-01-23 06:12:38');
INSERT INTO `t_test` VALUES (42,'??????1', '5', 'mrbird4@gmail.com', '2019-01-23 06:12:38');
INSERT INTO `t_test` VALUES (43,'??????1', '6', 'mrbird5@gmail.com', '2019-01-23 06:12:38');
INSERT INTO `t_test` VALUES (44,'??????1', '7', 'mrbird6@gmail.com', '2019-01-23 06:12:38');
INSERT INTO `t_test` VALUES (45,'??????1', '8', 'mrbird7@gmail.com', '2019-01-23 06:12:38');
INSERT INTO `t_test` VALUES (46,'??????1', '9', 'mrbird8@gmail.com', '2019-01-23 06:12:38');
INSERT INTO `t_test` VALUES (47,'??????1', '11', 'mrbird10@gmail.com', '2019-01-23 06:12:38');
INSERT INTO `t_test` VALUES (48,'??????1', '12', 'mrbird11@gmail.com', '2019-01-23 06:12:38');
INSERT INTO `t_test` VALUES (49,'??????1', '14', 'mrbird13@gmail.com', '2019-01-23 06:12:38');
INSERT INTO `t_test` VALUES (50,'??????1', '15', 'mrbird14@gmail.com', '2019-01-23 06:12:38');
INSERT INTO `t_test` VALUES (51,'??????1', '16', 'mrbird15@gmail.com', '2019-01-23 06:12:38');
INSERT INTO `t_test` VALUES (52,'??????1', '18', 'mrbird17@gmail.com', '2019-01-23 06:12:38');
INSERT INTO `t_test` VALUES (53,'??????1', '19', 'mrbird18@gmail.com', '2019-01-23 06:12:38');
INSERT INTO `t_test` VALUES (54,'??????1', '20', 'mrbird19@gmail.com', '2019-01-23 06:12:38');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `USER_ID` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '??????ID',
  `USERNAME` varchar(50) NOT NULL COMMENT '?????????',
  `PASSWORD` varchar(128) NOT NULL COMMENT '??????',
  `DEPT_ID` bigint(20) DEFAULT NULL COMMENT '??????ID',
  `EMAIL` varchar(128) DEFAULT NULL COMMENT '??????',
  `MOBILE` varchar(20) DEFAULT NULL COMMENT '????????????',
  `STATUS` char(1) NOT NULL COMMENT '?????? 0?????? 1??????',
  `CREATE_TIME` datetime NOT NULL COMMENT '????????????',
  `MODIFY_TIME` datetime DEFAULT NULL COMMENT '????????????',
  `LAST_LOGIN_TIME` datetime DEFAULT NULL COMMENT '??????????????????',
  `SSEX` char(1) DEFAULT NULL COMMENT '?????? 0??? 1??? 2??????',
  `DESCRIPTION` varchar(100) DEFAULT NULL COMMENT '??????',
  `AVATAR` varchar(100) DEFAULT NULL COMMENT '????????????',
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'mrbird', '94f860c4bbfeb2f49c84e321fdda4b07', '1', 'mrbird123@hotmail.com', '13455533233', '1', '2017-12-27 15:47:19', '2019-01-17 02:34:19', '2019-01-28 01:53:58', '2', '?????????????????????', 'ubnKSIfAJTxIgXOKlciN.png');
INSERT INTO `t_user` VALUES ('2', 'scott', '7b44a5363e3fd52435beb472e1d2b91f', '6', 'scott@qq.com', '15134627380', '1', '2017-12-29 16:16:39', '2019-01-18 00:59:09', '2019-01-28 01:54:09', '0', '??????scott?????????', 'jZUIxmJycoymBprLOUbT.png');
INSERT INTO `t_user` VALUES ('12', 'jack', '552649f10640385d0728a80a4242893e', '6', 'jack@hotmail.com', null, '1', '2019-01-23 07:34:05', '2019-01-24 03:08:01', '2019-01-24 08:52:03', '0', null, 'default.jpg');

-- ----------------------------
-- Table structure for t_user_config
-- ----------------------------
DROP TABLE IF EXISTS `t_user_config`;
CREATE TABLE `t_user_config` (
  `USER_ID` bigint(20) NOT NULL COMMENT '??????ID',
  `THEME` varchar(10) DEFAULT NULL COMMENT '???????????? dark???????????????light????????????',
  `LAYOUT` varchar(10) DEFAULT NULL COMMENT '???????????? side????????????head?????????',
  `MULTI_PAGE` char(1) DEFAULT NULL COMMENT '???????????? 1???????????? 0??????',
  `FIX_SIDERBAR` char(1) DEFAULT NULL COMMENT '????????????????????????????????? 1?????? 0?????????',
  `FIX_HEADER` char(1) DEFAULT NULL COMMENT '?????????????????????????????? 1?????? 0?????????',
  `COLOR` varchar(20) DEFAULT NULL COMMENT '???????????? RGB???',
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_user_config
-- ----------------------------
INSERT INTO `t_user_config` VALUES ('1', 'light', 'side', '1', '1', '1', 'rgb(24, 144, 255)');
INSERT INTO `t_user_config` VALUES ('2', 'light', 'head', '0', '1', '1', 'rgb(24, 144, 255)');
INSERT INTO `t_user_config` VALUES ('12', 'dark', 'side', '1', '1', '1', 'rgb(66, 185, 131)');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `USER_ID` bigint(20) NOT NULL COMMENT '??????ID',
  `ROLE_ID` bigint(20) NOT NULL COMMENT '??????ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1');
INSERT INTO `t_user_role` VALUES ('2', '2');
INSERT INTO `t_user_role` VALUES ('12', '72');


