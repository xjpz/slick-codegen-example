DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(100) NOT NULL COMMENT '用户名',
  `password` char(50) NOT NULL COMMENT '密码',
  `email` varchar(100) DEFAULT '' COMMENT '邮箱',
  `phone` char(11) DEFAULT '' COMMENT '电话',
  `type` tinyint(1) unsigned DEFAULT '0',
  `status` tinyint(1) DEFAULT '0',
  `init_time` int(10) unsigned DEFAULT '0',
  `update_time` int(10) unsigned DEFAULT '0',
  `tombstone` tinyint(1) unsigned DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `name` (`name`),
  KEY `email` (`email`),
  KEY `phone` (`phone`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO `user` (`id`, `name`, `password`, `email`, `phone`, `type`, `status`, `init_time`, `update_time`, `tombstone`)
VALUES
	(1, 'Andy', '', 'andy@123.com', '12300000000', 0, 0, 1488096840, 1488096840, 0);
