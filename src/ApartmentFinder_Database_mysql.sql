CREATE DATABASE  IF NOT EXISTS `apartments` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `apartments`;
-- MySQL dump 10.13  Distrib 5.6.11, for Win32 (x86)
--
-- Host: localhost    Database: apartments
-- ------------------------------------------------------
-- Server version	5.6.13

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addresscol` varchar(100) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zipcode` varchar(45) DEFAULT NULL,
  `apartmentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_apartmentId_idx` (`apartmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=939881 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (179019,'20520 Bothell Everett Hwy, Bothell, WA 98012','Bothell','WA','98012',139206),(359763,'100 NE, 9th Ave','seattle','wa','98101',403936),(450412,'19905 BOTHELL-EVERETT HWY BOTHELL, WA 98012','Bothell','WA','98012',426198),(560367,'1525 NE, 9th Ave','seattle','wa','98101',1),(693573,'19128 112TH AVE NE, BOTHELL, WA ','Bothell','WA','19128',636133),(708524,'1942 Westlake Avenue, Seattle, WA, 98101','Seattle','WA','98101',719051),(739180,'1000 100th Ave NE, Bellevue, WA 98004','Bellevue',' WA','98004',519664),(777695,'100 NE, 9th Ave','seattle','wa','98101',2),(893486,'801 Pine St, Seattle, WA ','Seattle','WA','98101',763262),(939880,'888 Pine St, Seattle, WA','Seattle','WA','98101',621311);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apartment`
--

DROP TABLE IF EXISTS `apartment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apartment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `owner` varchar(45) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `imageurl` varchar(200) DEFAULT NULL,
  `parking` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=886637 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apartment`
--

LOCK TABLES `apartment` WRITE;
/*!40000 ALTER TABLE `apartment` DISABLE KEYS */;
INSERT INTO `apartment` VALUES (1,'Premiere on Pine','bbarker',' Premiere on Pine is a 440-foot tall residential skyscraper in Seattle, Washington.',' https://cdngeneral.rentcafe.com/dmslivecafe/3/235042/Terrace%20IMG_5013enfB_2.jpg','Garage: $200-300'),(2,'Tower 21','boby','Tower 21  is a residential skyscraper in Seattle, Washington.','https://images.pexels.com/photos/439391/pexels-photo-439391.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500','$300 per month'),(139206,'Madison Park Apartment','Eliana','Madison Park Apartments offers gorgeous one and two bedroom apartment homes!','https://i0.wp.com/www.madisonparkapartments.net/wp-content/uploads/2017/12/front-sign.jpg?fit=1024%2C683&ssl=1','Garage: $50 '),(320250,'Tower 801','Eliana','','','No details to show'),(403936,'Hyatt Place','Rachel','The core of the downtown','https://assets.hyatt.com/content/dam/hyatt/hyattdam/images/2018/08/30/1555/Hyatt-Place-Seattle-Downtown-P003-Exterior.jpg/Hyatt-Place-Seattle-Downtown-P003-Exterior.16x9.adapt.1920.1080.jpg','300 per month'),(426198,'Avalon RockMeadow','Diana','We believe elevating where you live is about blending it seamlessly with how you live','https://www.avaloncommunities.com/~/media/Images/Community-Photos/Pacific%20Northwest/Washington/Avalon%20RockMeadow/Heros_Thumbs/RockMeadow_Hero.jpg','No details to show'),(519664,'Lux','Joe','nfused with modern sophistication, quartz counters, stainless steel appliances, private decks and the comforts of air conditioning and garage parking.','https://images1.apartments.com/i2/uvnhYnTnPfI67eUXlbbky3XokradMbByX3sxFKbuR8E/111/lux-bellevue-wa-primary-photo.jpg','Garage: $150 - 175'),(602302,'Tower 801','Eliana','this is good','','No details to show'),(621311,'New Apartment','Eliana','','','No details to show'),(636133,'The Villas at Beardslee','Zoe','The Villas at Beardslee is a luxury apartment community in the city of Bothell.','https://www.hollandresidential.com/globalassets/the-villas-at-beardslee/gallery/gallery-banner.jpg','$100 per month'),(719051,'Met Tower','Peter','The Met Tower is currently offering new, urban apartments for rent on the Museum Reach of the San Antonio River. ','https://cdngeneral.rentcafe.com/dmslivecafe/3/76175/mt2-123.jpg?&quality=85&','$100 per month'),(763262,'Tower 801','Polar','Tower 801 is shaping the future of Seattles vibrant downtown lifestyle!','https://cdngeneral.rentcafe.com/dmslivecafe/3/534942/Tower_801_Seattle_WA_ApartmentLivingRoomIntoKitchen.jpg?crop=(0,0,300,200)&cropxunits=300&cropyunits=200&quality=85&','No details to show'),(814009,'Tower 801','Eliana','','','No details to show'),(823046,'the spencer 61','Bear','this is good house','',''),(886636,'Tower 801','soheli','','','No details to show');
/*!40000 ALTER TABLE `apartment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `representative` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `openhour` varchar(45) DEFAULT NULL,
  `apartmentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_apartmentId_idx` (`apartmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=883253 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (175215,'Rachel','425.309.8757','abc@yahoo.com','MON - FRI: 10:00AM - 6:00PM',636133),(222668,'Danny','425-214-4764','xyz@google.com',' Moday to Friday 9 AM to 6 PM',519664),(560398,'Rachel','866-372-3152','abc@gmail.com','MON - FRI: 10:00AM - 6:00PM',1),(816091,'Rachel','866-372-3152','abc@gmail.com',' Moday to Friday 9 AM to 6 PM',139206),(883252,'Diana','(877) 684-6828','abc@gmail.com',' Moday to Friday 9 AM to 6 PM',426198);
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deals`
--

DROP TABLE IF EXISTS `deals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deals` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(200) DEFAULT NULL,
  `apartmentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_apartmentId_deals_idx` (`apartmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=665546 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deals`
--

LOCK TABLES `deals` WRITE;
/*!40000 ALTER TABLE `deals` DISABLE KEYS */;
INSERT INTO `deals` VALUES (69979,'2 Month Rent Free',1),(329473,'Free for 2 month',519664),(665545,'No special deals at this moment',636133);
/*!40000 ALTER TABLE `deals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `units`
--

DROP TABLE IF EXISTS `units`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `units` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(45) DEFAULT NULL,
  `squareft` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `rent` decimal(5,0) DEFAULT NULL,
  `avalibility` datetime DEFAULT NULL,
  `apertmentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_apermentId_idx` (`apertmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=997404 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `units`
--

LOCK TABLES `units` WRITE;
/*!40000 ALTER TABLE `units` DISABLE KEYS */;
INSERT INTO `units` VALUES (75400,'1209','500','Studio',2100,'2019-02-05 00:00:00',1),(92208,'333','1392','2 Bed',2290,'2019-10-20 00:00:00',426198),(94043,'2200','430','Studio',2100,'2019-02-05 00:00:00',519664),(114526,'4008','700','1 Bed',3000,'2019-10-01 00:00:00',1),(204780,'333','487','Studio',1510,'2020-12-08 00:00:00',636133),(326803,'441','1392','2 Bed',3000,'2020-12-08 00:00:00',139206),(334947,'500','1000','1 Bed',2100,'2020-12-08 00:00:00',426198),(365128,'441','487','Studio',1000,'2019-10-20 00:00:00',426198),(458299,'580','540','Studio',1050,'2020-12-08 00:00:00',139206),(461880,'441','487','Studio',2290,'2019-07-07 00:00:00',403936),(654096,'1200','553','Studio',2290,'2019-10-20 00:00:00',519664),(659231,'2402','1114','2 Bed',3720,'2019-10-20 00:00:00',1),(673403,'333','700','2 Bed',3060,'2019-10-20 00:00:00',403936),(686171,'534','592','1 Bed',1540,'2019-07-07 00:00:00',636133),(698890,'536','1123','2 Bed',2405,'2019-10-20 00:00:00',636133),(789226,'3900','800','1 Bed',3000,'2020-12-08 00:00:00',403936),(794017,'441','511','Studio',2072,'2019-07-07 00:00:00',719051),(880901,'1209','772','1 Bed',2100,'2019-10-20 00:00:00',139206),(922517,'441','772','1 Bed',3060,'2020-12-08 00:00:00',519664),(950636,'1209','1392','2 Bed',9909,'2020-12-08 00:00:00',519664),(997403,'3902','1516','3 Bed',6175,'2019-07-07 00:00:00',1);
/*!40000 ALTER TABLE `units` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-10 22:14:46
