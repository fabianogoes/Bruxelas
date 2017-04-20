-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: bruxelas
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
-- Table structure for table `connection_type`
--

DROP TABLE IF EXISTS `connection_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `connection_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `connection_type`
--

LOCK TABLES `connection_type` WRITE;
/*!40000 ALTER TABLE `connection_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `connection_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `native_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'Algeria','الجزائر'),(2,'Albania','Shqipëria'),(3,'Åland Islands','Åland'),(4,'Andorra','Andorra'),(5,'American Samoa','American Samoa'),(6,'Afghanistan','افغانستان'),(7,'Angola','Angola'),(8,'Antigua and Barbuda','Antigua and Barbuda'),(9,'Antarctica','Antarctica'),(10,'Anguilla','Anguilla'),(11,'Argentina','Argentina'),(12,'Austria','Österreich'),(13,'Azerbaijan','Azərbaycan'),(14,'Aruba','Aruba'),(15,'Australia','Australia'),(16,'Armenia','Հայաստան'),(17,'Bahamas','Bahamas'),(18,'Barbados','Barbados'),(19,'Bahrain','‏البحرين'),(20,'Belgium','België'),(21,'Bangladesh','Bangladesh'),(22,'Belarus','Белару́сь'),(23,'Bermuda','Bermuda'),(24,'Belize','Belize'),(25,'Bolivia (Plurinational State of)','Bolivia'),(26,'Benin','Bénin'),(27,'Bhutan','ʼbrug-yul'),(28,'Bosnia and Herzegovina','Bosna i Hercegovina'),(29,'Bonaire, Sint Eustatius and Saba','Bonaire'),(30,'British Indian Ocean Territory','British Indian Ocean Territory'),(31,'Botswana','Botswana'),(32,'Brazil','Brasil'),(33,'Bouvet Island','Bouvetøya'),(34,'Virgin Islands (British)','British Virgin Islands'),(35,'Virgin Islands (U.S.)','Virgin Islands of the United States'),(36,'Bulgaria','България'),(37,'United States Minor Outlying Islands','United States Minor Outlying Islands'),(38,'Brunei Darussalam','Negara Brunei Darussalam'),(39,'Burkina Faso','Burkina Faso'),(40,'Burundi','Burundi'),(41,'Cambodia','Kâmpŭchéa'),(42,'Cameroon','Cameroon'),(43,'Cabo Verde','Cabo Verde'),(44,'Cayman Islands','Cayman Islands'),(45,'Central African Republic','Ködörösêse tî Bêafrîka'),(46,'Canada','Canada'),(47,'Chad','Tchad'),(48,'Chile','Chile'),(49,'China','中国'),(50,'Christmas Island','Christmas Island'),(51,'Cocos (Keeling) Islands','Cocos (Keeling) Islands'),(52,'Colombia','Colombia'),(53,'Comoros','Komori'),(54,'Congo','République du Congo'),(55,'Cuba','Cuba'),(56,'Croatia','Hrvatska'),(57,'Costa Rica','Costa Rica'),(58,'Cook Islands','Cook Islands'),(59,'Congo (Democratic Republic of the)','République démocratique du Congo'),(60,'Curaçao','Curaçao'),(61,'Cyprus','Κύπρος'),(62,'Denmark','Danmark'),(63,'Czech Republic','Česká republika'),(64,'Djibouti','Djibouti'),(65,'Dominica','Dominica'),(66,'Dominican Republic','República Dominicana'),(67,'Egypt','مصر‎'),(68,'Ecuador','Ecuador'),(69,'El Salvador','El Salvador'),(70,'Estonia','Eesti'),(71,'Eritrea','ኤርትራ'),(72,'Falkland Islands (Malvinas)','Falkland Islands'),(73,'Ethiopia','ኢትዮጵያ'),(74,'Faroe Islands','Føroyar'),(75,'France','France'),(76,'French Guiana','Guyane française'),(77,'French Polynesia','Polynésie française'),(78,'French Southern Territories','Territoire des Terres australes et antarctiques françaises'),(79,'Gabon','Gabon'),(80,'Gambia','Gambia'),(81,'Georgia','საქართველო'),(82,'Germany','Deutschland'),(83,'Ghana','Ghana'),(84,'Gibraltar','Gibraltar'),(85,'Equatorial Guinea','Guinea Ecuatorial'),(86,'Greece','Ελλάδα'),(87,'Finland','Suomi'),(88,'Fiji','Fiji'),(89,'Grenada','Grenada'),(90,'Guadeloupe','Guadeloupe'),(91,'Greenland','Kalaallit Nunaat'),(92,'Guatemala','Guatemala'),(93,'Guam','Guam'),(94,'Guernsey','Guernsey'),(95,'Guyana','Guyana'),(96,'Guinea-Bissau','Guiné-Bissau'),(97,'Haiti','Haïti'),(98,'Heard Island and McDonald Islands','Heard Island and McDonald Islands'),(99,'Honduras','Honduras'),(100,'Guinea','Guinée'),(101,'Hong Kong','香港'),(102,'Hungary','Magyarország'),(103,'Iceland','Ísland'),(104,'Indonesia','Indonesia'),(105,'India','भारत'),(106,'Côte d\'Ivoire','Côte d\'Ivoire'),(107,'Holy See','Sancta Sedes'),(108,'Iran (Islamic Republic of)','ایران'),(109,'Isle of Man','Isle of Man'),(110,'Israel','יִשְׂרָאֵל'),(111,'Italy','Italia'),(112,'Ireland','Éire'),(113,'Iraq','العراق'),(114,'Jamaica','Jamaica'),(115,'Japan','日本'),(116,'Jersey','Jersey'),(117,'Jordan','الأردن'),(118,'Kiribati','Kiribati'),(119,'Kuwait','الكويت'),(120,'Kazakhstan','Қазақстан'),(121,'Kyrgyzstan','Кыргызстан'),(122,'Lao People\'s Democratic Republic','ສປປລາວ'),(123,'Kenya','Kenya'),(124,'Lebanon','لبنان'),(125,'Lesotho','Lesotho'),(126,'Latvia','Latvija'),(127,'Liberia','Liberia'),(128,'Liechtenstein','Liechtenstein'),(129,'Libya','‏ليبيا'),(130,'Luxembourg','Luxembourg'),(131,'Macedonia (the former Yugoslav Republic of)','Македонија'),(132,'Lithuania','Lietuva'),(133,'Malaysia','Malaysia'),(134,'Malawi','Malawi'),(135,'Mali','Mali'),(136,'Malta','Malta'),(137,'Marshall Islands','M̧ajeļ'),(138,'Martinique','Martinique'),(139,'Maldives','Maldives'),(140,'Macao','澳門'),(141,'Mauritania','موريتانيا'),(142,'Madagascar','Madagasikara'),(143,'Mauritius','Maurice'),(144,'Mayotte','Mayotte'),(145,'Mexico','México'),(146,'Micronesia (Federated States of)','Micronesia'),(147,'Moldova (Republic of)','Moldova'),(148,'Mongolia','Монгол улс'),(149,'Montserrat','Montserrat'),(150,'Montenegro','Црна Гора'),(151,'Morocco','المغرب'),(152,'Mozambique','Moçambique'),(153,'Myanmar','Myanma'),(154,'Namibia','Namibia'),(155,'Monaco','Monaco'),(156,'Nepal','नेपाल'),(157,'Netherlands','Nederland'),(158,'New Caledonia','Nouvelle-Calédonie'),(159,'New Zealand','New Zealand'),(160,'Nicaragua','Nicaragua'),(161,'Niger','Niger'),(162,'Niue','Niuē'),(163,'Norfolk Island','Norfolk Island'),(164,'Korea (Democratic People\'s Republic of)','북한'),(165,'Nauru','Nauru'),(166,'Northern Mariana Islands','Northern Mariana Islands'),(167,'Nigeria','Nigeria'),(168,'Oman','عمان'),(169,'Palestine, State of','فلسطين'),(170,'Pakistan','Pakistan'),(171,'Papua New Guinea','Papua Niugini'),(172,'Paraguay','Paraguay'),(173,'Norway','Norge'),(174,'Peru','Perú'),(175,'Philippines','Pilipinas'),(176,'Pitcairn','Pitcairn Islands'),(177,'Poland','Polska'),(178,'Portugal','Portugal'),(179,'Puerto Rico','Puerto Rico'),(180,'Qatar','قطر'),(181,'Palau','Palau'),(182,'Panama','Panamá'),(183,'Réunion','La Réunion'),(184,'Romania','România'),(185,'Russian Federation','Россия'),(186,'Rwanda','Rwanda'),(187,'Saint Barthélemy','Saint-Barthélemy'),(188,'Saint Kitts and Nevis','Saint Kitts and Nevis'),(189,'Saint Lucia','Saint Lucia'),(190,'Saint Pierre and Miquelon','Saint-Pierre-et-Miquelon'),(191,'Saint Martin (French part)','Saint-Martin'),(192,'Saint Vincent and the Grenadines','Saint Vincent and the Grenadines'),(193,'Samoa','Samoa'),(194,'San Marino','San Marino'),(195,'Senegal','Sénégal'),(196,'Serbia','Србија'),(197,'Saint Helena, Ascension and Tristan da Cunha','Saint Helena'),(198,'Seychelles','Seychelles'),(199,'Sierra Leone','Sierra Leone'),(200,'Slovakia','Slovensko'),(201,'Singapore','Singapore'),(202,'Slovenia','Slovenija'),(203,'Solomon Islands','Solomon Islands'),(204,'Somalia','Soomaaliya'),(205,'South Georgia and the South Sandwich Islands','South Georgia'),(206,'South Africa','South Africa'),(207,'Korea (Republic of)','대한민국'),(208,'Saudi Arabia','العربية السعودية'),(209,'Republic of Kosovo','Republika e Kosovës'),(210,'South Sudan','South Sudan'),(211,'Spain','España'),(212,'Sri Lanka','śrī laṃkāva'),(213,'Sudan','السودان'),(214,'Suriname','Suriname'),(215,'Sao Tome and Principe','São Tomé e Príncipe'),(216,'Svalbard and Jan Mayen','Svalbard og Jan Mayen'),(217,'Swaziland','Swaziland'),(218,'Sweden','Sverige'),(219,'Syrian Arab Republic','سوريا'),(220,'Switzerland','Schweiz'),(221,'Tajikistan','Тоҷикистон'),(222,'Tanzania, United Republic of','Tanzania'),(223,'Thailand','ประเทศไทย'),(224,'Timor-Leste','Timor-Leste'),(225,'Togo','Togo'),(226,'Tokelau','Tokelau'),(227,'Tonga','Tonga'),(228,'Trinidad and Tobago','Trinidad and Tobago'),(229,'Sint Maarten (Dutch part)','Sint Maarten'),(230,'Taiwan, Province of China','臺灣'),(231,'Tunisia','تونس'),(232,'Turkey','Türkiye'),(233,'Tuvalu','Tuvalu'),(234,'Ukraine','Україна'),(235,'United Arab Emirates','دولة الإمارات العربية المتحدة'),(236,'United Kingdom of Great Britain and Northern Ireland','United Kingdom'),(237,'United States of America','United States'),(238,'Uruguay','Uruguay'),(239,'Uzbekistan','O‘zbekiston'),(240,'Vanuatu','Vanuatu'),(241,'Venezuela (Bolivarian Republic of)','Venezuela'),(242,'Viet Nam','Việt Nam'),(243,'Wallis and Futuna','Wallis et Futuna'),(244,'Western Sahara','الصحراء الغربية'),(245,'Yemen','اليَمَن'),(246,'Zambia','Zambia'),(247,'Zimbabwe','Zimbabwe'),(248,'Turks and Caicos Islands','Turks and Caicos Islands'),(249,'Turkmenistan','Türkmenistan'),(250,'Uganda','Uganda');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country_languages`
--

DROP TABLE IF EXISTS `country_languages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country_languages` (
  `country_id` bigint(20) NOT NULL,
  `language_id` bigint(20) NOT NULL,
  KEY `FK96nwe8nimi1vc6nggqqo299lg` (`language_id`),
  KEY `FKewm1msv202fkvi22f2uglqiuu` (`country_id`),
  CONSTRAINT `FK96nwe8nimi1vc6nggqqo299lg` FOREIGN KEY (`language_id`) REFERENCES `language` (`id`),
  CONSTRAINT `FKewm1msv202fkvi22f2uglqiuu` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country_languages`
--

LOCK TABLES `country_languages` WRITE;
/*!40000 ALTER TABLE `country_languages` DISABLE KEYS */;
INSERT INTO `country_languages` VALUES (1,1),(3,7),(4,3),(5,2),(2,5),(6,6),(6,8),(5,4),(6,9),(7,10),(8,11),(9,12),(9,14),(10,16),(11,13),(11,17),(12,21),(14,18),(14,23),(13,20),(15,19),(16,15),(16,22),(17,28),(18,27),(20,24),(20,29),(19,26),(20,30),(21,25),(22,31),(22,32),(23,34),(24,33),(25,37),(26,36),(25,39),(24,35),(27,38),(25,40),(28,41),(28,42),(28,43),(29,44),(31,45),(31,49),(30,46),(32,48),(33,47),(33,50),(34,52),(35,53),(33,51),(37,55),(38,56),(36,54),(39,57),(39,58),(40,59),(40,60),(41,62),(43,64),(44,65),(45,66),(45,67),(42,61),(42,63),(46,68),(46,69),(47,70),(47,71),(48,72),(49,73),(50,74),(51,75),(52,76),(53,77),(53,78),(54,79),(54,80),(56,85),(55,86),(58,83),(57,84),(59,81),(59,82),(59,87),(59,88),(59,89),(61,94),(61,95),(60,90),(63,98),(64,93),(62,97),(61,96),(63,99),(60,91),(64,100),(65,101),(66,102),(67,103),(68,104),(69,105),(70,109),(60,92),(71,106),(71,107),(72,111),(71,110),(74,113),(73,112),(75,117),(76,118),(77,119),(78,120),(79,121),(80,122),(82,124),(83,125),(81,123),(85,108),(84,126),(86,130),(88,114),(88,115),(88,129),(88,131),(89,133),(90,134),(85,127),(87,116),(87,128),(91,132),(93,135),(92,137),(93,136),(94,139),(93,138),(94,140),(95,143),(96,144),(97,145),(98,148),(97,146),(101,150),(100,141),(101,151),(99,149),(100,142),(102,153),(103,154),(104,156),(105,155),(105,157),(107,147),(107,152),(108,162),(109,164),(109,165),(107,159),(106,158),(110,166),(107,160),(111,170),(110,167),(113,161),(113,169),(115,172),(116,173),(117,175),(116,174),(118,179),(114,171),(112,163),(112,168),(121,182),(121,183),(122,184),(120,176),(119,180),(124,186),(125,187),(124,188),(125,189),(123,178),(123,181),(127,190),(120,177),(128,191),(129,192),(126,185),(130,194),(130,196),(131,198),(130,197),(132,193),(133,201),(135,205),(136,206),(136,207),(137,208),(137,209),(138,210),(134,200),(141,211),(142,199),(142,212),(143,213),(144,214),(145,215),(146,216),(147,217),(148,219),(149,222),(150,220),(150,221),(150,223),(150,224),(151,225),(152,226),(153,227),(140,195),(139,203),(134,202),(140,204),(154,228),(154,229),(155,218),(156,231),(157,232),(159,234),(160,236),(159,235),(161,238),(158,233),(162,240),(164,242),(166,243),(163,241),(165,230),(165,237),(167,239),(168,247),(166,245),(169,251),(170,249),(170,253),(171,254),(172,255),(172,256),(173,244),(173,246),(174,257),(173,248),(175,258),(176,259),(177,260),(178,261),(179,262),(180,264),(181,250),(182,252),(183,266),(184,267),(185,268),(186,269),(186,270),(187,272),(186,271),(188,274),(189,275),(190,278),(191,276),(191,277),(191,279),(192,280),(193,281),(194,283),(179,263),(193,282),(195,287),(196,288),(197,273),(198,289),(199,291),(198,290),(200,295),(201,292),(201,293),(201,294),(201,297),(202,298),(203,299),(204,300),(204,302),(205,309),(206,301),(206,303),(206,304),(207,313),(206,305),(206,306),(206,307),(206,308),(206,310),(208,286),(210,314),(211,315),(212,316),(212,317),(213,318),(213,319),(214,320),(209,265),(206,311),(209,284),(215,285),(206,312),(217,323),(217,324),(219,327),(220,326),(220,329),(220,330),(221,331),(221,332),(222,333),(222,334),(223,335),(224,336),(225,337),(226,338),(227,339),(227,340),(228,341),(216,322),(229,296),(218,325),(229,321),(230,328),(231,342),(232,343),(233,347),(234,349),(235,348),(236,350),(237,351),(238,352),(239,353),(239,354),(240,355),(241,358),(240,356),(240,357),(242,359),(243,360),(244,361),(245,362),(246,363),(247,364),(247,365),(247,366),(249,346),(249,367),(248,344),(250,345),(250,368);
/*!40000 ALTER TABLE `country_languages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `language`
--

DROP TABLE IF EXISTS `language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `language` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `language`
--

LOCK TABLES `language` WRITE;
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
INSERT INTO `language` VALUES (1,'Arabic'),(2,'English'),(3,'Catalan'),(4,'Samoan'),(5,'Albanian'),(6,'Pashto'),(7,'Swedish'),(8,'Uzbek'),(9,'Turkmen'),(10,'Portuguese'),(11,'English'),(12,'English'),(13,'Spanish'),(14,'Russian'),(15,'Armenian'),(16,'English'),(17,'Guaraní'),(18,'Dutch'),(19,'English'),(20,'Azerbaijani'),(21,'German'),(22,'Russian'),(23,'(Eastern) Punjabi'),(24,'Dutch'),(25,'Bengali'),(26,'Arabic'),(27,'English'),(28,'English'),(29,'French'),(30,'German'),(31,'Belarusian'),(32,'Russian'),(33,'English'),(34,'English'),(35,'Spanish'),(36,'French'),(37,'Spanish'),(38,'Dzongkha'),(39,'Aymara'),(40,'Quechua'),(41,'Bosnian'),(42,'Croatian'),(43,'Serbian'),(44,'Dutch'),(45,'English'),(46,'English'),(47,'Norwegian'),(48,'Portuguese'),(49,'Tswana'),(50,'Norwegian Bokmål'),(51,'Norwegian Nynorsk'),(52,'English'),(53,'English'),(54,'Bulgarian'),(55,'English'),(56,'Malay'),(57,'French'),(58,'Fula'),(59,'French'),(60,'Kirundi'),(61,'English'),(62,'Khmer'),(63,'French'),(64,'Portuguese'),(65,'English'),(66,'French'),(67,'Sango'),(68,'English'),(69,'French'),(70,'French'),(71,'Arabic'),(72,'Spanish'),(73,'Chinese'),(74,'English'),(75,'English'),(76,'Spanish'),(77,'Arabic'),(78,'French'),(79,'French'),(80,'Lingala'),(81,'French'),(82,'Lingala'),(83,'English'),(84,'Spanish'),(85,'Croatian'),(86,'Spanish'),(87,'Kongo'),(88,'Swahili'),(89,'Luba-Katanga'),(90,'Dutch'),(91,'(Eastern) Punjabi'),(92,'English'),(93,'French'),(94,'Greek (modern)'),(95,'Turkish'),(96,'Armenian'),(97,'Danish'),(98,'Czech'),(99,'Slovak'),(100,'Arabic'),(101,'English'),(102,'Spanish'),(103,'Arabic'),(104,'Spanish'),(105,'Spanish'),(106,'Tigrinya'),(107,'Arabic'),(108,'Spanish'),(109,'Estonian'),(110,'English'),(111,'English'),(112,'Amharic'),(113,'Faroese'),(114,'English'),(115,'Fijian'),(116,'Finnish'),(117,'French'),(118,'French'),(119,'French'),(120,'French'),(121,'French'),(122,'English'),(123,'Georgian'),(124,'German'),(125,'English'),(126,'English'),(127,'French'),(128,'Swedish'),(129,'Hindi'),(130,'Greek (modern)'),(131,'Urdu'),(132,'Kalaallisut'),(133,'English'),(134,'French'),(135,'English'),(136,'Chamorro'),(137,'Spanish'),(138,'Spanish'),(139,'English'),(140,'French'),(141,'French'),(142,'Fula'),(143,'English'),(144,'Portuguese'),(145,'French'),(146,'Haitian'),(147,'Latin'),(148,'English'),(149,'Spanish'),(150,'English'),(151,'Chinese'),(152,'Italian'),(153,'Hungarian'),(154,'Icelandic'),(155,'Hindi'),(156,'Indonesian'),(157,'English'),(158,'French'),(159,'French'),(160,'German'),(161,'Arabic'),(162,'Persian (Farsi)'),(163,'Irish'),(164,'English'),(165,'Manx'),(166,'Hebrew (modern)'),(167,'Arabic'),(168,'English'),(169,'Kurdish'),(170,'Italian'),(171,'English'),(172,'Japanese'),(173,'English'),(174,'French'),(175,'Arabic'),(176,'Kazakh'),(177,'Russian'),(178,'English'),(179,'English'),(180,'Arabic'),(181,'Swahili'),(182,'Kyrgyz'),(183,'Russian'),(184,'Lao'),(185,'Latvian'),(186,'Arabic'),(187,'English'),(188,'French'),(189,'Southern Sotho'),(190,'English'),(191,'German'),(192,'Arabic'),(193,'Lithuanian'),(194,'French'),(195,'Chinese'),(196,'German'),(197,'Luxembourgish'),(198,'Macedonian'),(199,'French'),(200,'English'),(201,'Malaysian'),(202,'Chichewa'),(203,'Divehi'),(204,'Portuguese'),(205,'French'),(206,'Maltese'),(207,'English'),(208,'English'),(209,'Marshallese'),(210,'French'),(211,'Arabic'),(212,'Malagasy'),(213,'English'),(214,'French'),(215,'Spanish'),(216,'English'),(217,'Romanian'),(218,'French'),(219,'Mongolian'),(220,'Serbian'),(221,'Bosnian'),(222,'English'),(223,'Albanian'),(224,'Croatian'),(225,'Arabic'),(226,'Portuguese'),(227,'Burmese'),(228,'English'),(229,'Afrikaans'),(230,'English'),(231,'Nepali'),(232,'Dutch'),(233,'French'),(234,'English'),(235,'Māori'),(236,'Spanish'),(237,'Nauruan'),(238,'French'),(239,'English'),(240,'English'),(241,'English'),(242,'Korean'),(243,'English'),(244,'Norwegian'),(245,'Chamorro'),(246,'Norwegian Bokmål'),(247,'Arabic'),(248,'Norwegian Nynorsk'),(249,'English'),(250,'English'),(251,'Arabic'),(252,'Spanish'),(253,'Urdu'),(254,'English'),(255,'Spanish'),(256,'Guaraní'),(257,'Spanish'),(258,'English'),(259,'English'),(260,'Polish'),(261,'Portuguese'),(262,'Spanish'),(263,'English'),(264,'Arabic'),(265,'Albanian'),(266,'French'),(267,'Romanian'),(268,'Russian'),(269,'Kinyarwanda'),(270,'English'),(271,'French'),(272,'French'),(273,'English'),(274,'English'),(275,'English'),(276,'English'),(277,'French'),(278,'French'),(279,'Dutch'),(280,'English'),(281,'Samoan'),(282,'English'),(283,'Italian'),(284,'Serbian'),(285,'Portuguese'),(286,'Arabic'),(287,'French'),(288,'Serbian'),(289,'French'),(290,'English'),(291,'English'),(292,'English'),(293,'Malay'),(294,'Tamil'),(295,'Slovak'),(296,'Dutch'),(297,'Chinese'),(298,'Slovene'),(299,'English'),(300,'Somali'),(301,'Afrikaans'),(302,'Arabic'),(303,'English'),(304,'Southern Ndebele'),(305,'Southern Sotho'),(306,'Swati'),(307,'Tswana'),(308,'Tsonga'),(309,'English'),(310,'Venda'),(311,'Xhosa'),(312,'Zulu'),(313,'Korean'),(314,'English'),(315,'Spanish'),(316,'Sinhalese'),(317,'Tamil'),(318,'Arabic'),(319,'English'),(320,'Dutch'),(321,'English'),(322,'Norwegian'),(323,'English'),(324,'Swati'),(325,'Swedish'),(326,'German'),(327,'Arabic'),(328,'Chinese'),(329,'French'),(330,'Italian'),(331,'Tajik'),(332,'Russian'),(333,'Swahili'),(334,'English'),(335,'Thai'),(336,'Portuguese'),(337,'French'),(338,'English'),(339,'English'),(340,'Tonga (Tonga Islands)'),(341,'English'),(342,'Arabic'),(343,'Turkish'),(344,'English'),(345,'English'),(346,'Turkmen'),(347,'English'),(348,'Arabic'),(349,'Ukrainian'),(350,'English'),(351,'English'),(352,'Spanish'),(353,'Uzbek'),(354,'Russian'),(355,'Bislama'),(356,'English'),(357,'French'),(358,'Spanish'),(359,'Vietnamese'),(360,'French'),(361,'Spanish'),(362,'Arabic'),(363,'English'),(364,'English'),(365,'Shona'),(366,'Northern Ndebele'),(367,'Russian'),(368,'Swahili');
/*!40000 ALTER TABLE `language` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `languages_you_speak`
--

DROP TABLE IF EXISTS `languages_you_speak`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `languages_you_speak` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `learning` bit(1) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `language_id` bigint(20) DEFAULT NULL,
  `talker_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpn6pyja0rqxpeh46h3q3epa01` (`language_id`),
  KEY `FK6amis3rkg5fnum92riacs001v` (`talker_id`),
  CONSTRAINT `FK6amis3rkg5fnum92riacs001v` FOREIGN KEY (`talker_id`) REFERENCES `talker` (`id`),
  CONSTRAINT `FKpn6pyja0rqxpeh46h3q3epa01` FOREIGN KEY (`language_id`) REFERENCES `language` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `languages_you_speak`
--

LOCK TABLES `languages_you_speak` WRITE;
/*!40000 ALTER TABLE `languages_you_speak` DISABLE KEYS */;
INSERT INTO `languages_you_speak` VALUES (1,'',NULL,1,1),(2,'',NULL,326,3),(3,'',NULL,315,3),(4,'',NULL,8,4),(5,'',NULL,2,5),(6,'',NULL,2,6),(7,'',NULL,2,6),(8,'',NULL,2,6),(9,'',NULL,2,6),(10,'',NULL,1,7),(11,NULL,0,2,17);
/*!40000 ALTER TABLE `languages_you_speak` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `talker`
--

DROP TABLE IF EXISTS `talker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `talker` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `birth_date` date DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `born_in_id` bigint(20) DEFAULT NULL,
  `living_in_id` bigint(20) DEFAULT NULL,
  `native_language_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmwtr4uqh8so8mxnf52uceaf6r` (`born_in_id`),
  KEY `FKrdg63f8lkqr1tnpt7p88uo7a1` (`living_in_id`),
  KEY `FKosd1cesvokm3tk396n67b45vl` (`native_language_id`),
  KEY `FKcj8cv2qb4rvmkjhpwn1cbhky9` (`user_id`),
  CONSTRAINT `FKcj8cv2qb4rvmkjhpwn1cbhky9` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKmwtr4uqh8so8mxnf52uceaf6r` FOREIGN KEY (`born_in_id`) REFERENCES `country` (`id`),
  CONSTRAINT `FKosd1cesvokm3tk396n67b45vl` FOREIGN KEY (`native_language_id`) REFERENCES `language` (`id`),
  CONSTRAINT `FKrdg63f8lkqr1tnpt7p88uo7a1` FOREIGN KEY (`living_in_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `talker`
--

LOCK TABLES `talker` WRITE;
/*!40000 ALTER TABLE `talker` DISABLE KEYS */;
INSERT INTO `talker` VALUES (1,NULL,NULL,'aaaaaaa',1,1,1,NULL),(2,NULL,NULL,'ffffff',3,5,5,NULL),(3,NULL,NULL,'asdfsadf',2,4,4,NULL),(4,NULL,NULL,'dfadsfad',3,7,8,NULL),(5,NULL,NULL,'fasfsadfsd',3,6,8,NULL),(6,NULL,NULL,'ffsadasd',4,3,3,NULL),(7,NULL,NULL,'aaaaa',1,2,6,NULL),(8,NULL,NULL,'fasdfasd',1,1,1,NULL),(9,NULL,NULL,'aaa',3,4,6,NULL),(10,NULL,NULL,'fasdfasd',2,4,5,NULL),(11,NULL,NULL,'asdfsadfsad',1,1,1,NULL),(12,NULL,NULL,'dsfasdf',2,2,5,NULL),(13,NULL,NULL,'fsadf',1,3,3,NULL),(14,NULL,NULL,'fasdfsdf',4,4,12,NULL),(15,NULL,NULL,'asdfsadf',1,3,3,NULL),(16,NULL,NULL,'fasdfas',4,4,6,NULL),(17,'2017-04-19',NULL,'Maggie Rogers',237,237,19,1);
/*!40000 ALTER TABLE `talker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'maggierogers@bruxelas.com.br','123456');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `version`
--

DROP TABLE IF EXISTS `version`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `version` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `build` varchar(255) DEFAULT NULL,
  `build_date` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `version`
--

LOCK TABLES `version` WRITE;
/*!40000 ALTER TABLE `version` DISABLE KEYS */;
INSERT INTO `version` VALUES (1,'1','20170413','First Build');
/*!40000 ALTER TABLE `version` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

Insert Into user(email, password) values('maggierogers@bruxelas.com.br', '123456');
Insert Into talker(birth_date, name, born_in_id, user_id) values ('1999-12-19', 'Maggie Rogers', 237, 1);

