USE musimundos;
-- En el salón de Musimundos tenemos un cliente fanático de Willie Dixon,
-- quiere comprar toda la colección de sus temas, pero NO le interesan los
-- temas que sean de su etapa en el rock.

-- Hagamos una consulta en la base de datos donde muestre todos los registros
-- que contengan canciones con sus géneros, Y que el compositor sea Willie Dixon,
-- Y que tengan el género Blues.
SELECT canciones.nombre NombreCancion, generos.id GeneroID, generos.nombre NombreGenero, compositor Compositor
FROM canciones, generos
WHERE id_genero = generos.id AND compositor = "Willie Dixon" AND generos.nombre = "Blues";