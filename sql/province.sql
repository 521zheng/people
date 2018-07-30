CREATE TABLE province (
  `id` char(32) NOT NULL COMMENT '主键',
  `province_name` char(6) NOT NULL COMMENT '省份名称',
  `capital` char(32) NOT NULL COMMENT '首府',
  `create_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期时间',
  `update_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='省份';