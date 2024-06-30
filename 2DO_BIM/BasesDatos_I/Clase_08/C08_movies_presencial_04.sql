USE movies_db;

-- ###############################
-- ########## Consultas ##########
-- ###############################

-- ***** Alias, limit y offset *****

-- 1. Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
SELECT title AS "Titulo" FROM series AS Series;

-- 2. Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
SELECT rating, title, release_date FROM movies WHERE rating > 3 AND awards > 1 AND release_date BETWEEN "1988-01-01" AND "2009-12-31" ORDER BY rating DESC;

-- 3. Traer el top 3 a partir del registro 10 de la consulta anterior.
SELECT rating, title, release_date FROM movies WHERE rating > 3 AND awards > 1 AND release_date BETWEEN "1988-01-01" AND "2009-12-31" ORDER BY rating DESC LIMIT 3 OFFSET 10;

-- 4. ¿Cuáles son los 3 peores episodios teniendo en cuenta su rating?
SELECT title FROM episodes ORDER BY rating LIMIT 3;

-- 5. Obtener el listado de todos los actores. Quitar las columnas de fechas y película favorita, además traducir los nombres de las columnas.
SELECT first_name AS "Nombre", last_name AS "Apellido", rating AS "Calificación" FROM actors;
