DROP SCHEMA IF EXISTS `university`;

CREATE SCHEMA `university`;

use `university`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `degree`;

CREATE TABLE `degree` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `degree` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `head`;

CREATE TABLE `head` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(45) DEFAULT NULL,
  `head_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  UNIQUE KEY `DEPARTMENT_NAME` (`department_name`),
  
  KEY `FK_HEAD_idx` (`head_id`),
  
  CONSTRAINT `FK_HEAD` 
  FOREIGN KEY (`head_id`) 
  REFERENCES `head` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `lector`;

CREATE TABLE `lector` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `salary` int(11) NOT NULL,
  `degree_id` int(11) NOT NULL,
  
  PRIMARY KEY (`id`),
  
  KEY `FK_DEGREE_idx` (`degree_id`),
  
  CONSTRAINT `FK_DEGREE` 
  FOREIGN KEY (`degree_id`) 
  REFERENCES `degree` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `department_lector`;

CREATE TABLE `department_lector` (
  `department_id` int(11) NOT NULL,
  `lector_id` int(11) NOT NULL,
  
  PRIMARY KEY (`department_id`,`lector_id`),
  
  KEY `FK_LECTOR_idx` (`lector_id`),
  
  CONSTRAINT `FK_DEPARTMENT_05` FOREIGN KEY (`department_id`) 
  REFERENCES `department` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_LECTOR` FOREIGN KEY (`lector_id`) 
  REFERENCES `lector` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `degree` VALUES 
	(1, 'Assistant'),
	(2, 'Associate professor'),
	(3, 'Professor');
    
INSERT INTO `head` VALUES 
	(1, 'Robert', 'Kiyosaki'),
	(2, 'Bill', 'Gates'),
	(3, 'Jeff', 'Bezos'),
    (4, 'Tim', 'Cook');
    
INSERT INTO `department` VALUES 
	(1, 'Mathematics', 1),
	(2, 'Physics', 4),
	(3, 'Informatics', 2),
    (4, 'Philosophy', 3);
    
INSERT INTO `lector` VALUES 
	(1, 'Andriy', 'Mykush' , 1300, 3),
    (2, 'Taras', 'Sadovyi' , 500, 1),
    (3, 'Andrew', 'Malikov' , 800, 2),
    (4, 'Vasyl', 'Vasylyshyn' , 1200, 3),
    (5, 'Volodymyr', 'Vergun' , 750, 2),
    (6, 'Marko', 'Vovchok' , 600, 1),
    (7, 'Pavlo', 'Tsymbaliuk' , 750, 2),
    (8, 'Maksym', 'Paniak' , 680, 1),
    (9, 'Ruslan', 'Stosyk' , 950, 1),
    (10, 'Anton', 'Havrylenko' , 1400, 3);
    
INSERT INTO `department_lector` VALUES 
	(1, 1),
	(3, 1),
	(1, 2),
	(1, 3),
	(2, 3),
	(3, 3),
	(4, 4),
	(1, 5),
	(2, 5),
	(2, 6),
	(3, 6),
	(4, 7),
	(1, 8),
	(2, 8),
	(3, 8),
	(2, 9),
	(3, 9),
	(1, 10),
	(2, 10),
	(3, 10),
	(4, 10);

SET FOREIGN_KEY_CHECKS = 1;
