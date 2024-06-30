-- Ejercitación adicional - Bases de datos IV

-- En esta práctica vamos a seguir practicando consultas sobre la base de datos movies_db.
USE movies_db;

-- ##### Consultas #####
-- >> Join <<
-- 1. Utilizando la base de datos de movies, queremos conocer, por un lado, los
-- títulos y el nombre del género de todas las series de la base de datos.
SELECT title AS "Título Serie", name AS Género FROM series
INNER JOIN genres ON genre_id = genres.id;

-- 2. Por otro, necesitamos listar los títulos de los episodios junto con el nombre y
-- apellido de los actores que trabajan en cada uno de ellos.
SELECT title AS "Episodio", first_name AS Nombre, last_name AS Apellido
FROM episodes
INNER JOIN actor_episode ON episode_id = episodes.id
INNER JOIN actors ON actor_id = actors.id;

-- 3. Para nuestro próximo desafío, necesitamos obtener a todos los actores o
-- actrices (mostrar nombre y apellido) que han trabajado en cualquier película
-- de la saga de La Guerra de las galaxias.
SELECT title AS Pelicula, first_name AS Nombre, last_name AS Apellido FROM movies
INNER JOIN actor_movie ON movie_id = movies.id AND title LIKE "La Guerra de las galaxias%"
INNER JOIN actors ON actor_id = actors.id;

-- 4. Crear un listado a partir de la tabla de películas, mostrar un reporte de la
-- cantidad de películas por nombre de género.
SELECT genres.id AS ID, name AS Género, COUNT(genre_id) AS "Cantida películas" FROM genres
INNER JOIN movies ON genre_id = genres.id
GROUP BY genre_id;