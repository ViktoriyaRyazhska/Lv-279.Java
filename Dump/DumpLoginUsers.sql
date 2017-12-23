
use ss_ps_db;
SET SQL_SAFE_UPDATES = 0;

DROP TABLE IF EXISTS `login_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_non_expired` bit(1) NOT NULL,
  `account_non_locked` bit(1) NOT NULL,
  `authority` varchar(255) DEFAULT NULL,
  `credentials_non_expired` bit(1) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKctad27fryj7tnantkhbqggr1v` (`employee_id`),
  CONSTRAINT `FKctad27fryj7tnantkhbqggr1v` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `login_user` WRITE;
/*!40000 ALTER TABLE `login_user` DISABLE KEYS */;
INSERT INTO `login_user` VALUES (1,'','','USER','','','$2a$10$xsC3s4zqKO8CdStghFgqa.2/hw0ADFoNWPpjgiO2AOl3YhUUTnaUu','1',1),(2,'','','ADMIN','','','$2a$10$CQ.60ak/MVz4US0yLKU.NOYP2tQaNCVgnQbjm0AeR9yk63Ac/HhO2','admin',2),(3,'','','TEACHER','','','$2a$10$eWhb7Uz/ieOnfQDBjTOWWevSdEDgFpBjyRbusymXjyivG6Ht.X6f2','teacher',NULL),(4,'','','INTERVIEWER','','','$2a$10$8p7pTBdJMoKM8IKhLMgFkeuysqKkKGVd7xhk7BKkcu2BQPeetZkai','interviewer',NULL),(5,'','','EXPERT','','','$2a$10$uk8HbiWWIWvwXSyAqD2Xq.fMBdsFBK2svLqf28JlZd61UmrAC6HYa','expert',NULL),(6,'','','NETWORK_LEAD','','','$2a$10$zeonP.zr.rIyW9TUyfWQDeaIVoOUjbBRUNW.hm3TBWWSBO9hIWUD2','network_lead',NULL),(7,'','','ITA_COORDINATOR','','','$2a$10$An57CJXxOWyxBIFTxktMOObveyoX3bi5sZUm28jEbj9xR/OtqNZBu','ita_coordinator',NULL),(8,'','','ITA_ADMIN','','','$2a$10$PmBrMG3w9qrpKjy2bociHuwMEiHXZAQrtbE2TXFWsrJwS2oSRAXzi','ita_admin',NULL),(9,'','','RECRUITER','','','$2a$10$UQQqlWUgVCROgFtzeXc1ieA7fZoFrZyX53uZNpn8XoPORou4tYd3i','recruiter',NULL),(10,'','','SOFTSERVE_PM','','','$2a$10$tNFEFOLoDMYt9vXNTAG/s../TnuMktsMvhQHsgyMvTdJtGn3WUrC.','softserve_pm',NULL);
/*!40000 ALTER TABLE `login_user` ENABLE KEYS */;
UNLOCK TABLES;