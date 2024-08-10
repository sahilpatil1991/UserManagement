CREATE SCHEMA `todo_task` ;

CREATE TABLE `tasks` (
  `id` int NOT NULL AUTO_INCREMENT,
  `task` varchar(45) DEFAULT NULL,
  `priority` varchar(45) DEFAULT NULL,
  `duration` int DEFAULT NULL,
  `assigne` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

