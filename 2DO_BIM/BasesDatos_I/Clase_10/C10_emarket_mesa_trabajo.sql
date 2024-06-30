-- #########################################
-- ############### Consignas ###############
-- #########################################

-- Vamos a practicar sobre consultas SELECT, enfocándonos en GROUP BY, HAVING y DISTINCT.
USE emarket;

-- ***** Clientes *****
-- 1) ¿Cuántos clientes existen?
SELECT COUNT(ClienteID) AS "Total clientes" FROM clientes;

-- 2) ¿Cuántos clientes hay por ciudad?
SELECT ciudad AS Ciudad, COUNT(ClienteID) AS "Total clientes" FROM clientes
GROUP BY ciudad;


--  ***** Facturas *****
-- 1) ¿Cuál es el total de transporte?
SELECT SUM(transporte) AS "Total facturado" FROM facturas;

-- 2) ¿Cuál es el total de transporte por EnvioVia (empresa de envío)?
SELECT EnvioVia AS "ID Empresa Envío", COUNT(EnvioVia) AS "Total envíos" FROM facturas GROUP BY EnvioVia;

-- 3) Calcular la cantidad de facturas por cliente. Ordenar descendente por cantidad de facturas.
SELECT NombreEnvio AS nombre_cliente, COUNT(FacturaID) AS total_facturas FROM facturas
GROUP BY nombre_cliente ORDER BY total_facturas DESC;

-- 4) Obtener el Top 5 de clientes de acuerdo a su cantidad de facturas.
SELECT NombreEnvio AS nombre_cliente, COUNT(FacturaID) AS total_facturas FROM facturas
GROUP BY nombre_cliente ORDER BY total_facturas DESC LIMIT 5;

-- 5) ¿Cuál es el país de envío menos frecuente de acuerdo a la cantidad de facturas?
SELECT PaisEnvio AS nombre_pais, COUNT(FacturaID) AS total_facturas FROM facturas
GROUP BY nombre_pais ORDER BY total_facturas LIMIT 1;

-- 6) Se quiere otorgar un bono al empleado con más ventas. ¿Qué ID de empleado realizó más operaciones de ventas?
SELECT EmpleadoID, COUNT(FacturaID) AS operaciones FROM facturas
GROUP BY EmpleadoID ORDER BY operaciones DESC LIMIT 1;


-- ***** Factura detalle *****
-- 1) ¿Cuál es el producto que aparece en más líneas de la tabla Factura Detalle?
SELECT ProductoID, COUNT(FacturaID) AS veces_comprado FROM facturadetalle
GROUP BY ProductoID ORDER BY veces_comprado DESC LIMIT 1;

-- 2) ¿Cuál es el total facturado? Considerar que el total facturado es la suma de cantidad por precio unitario.
SELECT COUNT(FacturaID) AS total_facturas, SUM(Cantidad * PrecioUnitario) AS total_facturado FROM facturadetalle;

-- 3) ¿Cuál es el total facturado para los productos ID entre 30 y 50?
SELECT ProductoID, COUNT(ProductoID) AS total_productos, SUM(Cantidad * PrecioUnitario) AS total_facturado
FROM facturadetalle GROUP BY ProductoID HAVING ProductoID BETWEEN 30 AND 50;

-- 4) ¿Cuál es el precio unitario promedio de cada producto?
SELECT AVG(PrecioUnitario) AS precio_promedio FROM facturadetalle;

-- 5) ¿Cuál es el precio unitario máximo?
SELECT MAX(PrecioUnitario) AS precio_unitario_maximo FROM facturadetalle;


--  ***** Consultas Queries - JOINS *****
-- 1) Generar un listado de todas las facturas del empleado 'Buchanan'.
SELECT FacturaID, Apellido FROM facturas
JOIN empleados ON empleados.EmpleadoId = facturas.EmpleadoID AND Apellido = "Buchanan";

-- 2) Generar un listado con todos los campos de las facturas del correo 'Speedy Express'.
SELECT * FROM facturas
JOIN correos ON EnvioVia = CorreoID AND Compania = "Speedy Express";

-- 3) Generar un listado de todas las facturas con el nombre y apellido de los empleados.
SELECT *, Nombre, Apellido FROM facturas
JOIN empleados ON empleados.EmpleadoID = facturas.EmpleadoID
ORDER BY FacturaID;

-- 4) Mostrar un listado de las facturas de todos los clientes “Owner” y país de envío “USA”.
SELECT *, Titulo FROM facturas
JOIN clientes ON clientes.ClienteID = facturas.ClienteID
HAVING Titulo = "Owner" AND Pais = "USA";


-- 5) Mostrar todos los campos de las facturas del empleado cuyo apellido sea “Leverling”
-- o que incluyan el producto id = “42”.
SELECT * FROM facturas;
SELECT * FROM empleados;
SELECT *, Apellido FROM facturas
JOIN empleados ON empleados.EmpleadoId = facturas.EmpleadoID
JOIN facturadetalle ON facturadetalle.FacturaID = facturas.FacturaID
WHERE Apellido = "Leverling" OR ProductoID = 42;

-- 6) Mostrar todos los campos de las facturas del empleado cuyo apellido sea
-- “Leverling” y que incluya los producto id = “80” o ”42”.
SELECT * FROM facturas;
SELECT * FROM empleados;
SELECT *, Apellido FROM facturas
JOIN empleados ON empleados.EmpleadoId = facturas.EmpleadoID
JOIN facturadetalle ON facturadetalle.FacturaID = facturas.FacturaID
WHERE Apellido = "Leverling" AND (ProductoID = 80 OR ProductoID = 42);

-- 7) Generar un listado con los cinco mejores clientes, según sus importes de
-- compras total (PrecioUnitario * Cantidad).
SELECT ClienteID, SUM(PrecioUnitario * Cantidad) GastoTotal FROM facturas F
JOIN facturadetalle FD ON FD.FacturaID = F.FacturaID
GROUP BY ClienteID ORDER BY GastoTotal DESC LIMIT 5;

-- 8) Generar un listado de facturas, con los campos id, nombre y apellido del cliente,
-- fecha de factura, país de envío, Total, ordenado de manera descendente por fecha de factura
-- y limitado a 10 filas.
SELECT facturas.FacturaID, Contacto NombreApellido, FechaFactura, PaisEnvio, SUM(PrecioUnitario * Cantidad) GastoTotal FROM facturas
JOIN clientes ON clientes.ClienteID = facturas.ClienteID
JOIN facturadetalle ON facturadetalle.FacturaID = facturas.FacturaID
GROUP BY facturas.FacturaID ORDER BY FechaFactura DESC LIMIT 10;