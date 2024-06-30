USE movies_db;

-- USO DE LIMIT Y OFFSET
-- Mostrar todas las películas ordenadas ASCENDENTEMENTE por rating
SELECT title, rating FROM movies
ORDER BY rating ASC;

-- Mostrar las primeras 5 películas ordenadas ASCENDENTEMENTE por rating
SELECT title, rating FROM movies
ORDER BY rating ASC
LIMIT 5;

-- Mostrar 5 películas después del registro 5 ordenadas ASCENDENTEMENTE por rating
SELECT title, rating FROM movies
ORDER BY rating ASC
LIMIT 5
OFFSET 5;

-- Mostrar 5 películas después del registro 10 ordenadas ASCENDENTEMENTE por rating
SELECT title, rating FROM movies
ORDER BY rating ASC
LIMIT 5
OFFSET 10;

-- Mostrar 5 películas después del registro 15 ordenadas ASCENDENTEMENTE por rating
SELECT title, rating FROM movies
ORDER BY rating ASC
LIMIT 5
OFFSET 15;

-- Mostrar 5 películas después del registro 15 ordenadas ASCENDENTEMENTE por rating
SELECT title, rating FROM movies
ORDER BY rating ASC
LIMIT 5
OFFSET 20;