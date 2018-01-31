/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE IF NOT EXISTS personeel;
USE personeel;

DROP TABLE IF EXISTS jobtitels;
CREATE TABLE jobtitels (
  id int unsigned NOT NULL AUTO_INCREMENT,
  naam varchar(50) NOT NULL,
  versie int unsigned not null default 0,
  PRIMARY KEY (id),
  UNIQUE KEY jobtitel (naam)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

ALTER TABLE jobtitels DISABLE KEYS;
INSERT INTO jobtitels(id, naam) VALUES 
 (1,'President'),
 (2,'Sale Manager (EMEA)'),
 (3,'Sales Manager (APAC)'),
 (4,'Sales Manager (NA)'),
 (5,'Sales Rep'),
 (6,'VP Marketing'),
 (7,'VP Sales');
ALTER TABLE jobtitels ENABLE KEYS;

DROP TABLE IF EXISTS werknemers;
CREATE TABLE werknemers (
  id int unsigned NOT NULL AUTO_INCREMENT,
  familienaam varchar(50) NOT NULL,
  voornaam varchar(50) NOT NULL,
  email varchar(100) NOT NULL,
  chefid int unsigned DEFAULT NULL,
  jobtitelid int unsigned NOT NULL,
  salaris decimal(10,2) NOT NULL DEFAULT 0,
  versie int unsigned not null default 0,
  PRIMARY KEY (id),
  UNIQUE KEY email (email),
  KEY FK_werknemers_werknemers(chefid),
  KEY FK_werknemers_jobtitels(jobtitelid),
  CONSTRAINT FK_werknemers_werknemers FOREIGN KEY (chefid) REFERENCES werknemers(id),
  CONSTRAINT FK_werknemers_jobtitels FOREIGN KEY (jobtitelid) REFERENCES jobtitels(id)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

ALTER TABLE werknemers DISABLE KEYS;
INSERT INTO werknemers (id,familienaam,voornaam,email,chefid,jobtitelid,salaris) VALUES 
 (1,'Murphy','Diane','Diane.Murphy@toysforboys.com',NULL,1,3000),
 (2,'Patterson','Mary','Mary.Patterson@toysforboys.com',1,7,2000),
 (3,'Firrelli','Jeff','Jeff.Firrelli@toysforboys.com',1,6,2100),
 (4,'Patterson','William','William.Patterson@toysforboys.com',2,3,1950),
 (5,'Bondur','Gerard','Gerard.Bondur@toysforboys.com',2,2,1970),
 (6,'Bow','Anthony','Anthony.Bow@toysforboys.com',2,4,1920),
 (7,'Jennings','Leslie','Leslie.Jennings@toysforboys.com',6,5,1910),
 (8,'Thompson','Leslie','Leslie.Thompson@toysforboys.com',6,5,1905),
 (9,'Firrelli','Julie','Julie.Firrelli@toysforboys.com',6,5,1900),
 (10,'Patterson','Steve','Steve.Patterson@toysforboys.com',6,5,1910),
 (11,'Tseng','Foon Yue','Foon.Yue.Tseng@toysforboys.com',6,5,1904),
 (12,'Vanauf','George','George.Vanauf@toysforboys.com',6,5,1905),
 (13,'Bondur','Loui','Loui.Bondur@toysforboys.com',5,5,1909),
 (14,'Hernandez','Gerard','Gerard.Hernandez@toysforboys.com',5,5,1908),
 (15,'Castillo','Pamela','Pamela.Castillo@toysforboys.com',5,5,1903),
 (16,'Bott','Larry','Larry.Bott@toysforboys.com',5,5,1902),
 (17,'Jones','Barry','Barry.Jones@toysforboys.com',5,5,1903),
 (18,'Fixter','Andy','Andy.Fixter@toysforboys.com',4,5,1907),
 (19,'Marsh','Peter','Peter.Marsh@toysforboys.com',4,5,1905),
 (20,'King','Tom','Tom.King@toysforboys.com',4,5,1904),
 (21,'Nishi','Mami','Mami.Nishi@toysforboys.com',2,5,1900),
 (22,'Kato','Yoshimi','Yoshimi.Kato@toysforboys.com',19,5,1901),
 (23,'Gerard','Martin','Martin.Gerard@toysforboys.com',5,5,1902);
ALTER TABLE werknemers ENABLE KEYS;

grant select on jobtitels to 'cursist'@'localhost';
grant select,update on werknemers to 'cursist'@'localhost';



/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
