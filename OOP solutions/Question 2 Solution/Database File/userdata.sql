-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Jul 24, 2020 at 02:29 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `userlogin`
--

-- --------------------------------------------------------

--
-- Table structure for table `userdata`
--

DROP TABLE IF EXISTS `userdata`;
CREATE TABLE IF NOT EXISTS `userdata` (
  `Email` varchar(120) NOT NULL,
  `SECUREPASSWORD` varchar(120) NOT NULL,
  `Salt` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userdata`
--

INSERT INTO `userdata` (`Email`, `SECUREPASSWORD`, `Salt`) VALUES
('Asd@dasd.com', 'blQEYbwYEKj2hbDEaCfukJjK6z/YyKjVPOyQXHch5Qo=', 'ub17DCzXUsoa0P76vMBDUCcVsGVZYx'),
('a@g.com', 'Kny0UFo2hxQcXfcvt21k2tOL0FtvU9YKi1Fhjlk0TNg=', 'iDzsd9TzpFLUL08Qj4RlpwitzTVw5n'),
('admin@localhost.local', 'DYeO6F3jc1rpzMAcBiA27uwGgaK/NQQRmxg4IUK6Sro=', '1pcYsUGXD0LtLBIWl6oOGccxZ8MevJ'),
('b@g.com', 'jCuH1NZKwxjpFbNbPaJpQK09D2Cl7BH0/pcSST2iF1E=', 'LljmgHFOSWQl37aO0OgPjA13nElot8'),
('a@t.com', 'FtxMtqGah3twbQDc0PMDuV9DBasdvi4z5c2GLK4muBg=', '3xPlZKX1FEr4TdDkj5aPld5tbZTwq8'),
('a@y.com', 'tQooah76ufXlnILIpXTNGmrs39LWwwx02L2zjVtXyIc=', '9reIHqe7tWKBfd2BMCGj0Yzkjp99Yz'),
('a@gb.com', 'ePOTE33aGzgRTaAfHwJpmtmAMtYLM85Qq/rWxO8kSiw=', 'YPyzVFjXHBGaE8GQr8goExtoWAfZa8'),
('a@gbt.com', 'INOZ/GNxd3GsUmU9UQRuXWsLXf1j+xPsEw5EW7T8DI4=', 'BoYoC6tpQWcIq6fmA7lxnR2sIc45X7');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
