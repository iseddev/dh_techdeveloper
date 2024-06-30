-- ############### Reportes - JOINS ###############
-- Es momento de aplicar los conocimientos adquiridos. Para esto, vamos a trabajar
-- con una nueva base de datos, donde deberemos crear consultas con las cláusulas
-- INNER, LEFT, LEFT Excluding, RIGHT y RIGHT Excluding.

USE extra_joins;
-- ***** Consignas: *****
-- 1. Obtener los artistas que han actuado en una o más películas.
SELECT * FROM artista;
SELECT * FROM pelicula;
SELECT * FROM artista_x_pelicula;

SELECT id, artista_id, COUNT(artista_id), pelicula_id PeliculaID FROM artista
INNER JOIN artista_x_pelicula ON artista_id = artista.id
GROUP BY artista_id ORDER BY ConteoArtista;

-- 2. Obtener las películas donde han participado más de un artista según nuestra base de datos.

-- 3. Obtener aquellos artistas que han actuado en alguna película, incluso
-- aquellos que aún no lo han hecho, según nuestra base de datos.

-- 4. Obtener las películas que no se le han asignado artistas en nuestra base de datos.

-- 5. Obtener aquellos artistas que no han actuado en alguna película, según
-- nuestra base de datos.

-- 6. Obtener aquellos artistas que han actuado en dos o más películas según nuestra base de datos.

-- 7. Obtener aquellas películas que tengan asignado uno o más artistas, incluso
-- aquellas que aún no le han asignado un artista en nuestra base de datos.