-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.30-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para test
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `test`;


-- Volcando estructura para tabla test.tont_aves
CREATE TABLE IF NOT EXISTS `tont_aves` (
  `CDAVE` varchar(5) NOT NULL,
  `DSNOMBRE_COMUN` varchar(100) NOT NULL,
  `DSNOMBRE_CIENTIFICO` varchar(200) NOT NULL,
  PRIMARY KEY (`CDAVE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla test.tont_aves: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `tont_aves` DISABLE KEYS */;
INSERT INTO `tont_aves` (`CDAVE`, `DSNOMBRE_COMUN`, `DSNOMBRE_CIENTIFICO`) VALUES
	('A1', 'Sapo dorado', 'Bufo periglenes'),
	('A2', 'Iguana verde', 'Iguana iguana'),
	('A5', 'ELEFANTE E', 'ELEPHANTUS ED'),
	('C1', 'Cocodrilo americano', 'Crocodylus acutus');
/*!40000 ALTER TABLE `tont_aves` ENABLE KEYS */;


-- Volcando estructura para tabla test.tont_aves_pais
CREATE TABLE IF NOT EXISTS `tont_aves_pais` (
  `CDPAIS` varchar(3) NOT NULL,
  `CDAVE` varchar(5) NOT NULL,
  PRIMARY KEY (`CDPAIS`,`CDAVE`),
  KEY `FK_AVE` (`CDAVE`),
  CONSTRAINT `FK_AVE` FOREIGN KEY (`CDAVE`) REFERENCES `tont_aves` (`CDAVE`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_PAIS` FOREIGN KEY (`CDPAIS`) REFERENCES `tont_paises` (`CDPAIS`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla test.tont_aves_pais: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `tont_aves_pais` DISABLE KEYS */;
INSERT INTO `tont_aves_pais` (`CDPAIS`, `CDAVE`) VALUES
	('BR', 'A2'),
	('CO', 'A1'),
	('CO', 'A5'),
	('US', 'C1');
/*!40000 ALTER TABLE `tont_aves_pais` ENABLE KEYS */;


-- Volcando estructura para tabla test.tont_paises
CREATE TABLE IF NOT EXISTS `tont_paises` (
  `CDPAIS` varchar(3) NOT NULL,
  `DSNOMBRE` varchar(100) NOT NULL,
  `CDZONA` varchar(3) NOT NULL,
  PRIMARY KEY (`CDPAIS`),
  KEY `FK_ZONAS` (`CDZONA`),
  CONSTRAINT `FK_ZONAS` FOREIGN KEY (`CDZONA`) REFERENCES `tont_zonas` (`CDZONA`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla test.tont_paises: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `tont_paises` DISABLE KEYS */;
INSERT INTO `tont_paises` (`CDPAIS`, `DSNOMBRE`, `CDZONA`) VALUES
	('BR', 'Brasil', 'Z2'),
	('CO', 'Colombia', 'Z2'),
	('MX', 'México', 'Z5'),
	('US', 'Estados Unidos', 'Z1');
/*!40000 ALTER TABLE `tont_paises` ENABLE KEYS */;


-- Volcando estructura para tabla test.tont_zonas
CREATE TABLE IF NOT EXISTS `tont_zonas` (
  `CDZONA` varchar(3) NOT NULL,
  `DSNOMBRE` varchar(45) NOT NULL,
  PRIMARY KEY (`CDZONA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla test.tont_zonas: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `tont_zonas` DISABLE KEYS */;
INSERT INTO `tont_zonas` (`CDZONA`, `DSNOMBRE`) VALUES
	('Z1', 'Norte'),
	('Z2', 'Sur'),
	('Z3', 'Occidente'),
	('Z4', 'Oriente'),
	('Z5', 'Centro');
/*!40000 ALTER TABLE `tont_zonas` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
