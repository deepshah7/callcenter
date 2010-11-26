-- MySQL dump 10.13  Distrib 5.1.45, for Win64 (unknown)
--
-- Host: localhost    Database: callcenter
-- ------------------------------------------------------
-- Server version	5.1.45-community

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
-- Current Database: `callcenter`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `callcenter` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `callcenter`;

--
-- Table structure for table `call_record`
--

DROP TABLE IF EXISTS `call_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `call_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `call_time` datetime DEFAULT NULL,
  `called_id` varchar(255) DEFAULT NULL,
  `called_party_name` varchar(255) DEFAULT NULL,
  `caller_id` varchar(255) DEFAULT NULL,
  `calling_party_name` varchar(255) DEFAULT NULL,
  `display_info` varchar(255) DEFAULT NULL,
  `internal` bit(1) DEFAULT NULL,
  `ip_address` varchar(255) DEFAULT NULL,
  `outgoing` bit(1) DEFAULT NULL,
  `target_id` varchar(255) DEFAULT NULL,
  `wave_file_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `call_record`
--

LOCK TABLES `call_record` WRITE;
/*!40000 ALTER TABLE `call_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `call_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fields`
--

DROP TABLE IF EXISTS `fields`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fields` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `available_by_default` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fields`
--

LOCK TABLES `fields` WRITE;
/*!40000 ALTER TABLE `fields` DISABLE KEYS */;
INSERT INTO `fields` VALUES (1,1,'Call Time','callTime',''),(2,1,'Calling Party Name','callingPartyName',''),(3,1,'Targeted Id','targetId',''),(4,1,'Called Party','calledId',''),(5,1,'Calling Party','callerId','\0'),(6,1,'Called Party Name','calledPartyName','\0'),(7,1,'IP Address of switch','ipAddress','');
/*!40000 ALTER TABLE `fields` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_members`
--

DROP TABLE IF EXISTS `group_members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_members` (
  `group_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`group_id`,`user_id`),
  KEY `FK3B9C77591C637EB6` (`user_id`),
  KEY `FK3B9C77599D5263FE` (`group_id`),
  CONSTRAINT `FK3B9C77591C637EB6` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FK3B9C77599D5263FE` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_members`
--

LOCK TABLES `group_members` WRITE;
/*!40000 ALTER TABLE `group_members` DISABLE KEYS */;
INSERT INTO `group_members` VALUES (1,1),(1,2),(2,2),(1,3),(2,3);
/*!40000 ALTER TABLE `group_members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES (1,0,'Call Center Group','5001'),(2,0,'Banking Accounts Group','7001');
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recording_library_service_available_fields`
--

DROP TABLE IF EXISTS `recording_library_service_available_fields`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recording_library_service_available_fields` (
  `recording_library_service_id` bigint(20) NOT NULL,
  `field_id` bigint(20) NOT NULL,
  PRIMARY KEY (`recording_library_service_id`,`field_id`),
  KEY `FKBE3658CB605E5166` (`recording_library_service_id`),
  KEY `FKBE3658CB47B20E1E` (`field_id`),
  CONSTRAINT `FKBE3658CB47B20E1E` FOREIGN KEY (`field_id`) REFERENCES `fields` (`id`),
  CONSTRAINT `FKBE3658CB605E5166` FOREIGN KEY (`recording_library_service_id`) REFERENCES `recording_library_services` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recording_library_service_available_fields`
--

LOCK TABLES `recording_library_service_available_fields` WRITE;
/*!40000 ALTER TABLE `recording_library_service_available_fields` DISABLE KEYS */;
INSERT INTO `recording_library_service_available_fields` VALUES (4,1),(4,7);
/*!40000 ALTER TABLE `recording_library_service_available_fields` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recording_library_services`
--

DROP TABLE IF EXISTS `recording_library_services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recording_library_services` (
  `id` bigint(20) NOT NULL,
  `recording_type` varchar(255) DEFAULT NULL,
  `retain_from` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8BD0A3F0AAA3B174` (`id`),
  CONSTRAINT `FK8BD0A3F0AAA3B174` FOREIGN KEY (`id`) REFERENCES `services` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recording_library_services`
--

LOCK TABLES `recording_library_services` WRITE;
/*!40000 ALTER TABLE `recording_library_services` DISABLE KEYS */;
INSERT INTO `recording_library_services` VALUES (1,NULL,NULL),(2,NULL,NULL),(3,NULL,NULL),(4,NULL,NULL);
/*!40000 ALTER TABLE `recording_library_services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restriction_values`
--

DROP TABLE IF EXISTS `restriction_values`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restriction_values` (
  `restriction_id` bigint(20) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  `value_index` int(11) NOT NULL,
  PRIMARY KEY (`restriction_id`,`value_index`),
  KEY `FKD0A5E8F5D4B1B9DE` (`restriction_id`),
  CONSTRAINT `FKD0A5E8F5D4B1B9DE` FOREIGN KEY (`restriction_id`) REFERENCES `restrictions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restriction_values`
--

LOCK TABLES `restriction_values` WRITE;
/*!40000 ALTER TABLE `restriction_values` DISABLE KEYS */;
/*!40000 ALTER TABLE `restriction_values` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restrictions`
--

DROP TABLE IF EXISTS `restrictions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restrictions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `field` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `service_id` bigint(20) NOT NULL,
  `field_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKBB8E66277738BAD6` (`role_id`),
  KEY `FKBB8E662784E03898` (`field`),
  KEY `FKBB8E66271F595A54` (`service_id`),
  KEY `FKBB8E662743D5D73E` (`service_id`),
  KEY `FKBB8E662747B20E1E` (`field_id`),
  CONSTRAINT `FKBB8E66271F595A54` FOREIGN KEY (`service_id`) REFERENCES `recording_library_services` (`id`),
  CONSTRAINT `FKBB8E662743D5D73E` FOREIGN KEY (`service_id`) REFERENCES `services` (`id`),
  CONSTRAINT `FKBB8E662747B20E1E` FOREIGN KEY (`field_id`) REFERENCES `fields` (`id`),
  CONSTRAINT `FKBB8E66277738BAD6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKBB8E662784E03898` FOREIGN KEY (`field`) REFERENCES `fields` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restrictions`
--

LOCK TABLES `restrictions` WRITE;
/*!40000 ALTER TABLE `restrictions` DISABLE KEYS */;
/*!40000 ALTER TABLE `restrictions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_assignables`
--

DROP TABLE IF EXISTS `role_assignables`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_assignables` (
  `role_id` bigint(20) NOT NULL,
  `assignable_role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`assignable_role_id`),
  KEY `FKEE1B0817738BAD6` (`role_id`),
  KEY `FKEE1B081BF438F60` (`assignable_role_id`),
  CONSTRAINT `FKEE1B0817738BAD6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKEE1B081BF438F60` FOREIGN KEY (`assignable_role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_assignables`
--

LOCK TABLES `role_assignables` WRITE;
/*!40000 ALTER TABLE `role_assignables` DISABLE KEYS */;
INSERT INTO `role_assignables` VALUES (3,1),(4,2),(4,3);
/*!40000 ALTER TABLE `role_assignables` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_services`
--

DROP TABLE IF EXISTS `role_services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_services` (
  `role_id` bigint(20) NOT NULL,
  `service_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`service_id`),
  KEY `FK156EE6077738BAD6` (`role_id`),
  KEY `FK156EE60743D5D73E` (`service_id`),
  CONSTRAINT `FK156EE60743D5D73E` FOREIGN KEY (`service_id`) REFERENCES `services` (`id`),
  CONSTRAINT `FK156EE6077738BAD6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_services`
--

LOCK TABLES `role_services` WRITE;
/*!40000 ALTER TABLE `role_services` DISABLE KEYS */;
INSERT INTO `role_services` VALUES (2,2),(3,3),(4,1),(4,2),(4,3);
/*!40000 ALTER TABLE `role_services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `can_add_groups` bit(1) DEFAULT NULL,
  `can_add_roles` bit(1) DEFAULT NULL,
  `can_add_users` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `timeout` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,1,'','','','Administrator','en_GB','ROLE_ADMIN',600),(2,0,'\0','\0','\0','Default Role','en_US','ROLE_DEFAULT',300),(3,0,'','\0','','User Role','en_GB','ROLE_USER',300),(4,0,'','','','Credit Card Role','en_US','ROLE_CREDIT_CARD',300);
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `services` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES (1,1,'RL_ADMIN'),(2,1,'RL_DEFAULT'),(3,1,'RL_USER'),(4,0,'RL_TEST');
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `FK6A68E08255CA5C8` (`role`),
  CONSTRAINT `FK6A68E08255CA5C8` FOREIGN KEY (`role`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,1,'','admin','admin',1),(2,1,'en_gb','creditcard','creditcard',4),(3,1,'en_gb','batman','catwoman',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2010-11-26 11:35:01
