-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-11-2022 a las 17:31:35
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `razonesfinancierasdb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `accounts`
--

CREATE TABLE `accounts` (
  `id_account` int(11) NOT NULL,
  `id_finance_state` int(11) NOT NULL,
  `id_file` int(11) NOT NULL,
  `amount` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `accounts`
--

INSERT INTO `accounts` (`id_account`, `id_finance_state`, `id_file`, `amount`) VALUES
(51, 1, 39, 10000),
(52, 2, 39, 20000),
(53, 3, 39, 40000),
(54, 4, 39, 20000),
(55, 5, 39, 40000),
(56, 16, 39, 60000),
(57, 17, 39, 10000),
(58, 7, 39, 18000),
(59, 8, 39, 30000),
(60, 18, 39, 12000),
(61, 19, 39, 100000),
(62, 20, 39, 40000),
(63, 21, 41, 5253000),
(64, 22, 41, 3551000),
(65, 23, 41, 128000),
(66, 24, 41, 212400),
(67, 25, 41, 47000),
(68, 26, 41, 253000),
(69, 27, 41, 98000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `accounts_finance_state`
--

CREATE TABLE `accounts_finance_state` (
  `id_finance_state` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `subtype` varchar(100) DEFAULT NULL,
  `finance_state` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `accounts_finance_state`
--

INSERT INTO `accounts_finance_state` (`id_finance_state`, `name`, `type`, `subtype`, `finance_state`) VALUES
(1, 'Caja', 'activo', 'Circulante', 'BG'),
(2, 'Bancos', 'activo', 'Circulante', 'BG'),
(3, 'Inversiones', 'activo', 'Circulante', 'BG'),
(4, 'Clientes', 'activo', 'Circulante', 'BG'),
(5, 'Inventarios', 'activo', 'Circulante', 'BG'),
(6, 'Edificio', 'activo', 'No Circulante', 'BG'),
(7, 'Proveedores', 'pasivo', 'Circulante', 'BG'),
(8, 'Cuentas por pagar', 'pasivo', 'Circulante', 'BG'),
(9, 'Capital', 'capital', NULL, 'BG'),
(10, 'Maquinaria', 'activo', 'No Circulante', 'BG'),
(11, 'Mobiliario', 'activo', 'No Circulante', 'BG'),
(13, 'Deudores varios', 'activo', 'Circulante', 'BG'),
(14, 'Cuentas por cobrar', 'activo', 'Circulante', 'BG'),
(15, 'Inventario', 'activo', 'Circulante', 'BG'),
(16, 'Activo Fijo', 'activo', 'No Circulante', 'BG'),
(17, 'Activo Diferido', 'activo', 'No Circulante', 'BG'),
(18, 'Obligaciones Financieras', 'pasivo', 'No Circulante', 'BG'),
(19, 'Aportes Sociales', 'capital', '', 'BG'),
(20, 'Utilidad del ejercicio', 'capital', '', 'BG'),
(21, 'Ingresos por ventas', 'Ingresos', '', 'ER'),
(22, 'Costos de venta', 'Costos', '', 'ER'),
(23, 'Gastos de venta', 'Gastos', '', 'ER'),
(24, 'Gastos generales y administrativos', 'Gastos', '', 'ER'),
(25, 'Gastos de arrendamiento', 'Gastos', '', 'ER'),
(26, 'Gastos de depreción', 'Gastos', '', 'ER'),
(27, 'Gastos por intereses', 'Gastos No Operacionales', '', 'ER');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `files`
--

CREATE TABLE `files` (
  `id_file` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `id_user` int(11) NOT NULL,
  `date_file` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `files`
--

INSERT INTO `files` (`id_file`, `name`, `id_user`, `date_file`) VALUES
(39, 'BG_DelisiasSA_2014', 1, '2022-11-03 13:36:12'),
(41, 'ER_DelisiasSA_2014', 1, '2022-11-10 06:48:50'),
(61, 'RF_DelisiasSA_2014', 1, '2022-11-11 19:00:47');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `file_detail`
--

CREATE TABLE `file_detail` (
  `id_file_detail` int(11) NOT NULL,
  `id_file` int(11) NOT NULL,
  `empresa` varchar(100) NOT NULL,
  `periodo` varchar(50) NOT NULL,
  `dividendos` float DEFAULT NULL,
  `ir` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `file_detail`
--

INSERT INTO `file_detail` (`id_file_detail`, `id_file`, `empresa`, `periodo`, `dividendos`, `ir`) VALUES
(3, 39, 'Delisias S.A', 'Año 2014', 0, 0),
(4, 41, 'Delisias S.A', 'Año 2014', 20000, 30);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rfanalisis`
--

