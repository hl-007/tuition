alter table sg_lost_things modify id varchar(64) NOT NULL COMMENT '部门编号';
alter table sg_lost_things add file_name varchar(32) DEFAULT NULL COMMENT '文件名称';
alter table sg_lost_things drop publish_type;