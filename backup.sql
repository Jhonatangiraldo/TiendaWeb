-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.28-rc-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema hibernatedb
--

CREATE DATABASE IF NOT EXISTS hibernatedb;
USE hibernatedb;

--
-- Definition of table `bodega`
--

DROP TABLE IF EXISTS `bodega`;
CREATE TABLE `bodega` (
  `id_bodega` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_bodega`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bodega`
--

/*!40000 ALTER TABLE `bodega` DISABLE KEYS */;
INSERT INTO `bodega` (`id_bodega`,`nombre`) VALUES 
 (1,'Poblado '),
 (2,'Laureles'),
 (3,'Centro');
/*!40000 ALTER TABLE `bodega` ENABLE KEYS */;


--
-- Definition of table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria` (
  `id_categoria` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categoria`
--

/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` (`id_categoria`,`nombre`) VALUES 
 (1,'Drama'),
 (2,'Comedia'),
 (3,'Aventura'),
 (4,'Romance'),
 (5,'Accion'),
 (6,'Terror');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;


--
-- Definition of table `director`
--

DROP TABLE IF EXISTS `director`;
CREATE TABLE `director` (
  `id_director` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_director`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `director`
--

/*!40000 ALTER TABLE `director` DISABLE KEYS */;
INSERT INTO `director` (`id_director`,`nombre`) VALUES 
 (1,'Scott Derrickson'),
 (2,'Peter Jackson'),
 (3,'Ridley Scott'),
 (4,'Zack Snyder'),
 (5,'Jon Favreau'),
 (6,'Steven Soderbergh'),
 (7,'Martin Scorsese'),
 (8,'Joss Whedon'),
 (9,'Clint Eastwood');
/*!40000 ALTER TABLE `director` ENABLE KEYS */;


--
-- Definition of table `distribuidorestudio`
--

DROP TABLE IF EXISTS `distribuidorestudio`;
CREATE TABLE `distribuidorestudio` (
  `id_distribuidorEstudio` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_distribuidorEstudio`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `distribuidorestudio`
--

/*!40000 ALTER TABLE `distribuidorestudio` DISABLE KEYS */;
INSERT INTO `distribuidorestudio` (`id_distribuidorEstudio`,`nombre`) VALUES 
 (1,'Universal Pictures'),
 (2,'20th Century Fox'),
 (3,'Walt Disney Pictures'),
 (4,'Sony Pictures'),
 (5,'Columbia Pictures'),
 (6,'Marvel Studios'),
 (7,'Paramount Pictures'),
 (8,'Metro Goldwyn Meyer');
/*!40000 ALTER TABLE `distribuidorestudio` ENABLE KEYS */;


--
-- Definition of table `formato`
--

DROP TABLE IF EXISTS `formato`;
CREATE TABLE `formato` (
  `id_formato` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_formato`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `formato`
--

/*!40000 ALTER TABLE `formato` DISABLE KEYS */;
INSERT INTO `formato` (`id_formato`,`nombre`) VALUES 
 (1,'DVD'),
 (2,'Bluray'),
 (3,'SSD');
/*!40000 ALTER TABLE `formato` ENABLE KEYS */;


--
-- Definition of table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES 
 (20),
 (20),
 (20),
 (20),
 (20),
 (20),
 (20),
 (20);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;


--
-- Definition of table `pelicula`
--

DROP TABLE IF EXISTS `pelicula`;
CREATE TABLE `pelicula` (
  `id_pelicula` bigint(20) NOT NULL AUTO_INCREMENT,
  `costoHora` bigint(20) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `id_bodega` bigint(20) DEFAULT NULL,
  `id_categoria` bigint(20) DEFAULT NULL,
  `id_director` bigint(20) DEFAULT NULL,
  `id_distribuidorEstudio` bigint(20) DEFAULT NULL,
  `id_formato` bigint(20) DEFAULT NULL,
  `id_sucursal` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_pelicula`),
  KEY `FKabjbth2w7hja09m9f5rrs56ql` (`id_bodega`),
  KEY `FKafe70ywxekpqpkc9je3dabn7f` (`id_categoria`),
  KEY `FKogp9cm969f8wynmq2dd8bx33w` (`id_director`),
  KEY `FKq6etqlyqjps2f22xgysi4npww` (`id_distribuidorEstudio`),
  KEY `FKm4soq8fe5k9207ghj2oxwdbnd` (`id_formato`),
  KEY `FKbudns2fa6w1e779sf1qqyywi0` (`id_sucursal`),
  CONSTRAINT `FKabjbth2w7hja09m9f5rrs56ql` FOREIGN KEY (`id_bodega`) REFERENCES `bodega` (`id_bodega`),
  CONSTRAINT `FKafe70ywxekpqpkc9je3dabn7f` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`),
  CONSTRAINT `FKbudns2fa6w1e779sf1qqyywi0` FOREIGN KEY (`id_sucursal`) REFERENCES `sucursal` (`id_sucursal`),
  CONSTRAINT `FKm4soq8fe5k9207ghj2oxwdbnd` FOREIGN KEY (`id_formato`) REFERENCES `formato` (`id_formato`),
  CONSTRAINT `FKogp9cm969f8wynmq2dd8bx33w` FOREIGN KEY (`id_director`) REFERENCES `director` (`id_director`),
  CONSTRAINT `FKq6etqlyqjps2f22xgysi4npww` FOREIGN KEY (`id_distribuidorEstudio`) REFERENCES `distribuidorestudio` (`id_distribuidorEstudio`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pelicula`
--

/*!40000 ALTER TABLE `pelicula` DISABLE KEYS */;
INSERT INTO `pelicula` (`id_pelicula`,`costoHora`,`imagen`,`nombre`,`id_bodega`,`id_categoria`,`id_director`,`id_distribuidorEstudio`,`id_formato`,`id_sucursal`) VALUES 
 (1,100,'Doctor-Strange.jpg','Doctor Strange',1,3,1,6,2,1),
 (2,100,'sinister2.jpg','Sinister 2',2,6,1,7,1,4),
 (3,100,'deliverevil.jpg','Líbranos del mal',2,6,1,7,3,4),
 (4,100,'thehobbit-desolation.jpg','El hobbit: la desolación de Smaug',3,3,2,8,2,3),
 (5,100,'hobbit-journey.jpg','El hobbit: un viaje inesperado',3,3,2,8,2,5),
 (6,100,'las-dos-torres-b.jpg','El Señor de los Anillos',2,3,2,8,1,6),
 (7,100,'sector9.jpg','Sector 9',1,5,2,5,1,2),
 (8,100,'rescate.jpg','Misión Rescate',2,1,3,4,2,2),
 (9,100,'gladiador.jpg','Gladiador',3,5,3,2,3,3),
 (10,100,'Black_haw.jpg','La caída del halcón negro',2,5,3,4,2,5),
 (11,100,'Batman_v_Superman.jpg','Batman v Superman',3,5,4,4,2,6),
 (12,100,'elflarge.jpg','Elf',1,2,5,3,3,5),
 (13,100,'couples_retreat.jpg','Solo para parejas',1,2,5,1,2,1),
 (14,100,'Hagan-juego.jpg','La gran estafa',2,1,6,2,3,1),
 (15,100,'out_of_sight.jpg','Un romance peligroso',1,4,6,3,1,6),
 (16,100,'solaris.jpg','Solaris',2,4,6,5,3,6),
 (17,100,'lobo.jpg','El lobo de Wall Street',3,2,7,7,3,1),
 (18,100,'Shutterislandposter.jpg','Shutter Island',3,1,7,7,1,4),
 (19,100,'vengadores.jpg','The Avengers',2,5,8,6,2,3),
 (20,100,'Avengers_Age_of_Ultron.jpg','Vengadores: La era de Ultrón',1,5,8,6,1,2),
 (21,100,'Watch-The-Cabin.jpg','La cabaña del terror',2,6,8,1,2,5),
 (22,100,'franco.jpg','Francotirador',3,1,9,2,1,5),
 (23,100,'invictus.jpg','Invictus',2,1,9,2,3,2);
/*!40000 ALTER TABLE `pelicula` ENABLE KEYS */;


--
-- Definition of table `personaje`
--

DROP TABLE IF EXISTS `personaje`;
CREATE TABLE `personaje` (
  `id_personaje` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `id_pelicula` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_personaje`) USING BTREE,
  KEY `FKpn6lghsloki3jdqpyhu1cr1ps` (`id_pelicula`),
  CONSTRAINT `FKpn6lghsloki3jdqpyhu1cr1ps` FOREIGN KEY (`id_pelicula`) REFERENCES `pelicula` (`id_pelicula`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `personaje`
--

/*!40000 ALTER TABLE `personaje` DISABLE KEYS */;
INSERT INTO `personaje` (`id_personaje`,`nombre`,`id_pelicula`) VALUES 
 (1,'Benedict Cumberbatch',1),
 (2,'Benedict Wong',1),
 (3,'James Ransone',2),
 (4,'Eric Bana',3),
 (5,'Édgar Ramírez',3),
 (6,'Martin Freeman',4),
 (7,'Ian Mckellen',4),
 (8,'Richard Armitage',5),
 (9,'James Nesbitt',5),
 (10,'Ian McKellen',6),
 (11,'Orlando Bloom',6),
 (12,'Sharlto Copley',7),
 (13,'Jason Cope',7),
 (14,'Matt Damon',8),
 (15,'Jessica Chastain',8),
 (16,'Russell Crowe',9),
 (17,'Josh Hartnett',10),
 (18,'Eric Bana',10),
 (19,'Ben Affleck',11),
 (20,'Henry Cavill',11),
 (21,'Will Ferrell',12),
 (22,'Jon Favreau',13),
 (23,'Vince Vaughn',13),
 (24,'George Clooney',14),
 (25,'Brad Pitt',14),
 (26,'George Clooney',15),
 (27,'Jennifer Lopez',15),
 (28,'George Clooney',16),
 (29,'Natascha McElhone',16),
 (30,'Leonardo DiCaprio',17),
 (31,'Margot Robbie',17),
 (32,'Leonardo DiCaprio',18),
 (33,'Mark Ruffalo',18),
 (34,'Robert Downey Jr.',19),
 (35,'Mark Ruffalo',19),
 (36,'Chris Hemsworth',19),
 (37,'Robert Downey Jr.',20),
 (38,'Chris Hemsworth',20),
 (39,'Chris Evans',20),
 (40,'Chris Hemsworth',21),
 (41,'Fran Kranz',21),
 (42,'Bradley Cooper',22),
 (43,'Sienna Miller',22),
 (44,'Morgan Freeman',23),
 (45,'Matt Damon',23);
/*!40000 ALTER TABLE `personaje` ENABLE KEYS */;


--
-- Definition of table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
CREATE TABLE `reserva` (
  `id_reserva` bigint(20) NOT NULL AUTO_INCREMENT,
  `fechaFinal` varchar(45) DEFAULT NULL,
  `fechaInicio` varchar(45) DEFAULT NULL,
  `id_pelicula` bigint(20) DEFAULT NULL,
  `id_usuario` bigint(20) DEFAULT NULL,
  `precioTotal` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_reserva`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reserva`
--

/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;


--
-- Definition of table `sucursal`
--

DROP TABLE IF EXISTS `sucursal`;
CREATE TABLE `sucursal` (
  `id_sucursal` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_sucursal`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sucursal`
--

/*!40000 ALTER TABLE `sucursal` DISABLE KEYS */;
INSERT INTO `sucursal` (`id_sucursal`,`nombre`) VALUES 
 (1,'Sucursal Robledo'),
 (2,'Sucursal La América'),
 (3,'Sucursal San Javier'),
 (4,'Sucursal Aranjuez'),
 (5,'Sucursal El Poblado'),
 (6,'Sucursal Belén');
/*!40000 ALTER TABLE `sucursal` ENABLE KEYS */;


--
-- Definition of table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id_usuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `contrasena` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id_usuario`,`contrasena`,`usuario`) VALUES 
 (1,'1234','jhonatan');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
