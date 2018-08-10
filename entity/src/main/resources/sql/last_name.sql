CREATE TABLE LAST_NAME (
  `ID` CHAR(32) NOT NULL COMMENT '主键',
  `LAST_NAME` VARCHAR(5) NOT NULL COMMENT '姓氏',
  `CREATE_DATETIME` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期时间',
  `UPDATE_DATETIME` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期时间',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `LAST_NAME` (`LAST_NAME`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8 COMMENT='姓氏表';