-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 29 Ağu 2022, 12:01:22
-- Sunucu sürümü: 10.4.24-MariaDB
-- PHP Sürümü: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `veterinarian`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `animal`
--

CREATE TABLE `animal` (
  `aid` int(11) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `definition` varchar(255) DEFAULT NULL,
  `genus` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `species` varchar(255) DEFAULT NULL,
  `pet_owner_pid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `animal`
--

INSERT INTO `animal` (`aid`, `age`, `definition`, `genus`, `name`, `species`, `pet_owner_pid`) VALUES
(2, 2, 'Orange', 'Uraeginthus granatina', 'Hillie', 'Grenadier, purple', 2);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `pet_owner`
--

CREATE TABLE `pet_owner` (
  `pid` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `pet_owner`
--

INSERT INTO `pet_owner` (`pid`, `email`, `name`, `phone`, `surname`) VALUES
(2, 'vlufkin11@cloudflare.com', 'Valentina', '786-974-4366', 'Lufkin');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `animal`
--
ALTER TABLE `animal`
  ADD PRIMARY KEY (`aid`),
  ADD KEY `FKchyv17gg05np1agca9xbyw0tb` (`pet_owner_pid`);

--
-- Tablo için indeksler `pet_owner`
--
ALTER TABLE `pet_owner`
  ADD PRIMARY KEY (`pid`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `animal`
--
ALTER TABLE `animal`
  MODIFY `aid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `pet_owner`
--
ALTER TABLE `pet_owner`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `animal`
--
ALTER TABLE `animal`
  ADD CONSTRAINT `FKchyv17gg05np1agca9xbyw0tb` FOREIGN KEY (`pet_owner_pid`) REFERENCES `pet_owner` (`pid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
