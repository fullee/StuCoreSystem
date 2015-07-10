-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2015 年 06 月 06 日 03:49
-- 服务器版本: 5.5.20
-- PHP 版本: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `student`
--

-- --------------------------------------------------------

--
-- 表的结构 `core`
--

CREATE TABLE IF NOT EXISTS `core` (
  `id` bigint(20) unsigned NOT NULL,
  `name` varchar(66) CHARACTER SET latin1 NOT NULL,
  `eng` int(11) NOT NULL,
  `chn` int(11) NOT NULL,
  `math` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=gbk;

--
-- 转存表中的数据 `core`
--

INSERT INTO `core` (`id`, `name`, `eng`, `chn`, `math`) VALUES
(201404140022, '??', 99, 99, 99),
(201404140001, '?', 99, 66, 66);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
