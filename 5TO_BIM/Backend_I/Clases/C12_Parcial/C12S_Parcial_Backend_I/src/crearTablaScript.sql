--Se envia el modo general para no alterar nuestro desarrollo en los otros paquetes.
DELIMITER $$
CREATE PROCEDURE CreateTable(
    IN tableName VARCHAR(255),
    IN setColumns TEXT
)
BEGIN
    SET @sql = CONCAT('CREATE TABLE ', tableName, ' (', setColumns, ')');
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END$$

DELIMITER ;