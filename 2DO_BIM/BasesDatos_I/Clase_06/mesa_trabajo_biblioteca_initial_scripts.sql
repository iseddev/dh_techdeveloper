-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema practica_clase_05S
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema practica_clase_05S
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `practica_clase_05S` DEFAULT CHARACTER SET utf8 ;
USE `practica_clase_05S` ;

-- -----------------------------------------------------
-- Table `practica_clase_05S`.`autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica_clase_05S`.`autor` (
  `id_autor` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_autor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practica_clase_05S`.`editorial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica_clase_05S`.`editorial` (
  `id_editorial` INT NOT NULL AUTO_INCREMENT,
  `razon_social` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id_editorial`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practica_clase_05S`.`libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica_clase_05S`.`libro` (
  `id_libro` INT NOT NULL AUTO_INCREMENT,
  `codigo_interno` VARCHAR(45) NOT NULL,
  `isbn` VARCHAR(45) NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `año_escrito` INT NOT NULL,
  `autor` VARCHAR(100) NOT NULL,
  `año_edicion` INT NOT NULL,
  `editorial` VARCHAR(50) NOT NULL,
  `autor_id_autor` INT NOT NULL,
  `editorial_id_editorial` INT NOT NULL,
  PRIMARY KEY (`id_libro`),
  INDEX `fk_libro_autor_idx` (`autor_id_autor` ASC) VISIBLE,
  INDEX `fk_libro_editorial1_idx` (`editorial_id_editorial` ASC) VISIBLE,
  CONSTRAINT `fk_libro_autor`
    FOREIGN KEY (`autor_id_autor`)
    REFERENCES `practica_clase_05S`.`autor` (`id_autor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_libro_editorial1`
    FOREIGN KEY (`editorial_id_editorial`)
    REFERENCES `practica_clase_05S`.`editorial` (`id_editorial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practica_clase_05S`.`socio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica_clase_05S`.`socio` (
  `id_socio` INT NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(100) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apelidos` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_socio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practica_clase_05S`.`telefono`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica_clase_05S`.`telefono` (
  `id_telefono` INT NOT NULL AUTO_INCREMENT,
  `socio_id_socio` INT NOT NULL,
  PRIMARY KEY (`id_telefono`),
  INDEX `fk_telefono_socio1_idx` (`socio_id_socio` ASC) VISIBLE,
  CONSTRAINT `fk_telefono_socio1`
    FOREIGN KEY (`socio_id_socio`)
    REFERENCES `practica_clase_05S`.`socio` (`id_socio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practica_clase_05S`.`copia_libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica_clase_05S`.`copia_libro` (
  `idcopia_libro` INT NOT NULL AUTO_INCREMENT,
  `deteriorada` TINYINT NOT NULL,
  `libro_id_libro` INT NOT NULL,
  PRIMARY KEY (`idcopia_libro`),
  INDEX `fk_copia_libro_libro1_idx` (`libro_id_libro` ASC) VISIBLE,
  CONSTRAINT `fk_copia_libro_libro1`
    FOREIGN KEY (`libro_id_libro`)
    REFERENCES `practica_clase_05S`.`libro` (`id_libro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practica_clase_05S`.`prestamo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica_clase_05S`.`prestamo` (
  `id_prestamo` INT NOT NULL AUTO_INCREMENT,
  `fecha_inicio` DATE NOT NULL,
  `fecha_limite` DATE NOT NULL,
  `fecha_entrega` DATE NOT NULL,
  `socio_id_socio` INT NOT NULL,
  PRIMARY KEY (`id_prestamo`),
  INDEX `fk_prestamo_socio1_idx` (`socio_id_socio` ASC) VISIBLE,
  CONSTRAINT `fk_prestamo_socio1`
    FOREIGN KEY (`socio_id_socio`)
    REFERENCES `practica_clase_05S`.`socio` (`id_socio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practica_clase_05S`.`copia_prestamo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `practica_clase_05S`.`copia_prestamo` (
  `id_copia_prestamo` INT NOT NULL AUTO_INCREMENT,
  `copia_libro_idcopia_libro` INT NOT NULL,
  `prestamo_id_prestamo` INT NOT NULL,
  INDEX `fk_copia_libro_has_prestamo_prestamo1_idx` (`prestamo_id_prestamo` ASC) VISIBLE,
  INDEX `fk_copia_libro_has_prestamo_copia_libro1_idx` (`copia_libro_idcopia_libro` ASC) VISIBLE,
  PRIMARY KEY (`id_copia_prestamo`),
  CONSTRAINT `fk_copia_libro_has_prestamo_copia_libro1`
    FOREIGN KEY (`copia_libro_idcopia_libro`)
    REFERENCES `practica_clase_05S`.`copia_libro` (`idcopia_libro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_copia_libro_has_prestamo_prestamo1`
    FOREIGN KEY (`prestamo_id_prestamo`)
    REFERENCES `practica_clase_05S`.`prestamo` (`id_prestamo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
