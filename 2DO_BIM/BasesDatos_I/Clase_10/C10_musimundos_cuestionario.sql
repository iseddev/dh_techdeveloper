USE musimundos;

-- ¿Qué consulta debemos hacer para mostrar todos los registros de la tabla “autor”,
-- incluso aquellos que no tienen un libro asignado dentro de nuestra BD?
SELECT * FROM libro l -- Seleccionamos todo de la tabla libro
RIGHT JOIN libro_x_autor lxa ON lxa.libro_id = l.id -- Unimos a la derecha la tabla libro con la tabla libro_x_autor donde libro_id = l.id
RIGHT JOIN autor a ON a.id = lxa.autor_id; -- Unimos a la derecha la tabla autor con la tabla libro_x_autor donde a.id = lxa.autor_id

-- ¿Qué consulta debemos realizar para visualizar todos los registros de la tabla “libro”,
-- incluyendo aquellos que no tienen un autor asignado dentro de nuestra BD?
SELECT * FROM libro l
LEFT JOIN libro_x_autor lxa ON lxa.libro_id = l.id
LEFT JOIN autor a ON a.id = lxa.autor_id;

-- ¿Cómo debemos armar una consulta para traer solamente los registros de los libros que tienen asignado un autor?
SELECT * FROM libro l
INNER JOIN libro_x_autor lxa ON lxa.libro_id = l.id
INNER JOIN autor a ON a.id = lxa.autor_id;

-- ¿Qué consulta debemos armar para visualizar todos los registros de la tabla “libro”,
-- excluyendo aquellos que tienen un autor asignado dentro de nuestra BD?
SELECT * FROM libro l
LEFT JOIN libro_x_autor lxa ON lxa.libro_id = l.id
LEFT JOIN autor a ON a.id = lxa.autor_id WHERE a.id IS NULL;