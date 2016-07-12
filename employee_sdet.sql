-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: employee_sdet
-- ------------------------------------------------------
-- Server version	5.6.23-log

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
-- Current Database: `employee_sdet`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `employee_sdet` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `employee_sdet`;

--
-- Table structure for table `competence`
--

DROP TABLE IF EXISTS `competence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `competence` (
  `idcompetence` int(11) NOT NULL AUTO_INCREMENT,
  `competence_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcompetence`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `competence`
--

LOCK TABLES `competence` WRITE;
/*!40000 ALTER TABLE `competence` DISABLE KEYS */;
INSERT INTO `competence` VALUES (1,'C1'),(2,'C2'),(3,'C3'),(4,'C4'),(5,'C5'),(6,'C6'),(7,'C7'),(8,'C8'),(9,'C9');
/*!40000 ALTER TABLE `competence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `idemployee` int(11) NOT NULL,
  `employee_name` varchar(45) DEFAULT NULL,
  `idcompetence` int(11) DEFAULT NULL,
  `idsubpractice` int(11) DEFAULT NULL,
  `idverticals` int(11) DEFAULT NULL,
  PRIMARY KEY (`idemployee`),
  KEY `idcompetence_idx` (`idcompetence`),
  KEY `idsubpractice_idx` (`idsubpractice`),
  KEY `idverticals_idx` (`idverticals`),
  CONSTRAINT `idcompetence` FOREIGN KEY (`idcompetence`) REFERENCES `competence` (`idcompetence`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idsubpractice` FOREIGN KEY (`idsubpractice`) REFERENCES `subpractice` (`idsubpractice`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idverticals` FOREIGN KEY (`idverticals`) REFERENCES `verticals` (`idverticals`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1027353,'CHITKARSH GANDHI',2,2,4),(1028099,'KRISHNANAND SINGH',1,2,4);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subpractice`
--

DROP TABLE IF EXISTS `subpractice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subpractice` (
  `idsubpractice` int(11) NOT NULL AUTO_INCREMENT,
  `subpractice_name` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`idsubpractice`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subpractice`
--

LOCK TABLES `subpractice` WRITE;
/*!40000 ALTER TABLE `subpractice` DISABLE KEYS */;
INSERT INTO `subpractice` VALUES (1,'Automation Testing'),(2,'Performance Testing'),(3,'Functional Testing'),(4,'Digital Testing');
/*!40000 ALTER TABLE `subpractice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `verticals`
--

DROP TABLE IF EXISTS `verticals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `verticals` (
  `idverticals` int(11) NOT NULL AUTO_INCREMENT,
  `verticals_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idverticals`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `verticals`
--

LOCK TABLES `verticals` WRITE;
/*!40000 ALTER TABLE `verticals` DISABLE KEYS */;
INSERT INTO `verticals` VALUES (1,'TTH'),(2,'RCM'),(3,'BFSI'),(4,'COE');
/*!40000 ALTER TABLE `verticals` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-12 19:46:51
