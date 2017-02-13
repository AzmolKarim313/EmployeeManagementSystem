-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: employee_management_db
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `contact_us_table`
--

DROP TABLE IF EXISTS `contact_us_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact_us_table` (
  `contact_id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `subject` varchar(45) DEFAULT NULL,
  `msg` varchar(550) DEFAULT NULL,
  PRIMARY KEY (`contact_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_us_table`
--

LOCK TABLES `contact_us_table` WRITE;
/*!40000 ALTER TABLE `contact_us_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `contact_us_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `designation_table`
--

DROP TABLE IF EXISTS `designation_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `designation_table` (
  `deg_id` int(11) NOT NULL,
  `designation_name` varchar(45) DEFAULT NULL,
  `gread` varchar(2) DEFAULT NULL,
  `salary` float DEFAULT NULL,
  PRIMARY KEY (`deg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `designation_table`
--

LOCK TABLES `designation_table` WRITE;
/*!40000 ALTER TABLE `designation_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `designation_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_info`
--

DROP TABLE IF EXISTS `emp_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emp_info` (
  `emp_id` varchar(9) NOT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) NOT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `job_title` varchar(45) DEFAULT NULL,
  `department` varchar(45) DEFAULT NULL,
  `dob` date NOT NULL,
  `nationality` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `contact` varchar(45) DEFAULT NULL,
  `mail_address` varchar(550) DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `contact_UNIQUE` (`contact`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_info`
--

LOCK TABLES `emp_info` WRITE;
/*!40000 ALTER TABLE `emp_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `emp_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `extra_activity_table`
--

DROP TABLE IF EXISTS `extra_activity_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `extra_activity_table` (
  `activity_id` int(11) NOT NULL,
  `emp_id` varchar(9) NOT NULL,
  `announcementAmount` float DEFAULT NULL,
  `notes` varchar(450) DEFAULT NULL,
  PRIMARY KEY (`activity_id`),
  KEY `emp_id_fk_eat_idx` (`emp_id`),
  CONSTRAINT `emp_id_fk_eat` FOREIGN KEY (`emp_id`) REFERENCES `emp_info` (`emp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extra_activity_table`
--

LOCK TABLES `extra_activity_table` WRITE;
/*!40000 ALTER TABLE `extra_activity_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `extra_activity_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `family_info`
--

DROP TABLE IF EXISTS `family_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `family_info` (
  `emp_id` varchar(9) NOT NULL,
  `nominy_name` varchar(45) DEFAULT NULL,
  `relation` varchar(45) DEFAULT NULL,
  `contact` varchar(45) DEFAULT NULL,
  `mail_address` varchar(450) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  CONSTRAINT `emp_id_fk_fi` FOREIGN KEY (`emp_id`) REFERENCES `emp_info` (`emp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `family_info`
--

LOCK TABLES `family_info` WRITE;
/*!40000 ALTER TABLE `family_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `family_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leave_info`
--

DROP TABLE IF EXISTS `leave_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leave_info` (
  `leave_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_id` varchar(9) DEFAULT NULL,
  `reason` varchar(45) DEFAULT NULL,
  `from_date` date DEFAULT NULL,
  `to_date` date DEFAULT NULL,
  `noOfDate` int(11) DEFAULT NULL,
  PRIMARY KEY (`leave_id`),
  KEY `emp_id_fk_li_idx` (`emp_id`),
  CONSTRAINT `emp_id_fk_li` FOREIGN KEY (`emp_id`) REFERENCES `emp_info` (`emp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_info`
--

LOCK TABLES `leave_info` WRITE;
/*!40000 ALTER TABLE `leave_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `leave_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `performance_table`
--

DROP TABLE IF EXISTS `performance_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `performance_table` (
  `perform_id` int(11) NOT NULL,
  `emp_id` varchar(9) DEFAULT NULL,
  `month` varchar(45) DEFAULT NULL,
  `noOfAssignment` int(11) DEFAULT NULL,
  `noOfClientDeily` int(11) DEFAULT NULL,
  `leave` int(11) DEFAULT NULL,
  PRIMARY KEY (`perform_id`),
  KEY `emp_id_fk_pt_idx` (`emp_id`),
  CONSTRAINT `emp_id_fk_pt` FOREIGN KEY (`emp_id`) REFERENCES `emp_info` (`emp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `performance_table`
--

LOCK TABLES `performance_table` WRITE;
/*!40000 ALTER TABLE `performance_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `performance_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary_info`
--

DROP TABLE IF EXISTS `salary_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salary_info` (
  `salary_id` int(11) NOT NULL,
  `emp_id` varchar(9) DEFAULT NULL,
  `deg_id` int(11) DEFAULT NULL,
  `perform_id` int(11) DEFAULT NULL,
  `activity_id` int(11) DEFAULT NULL,
  `total_salary` float DEFAULT NULL,
  PRIMARY KEY (`salary_id`),
  KEY `emp_id_fk_si_idx` (`emp_id`),
  KEY `deg_id_fk_si_idx` (`deg_id`),
  KEY `perform_id_fk_si_idx` (`perform_id`),
  KEY `activity_id_fk_si_idx` (`activity_id`),
  CONSTRAINT `activity_id_fk_si` FOREIGN KEY (`activity_id`) REFERENCES `extra_activity_table` (`activity_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `deg_id_fk_si` FOREIGN KEY (`deg_id`) REFERENCES `designation_table` (`deg_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `emp_id_fk_si` FOREIGN KEY (`emp_id`) REFERENCES `emp_info` (`emp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `perform_id_fk_si` FOREIGN KEY (`perform_id`) REFERENCES `performance_table` (`perform_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary_info`
--

LOCK TABLES `salary_info` WRITE;
/*!40000 ALTER TABLE `salary_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `salary_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_table`
--

DROP TABLE IF EXISTS `task_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_table` (
  `task_id` varchar(45) NOT NULL,
  `task_title` varchar(450) DEFAULT NULL,
  `emp_id` varchar(9) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `remarks` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`task_id`),
  KEY `emp_id_fk_tt_idx` (`emp_id`),
  CONSTRAINT `emp_id_fk_tt` FOREIGN KEY (`emp_id`) REFERENCES `emp_info` (`emp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_table`
--

LOCK TABLES `task_table` WRITE;
/*!40000 ALTER TABLE `task_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-27 10:52:29
