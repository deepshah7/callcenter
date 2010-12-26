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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `call_record`
--

LOCK TABLES `call_record` WRITE;
/*!40000 ALTER TABLE `call_record` DISABLE KEYS */;
INSERT INTO `call_record` VALUES (1,0,'2010-09-14 14:15:17','2002','Extn2002','2001','Extn2001','Extn2001','','10.10.250.10','\0','2002','20101209154500_test1.wav'),(2,0,'2010-09-14 14:15:17','2002','Extn2002','2001','Extn2001','Extn2001','','10.10.250.20','\0','2002','20101209154500_test2.wav'),(3,0,'2010-09-14 14:17:52','2001','Extn2001','2009','Extn2009','Extn2009','','10.10.250.30','\0','2001','20101209154501_test3.wav');
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
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fields`
--

LOCK TABLES `fields` WRITE;
/*!40000 ALTER TABLE `fields` DISABLE KEYS */;
INSERT INTO `fields` VALUES (1,1,'Call Time','callTime','',1),(2,1,'Calling Party Name','callingPartyName','',0),(3,1,'Targeted Id','targetId','',0),(4,1,'Called Party','calledId','',0),(5,1,'Calling Party','callerId','\0',0),(6,1,'Called Party Name','calledPartyName','\0',0),(7,1,'IP Address of switch','ipAddress','',0);
/*!40000 ALTER TABLE `fields` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_member_groups`
--

