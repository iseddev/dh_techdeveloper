-- Seleccionar BD
USE dh_salud;

-- Ver datos
SELECT * FROM especialidad;

-- Insertar datos (Comenzar con las tablas que no tienen claves foraneas)
INSERT INTO	especialidad(idespecialidad, detalle)
VALUES(1, "Clinica Médica");

INSERT INTO especialidad
VALUES(default, "Neuro Cirugía"),
(default, "Dermatología"),
(default, "Ginecología");

-- Insertar datos a la tabla médico
SELECT * FROM medico;
INSERT INTO medico VALUES(1, "a1b2c", "Sarahí", "Navarrete", 1);
INSERT INTO medico VALUES(default, 91827, "Mateo", "Moreno", 2);
INSERT INTO medico VALUES(default, 95135, "Israel", "Porfirio", 4);

-- Actualizar datos
UPDATE medico SET matricula = 19283 WHERE idmedico = 1;

-- Eliminar registros (datos)
DELETE FROM medico WHERE idmedico = 3;

INSERT INTO medico VALUES(default, 95135, "Israel", "Porfirio", 4);