-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 24, 2023 at 04:54 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sach`
--

-- --------------------------------------------------------

--
-- Table structure for table `sach`
--

CREATE TABLE `sach` (
  `MaSoSach` varchar(20) NOT NULL,
  `TenSach` text NOT NULL,
  `TacGia` text NOT NULL,
  `NamXuatBan` int(11) NOT NULL,
  `NhaXuatBan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sach`
--

INSERT INTO `sach` (`MaSoSach`, `TenSach`, `TacGia`, `NamXuatBan`, `NhaXuatBan`) VALUES
('DTC1', 'Tôi là ai?', 'Nguyễn Vũ Hải', 2001, 'Xuân Đồng'),
('DTC1', 'Tôi là ai?', 'Nguyễn Vũ Hải', 2001, 'Xuân Đồng'),
('DTC2', 'Hello boi', 'Ninh', 2003, 'Halo'),
('DTC2', 'Hello boi', 'Ninh', 2003, 'Halo');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
