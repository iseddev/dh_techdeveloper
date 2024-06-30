use movies_db;
-- Funciones de agregación, GROUP BY y HAVING
-- 1. ¿Cuántas películas hay?
select count(*) from movies;

-- 2. ¿Cuántas películas tienen entre 3 y 7 premios?
select count(*) from movies
where awards between 3 and 7;

-- 3. ¿Cuántas películas tienen entre 3 y 7 premios y un rating mayor a 7?
select count(*) from movies
where awards between 3 and 7 and rating > 7;

-- 4. Crear un listado a partir de la tabla de películas, mostrar un reporte de la cantidad de películas por id. de género.
select genre_id GenreID, count(*) TotalMovies from movies
group by genre_id;

-- 5. De la consulta anterior, listar sólo aquellos géneros que tengan como suma de premios un número mayor a 5.
select genre_id GenreID, count(*) TotalMovies, sum(awards) SumAwards from movies
group by genre_id
having SumAwards > 5;