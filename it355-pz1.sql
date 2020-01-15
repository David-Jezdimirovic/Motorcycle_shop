-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 23, 2019 at 12:35 PM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `it355-pz1`
--
CREATE DATABASE IF NOT EXISTS `it355-pz1` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `it355-pz1`;

-- --------------------------------------------------------

--
-- Table structure for table `korisnici`
--

CREATE TABLE IF NOT EXISTS `korisnici` (
  `korisnik_id` int(11) NOT NULL AUTO_INCREMENT,
  `aktivan` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `ime` varchar(255) DEFAULT NULL,
  `prezime` varchar(255) DEFAULT NULL,
  `sifra` varchar(255) DEFAULT NULL,
  `uloga_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`korisnik_id`),
  KEY `FKkrcmlkbln8naw7c1vurtrl6qn` (`uloga_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `marke`
--

CREATE TABLE IF NOT EXISTS `marke` (
  `marka_id` int(11) NOT NULL AUTO_INCREMENT,
  `marka_naziv` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`marka_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `modeli`
--

CREATE TABLE IF NOT EXISTS `modeli` (
  `model_id` int(11) NOT NULL AUTO_INCREMENT,
  `model_naziv` varchar(255) DEFAULT NULL,
  `marka_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`model_id`),
  KEY `FK7macsa7rt1ncjp5s063whn9pt` (`marka_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `motori`
--

CREATE TABLE IF NOT EXISTS `motori` (
  `motor_id` int(11) NOT NULL AUTO_INCREMENT,
  `cena` int(11) DEFAULT NULL,
  `godiste` int(11) DEFAULT NULL,
  `opis` varchar(255) DEFAULT NULL,
  `model_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`motor_id`),
  KEY `FK4enmrejg5x7pyhta3t5odb9dd` (`model_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `porudzbine`
--

CREATE TABLE IF NOT EXISTS `porudzbine` (
  `porudzbina_id` int(11) NOT NULL AUTO_INCREMENT,
  `datum` datetime DEFAULT NULL,
  `korisnik_id` int(11) DEFAULT NULL,
  `motor_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`porudzbina_id`),
  KEY `FKqlg9tjd3ilfperaao9ewuujf1` (`korisnik_id`),
  KEY `FKliflvomxlqrim2a6qbx9qav8t` (`motor_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `uloge`
--

CREATE TABLE IF NOT EXISTS `uloge` (
  `uloga_id` int(11) NOT NULL AUTO_INCREMENT,
  `uloga_naziv` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uloga_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
