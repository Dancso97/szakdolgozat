-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2021. Már 31. 21:34
-- Kiszolgáló verziója: 10.4.17-MariaDB
-- PHP verzió: 7.4.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `szd`
--
CREATE DATABASE IF NOT EXISTS `szd` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `szd`;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `address`
--

DROP TABLE IF EXISTS `address`;
CREATE TABLE IF NOT EXISTS `address` (
  `zip` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address1` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address2` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`zip`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- A tábla adatainak kiíratása `address`
--

INSERT INTO `address` (`zip`, `city`, `address1`, `address2`) VALUES
(1, 'Miskolc', 'Nagy Imre 11', NULL),
(2, 'Miskolc', 'Arany János ', '3/A');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `building`
--

DROP TABLE IF EXISTS `building`;
CREATE TABLE IF NOT EXISTS `building` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `added_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `comment` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address` int(11) NOT NULL,
  `client` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `client` (`client`),
  KEY `address` (`address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `data`
--

DROP TABLE IF EXISTS `data`;
CREATE TABLE IF NOT EXISTS `data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plate` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `stop_date` timestamp NULL DEFAULT NULL,
  `comment` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `image` int(11) NOT NULL,
  `service` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `service` (`service`),
  KEY `image` (`image`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `image`
--

DROP TABLE IF EXISTS `image`;
CREATE TABLE IF NOT EXISTS `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` timestamp NOT NULL DEFAULT current_timestamp(),
  `image` longblob NOT NULL,
  `image_metadata` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `image_imagemetadata_id_fk` (`image_metadata`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- A tábla adatainak kiíratása `image`
--

INSERT INTO `image` (`id`, `date`, `image`, `image_metadata`) VALUES

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `imagemetadata`
--

DROP TABLE IF EXISTS `imagemetadata`;
CREATE TABLE IF NOT EXISTS `imagemetadata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `height` int(11) NOT NULL,
  `width` int(11) NOT NULL,
  `original_date` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- A tábla adatainak kiíratása `imagemetadata`
--

INSERT INTO `imagemetadata` (`id`, `name`, `height`, `width`, `original_date`) VALUES
(1, 'PROBA', 500, 400, '2021-03-25 23:00:00'),
(2, 'metadata2', 600, 400, '2021-03-25 23:00:00'),
(4, 'proba2', 600, 400, '2021-03-26 22:57:11');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `services`
--

DROP TABLE IF EXISTS `services`;
CREATE TABLE IF NOT EXISTS `services` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `comment` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `servicetype`
--

DROP TABLE IF EXISTS `servicetype`;
CREATE TABLE IF NOT EXISTS `servicetype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `start_date` int(11) NOT NULL,
  `end_date` int(11) DEFAULT NULL,
  `service` int(11) NOT NULL,
  `building` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `building` (`building`),
  KEY `service` (`service`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `building`
--
ALTER TABLE `building`
  ADD CONSTRAINT `building_ibfk_1` FOREIGN KEY (`client`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `building_ibfk_2` FOREIGN KEY (`address`) REFERENCES `address` (`zip`),
  ADD CONSTRAINT `building_ibfk_3` FOREIGN KEY (`address`) REFERENCES `address` (`zip`);

--
-- Megkötések a táblához `data`
--
ALTER TABLE `data`
  ADD CONSTRAINT `data_ibfk_1` FOREIGN KEY (`service`) REFERENCES `servicetype` (`id`),
  ADD CONSTRAINT `data_ibfk_2` FOREIGN KEY (`image`) REFERENCES `image` (`id`);

--
-- Megkötések a táblához `image`
--
ALTER TABLE `image`
  ADD CONSTRAINT `image_imagemetadata_id_fk` FOREIGN KEY (`image_metadata`) REFERENCES `imagemetadata` (`id`);

--
-- Megkötések a táblához `servicetype`
--
ALTER TABLE `servicetype`
  ADD CONSTRAINT `servicetype_ibfk_1` FOREIGN KEY (`building`) REFERENCES `building` (`id`),
  ADD CONSTRAINT `servicetype_ibfk_2` FOREIGN KEY (`building`) REFERENCES `building` (`id`),
  ADD CONSTRAINT `servicetype_ibfk_3` FOREIGN KEY (`service`) REFERENCES `services` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;