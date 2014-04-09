/*
SQLyog Ultimate v9.20 
MySQL - 5.1.68-community-log : Database - javawork
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`javawork` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `javawork`;

/*Table structure for table `city` */

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `CITY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CITY_NAME` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `COUNTRY_ID` int(11) NOT NULL,
  PRIMARY KEY (`CITY_ID`),
  KEY `FK_city_country_country_id` (`COUNTRY_ID`),
  CONSTRAINT `FK_city_country_country_id` FOREIGN KEY (`COUNTRY_ID`) REFERENCES `country` (`COUNTRY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=334 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `city` */

insert  into `city`(`CITY_ID`,`CITY_NAME`,`COUNTRY_ID`) values (1,'Buenos Aires',2),(2,'El Calafate',2),(3,'Mendoza',2),(4,'Puerto Iguazu',2),(5,'Ushuaia',2),(6,'Patagonia',2),(7,'Adelaide',4),(8,'Alice Springs',4),(9,'Ayers Rock',4),(10,'Brisbane',4),(11,'Broome',4),(12,'Cairns & the Tropical North',4),(13,'Canberra',4),(14,'Darwin',4),(15,'Gold Coast',4),(16,'Hobart',4),(17,'Launceston',4),(18,'Melbourne',4),(19,'Noosa & Sunshine Coast',4),(20,'Palm Cove',4),(21,'Perth',4),(22,'Port Douglas',4),(23,'Sydney',4),(24,'The Whitsundays & Hamilton Island',4),(25,'New South Wales ',4),(26,'Northern Territory ',4),(27,'Queensland ',4),(28,'South Australia ',4),(29,'Tasmania ',4),(30,'Victoria ',4),(31,'Western Australia ',4),(32,'Salzburg',5),(33,'Vienna',5),(34,'Freeport',6),(35,'Nassau',6),(36,'Bruges',8),(37,'Brussels',8),(38,'Ambergris Caye',9),(39,'Belize City',9),(40,'The Cayes ',9),(41,'Fortaleza',11),(42,'Foz do Iguacu',11),(43,'Manaus',11),(44,'Natal',11),(45,'Rio de Janeiro',11),(46,'Salvador da Bahia',11),(47,'Angkor Wat',13),(48,'Banff',14),(49,'Calgary',14),(50,'Montreal',14),(51,'Niagara Falls & Around',14),(52,'Ottawa',14),(53,'Quebec City',14),(54,'Toronto',14),(55,'Vancouver',14),(56,'Victoria',14),(57,'Whistler',14),(58,'Alberta ',14),(59,'British Columbia ',14),(60,'Ontario ',14),(61,'Quebec ',14),(62,'Santiago',16),(63,'North Chile ',16),(64,'Patagonia ',16),(65,'Beijing',17),(66,'Chengdu',17),(67,'Guilin',17),(68,'Hangzhou',17),(69,'Macau',17),(70,'Shanghai',17),(71,'Xian',17),(72,'Yangshuo',17),(73,'Eastern China ',17),(74,'Northern China ',17),(75,'Northwest China ',17),(76,'Southern China ',17),(77,'Southwest China ',17),(78,'Yangtze River ',17),(79,'Bogotá',18),(80,'Cartagena',18),(81,'Medellín',18),(82,'Arenal Volcano National Park',19),(83,'Jaco',19),(84,'San Jose',19),(85,'Guanacaste and Northwest ',19),(86,'Pacific Coast ',19),(87,'Dubrovnik',20),(88,'Prague',22),(89,'Copenhagen',23),(90,'Puerto Plata',25),(91,'Punta Cana',25),(92,'Quito',26),(93,'Galapagos Islands ',26),(94,'Aswan',27),(95,'Cairo',27),(96,'Hurghada',27),(97,'Luxor',27),(98,'Sharm el Sheikh',27),(99,'Liverpool',28),(100,'London',28),(101,'Manchester',28),(102,'Lake District ',28),(103,'The North of England ',28),(104,'Tallinn',29),(105,'Helsinki',31),(106,'Avignon',32),(107,'Bayeux',32),(108,'Bordeaux',32),(109,'Cannes',32),(110,'Lille',32),(111,'Lyon',32),(112,'Marseille',32),(113,'Nice',32),(114,'Paris',32),(115,'Versailles',32),(116,'Aquitaine ',32),(117,'Burgundy & Dijon ',32),(118,'Champagne ',32),(119,'French Riviera ',32),(120,'Normandy ',32),(121,'Provence ',32),(122,'Berlin',33),(123,'Cologne',33),(124,'Frankfurt',33),(125,'Hamburg',33),(126,'Munich',33),(127,'Rhine River ',33),(128,'Athens',34),(129,'Mykonos',34),(130,'Santorini',34),(131,'Cyclades Islands ',34),(132,'Antigua',36),(133,'Guatemala City',36),(134,'Budapest',38),(135,'Reykjavik',39),(136,'Chennai',40),(137,'Goa',40),(138,'Jaipur',40),(139,'Kochi',40),(140,'Kolkata',40),(141,'Mumbai',40),(142,'New Delhi',40),(143,'Udaipur',40),(144,'Kerala ',40),(145,'Rajasthan ',40),(146,'Tamil Nadu ',40),(147,'West Bengal ',40),(148,'Bali ',41),(149,'Belfast',42),(150,'Dublin',42),(151,'Galway',42),(152,'Killarney',42),(153,'Jerusalem',43),(154,'Tel Aviv',43),(155,'Bologna',44),(156,'Florence',44),(157,'Milan',44),(158,'Naples',44),(159,'Pisa',44),(160,'Rome',44),(161,'Siena',44),(162,'Sorrento',44),(163,'Turin',44),(164,'Venice',44),(165,'Verona',44),(166,'Amalfi Coast ',44),(167,'Piedmont & Liguria ',44),(168,'Sicily ',44),(169,'Tuscany ',44),(170,'Montego Bay',45),(171,'Negril',45),(172,'Ocho Rios',45),(173,'Kyoto',46),(174,'Osaka',46),(175,'Tokyo',46),(176,'Amman ',47),(177,'Beirut',48),(178,'Kota Kinabalu',50),(179,'Kuala Lumpur',50),(180,'Kuching',50),(181,'Langkawi',50),(182,'Penang',50),(183,'Sabah ',50),(184,'Sarawak ',50),(185,'Acapulco',51),(186,'Cancun',51),(187,'Cozumel',51),(188,'Los Cabos',51),(189,'Mexico City',51),(190,'Puerto Vallarta',51),(191,'Baja California Peninsula ',51),(192,'Central Pacific Coast ',51),(193,'Riviera Maya & the Yucatan ',51),(194,'Monaco',52),(195,'Marrakech ',53),(196,'Kathmandu',54),(197,'Amsterdam',55),(198,'Auckland',56),(199,'Bay of Islands',56),(200,'Christchurch',56),(201,'Dunedin & The Otago Peninsula',56),(202,'Fiordland & Milford Sound',56),(203,'Franz Josef & Fox Glacier',56),(204,'Mount Cook',56),(205,'Picton',56),(206,'Queenstown',56),(207,'Rotorua',56),(208,'Wellington',56),(209,'North Island ',56),(210,'South Island ',56),(211,'Managua',57),(212,'Oslo',58),(213,'Panama City',60),(214,'Arequipa',61),(215,'Cusco',61),(216,'Iquitos',61),(217,'Lima',61),(218,'Puno',61),(219,'Cebu',62),(220,'Manila',62),(221,'Visayas ',62),(222,'Krakow',63),(223,'Warsaw',63),(224,'Lisbon',64),(225,'Islands of Portugal ',64),(226,'Porto & Northern Portugal ',64),(227,'The Algarve ',64),(228,'San Juan ',65),(229,'Moscow',66),(230,'St Petersburg',66),(231,'Edinburgh',67),(232,'Glasgow',67),(233,'Inverness',67),(234,'The Scottish Highlands ',67),(235,'Cape Town',70),(236,'Durban',70),(237,'Johannesburg',70),(238,'Seoul',71),(239,'Barcelona',72),(240,'Costa del Sol',72),(241,'Granada',72),(242,'Gran Canaria',72),(243,'Ibiza',72),(244,'Madrid',72),(245,'Malaga ',72),(246,'Mallorca',72),(247,'Santiago de Compostela',72),(248,'Seville',72),(249,'Valencia',72),(250,'Andalucia & Costa del Sol ',72),(251,'Balearic Islands ',72),(252,'Basque Country ',72),(253,'Canary Islands ',72),(254,'Costa Brava ',72),(255,'St Kitts ',73),(256,'Stockholm',76),(257,'Geneva',77),(258,'Lucerne',77),(259,'Zurich',77),(260,'Bangkok',80),(261,'Chiang Mai & Chiang Rai',80),(262,'Koh Samui',80),(263,'Krabi',80),(264,'Pattaya',80),(265,'Phuket',80),(266,'Ankara',82),(267,'Antalya',82),(268,'Cappadocia',82),(269,'Istanbul',82),(270,'Izmir',82),(271,'Kusadasi',82),(272,'Dubai',83),(273,'Montevideo',84),(274,'Punta del Este',84),(275,'Anaheim & Buena Park',85),(276,'Anchorage',85),(277,'Atlanta',85),(278,'Austin',85),(279,'Big Island of Hawaii',85),(280,'Boston',85),(281,'Charleston',85),(282,'Chicago',85),(283,'Dallas',85),(284,'Denver',85),(285,'Fort Lauderdale',85),(286,'Grand Canyon National Park',85),(287,'Juneau',85),(288,'Kauai',85),(289,'Ketchikan',85),(290,'Key West',85),(291,'Lake Tahoe',85),(292,'Las Vegas',85),(293,'Los Angeles',85),(294,'Maui',85),(295,'Memphis',85),(296,'Miami',85),(297,'Napa & Sonoma',85),(298,'Nashville',85),(299,'New Orleans',85),(300,'New York City',85),(301,'Oahu',85),(302,'Orlando',85),(303,'Palm Springs',85),(304,'Philadelphia',85),(305,'Phoenix',85),(306,'Portland',85),(307,'San Antonio',85),(308,'San Diego',85),(309,'San Francisco',85),(310,'Seattle',85),(311,'Sedona & Flagstaff',85),(312,'Sitka',85),(313,'Skagway',85),(314,'St Augustine',85),(315,'Tampa',85),(316,'Washington DC',85),(317,'Alaska ',85),(318,'Arizona ',85),(319,'California ',85),(320,'Colorado ',85),(321,'Florida ',85),(322,'Georgia ',85),(323,'Hawaii ',85),(324,'Maryland ',85),(325,'Oregon ',85),(326,'Pennsylvania ',85),(327,'South Carolina ',85),(328,'Tennessee ',85),(329,'Texas ',85),(330,'Washington ',85),(331,'St Thomas ',86),(332,'Hanoi',87),(333,'Ho Chi Minh City',87);

/*Table structure for table `country` */

DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
  `COUNTRY_ID` int(11) NOT NULL,
  `COUNTRY_NAME` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `PRIORITY` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`COUNTRY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `country` */

insert  into `country`(`COUNTRY_ID`,`COUNTRY_NAME`,`PRIORITY`) values (1,'Antigua and Barbuda',0),(2,'Argentina',0),(3,'Aruba',0),(4,'Australia',8),(5,'Austria',0),(6,'Bahamas',0),(7,'Barbados',0),(8,'Belgium',0),(9,'Belize',0),(10,'Bermuda',0),(11,'Brazil',0),(12,'British Virgin Islands',0),(13,'Cambodia',0),(14,'Canada',0),(15,'Cayman Islands',0),(16,'Chile',0),(17,'China',0),(18,'Colombia',0),(19,'Costa Rica',0),(20,'Croatia',0),(21,'Curacao',0),(22,'Czech Republic',0),(23,'Denmark',0),(24,'Dominica',0),(25,'Dominican Republic',0),(26,'Ecuador',0),(27,'Egypt',0),(28,'England',3),(29,'Estonia',0),(30,'Fiji',0),(31,'Finland',0),(32,'France',6),(33,'Germany',0),(34,'Greece',0),(35,'Grenada',0),(36,'Guatemala',0),(37,'Hong Kong',0),(38,'Hungary',0),(39,'Iceland',0),(40,'India',0),(41,'Indonesia',0),(42,'Ireland',0),(43,'Israel',0),(44,'Italy',5),(45,'Jamaica',0),(46,'Japan',0),(47,'Jordan',0),(48,'Lebanon',0),(49,'Lithuania',0),(50,'Malaysia',0),(51,'Mexico',0),(52,'Monaco',0),(53,'Morocco',0),(54,'Nepal',0),(55,'Netherlands',2),(56,'New Zealand',7),(57,'Nicaragua',0),(58,'Norway',0),(59,'Oman',0),(60,'Panama',0),(61,'Peru',0),(62,'Philippines',0),(63,'Poland',0),(64,'Portugal',0),(65,'Puerto Rico',0),(66,'Russia',0),(67,'Scotland',0),(68,'Singapore',0),(69,'Slovenia',0),(70,'South Africa',0),(71,'South Korea',0),(72,'Spain',4),(73,'St Kitts and Nevis',0),(74,'St Lucia',0),(75,'St Maarten',0),(76,'Sweden',0),(77,'Switzerland',0),(78,'Tahiti',0),(79,'Taiwan',0),(80,'Thailand',0),(81,'Trinidad and Tobago',0),(82,'Turkey',0),(83,'United Arab Emirates',0),(84,'Uruguay',0),(85,'USA',9),(86,'US Virgin Islands',0),(87,'Vietnam',0);

/*Table structure for table `file` */

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
  `FILE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FILE_NAME` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `DESCRIPTION` varchar(512) COLLATE utf8_unicode_ci DEFAULT NULL,
  `PATH` varchar(512) COLLATE utf8_unicode_ci NOT NULL,
  `CREATED_DATE` datetime NOT NULL,
  PRIMARY KEY (`FILE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `file` */

/*Table structure for table `job` */

DROP TABLE IF EXISTS `job`;

CREATE TABLE `job` (
  `JOB_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `CUSTOM_REQUIRED_SKILL` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DESCRIPTION` varchar(4000) COLLATE utf8_unicode_ci NOT NULL,
  `SALARY_TYPE` enum('FIXED_PRICE','PER_HOUR','PER_MONTH') COLLATE utf8_unicode_ci NOT NULL,
  `SALARY_FROM_AMOUNT` double DEFAULT NULL,
  `SALARY_TO_AMOUNT` double DEFAULT NULL,
  `OTHER_OPTION` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL,
  `CREATE_USER_ID` int(11) NOT NULL,
  `WORK_CATEGORY_ID` int(11) DEFAULT NULL,
  `COUNTRY_ID` int(11) DEFAULT NULL,
  `CITY_ID` int(11) DEFAULT NULL,
  `CREATED_DATE` datetime NOT NULL,
  `UPDATED_DATE` datetime DEFAULT NULL,
  `STATUS` enum('OPENING','CLOSED') COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`JOB_ID`),
  KEY `FK_job_city_city_id` (`CITY_ID`),
  KEY `FK_job_country_country_id` (`COUNTRY_ID`),
  KEY `FK_job_user_user_id` (`CREATE_USER_ID`),
  KEY `FK_job_work_category_work_category_id` (`WORK_CATEGORY_ID`),
  CONSTRAINT `FK_job_city_city_id` FOREIGN KEY (`CITY_ID`) REFERENCES `city` (`CITY_ID`),
  CONSTRAINT `FK_job_country_country_id` FOREIGN KEY (`COUNTRY_ID`) REFERENCES `country` (`COUNTRY_ID`),
  CONSTRAINT `FK_job_user_user_id` FOREIGN KEY (`CREATE_USER_ID`) REFERENCES `user` (`USER_ID`),
  CONSTRAINT `FK_job_work_category_work_category_id` FOREIGN KEY (`WORK_CATEGORY_ID`) REFERENCES `work_category` (`WORK_CATEGORY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `job` */

/*Table structure for table `job_apply` */

DROP TABLE IF EXISTS `job_apply`;

CREATE TABLE `job_apply` (
  `JOB_APPLY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `JOB_ID` int(11) NOT NULL,
  `APPLY_USER_ID` int(11) NOT NULL,
  `PROPOSAL` varchar(2000) COLLATE utf8_unicode_ci NOT NULL,
  `BID_VALUE` int(11) DEFAULT NULL,
  `APPLY_DATE` datetime NOT NULL,
  `STATUS` enum('WAITING','INVITED','ACCEPTED','REJECTED') COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`JOB_APPLY_ID`),
  KEY `FK_job_apply_job_job_id` (`JOB_ID`),
  KEY `FK_job_apply_user_user_id` (`APPLY_USER_ID`),
  CONSTRAINT `FK_job_apply_user_user_id` FOREIGN KEY (`APPLY_USER_ID`) REFERENCES `user` (`USER_ID`),
  CONSTRAINT `FK_job_apply_job_job_id` FOREIGN KEY (`JOB_ID`) REFERENCES `job` (`JOB_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `job_apply` */

/*Table structure for table `job_skill` */

DROP TABLE IF EXISTS `job_skill`;

CREATE TABLE `job_skill` (
  `JOB_SKILL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `JOB_ID` int(11) NOT NULL,
  `SKILL_ID` int(11) NOT NULL,
  PRIMARY KEY (`JOB_SKILL_ID`),
  KEY `FK_job_skill_job_job_id` (`JOB_ID`),
  KEY `FK_job_skill_skill_skill_id` (`SKILL_ID`),
  CONSTRAINT `FK_job_skill_skill_skill_id` FOREIGN KEY (`SKILL_ID`) REFERENCES `skill` (`SKILL_ID`),
  CONSTRAINT `FK_job_skill_job_job_id` FOREIGN KEY (`JOB_ID`) REFERENCES `job` (`JOB_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `job_skill` */

/*Table structure for table `profile` */

DROP TABLE IF EXISTS `profile`;

CREATE TABLE `profile` (
  `PROFILE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TAGLINE` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `OVERVIEW` varchar(1024) COLLATE utf8_unicode_ci NOT NULL,
  `HOURLY_RATE` int(11) DEFAULT NULL,
  `EXPERIENCE` varchar(1024) COLLATE utf8_unicode_ci NOT NULL,
  `PHOTO_ATTACH_FILE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`PROFILE_ID`),
  KEY `FK_profile_file_file_id` (`PHOTO_ATTACH_FILE_ID`),
  CONSTRAINT `FK_profile_file_file_id` FOREIGN KEY (`PHOTO_ATTACH_FILE_ID`) REFERENCES `file` (`FILE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `profile` */

/*Table structure for table `skill` */

DROP TABLE IF EXISTS `skill`;

CREATE TABLE `skill` (
  `SKILL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `DESCRIPTION` varchar(512) COLLATE utf8_unicode_ci DEFAULT NULL,
  `WORK_CATEGORY_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`SKILL_ID`),
  KEY `FK_skill_work_category_work_category_id` (`WORK_CATEGORY_ID`),
  CONSTRAINT `FK_skill_work_category_work_category_id` FOREIGN KEY (`WORK_CATEGORY_ID`) REFERENCES `work_category` (`WORK_CATEGORY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `skill` */

insert  into `skill`(`SKILL_ID`,`NAME`,`DESCRIPTION`,`WORK_CATEGORY_ID`) values (1,'Servlets/JSP','Servlets/JSP',3),(2,'Java Persistence API (JPA)','Java Persistence API (JPA)',3),(3,'Java Server Face (JSF)','Java Server Face (JSF)',3),(4,'Struts Framework','Struts Framework',3),(5,'Spring Framework','Spring Framework',3),(6,'JMS','JMS',3),(7,'IBM DB2','IBM DB2',7),(8,'Oracle','Oracle',7),(9,'PostgreSQL','PostgreSQL',7),(10,'Informix','Informix',7),(11,'Interbase','Interbase',7),(12,'Sybase','Sybase',7),(13,'SQL Server','SQL Server',7),(14,'C#','C#',6),(15,'ASP.NET','ASP.NET',6),(16,'BizTalk','BizTalk',6),(17,'COM/DCOM','COM/DCOM',6),(18,'ActiveX','ActiveX',6),(19,'OLE','OLE',6),(20,'Visual C++.NET','Visual C++.NET',6);

/*Table structure for table `t_option` */

DROP TABLE IF EXISTS `t_option`;

CREATE TABLE `t_option` (
  `T_OPTION_ID` int(1) NOT NULL,
  `DESCRIPTION` varchar(1024) COLLATE utf8_unicode_ci NOT NULL,
  `IS_KEY` tinyint(1) NOT NULL DEFAULT '0',
  `QUESTION_ID` int(11) NOT NULL,
  PRIMARY KEY (`T_OPTION_ID`),
  KEY `FK_t_option_t_question_question_id` (`QUESTION_ID`),
  CONSTRAINT `FK_t_option_t_question_question_id` FOREIGN KEY (`QUESTION_ID`) REFERENCES `t_question` (`QUESTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `t_option` */

/*Table structure for table `t_question` */

DROP TABLE IF EXISTS `t_question`;

CREATE TABLE `t_question` (
  `QUESTION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `STEM` varchar(1024) COLLATE utf8_unicode_ci NOT NULL,
  `IS_MULTIPLE_CHOICE` tinyint(1) NOT NULL DEFAULT '0',
  `DURATION` int(11) NOT NULL,
  `CREATED_USER_ID` int(11) DEFAULT NULL,
  `SKILL_ID` int(11) NOT NULL,
  PRIMARY KEY (`QUESTION_ID`),
  KEY `FK_t_question_user_user_id` (`CREATED_USER_ID`),
  KEY `FK_t_question_work_category_work_category_id` (`SKILL_ID`),
  CONSTRAINT `FK_t_question_skill_skill_id` FOREIGN KEY (`SKILL_ID`) REFERENCES `skill` (`SKILL_ID`),
  CONSTRAINT `FK_t_question_user_user_id` FOREIGN KEY (`CREATED_USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `t_question` */

/*Table structure for table `t_test` */

DROP TABLE IF EXISTS `t_test`;

CREATE TABLE `t_test` (
  `TEST_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TOTAL_QUESTION` int(11) NOT NULL DEFAULT '0',
  `TOTAL_TIME` int(11) NOT NULL DEFAULT '0',
  `DATE_CREATED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DATE_UPDATED` timestamp NULL DEFAULT NULL,
  `SKILL_ID` int(11) NOT NULL,
  PRIMARY KEY (`TEST_ID`),
  KEY `FK_t_test_skill_skill_id` (`SKILL_ID`),
  CONSTRAINT `FK_t_test_skill_skill_id` FOREIGN KEY (`SKILL_ID`) REFERENCES `skill` (`SKILL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `t_test` */

/*Table structure for table `t_test_question` */

DROP TABLE IF EXISTS `t_test_question`;

CREATE TABLE `t_test_question` (
  `TEST_QUESTION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TEST_ID` int(11) NOT NULL,
  `QUESTION_ID` int(11) NOT NULL,
  `SEQUENCE` int(11) DEFAULT NULL,
  PRIMARY KEY (`TEST_QUESTION_ID`),
  KEY `FK_t_test_question_test_test_id` (`TEST_ID`),
  KEY `FK_t_test_question_question_question_id` (`QUESTION_ID`),
  CONSTRAINT `FK_t_test_question_question_question_id` FOREIGN KEY (`QUESTION_ID`) REFERENCES `t_question` (`QUESTION_ID`),
  CONSTRAINT `FK_t_test_question_test_test_id` FOREIGN KEY (`TEST_ID`) REFERENCES `t_test` (`TEST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `t_test_question` */

/*Table structure for table `t_user_test` */

DROP TABLE IF EXISTS `t_user_test`;

CREATE TABLE `t_user_test` (
  `T_USER_TEST_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) NOT NULL,
  `TEST_ID` int(11) NOT NULL,
  `CORRECT_COUNT` int(11) DEFAULT '0',
  `SCORE` int(11) DEFAULT '0',
  `FINISHED_DATED` datetime,
  PRIMARY KEY (`T_USER_TEST_ID`),
  KEY `FK_t_user_test_user_user_id` (`USER_ID`),
  KEY `FK_t_user_test_test_test_id` (`TEST_ID`),
  CONSTRAINT `FK_t_user_test_test_test_id` FOREIGN KEY (`TEST_ID`) REFERENCES `t_test` (`TEST_ID`),
  CONSTRAINT `FK_t_user_test_user_user_id` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `t_user_test` */

/*Table structure for table `u_certification` */

DROP TABLE IF EXISTS `u_certification`;

CREATE TABLE `u_certification` (
  `CERTIFICATION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) NOT NULL,
  `CONFERRING_ORGANIZATION` varchar(512) COLLATE utf8_unicode_ci NOT NULL,
  `PROFESSIONAL_CERTIFICATE` varchar(512) COLLATE utf8_unicode_ci NOT NULL,
  `DATE_AWARDED` date NOT NULL,
  `CERTIFICATE_NUMBER` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DESCRIPTION` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`CERTIFICATION_ID`),
  KEY `FK_u_certification_user_user_id` (`USER_ID`),
  CONSTRAINT `FK_u_certification_user_user_id` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `u_certification` */

/*Table structure for table `u_education` */

DROP TABLE IF EXISTS `u_education`;

CREATE TABLE `u_education` (
  `EDUCATION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) NOT NULL,
  `INSTITUTION_NAME` varchar(512) COLLATE utf8_unicode_ci NOT NULL,
  `DEGREE_TYPE` varchar(512) COLLATE utf8_unicode_ci NOT NULL,
  `GRADUATION_START_DATE` date NOT NULL,
  `GRADUATION_END_DATE` date NOT NULL,
  `DESCRIPTION` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`EDUCATION_ID`),
  KEY `FK_u_education_user_user_id` (`USER_ID`),
  CONSTRAINT `FK_u_education_user_user_id` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `u_education` */

/*Table structure for table `u_employment` */

DROP TABLE IF EXISTS `u_employment`;

CREATE TABLE `u_employment` (
  `EMPLOYMENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) NOT NULL,
  `CLIENT_NAME` varchar(512) COLLATE utf8_unicode_ci NOT NULL,
  `POSITION_HELD` varchar(512) COLLATE utf8_unicode_ci NOT NULL,
  `START_DATE` date NOT NULL,
  `END_DATE` date NOT NULL,
  `DESCRIPTION` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`EMPLOYMENT_ID`),
  KEY `FK_u_employment_user_user_id` (`USER_ID`),
  CONSTRAINT `FK_u_employment_user_user_id` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `u_employment` */

/*Table structure for table `u_license` */

DROP TABLE IF EXISTS `u_license`;

CREATE TABLE `u_license` (
  `LICENSE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(11) DEFAULT NULL,
  `CONFERRING_ORGANIZATION` varchar(512) COLLATE utf8_unicode_ci NOT NULL,
  `PROFESSIONAL_LICENSE` varchar(512) COLLATE utf8_unicode_ci NOT NULL,
  `DATE_ISSUED` date NOT NULL,
  `LICENSE_NUMBER` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DESCRIPTION` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`LICENSE_ID`),
  KEY `FK_u_license_user_user_id` (`USER_ID`),
  CONSTRAINT `FK_u_license_user_user_id` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `u_license` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(50) DEFAULT NULL,
  `LAST_NAME` varchar(50) DEFAULT NULL,
  `USER_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `USER_EMAIL` varchar(50) NOT NULL,
  `USER_PASSWORD` varchar(200) NOT NULL,
  `DATE_CREATED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DATE_UPDATED` timestamp NULL DEFAULT NULL,
  `LAST_LOGIN_DATE` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `PASSWORD_LAST_CHANGED_DATE` datetime DEFAULT NULL,
  `LAST_FAILED_LOGIN_DATE` timestamp NULL DEFAULT NULL,
  `FAILED_LOGIN_ATTEMPTS` int(2) DEFAULT '0',
  `PASSWORD_EXPIRED` tinyint(1) DEFAULT '0',
  `ACCOUNT_LOCKED` tinyint(1) DEFAULT '0',
  `API_LOGIN` tinyint(1) NOT NULL DEFAULT '0',
  `ACTIVE` tinyint(1) DEFAULT '1',
  `PASSWORD_HASH` varchar(32) DEFAULT NULL,
  `PASSWORD_HASH_DATE` timestamp NULL DEFAULT NULL,
  `PURPOSE` enum('WORK','HIRE') NOT NULL DEFAULT 'WORK',
  `PROFILE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `UNIQ_user_email` (`USER_EMAIL`),
  KEY `FK_user_profile_profile_id` (`PROFILE_ID`),
  CONSTRAINT `FK_user_profile_profile_id` FOREIGN KEY (`PROFILE_ID`) REFERENCES `profile` (`PROFILE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

/*Table structure for table `work_category` */

DROP TABLE IF EXISTS `work_category`;

CREATE TABLE `work_category` (
  `WORK_CATEGORY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `WORK_CATEGORY_NAME` varchar(512) COLLATE utf8_unicode_ci NOT NULL,
  `PARENT_WORK_CATEGORY_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`WORK_CATEGORY_ID`),
  KEY `FK_work_category_domain_domain_id` (`WORK_CATEGORY_NAME`(255)),
  KEY `FK_work_category_work_category_work_category_id` (`PARENT_WORK_CATEGORY_ID`),
  CONSTRAINT `FK_work_category_work_category_work_category_id` FOREIGN KEY (`PARENT_WORK_CATEGORY_ID`) REFERENCES `work_category` (`WORK_CATEGORY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `work_category` */



insert  into `work_category`(`WORK_CATEGORY_ID`,`WORK_CATEGORY_NAME`,`PARENT_WORK_CATEGORY_ID`) values (1,'Graphic Designer',NULL),(2,'Front End Developer',NULL),(3,'Java Developer',NULL),(4,'PHP Developer',NULL),(5,'Ruby Developer',NULL),(6,'.NET Developer',NULL),(7,'Database Administrator',NULL),(8,'IT Administrator',NULL),(9,'Mobile Developer',NULL),(10,'C/C++ Developer',NULL),(13,'Embedded System',NULL);

/* Trigger structure for table `t_test` */

DELIMITER $$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `t_test_update_date_updated` BEFORE UPDATE ON `t_test` FOR EACH ROW SET NEW.DATE_UPDATED = CURRENT_TIMESTAMP */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

