-- ######################### Reportes #########################
USE sakila;

-- ********** Reportes parte 1: **********

-- 1. Obtener el nombre y apellido de los primeros 5 actores disponibles. Utilizar
-- alias para mostrar los nombres de las columnas en español.
SELECT first_name AS nombre, last_name AS apellido FROM actor LIMIT 5;

-- 2. Obtener un listado que incluya nombre, apellido y correo electrónico de los
-- clientes (customers) inactivos. Utilizar alias para mostrar los nombres de las
-- columnas en español.
SELECT first_name as nombre, last_name AS apellido, email AS correo, active AS esta_activo
FROM customer WHERE active = 0;

-- 3. Obtener un listado de films incluyendo título, año y descripción de los films
-- que tienen un rental_duration mayor a cinco. Ordenar por rental_duration de
-- mayor a menor. Utilizar alias para mostrar los nombres de las columnas en español.
SELECT title AS titulo, release_year AS año_estreno, description AS descripcion
FROM film WHERE rental_duration > 5 ORDER BY rental_duration DESC;

-- 4. Obtener un listado de alquileres (rentals) que se hicieron durante el mes de
-- mayo de 2005, incluir en el resultado todas las columnas disponibles.
SELECT * FROM rental WHERE rental_date BETWEEN "2005-05-01" AND "2005-05-31";


-- ********** Reportes parte 2 **********

-- 1. Obtener la cantidad TOTAL de alquileres (rentals). Utilizar un alias para
-- mostrarlo en una columna llamada “cantidad”.
SELECT COUNT(rental_id) AS total_alquileres FROM rental;

-- 2. Obtener la suma TOTAL de todos los pagos (payments). Utilizar un alias para
-- mostrarlo en una columna llamada “total”, junto a una columna con la cantidad de
-- alquileres con el alias “Cantidad” y una columna que indique el “Importe promedio” por alquiler.
SELECT SUM(amount) AS total_pagos, COUNT(rental_id) AS total_rentas, AVG(amount) AS importe_promedio FROM payment;

-- 3. Generar un reporte que responda la pregunta: ¿cuáles son los diez clientes
-- que más dinero gastan y en cuántos alquileres lo hacen?
SELECT rental.customer_id AS id_cliente, SUM(amount) AS total_facturado, COUNT(rental.rental_id) AS total_alquileres FROM rental
INNER JOIN payment ON payment.rental_id = rental.rental_id
GROUP BY id_cliente ORDER BY total_facturado DESC LIMIT 10;

-- 4. Generar un reporte que indique: ID de cliente, cantidad de alquileres y monto total
-- para todos los clientes que hayan gastado más de 150 dólares en alquileres.
SELECT rental.customer_id AS id_cliente, COUNT(rental.rental_id) AS total_alquileres, SUM(amount) AS total_facturado FROM rental
INNER JOIN payment ON payment.rental_id = rental.rental_id
GROUP BY id_cliente HAVING total_facturado > 150 ORDER BY total_facturado;

-- 5. Generar un reporte que muestre por mes de alquiler (rental_date de tabla rental),
-- la cantidad de alquileres y la suma total pagada (amount de tabla payment) para el año
-- de alquiler 2005 (rental_date de tabla rental).
SELECT EXTRACT(MONTH FROM rental_date) AS mes_alquiler,
COUNT(rental.rental_id) AS total_rentas,
SUM(amount) AS total_facturado FROM rental
INNER JOIN payment ON payment.rental_id = rental.rental_id AND EXTRACT(YEAR FROM rental.rental_date) = 2005
GROUP BY mes_alquiler HAVING mes_alquiler = 5;

-- 6. Generar un reporte que responda a la pregunta: ¿cuáles son los 5 inventarios más alquilados?
-- (columna inventory_id en la tabla rental). Para cada una de ellas indicar la cantidad de alquileres.
SELECT * FROM rental;
SELECT inventory_id FROM rental GROUP BY inventory_id;
SELECT inventory_id, COUNT(inventory_id) AS conteo FROM rental
GROUP BY inventory_id  ORDER BY conteo DESC LIMIT 5;