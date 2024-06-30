-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema DHAlmundo
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema DHAlmundo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DHAlmundo` DEFAULT CHARACTER SET utf8 ;
USE `DHAlmundo` ;

-- -----------------------------------------------------
-- Table `DHAlmundo`.`paises`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHAlmundo`.`paises` (
  `idpais` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NULL,
  PRIMARY KEY (`idpais`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHAlmundo`.`sucursales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHAlmundo`.`sucursales` (
  `idSucursal` INT NOT NULL AUTO_INCREMENT,
  `direccion` VARCHAR(45) NULL,
  `ciudad` VARCHAR(45) NULL,
  `telefono` VARCHAR(25) NULL,
  `idPais` INT NULL,
  PRIMARY KEY (`idSucursal`),
  INDEX `FK_sucursales_paises_idx` (`idPais` ASC) VISIBLE,
  CONSTRAINT `FK_sucursales_paises`
    FOREIGN KEY (`idPais`)
    REFERENCES `DHAlmundo`.`paises` (`idpais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHAlmundo`.`hoteles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHAlmundo`.`hoteles` (
  `idhotel` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `ciudad` VARCHAR(45) NULL,
  `telefono` VARCHAR(25) NULL,
  `cantidadHabitaciones` INT NULL,
  `idPais` INT NULL,
  PRIMARY KEY (`idhotel`),
  INDEX `FK_hoteles_paises_idx` (`idPais` ASC) VISIBLE,
  CONSTRAINT `FK_hoteles_paises`
    FOREIGN KEY (`idPais`)
    REFERENCES `DHAlmundo`.`paises` (`idpais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHAlmundo`.`vuelos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHAlmundo`.`vuelos` (
  `idvuelo` INT NOT NULL AUTO_INCREMENT,
  `nroVuelo` VARCHAR(6) NULL,
  `fechaPartida` DATETIME NULL,
  `fechaLlegada` DATETIME NULL,
  `origen` VARCHAR(100) NULL,
  `destino` VARCHAR(100) NULL,
  `cantidadTurista` INT NULL,
  `cantidadPrimeraClase` INT NULL,
  PRIMARY KEY (`idvuelo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHAlmundo`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHAlmundo`.`clientes` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(45) NULL,
  `apellidos` VARCHAR(45) NULL,
  `numeroPasaporte` VARCHAR(11) NULL,
  `direccion` VARCHAR(45) NULL,
  `ciudad` VARCHAR(45) NULL,
  `telefono` VARCHAR(25) NULL,
  `idPais` INT NULL,
  PRIMARY KEY (`idcliente`),
  INDEX `FK_clientes_paises_idx` (`idPais` ASC) VISIBLE,
  CONSTRAINT `FK_clientes_paises`
    FOREIGN KEY (`idPais`)
    REFERENCES `DHAlmundo`.`paises` (`idpais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHAlmundo`.`metodospago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHAlmundo`.`metodospago` (
  `idmetodospago` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`idmetodospago`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHAlmundo`.`pagos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHAlmundo`.`pagos` (
  `idpago` INT NOT NULL AUTO_INCREMENT,
  `precioTotal` DOUBLE NULL,
  `cantidadCuotas` INT NULL,
  `idMetodosPago` INT NULL,
  PRIMARY KEY (`idpago`),
  INDEX `FK_pagos_metodospago_idx` (`idMetodosPago` ASC) VISIBLE,
  CONSTRAINT `FK_pagos_metodospago`
    FOREIGN KEY (`idMetodosPago`)
    REFERENCES `DHAlmundo`.`metodospago` (`idmetodospago`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHAlmundo`.`reservas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHAlmundo`.`reservas` (
  `idreserva` INT NOT NULL AUTO_INCREMENT,
  `codigoReserva` VARCHAR(6) NULL,
  `fechaRegistro` DATETIME NULL,
  `idCliente` INT NULL,
  `idSucursal` INT NULL,
  `idPago` INT NULL,
  PRIMARY KEY (`idreserva`),
  INDEX `FK_reservas_clientes_idx` (`idCliente` ASC) VISIBLE,
  INDEX `FK_reservas_sucursales_idx` (`idSucursal` ASC) VISIBLE,
  INDEX `FK_reservas_pagos_idx` (`idPago` ASC) VISIBLE,
  CONSTRAINT `FK_reservas_clientes`
    FOREIGN KEY (`idCliente`)
    REFERENCES `DHAlmundo`.`clientes` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_reservas_sucursales`
    FOREIGN KEY (`idSucursal`)
    REFERENCES `DHAlmundo`.`sucursales` (`idSucursal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_reservas_pagos`
    FOREIGN KEY (`idPago`)
    REFERENCES `DHAlmundo`.`pagos` (`idpago`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHAlmundo`.`categoriasvuelos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHAlmundo`.`categoriasvuelos` (
  `idcategoriasvuelos` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`idcategoriasvuelos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHAlmundo`.`vuelosxreserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHAlmundo`.`vuelosxreserva` (
  `idvuelosxreserva` INT NOT NULL AUTO_INCREMENT,
  `idVuelo` INT NULL,
  `idReserva` INT NULL,
  `idCategoriasVuelos` INT NULL,
  PRIMARY KEY (`idvuelosxreserva`),
  INDEX `FK_vuelosxreserva_reservas_idx` (`idReserva` ASC) VISIBLE,
  INDEX `FK_vuelosxreserva_vuelos_idx` (`idVuelo` ASC) VISIBLE,
  INDEX `FK_vuelosxreserva_categoriasvuelos_idx` (`idCategoriasVuelos` ASC) VISIBLE,
  CONSTRAINT `FK_vuelosxreserva_reservas`
    FOREIGN KEY (`idReserva`)
    REFERENCES `DHAlmundo`.`reservas` (`idreserva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_vuelosxreserva_vuelos`
    FOREIGN KEY (`idVuelo`)
    REFERENCES `DHAlmundo`.`vuelos` (`idvuelo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_vuelosxreserva_categoriasvuelos`
    FOREIGN KEY (`idCategoriasVuelos`)
    REFERENCES `DHAlmundo`.`categoriasvuelos` (`idcategoriasvuelos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHAlmundo`.`tiposhospedaje`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHAlmundo`.`tiposhospedaje` (
  `idtiposhospedaje` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`idtiposhospedaje`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHAlmundo`.`hotelesxreserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHAlmundo`.`hotelesxreserva` (
  `idhotelesxreserva` INT NOT NULL AUTO_INCREMENT,
  `checkin` DATETIME NULL,
  `checkout` DATETIME NULL,
  `idHotel` INT NULL,
  `idReserva` INT NULL,
  `idTiposHospedaje` INT NULL,
  PRIMARY KEY (`idhotelesxreserva`),
  INDEX `FK_hotelesxreserva_reservas_idx` (`idReserva` ASC) VISIBLE,
  INDEX `FK_hotelesxreserva_hoteles_idx` (`idHotel` ASC) VISIBLE,
  INDEX `FK_hotelesxreserva_tiposhospedaje_idx` (`idTiposHospedaje` ASC) VISIBLE,
  CONSTRAINT `FK_hotelesxreserva_reservas`
    FOREIGN KEY (`idReserva`)
    REFERENCES `DHAlmundo`.`reservas` (`idreserva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_hotelesxreserva_hoteles`
    FOREIGN KEY (`idHotel`)
    REFERENCES `DHAlmundo`.`hoteles` (`idhotel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_hotelesxreserva_tiposhospedaje`
    FOREIGN KEY (`idTiposHospedaje`)
    REFERENCES `DHAlmundo`.`tiposhospedaje` (`idtiposhospedaje`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
