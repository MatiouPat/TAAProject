-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : db
-- Généré le : ven. 05 nov. 2021 à 13:50
-- Version du serveur : 8.0.26
-- Version de PHP : 7.4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `taabdd`
--
CREATE DATABASE IF NOT EXISTS `taabdd` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `taabdd`;

-- --------------------------------------------------------

--
-- Structure de la table `professional_appointments`
--

DROP TABLE IF EXISTS `professional_appointments`;
CREATE TABLE IF NOT EXISTS `professional_appointments` (
  `professional_id` bigint NOT NULL,
  `appointments_id` bigint NOT NULL,
  UNIQUE KEY `UK_n9wewd6sh6hfgu6hnv6y56pr7` (`appointments_id`),
  KEY `FK1kqosb9ta6vuegwi6mf47d7ek` (`professional_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------


--
-- Structure de la table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
CREATE TABLE IF NOT EXISTS `appointment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `duration` int NOT NULL,
  `libre` bit(1) NOT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `agenda_id` bigint DEFAULT NULL,
  `professionnal_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhulxmy8gvgya4j63rl7hsm23b` (`agenda_id`),
  KEY `FK2cjvpsakicl79jxsx37kbcgfy` (`professionnal_id`),
  KEY `FKa8m1smlfsc8kkjn2t6wpdmysk` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `professional`
--

DROP TABLE IF EXISTS `professional`;
CREATE TABLE IF NOT EXISTS `professional` (
  `job` varchar(255) DEFAULT NULL,
  `id` bigint NOT NULL,
  `account_id` bigint DEFAULT NULL,
  `agenda_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrmhffy3toilmeli8ejsqartco` (`account_id`),
  KEY `FKmhsjdnp2vudd6pi8xwi4cqy2g` (`agenda_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `professional`
--

INSERT INTO `professional` (`job`, `id`, `account_id`, `agenda_id`) VALUES
('Professeur', 1, 1, 1),
('Responsable de formation', 4, 2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `account`
--

DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `account`
--

INSERT INTO `account` (`id`, `login`, `password`) VALUES
(1, 'obarais', 'azerty'),
(2, 'mchristie', 'azerty');

-- --------------------------------------------------------

--
-- Structure de la table `agenda`
--

DROP TABLE IF EXISTS `agenda`;
CREATE TABLE IF NOT EXISTS `agenda` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `agenda`
--

INSERT INTO `agenda` (`id`, `url`) VALUES
(1, 'https://agende_de_barais.fr'),
(2, 'https://agenda_de_christie.fr');

-- --------------------------------------------------------

--
-- Structure de la table `agenda_appointments`
--

DROP TABLE IF EXISTS `agenda_appointments`;
CREATE TABLE IF NOT EXISTS `agenda_appointments` (
  `agenda_id` bigint NOT NULL,
  `appointments_id` bigint NOT NULL,
  UNIQUE KEY `UK_r01ng21itp5vquixibdihxrp7` (`appointments_id`),
  KEY `FKpbc1pem9vdbfgwshdqedyi8no` (`agenda_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------


--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `firstname`, `lastname`) VALUES
(1, 'Olivier', 'Barais'),
(2, 'Guillaume', 'Subra'),
(3, 'Matthieu', 'Pays'),
(4, 'Marc', 'Christie');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `agenda_appointments`
--
ALTER TABLE `agenda_appointments`
  ADD CONSTRAINT `FKpbc1pem9vdbfgwshdqedyi8no` FOREIGN KEY (`agenda_id`) REFERENCES `agenda` (`id`),
  ADD CONSTRAINT `FKsncnv635rorkq39tnl6vmsgv3` FOREIGN KEY (`appointments_id`) REFERENCES `appointment` (`id`);

--
-- Contraintes pour la table `appointment`
--
ALTER TABLE `appointment`
  ADD CONSTRAINT `FK2cjvpsakicl79jxsx37kbcgfy` FOREIGN KEY (`professionnal_id`) REFERENCES `professional` (`id`),
  ADD CONSTRAINT `FKa8m1smlfsc8kkjn2t6wpdmysk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKhulxmy8gvgya4j63rl7hsm23b` FOREIGN KEY (`agenda_id`) REFERENCES `agenda` (`id`);

--
-- Contraintes pour la table `professional`
--
ALTER TABLE `professional`
  ADD CONSTRAINT `FKmhsjdnp2vudd6pi8xwi4cqy2g` FOREIGN KEY (`agenda_id`) REFERENCES `agenda` (`id`),
  ADD CONSTRAINT `FKr0796vkyxbx0w2px6c4jmn9oq` FOREIGN KEY (`id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKrmhffy3toilmeli8ejsqartco` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`);

--
-- Contraintes pour la table `professional_appointments`
--
ALTER TABLE `professional_appointments`
  ADD CONSTRAINT `FK1kqosb9ta6vuegwi6mf47d7ek` FOREIGN KEY (`professional_id`) REFERENCES `professional` (`id`),
  ADD CONSTRAINT `FKra9934i57pot1nisr5s03ko1v` FOREIGN KEY (`appointments_id`) REFERENCES `appointment` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
