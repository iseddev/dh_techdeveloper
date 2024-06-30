USE practica_clase_05S;

INSERT INTO autor VALUES (default, "Gabriel");

INSERT INTO editorial VALUES(default, "Trillas Editorial SA de CV", "5595175325"),
(default, "Univeso Libros Editorial SA", "5515935752"),
(default, "DH Editorial SA", "5574185296");

SELECT * FROM autor;

SELECT * FROM editorial;

INSERT INTO autor VALUES (default, "Octavio");
INSERT INTO autor VALUES (default, "Pablo");

UPDATE autor SET nombre = "Miguel" WHERE id_autor = 3;

UPDATE editorial SET telefono = "5596385274" WHERE id_editorial = 2;

DELETE FROM editorial WHERE id_editorial = 2;
SELECT * FROM editorial;

DELETE FROM autor WHERE id_autor = 3;
SELECT * FROM autor;