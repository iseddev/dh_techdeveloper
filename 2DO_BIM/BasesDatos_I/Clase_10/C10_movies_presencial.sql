USE movies_db;

-- ##### >>TABLE REFERENCE<< #####
-- EJEMPLOS CLASE VIRTUAL

-- Referenciación muchos--muchos (N:M)
SELECT title, first_name, last_name
FROM movies, actor_movie, actors
WHERE movie_id = movies.id
AND actor_id = actors.id;

-- Uso de >>INNER JOIN<<
SELECT title, first_name, last_name
FROM movies
INNER JOIN actor_movie ON movie_id = movies.id
INNER JOIN actors ON actor_id = actors.id;

-- Ejercicios clase virtual
USE musimundos;

SELECT * FROM canciones, generos
WHERE canciones.compositor = "Willie Dixon"
AND generos.nombre = "Blues";


-- ##### JOINS #####

-- INNER JOIN, LEFT JOIN y RIGHT JOIN
SELECT * FROM canciones
INNER JOIN generos ON canciones.compositor = "Willie Dixon" AND generos.nombre = "Blues";

-- ##### DISTINCT #####
USE movies_db;

-- EJERCICIO EJEMPLO
SELECT first_name, last_name
FROM movies
INNER JOIN actor_movie ON movie_id = movies.id
INNER JOIN actors ON actor_id = actors.id
WHERE title LIKE "Harry%";

-- APLICANDO DISTINCT => Elimina duplicados **exactamente** iguales
SELECT DISTINCT first_name, last_name
FROM movies
INNER JOIN actor_movie ON movie_id = movies.id
INNER JOIN actors ON actor_id = actors.id
WHERE title LIKE "Harry%";

-- ##### FUNCIONES DE ALTERACIÓN #####
USE movies_db;
SELECT first_name, last_name FROM actors;

-- CONCAT()
SELECT CONCAT(first_name, " ", last_name) AS "Nombre completo" FROM actors;

-- COALESCE()
SELECT title, COALESCE(name, "Sin género") FROM movies

-- INNER JOIN genres ON genres_id = genres.id
LEFT JOIN genres ON genre_id = genres.id;

-- NOW() y DATEDIFF()
SELECT title, DATEDIFF(NOW(), release_date) AS "Días desde estreno" FROM movies;

-- DATE_ADD("date", INTERVAL "num", format(seconds, minutes, hours, day, etc))
SELECT title, release_date FROM movies;
SELECT title, DATE_ADD(release_date, INTERVAL "3" DAY) FROM movies;
SELECT title, release_date, DATE_ADD(release_date, INTERVAL "3" DAY) AS "Mas 3 días" FROM movies;

-- DATE_SUB("date", INTERVAL "num", format(seconds, minutes, hours, day, etc))
SELECT title, release_date FROM movies;
SELECT title, DATE_SUB(release_date, INTERVAL "3" DAY) FROM movies;
SELECT title, release_date, DATE_SUB(release_date, INTERVAL "3" DAY) AS "Menos 3 días" FROM movies;

-- DATEFORMAT() [minúsculas => Formato "corto"; MAYÚSCULAS => Formato "largo"]
SELECT title, DATE_FORMAT(release_date, "%d/%m/%y") FROM movies;
SELECT title, DATE_FORMAT(release_date, "%d/%M/%Y") FROM movies;
SELECT title, DATE_FORMAT(release_date, "%d/%M/%y") FROM movies;

-- EXTRACT
SELECT title, EXTRACT(DAY FROM release_date) FROM movies;
SELECT title, EXTRACT(HOUR FROM release_date) FROM movies;
SELECT title, EXTRACT(MONTH FROM release_date) FROM movies;
SELECT title, EXTRACT(YEAR FROM release_date) FROM movies;

-- REPLACE(col, data_from_replace, data_to_replace)
SELECT REPLACE(title, "Harry", "Israel")  FROM movies;

-- LENGTH
SELECT LENGTH(title) FROM movies;
-- Otro ejemplo
SELECT title FROM movies WHERE LENGTH(title) > 5;
SELECT title FROM movies WHERE LENGTH(title) > 10;

-- CASE - WHEN - THEN - ELSE - END
SELECT title, rating,
CASE
	WHEN rating < 5 THEN "Mala"
    WHEN rating < 7 THEN "Buena"
    ELSE "Muy buena"
END AS Calificación
FROM movies;