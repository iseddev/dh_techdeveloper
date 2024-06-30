-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema dh_salud
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dh_salud
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dh_salud` ;
USE `dh_salud` ;

-- -----------------------------------------------------
-- Table `dh_salud`.`paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dh_salud`.`paciente` (
  `num_socio` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`num_socio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dh_salud`.`especialidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dh_salud`.`especialidad` (
  `idespecialidad` INT NOT NULL AUTO_INCREMENT,
  `detalle` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idespecialidad`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dh_salud`.`medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dh_salud`.`medico` (
  `idmedico` INT NOT NULL AUTO_INCREMENT,
  `matricula` CHAR(5) NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `especialidad_idespecialidad` INT NOT NULL,
  PRIMARY KEY (`idmedico`),
  INDEX `fk_medico_especialidad1_idx` (`especialidad_idespecialidad` ASC) VISIBLE,
  CONSTRAINT `fk_medico_especialidad1`
    FOREIGN KEY (`especialidad_idespecialidad`)
    REFERENCES `dh_salud`.`especialidad` (`idespecialidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dh_salud`.`turno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dh_salud`.`turno` (
  `idturno` INT NOT NULL AUTO_INCREMENT,
  `fecha_hora` DATETIME NULL,
  `consultorio` CHAR(4) NULL,
  `idmedico` VARCHAR(45) NULL,
  `paciente_num_socio` INT NOT NULL,
  `medico_idmedico` INT NOT NULL,
  PRIMARY KEY (`idturno`),
  INDEX `fk_turno_paciente_idx` (`paciente_num_socio` ASC) VISIBLE,
  INDEX `fk_turno_medico1_idx` (`medico_idmedico` ASC) VISIBLE,
  CONSTRAINT `fk_turno_paciente`
    FOREIGN KEY (`paciente_num_socio`)
    REFERENCES `dh_salud`.`paciente` (`num_socio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_turno_medico1`
    FOREIGN KEY (`medico_idmedico`)
    REFERENCES `dh_salud`.`medico` (`idmedico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
