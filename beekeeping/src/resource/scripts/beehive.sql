DROP SCHEMA IF EXISTS `beekeeping` ;

CREATE SCHEMA `beekeeping` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `beekeeping`.`apiary_site` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `created_at` DATE NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(200) NULL DEFAULT NULL,
  `notice` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS `beekeeping`.`beehive` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  `number` SMALLINT(2) NOT NULL,
  `created_at` DATE NOT NULL,
  `description` VARCHAR(200) NULL DEFAULT NULL,
  `queen_color` VARCHAR(45) NOT NULL,
  `honey` SMALLINT(2) NULL DEFAULT NULL,
  `notice` VARCHAR(45) NULL DEFAULT NULL,
  `apiary_site_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_beehive_apiary_site_idx` (`apiary_site_id` ASC),
  CONSTRAINT `fk_beehive_apiary_site`
  FOREIGN KEY (`apiary_site_id`)
  REFERENCES `beekeeping`.`apiary_site` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS `beekeeping`.`chamber` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `created_at` DATE NOT NULL,
  `number` SMALLINT(2) NOT NULL DEFAULT 1,
  `description` VARCHAR(200) NULL DEFAULT NULL,
  `color` VARCHAR(45) NOT NULL,
  `notice` VARCHAR(45) NULL DEFAULT NULL,
  `beehive_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_chamber_beehive1_idx` (`beehive_id` ASC),
  CONSTRAINT `fk_chamber_beehive1`
  FOREIGN KEY (`beehive_id`)
  REFERENCES `beekeeping`.`beehive` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS `beekeeping`.`flora` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(200) NULL DEFAULT NULL,
  `notice` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS `beekeeping`.`frame` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `number` SMALLINT(2) NOT NULL,
  `created_at` DATE NOT NULL,
  `description` VARCHAR(200) NULL DEFAULT NULL,
  `brood` SMALLINT(2) NULL DEFAULT NULL,
  `brood closed` SMALLINT(2) NULL DEFAULT NULL,
  `honey` SMALLINT(2) NULL DEFAULT NULL,
  `honey closed` SMALLINT(2) NULL DEFAULT NULL,
  `pollen` TINYINT(1) NULL DEFAULT NULL,
  `notice` VARCHAR(45) NULL DEFAULT NULL,
  `chamber_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_frame_chamber1_idx` (`chamber_id` ASC),
  CONSTRAINT `fk_frame_chamber1`
  FOREIGN KEY (`chamber_id`)
  REFERENCES `beekeeping`.`chamber` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
  ENGINE = InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS `beekeeping`.`task` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `created_at` DATE NOT NULL,
  `completed` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS `beekeeping`.`weather` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(200) NULL DEFAULT NULL,
  `notice` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

