--
-- Table structure for table `login_user`
--
DROP TABLE IF EXISTS `login_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_non_expired` bit(1) NOT NULL,
  `account_non_locked` bit(1) NOT NULL,
  `credentials_non_expired` bit(1) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKctad27fryj7tnantkhbqggr1v` (`employee_id`),
  CONSTRAINT `FKctad27fryj7tnantkhbqggr1v` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_user`
--
LOCK TABLES `login_user` WRITE;
/*!40000 ALTER TABLE `login_user` DISABLE KEYS */;
INSERT INTO `login_user` VALUES (1,'','','','','$2a$10$JADJ2scItwF5HfBETnge4e0YFyr8kgMHntRTZ7dkHAchGh3m/4qI6','teacher',NULL),(2,'','','','','$2a$10$uqhIxfglXQi/LEpAYzllcebWPUJcXmXqC/9ZlUPK6.ewAvtIEux.e','expert',NULL),(3,'','','','','$2a$10$LSaYypTfNTegjc4Zr.aXv.ZAS/Y6AAIWdYSaD0z9G8YQCopOQidIS','interviewer',NULL),(4,'','','','','$2a$10$qMmbBP3iuYd5zpESCauT8OK8llTbE9kF6rXoI8gqPdRaLNM2V3/rG','network_lead',NULL),(5,'','','','','$2a$10$dKevT15RapKefa69tl1/LOnmMl32GFofKzVWzdYmOV6rpoRHUC0oW','ita_coordinator',NULL),(6,'','','','','$2a$10$nfpCsY8OWOkhCZTfJ1lRAuDfsNmLcSCHbwxYupZX.a4dHV6pqJXJe','ita_admin',NULL),(7,'','','','','$2a$10$fnrARL/5xpDJwhMKpxnVSe0mh9IhczwJTjB7AXz6ZDaU4ZBEwagYq','recruiter',NULL),(8,'','','','','$2a$10$xjBTA4Jy5c1jkJyeQ8pmt.inINk2WR7zWzfWZCvt.7c3rKLVm7Gvy','softserve_pm',NULL);
/*!40000 ALTER TABLE `login_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_roles`
--
DROP TABLE IF EXISTS `employee_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_roles` (
  `employeeroles_id` int(11) NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employeeroles_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_roles`
--
LOCK TABLES `employee_roles` WRITE;
/*!40000 ALTER TABLE `employee_roles` DISABLE KEYS */;
INSERT INTO `employee_roles` VALUES (1,'TEACHER'),(2,'EXPERT'),(3,'INTERVIEWER'),(4,'NETWORK_LEAD'),(5,'ITA_COORDINATOR'),(6,'ITA_ADMIN'),(7,'RECRUITER'),(8,'SOFTSERVE_PM');
/*!40000 ALTER TABLE `employee_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loginuser_employeeroles`
--
DROP TABLE IF EXISTS `loginuser_employeeroles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loginuser_employeeroles` (
  `id` int(11) NOT NULL,
  `employeeroles_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`employeeroles_id`),
  KEY `FKgvekcnf1ydg5qtikcho8shaae` (`employeeroles_id`),
  CONSTRAINT `FKkl3g1t81y0pbexjofd0xn4ct7` FOREIGN KEY (`id`) REFERENCES `login_user` (`id`),
  CONSTRAINT `FKgvekcnf1ydg5qtikcho8shaae` FOREIGN KEY (`employeeroles_id`) REFERENCES `employee_roles` (`employeeroles_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loginuser_employeeroles`
--
LOCK TABLES `loginuser_employeeroles` WRITE;
/*!40000 ALTER TABLE `loginuser_employeeroles` DISABLE KEYS */;
INSERT INTO `loginuser_employeeroles` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8);
/*!40000 ALTER TABLE `loginuser_employeeroles` ENABLE KEYS */;
UNLOCK TABLES;

