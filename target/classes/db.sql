-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema news_portal
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema news_portal
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `news_portal` DEFAULT CHARACTER SET utf8 ;
USE `news_portal` ;

-- -----------------------------------------------------
-- Table `news_portal`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `news_portal`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `role` VARCHAR(20) NOT NULL,
  `dateOfRegistration` DATE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `news_portal`.`news`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `news_portal`.`news` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(150) NOT NULL,
  `briefDescription` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
