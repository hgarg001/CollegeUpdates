CREATE DATABASE  IF NOT EXISTS `collegeupdates` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `collegeupdates`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: collegeupdates
-- ------------------------------------------------------
-- Server version	5.5.53

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `comments_on_post`
--

DROP TABLE IF EXISTS `comments_on_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments_on_post` (
  `POST_ID` bigint(10) DEFAULT NULL,
  `COMMENT_BY_USER_ID` varchar(30) DEFAULT NULL,
  `COMMENT_DATE_TIME` datetime NOT NULL,
  `COMMENT_TEXT` varchar(500) DEFAULT NULL,
  `COMMENT_IMAGE` blob,
  KEY `POST_ID` (`POST_ID`),
  KEY `COMMENT_BY_USER_ID` (`COMMENT_BY_USER_ID`),
  CONSTRAINT `comments_on_post_ibfk_1` FOREIGN KEY (`POST_ID`) REFERENCES `user_post` (`POST_ID`),
  CONSTRAINT `comments_on_post_ibfk_2` FOREIGN KEY (`COMMENT_BY_USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments_on_post`
--

LOCK TABLES `comments_on_post` WRITE;
/*!40000 ALTER TABLE `comments_on_post` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments_on_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `DEPARTMENT_NAME` varchar(50) NOT NULL,
  `HEAD_OF_DEPARTMENT` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`DEPARTMENT_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES ('COMPUTER SCIENCE','R. K. GUPTA');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `USER_ID` varchar(30) NOT NULL,
  `USER_NAME` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `GENDER` char(1) NOT NULL,
  `DATE_OF_BIRTH` date DEFAULT NULL,
  `BRANCH` varchar(30) NOT NULL,
  `DEPARTMENT_NAME` varchar(50) NOT NULL,
  `EMAIL_ID` varchar(50) NOT NULL,
  `MOBILE_NUMBER` bigint(10) NOT NULL,
  `PROFILE_PIC` blob,
  `USER_TYPE` char(1) NOT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `EMAIL_ID` (`EMAIL_ID`),
  UNIQUE KEY `MOBILE_NUMBER` (`MOBILE_NUMBER`),
  KEY `DEPARTMENT_NAME` (`DEPARTMENT_NAME`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`DEPARTMENT_NAME`) REFERENCES `department` (`DEPARTMENT_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('0901CS111029','HITENDRA GARG','12345','M','1992-05-26','CSE','COMPUTER SCIENCE','HITENDRAGARG001@GMAIL.COM',9620339100,NULL,'E'),('643564356','12345','dgegdfgsd','M','2017-03-16','sdgdfg','COMPUTER SCIENCE','fhfdgh@dfgd',456456,NULL,'E'),('DFGDFG','1234','shdfh','M','2017-03-16','sfghh','COMPUTER SCIENCE','sdgdfgs@cxg',698698,NULL,'E'),('fghfgh','4785','fghdh','M','2017-04-11','fhdgh','COMPUTER SCIENCE','fghfg@dfhdfh.g',3453453,NULL,'E'),('gdsgdfg','789','dfgdgs','F','2017-04-11','3hdf','COMPUTER SCIENCE','hgfhfghf@fghgfh.gf',352,NULL,'E'),('SDBBCVB','456','CBcbcbcbx','F','2017-04-10','xcbcvbx','COMPUTER SCIENCE','bxcb@dfgdfg.dfgsd',3345435,NULL,'E');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_liked_post`
--

DROP TABLE IF EXISTS `user_liked_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_liked_post` (
  `POST_ID` bigint(10) NOT NULL DEFAULT '0',
  `USER_ID` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`POST_ID`,`USER_ID`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `user_liked_post_ibfk_1` FOREIGN KEY (`POST_ID`) REFERENCES `user_post` (`POST_ID`),
  CONSTRAINT `user_liked_post_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_liked_post`
--

LOCK TABLES `user_liked_post` WRITE;
/*!40000 ALTER TABLE `user_liked_post` DISABLE KEYS */;
INSERT INTO `user_liked_post` VALUES (1,'DFGDFG'),(2,'DFGDFG'),(3,'DFGDFG');
/*!40000 ALTER TABLE `user_liked_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_post`
--

DROP TABLE IF EXISTS `user_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_post` (
  `POST_ID` bigint(10) NOT NULL AUTO_INCREMENT,
  `POST_OWNER_ID` varchar(30) DEFAULT NULL,
  `POST_DATE_TIME` datetime NOT NULL,
  `POST_TEXT` varchar(500) DEFAULT NULL,
  `POST_IMAGE1` blob,
  `POST_IMAGE2` blob,
  `POST_IMAGE3` blob,
  `POST_IMAGE4` blob,
  `NO_OF_LIKES` bigint(5) DEFAULT NULL,
  PRIMARY KEY (`POST_ID`),
  KEY `POST_OWNER_ID` (`POST_OWNER_ID`),
  CONSTRAINT `user_post_ibfk_1` FOREIGN KEY (`POST_OWNER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_post`
--

LOCK TABLES `user_post` WRITE;
/*!40000 ALTER TABLE `user_post` DISABLE KEYS */;
INSERT INTO `user_post` VALUES (1,'DFGDFG','2017-04-09 00:30:25','hrhfg',NULL,NULL,NULL,NULL,1),(2,'DFGDFG','2017-04-09 00:30:29','fghfghdfgh',NULL,NULL,NULL,NULL,1),(3,'DFGDFG','2017-04-09 00:30:32','fghdfhfgh',NULL,NULL,NULL,NULL,1),(4,'DFGDFG','2017-04-09 00:33:37','fgjdf',NULL,NULL,NULL,NULL,0),(5,'DFGDFG','2017-04-09 09:07:45','gkjgk',NULL,NULL,NULL,NULL,0),(6,'DFGDFG','2017-04-09 09:07:56','fdbcnxcn',NULL,NULL,NULL,NULL,0),(7,'DFGDFG','2017-04-09 09:07:59','cbcvbcvbx',NULL,NULL,NULL,NULL,0),(8,'DFGDFG','2017-04-09 09:08:02','bfdgdfdh',NULL,NULL,NULL,NULL,0),(10,'DFGDFG','2017-04-09 15:45:17','fjhgjkgkjgkjgjkjgkjkggjkgkjjkgjgkgkjkgjkgjjgkjgkjgkjgkjkgkjggkjkgjkjgkjgkjgjgkjkgjgkjgk\r\n,b,nbmmmmmmmmmmmmmmmmmmmmmmmmmmmmmghkhhhhiutiugfukigkjgkjhkjhkjhkjhkjhkjhkhkjhkjhkjkjhkjhkjhkj',NULL,NULL,NULL,NULL,0),(11,'DFGDFG','2017-04-09 23:26:41','vkjbk',NULL,NULL,NULL,NULL,0),(12,'DFGDFG','2017-04-11 00:26:01','lkxvhlkvhlkvsdvsdv',NULL,NULL,NULL,NULL,0),(13,'DFGDFG','2017-04-11 00:26:22','fddgdgdfg\r\nb\r\ncbc\r\nbcv\r\nbcv\r\nb',NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `user_post` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-15  8:35:27
