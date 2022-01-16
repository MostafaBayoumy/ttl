--------------------------------------------------------
-- create user `ttl` with password `ttl`
--------------------------------------------------------
CREATE USER 'ttl'@'localhost' IDENTIFIED BY 'ttl';
GRANT ALL PRIVILEGES ON * . * TO 'ttl'@'localhost';
FLUSH PRIVILEGES;

-- -----------------------------------------------------
-- Schema ttldb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ttldb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema ttldb
-- -----------------------------------------------------
USE `ttldb` ;

-- -----------------------------------------------------
-- Table `ttldb`.`participants`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ttldb`.`participants` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
  ENGINE = InnoDB
  AUTO_INCREMENT = 19
  DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ttldb`.`leagues`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ttldb`.`leagues` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `champion_id` INT(10) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_leagues_participants1_idx` (`champion_id` ASC),
  CONSTRAINT `fk_leagues_participants1`
  FOREIGN KEY (`champion_id`)
  REFERENCES `ttldb`.`participants` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION)
  ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ttldb`.`leagues_participants`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ttldb`.`leagues_participants` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `participant_id` INT(10) UNSIGNED NOT NULL,
  `league_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `league_participant_un` (`participant_id` ASC, `league_id` ASC),
  INDEX `fk_participants_has_leagues_leagues1_idx` (`league_id` ASC),
  INDEX `fk_participants_has_leagues_participants1_idx` (`participant_id` ASC),
  CONSTRAINT `fk_participants_has_leagues_participants1`
  FOREIGN KEY (`participant_id`)
  REFERENCES `ttldb`.`participants` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT `fk_participants_has_leagues_leagues1`
  FOREIGN KEY (`league_id`)
  REFERENCES `ttldb`.`leagues` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION)
  ENGINE = InnoDB
  AUTO_INCREMENT = 24
  DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `ttldb`.`matches`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ttldb`.`matches` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_participant_id` INT(10) UNSIGNED NOT NULL,
  `second_participant_id` INT(10) UNSIGNED NULL DEFAULT NULL,
  `round_no` TINYINT(4) NOT NULL,
  `winner_id` INT(10) UNSIGNED NULL DEFAULT NULL,
  `result` VARCHAR(10) NULL DEFAULT NULL,
  `match_date` DATE NOT NULL,
  `league_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_matches_participants1_idx` (`first_participant_id` ASC),
  INDEX `fk_matches_participants2_idx` (`second_participant_id` ASC),
  INDEX `fk_matches_participants3_idx` (`winner_id` ASC),
  INDEX `fk_matches_leagues1_idx` (`league_id` ASC),
  CONSTRAINT `fk_matches_participants1`
  FOREIGN KEY (`first_participant_id`)
  REFERENCES `ttldb`.`participants` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT `fk_matches_participants2`
  FOREIGN KEY (`second_participant_id`)
  REFERENCES `ttldb`.`participants` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT `fk_matches_participants3`
  FOREIGN KEY (`winner_id`)
  REFERENCES `ttldb`.`participants` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
  CONSTRAINT `fk_matches_leagues1`
  FOREIGN KEY (`league_id`)
  REFERENCES `ttldb`.`leagues` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION)
  ENGINE = InnoDB
  AUTO_INCREMENT = 60
  DEFAULT CHARACTER SET = latin1;