DROP TABLE IF EXISTS `group_member_groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_member_groups` (
  `group_id` bigint(20) NOT NULL,
  `other_group_id` bigint(20) NOT NULL,
  PRIMARY KEY (`group_id`,`other_group_id`),
  KEY `FK147309599D5263FE` (`group_id`),
  KEY `FK147309594C5B084D` (`other_group_id`),
  CONSTRAINT `FK147309594C5B084D` FOREIGN KEY (`other_group_id`) REFERENCES `groups` (`id`),
  CONSTRAINT `FK147309599D5263FE` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_member_groups`
--

LOCK TABLES `group_member_groups` WRITE;
/*!40000 ALTER TABLE `group_member_groups` DISABLE KEYS */;
INSERT INTO `group_member_groups` VALUES (3,2);
/*!40000 ALTER TABLE `group_member_groups` ENABLE KEYS */;
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
INSERT INTO `group_members` VALUES (1,1),(1,2),(2,2),(1,3),(2,3),(3,6),(3,7),(3,8),(3,9);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES (1,0,'Call Center Group','5001'),(2,0,'Banking Accounts Group','7001'),(3,0,'CreateGroupTest','9001');
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
INSERT INTO `recording_library_service_available_fields` VALUES (4,1),(4,7),(16,1),(16,7),(18,1),(18,7),(19,1),(19,7),(21,1),(21,2),(21,3),(21,4),(21,7),(22,1),(22,4),(22,7),(23,1),(23,2),(23,3),(23,4),(23,5),(24,1),(24,2),(24,3),(24,4),(24,7),(25,1),(25,2),(25,3),(25,4),(25,5),(25,6),(25,7);
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
INSERT INTO `recording_library_services` VALUES (1,NULL,NULL),(2,NULL,NULL),(3,NULL,NULL),(4,NULL,NULL),(16,NULL,'2010-11-01 00:00:00'),(18,NULL,'2010-11-02 00:00:00'),(19,NULL,'2010-01-01 00:00:00'),(21,NULL,'2010-12-01 00:00:00'),(22,NULL,'2010-12-09 00:00:00'),(23,NULL,'2010-12-01 00:00:00'),(24,NULL,'2010-12-01 00:00:00'),(25,NULL,'2000-12-01 00:00:00');
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
INSERT INTO `restriction_values` VALUES (1,'10.0.0.1',0),(1,'10.23.23.11',1),(1,'10.45.56.67',2),(2,'5001',0),(2,'5002',1),(2,'4005',2),(2,'4059',3),(3,'2010-01-01',0),(3,'2010-12-31',1),(4,'5001',0),(4,'5002',1),(4,'4005',2),(4,'4059',3),(5,'10.0.0.1',0),(5,'10.23.23.11',1),(5,'10.45.56.67',2),(6,'6001',0),(8,'10.10.250.30',0),(9,'10.88.88.1',0),(9,'10.88.88.2',1),(9,'10.88.88.3',2),(10,'2010-01-01',0),(10,'2010-12-31',1),(11,'5001',0),(11,'5002',1),(11,'5003',2),(12,'10.10.250.10',0),(13,'2005',0),(13,'2006',1),(13,'2007',2),(14,'2010-01-01',0),(14,'2010-12-31',1);
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
  `service_id` bigint(20) NOT NULL,
  `field_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKBB8E66271F595A54` (`service_id`),
  KEY `FKBB8E662743D5D73E` (`service_id`),
  KEY `FKBB8E662747B20E1E` (`field_id`),
  CONSTRAINT `FKBB8E66271F595A54` FOREIGN KEY (`service_id`) REFERENCES `recording_library_services` (`id`),
  CONSTRAINT `FKBB8E662743D5D73E` FOREIGN KEY (`service_id`) REFERENCES `services` (`id`),
  CONSTRAINT `FKBB8E662747B20E1E` FOREIGN KEY (`field_id`) REFERENCES `fields` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restrictions`
--

LOCK TABLES `restrictions` WRITE;
/*!40000 ALTER TABLE `restrictions` DISABLE KEYS */;
INSERT INTO `restrictions` VALUES (1,0,'BETWEEN',18,1),(2,0,'IN',18,3),(3,0,'BETWEEN',19,1),(4,0,'IN',19,4),(5,0,'IN',19,7),(6,0,'IN',19,3),(8,0,'IN',21,7),(9,0,'IN',22,7),(10,0,'BETWEEN',22,1),(11,0,'IN',22,5),(12,0,'IN',23,7),(13,0,'IN',24,3),(14,0,'BETWEEN',24,1);
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
INSERT INTO `role_assignables` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,11),(3,1),(4,2),(4,3),(6,2),(7,2),(7,3),(7,5),(7,6),(8,2),(8,3),(8,4),(8,6),(9,2),(9,3),(9,6),(10,2),(10,3),(10,5),(10,6),(11,4),(11,5),(11,6),(11,7),(11,8),(11,9),(11,10);
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
INSERT INTO `role_services` VALUES (1,25),(2,2),(3,3),(4,1),(4,2),(4,3),(5,19),(6,21),(7,19),(8,23),(9,24),(10,2),(10,3),(10,4),(11,16),(11,18),(11,19),(11,21),(11,22),(11,23),(11,24);
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,2,'','','','Administrator','en_GB','ROLE_ADMIN',600),(2,0,'\0','\0','\0','Default Role','en_US','ROLE_DEFAULT',300),(3,0,'','\0','','User Role','en_GB','ROLE_USER',300),(4,0,'','','','Credit Card Role','en_US','ROLE_CREDIT_CARD',300),(5,0,'\0','\0','\0','CC user role','en_US','ROLE_CC',300),(6,0,'\0','\0','\0','Bank Account Role','en_GB','ROLE_BANK_ACCOUNT',300),(7,0,'','','','The administrator of bank','en_US','ROLE_BANK_ADMIN',300),(8,0,'','','','Vodafone Default User','en_GB','ROLE_VODAFONE_DEFAULT',300),(9,0,'\0',NULL,'','can add user','en_GB','ROLE_CAN_ADD_USER',300),(10,0,'\0',NULL,'','tesing whether it gets added','en_US','ROLE_TEST_ADMIN',300),(11,0,'',NULL,'','admin test 1','en_US','ROLE_ADMIN_TEST1',300);
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES (1,1,'RL_ADMIN'),(2,1,'RL_DEFAULT'),(3,1,'RL_USER'),(4,0,'RL_TEST'),(16,0,'TLERE'),(18,0,'REERE'),(19,0,'RL_CC'),(21,0,'RL_IP_ONLY'),(22,0,'RL_BA'),(23,0,'RL_VODAFONE_DEFAULT'),(24,0,'RL_VODAFONE_SMALL'),(25,0,'RL_ADMIN_ALL_ACCESS');
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,1,'','admin','admin',1),(2,1,'en_gb','creditcard','creditcard',4),(3,1,'en_gb','batman','catwoman',1),(6,0,NULL,'testccuser','testccuser',5),(7,0,'en_GB','testbankaccount','testbankaccount',6),(8,0,'en_US','vodafonedefault','vodafonedefault',8),(9,0,'en_GB','testcanadduser','testcanadduser',9),(10,0,'en_US','testadminuser1','testadminuser',11),(11,0,'en_US','anothertestuser','anothertestuser',3);
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

-- Dump completed on 2010-12-26 13:18:58
