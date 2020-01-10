-- 1. Design the schema for movie cruiser in MySQL Workbench
-- 2. Generate the SQL schema script in MySQL Workbench
-- 3. Paste the generated the SQL code here

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- --------------------------------------------------------------
-- Schema moviecruiser
-- --------------------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `movie_cruiser` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `movie_cruiser` ;

-- -----------------------------------------------------
-- Table `movie_cruiser`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_cruiser`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(60) NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `movie_cruiser`.`movie_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_cruiser`.`movie_item` (
  `mv_id` INT NOT NULL AUTO_INCREMENT,
  `mv_title` VARCHAR(100) NULL,
  `mv_box` DECIMAL(12,2) NULL,
  `mv_active` VARCHAR(3) NULL,
  `mv_date_of_launch` DATE NULL,
  `mv_genre` VARCHAR(45) NULL,
  `mv_teaser` VARCHAR(3) NULL,
  PRIMARY KEY (`mv_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `movie_cruiser`.`favorite`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_cruiser`.`favorite` (
  `fv_id` INT NOT NULL AUTO_INCREMENT,
  `fv_user_id` INT NULL,
  `fv_mv_id` INT NULL,
  PRIMARY KEY (`fv_id`),
  INDEX `fv_user_fk_idx` (`fv_user_id` ASC),
  INDEX `fv_mv_fk_idx` (`fv_mv_id` ASC),
  CONSTRAINT `fv_user_fk`
    FOREIGN KEY (`fv_user_id`)
    REFERENCES `movie_cruiser`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fv_mv_fk`
    FOREIGN KEY (`fv_mv_id`)
    REFERENCES `movie_cruiser`.`movie_item` (`mv_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;