SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `orders` (
                          `id` int(11) NOT NULL,
                          `username` text NOT NULL,
                          `price` double NOT NULL,
                          `isdone` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `pizzas` (
                          `name` varchar(15) NOT NULL,
                          `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `pizza_order` (
                               `order_id` int(11) NOT NULL,
                               `pizzaName` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `tokens` (
                          `token` int(11) NOT NULL,
                          `username` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `users` (
                         `username` varchar(15) NOT NULL,
                         `password` varchar(15) NOT NULL,
                         `isAdmin` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