CREATE TABLE `rfanalisis` (
  `id_rf` int(11) NOT NULL,
  `id_file` int(11) NOT NULL,
  `analisisL` varchar(500) NOT NULL,
  `analisisR` varchar(500) NOT NULL,
  `analisisE` varchar(500) NOT NULL,
  `InventarioI` float NOT NULL,
  `ventasCred` int(11) NOT NULL,
  `CuentPorCobI` float NOT NULL,
  `CompCred` int(11) NOT NULL,
  `CuentPorPagI` float NOT NULL,
  `BG` text NOT NULL,
  `ER` text NOT NULL,
  `empresa` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `rfanalisis`
--

INSERT INTO `rfanalisis` (`id_rf`, `id_file`, `analisisL`, `analisisR`, `analisisE`, `InventarioI`, `ventasCred`, `CuentPorCobI`, `CompCred`, `CuentPorPagI`, `BG`, `ER`, `empresa`) VALUES
(3, 61, 'analisis', 'analisis', 'analisis', 10000, 5, 10000, 2, 10000, 'BG_DelisiasSA_2014', 'ER_DelisiasSA_2014', 'Delisias S.A');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL,
  `fullname` varchar(200) NOT NULL,
  `username` varchar(100) NOT NULL,
  `pass` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id_user`, `fullname`, `username`, `pass`) VALUES
(1, 'administrador', 'admin', 'admin123'),
(2, 'Scarleth', 'Scar01', 'scar123');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`id_account`),
  ADD KEY `id_finance_state` (`id_finance_state`),
  ADD KEY `id_file` (`id_file`);

--
-- Indices de la tabla `accounts_finance_state`
--
ALTER TABLE `accounts_finance_state`
  ADD PRIMARY KEY (`id_finance_state`);

--
-- Indices de la tabla `files`
--
ALTER TABLE `files`
  ADD PRIMARY KEY (`id_file`),
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `id_user` (`id_user`);

--
-- Indices de la tabla `file_detail`
--
ALTER TABLE `file_detail`
  ADD PRIMARY KEY (`id_file_detail`),
  ADD KEY `id_file` (`id_file`);

--
-- Indices de la tabla `rfanalisis`
--
ALTER TABLE `rfanalisis`
  ADD PRIMARY KEY (`id_rf`),
  ADD KEY `id_file` (`id_file`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `accounts`
--
ALTER TABLE `accounts`
  MODIFY `id_account` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT de la tabla `accounts_finance_state`
--
ALTER TABLE `accounts_finance_state`
  MODIFY `id_finance_state` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `files`
--
ALTER TABLE `files`
  MODIFY `id_file` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

--
-- AUTO_INCREMENT de la tabla `file_detail`
--
ALTER TABLE `file_detail`
  MODIFY `id_file_detail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `rfanalisis`
--
ALTER TABLE `rfanalisis`
  MODIFY `id_rf` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `accounts`
--
ALTER TABLE `accounts`
  ADD CONSTRAINT `accounts_ibfk_1` FOREIGN KEY (`id_finance_state`) REFERENCES `accounts_finance_state` (`id_finance_state`),
  ADD CONSTRAINT `accounts_ibfk_2` FOREIGN KEY (`id_file`) REFERENCES `files` (`id_file`);

--
-- Filtros para la tabla `files`
--
ALTER TABLE `files`
  ADD CONSTRAINT `files_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`);

--
-- Filtros para la tabla `file_detail`
--
ALTER TABLE `file_detail`
  ADD CONSTRAINT `file_detail_ibfk_1` FOREIGN KEY (`id_file`) REFERENCES `files` (`id_file`);

--
-- Filtros para la tabla `rfanalisis`
--
ALTER TABLE `rfanalisis`
  ADD CONSTRAINT `rfanalisis_ibfk_1` FOREIGN KEY (`id_file`) REFERENCES `files` (`id_file`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
