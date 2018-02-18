/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.1.25-MariaDB : Database - jeeprofesional
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jeeprofesional` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `jeeprofesional`;

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id_course` int(11) NOT NULL AUTO_INCREMENT,
  `id_teacher` int(11) DEFAULT NULL,
  `name` varchar(250) CHARACTER SET utf8mb4 NOT NULL,
  `themes` text CHARACTER SET utf8mb4,
  `project` varchar(250) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`id_course`),
  KEY `id_teacher` (`id_teacher`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`id_course`,`id_teacher`,`name`,`themes`,`project`) values (1,NULL,'Java Avanzado','Tema 1','Rest API');

/*Table structure for table `social_media` */

DROP TABLE IF EXISTS `social_media`;

CREATE TABLE `social_media` (
  `id_social_media` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  `icon` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id_social_media`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `social_media` */

insert  into `social_media`(`id_social_media`,`name`,`icon`) values (1,'twitter',''),(2,'facebook','avatar'),(3,'LinkedIn','avatar');

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `id_teacher` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  `avatar` varchar(250) NOT NULL,
  PRIMARY KEY (`id_teacher`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `teacher` */

insert  into `teacher`(`id_teacher`,`name`,`avatar`) values (1,'Danny Vásquez',''),(2,'Gaby Rafael','Avatar'),(3,'Francisco Vásquez','Avatar');

/*Table structure for table `teacher_social_media` */

DROP TABLE IF EXISTS `teacher_social_media`;

CREATE TABLE `teacher_social_media` (
  `id_teacher_social_media` int(11) NOT NULL AUTO_INCREMENT,
  `id_teacher` int(11) NOT NULL,
  `id_social_media` int(11) NOT NULL,
  `nickname` varchar(250) NOT NULL,
  PRIMARY KEY (`id_teacher_social_media`),
  KEY `id_teacher` (`id_teacher`,`id_social_media`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `teacher_social_media` */

insert  into `teacher_social_media`(`id_teacher_social_media`,`id_teacher`,`id_social_media`,`nickname`) values (1,1,1,'@DANNY_22VR'),(2,1,2,'DannyVasques');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
