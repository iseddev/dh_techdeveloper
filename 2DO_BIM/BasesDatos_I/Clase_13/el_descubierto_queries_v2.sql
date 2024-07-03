USE el_descubierto;
-- 1. Listar todos los clientes que tengan tres o más cuentas bancarias. Mostrar el
-- número de cliente, apellido y nombre separado por un espacio dentro de una
-- misma columna denominada "Cliente" y, la cantidad de cuentas que posee.
SELECT * FROM cliente_x_cuenta ORDER BY cliente_id;
SELECT CONCAT(id, " ", apellido, " ", nombre) Cliente, COUNT(cliente_id) TotalCuentas FROM cliente
JOIN cliente_x_cuenta CC ON id = cliente_id
GROUP BY cliente_id HAVING Totalcuentas >= 3;
-- Total rows: 6

-- 2. Listar todos los clientes que no tengan una cuenta bancaria. Mostrar el número
-- de cliente, apellido y nombre en mayúsculas dentro de una misma columna
-- denominada "Cliente sin cuenta bancaria".
SELECT UPPER(CONCAT(id, " ", apellido, " ", nombre)) "Cliente sin cuenta bancaria" FROM cliente
LEFT JOIN cliente_x_cuenta CC ON id = cliente_id
WHERE cliente_id IS NULL;
-- Total rows: 8

-- 3. Listar todos los clientes que tengan al menos un préstamo que corresponda a la
-- sucursal de la ciudad de "Pilar - Buenos Aires". Se debe mostrar el número de
-- cliente, apellido, nombre, número de préstamo, número de sucursal, nombre de
-- la ciudad y país de dicha sucursal.
SELECT cliente.id NoCliente, apellido Apellido, cliente.nombre Nombre, prestamo_id NoPrestamo, numero NoSucursal, C.nombre Ciudad, Pais.nombre Pais FROM cliente
JOIN cliente_x_prestamo CxP ON CxP.cliente_id = cliente.id
JOIN prestamo P ON P.id = CxP.prestamo_id
JOIN sucursal S ON S.numero = P.sucursal_numero
JOIN ciudad C ON C.id = S.Ciudad_id
JOIN pais Pais ON Pais.id = C.pais_id
WHERE C.nombre LIKE "Pilar - Buenos Aires";
-- Total rows: 3

-- 4. Listar los clientes que tengan una o más cajas de ahorro y que en la segunda
-- letra de su apellido contenga una "e".
SELECT * FROM cliente
JOIN cliente_x_cuenta ON cliente_x_cuenta.cliente_id = cliente.id
JOIN cuenta ON cuenta.numero = cliente_x_cuenta.cuenta_numero
JOIN cuenta_tipo ON cuenta_tipo.id = cuenta.cuenta_tipo_id
WHERE cuenta_tipo.id = 1 AND cliente.apellido LIKE "_e%";
-- Total rows: 5

-- 5. Listar absolutamente todos los países y la cantidad de clientes que tengan.
SELECT P.nombre Pais, COUNT(Cte.id) Totalclientes FROM pais P
LEFT JOIN ciudad C ON C.pais_id = P.id
LEFT JOIN cliente Cte ON Cte.ciudad_id = C.id
GROUP BY P.nombre;

-- 6. Calcular el importe total y la cantidad de préstamos otorgados en el mes de
-- agosto por cada cliente. Mostrar el número de cliente, importe total y cantidad
-- de préstamos.
SELECT * FROM cliente_x_prestamo;
SELECT CxP.cliente_id NoCliente, SUM(P.importe) ImporteTotal, COUNT(P.id) CantidadPrestamos FROM prestamo P
JOIN cliente_x_prestamo CxP ON CxP.prestamo_id = P.id
WHERE MONTH(fecha_otorgado) = 8
GROUP BY NoCliente;

-- 7. Calcular el importe total y la cantidad de cuotas pagadas para el préstamo
-- número cuarenta.
SELECT prestamo_id NoPrestamo, SUM(importe) TotalPagado, COUNT(cuota_nro) CuotasPagadas FROM pago
WHERE prestamo_id = 40;

-- 8. Determinar el importe restante que falta por pagar para el préstamo número 45.
SELECT prestamo.id NoPrestamo, prestamo.importe - SUM(pago.importe) Importe_X_Pagar FROM prestamo
JOIN pago ON prestamo_id = prestamo.id
WHERE prestamo.id = 45;

-- 9. Listar los préstamos de la sucursal número cuatro. Mostrar el número de cliente,
-- apellido, nombre y el número de préstamo.
SELECT Suc.numero NoSucursal, Cte.id NoCliente, Cte.apellido Apellido, Cte.nombre Nombre, P.id NoPrestamo FROM sucursal Suc
JOIN prestamo P ON P.sucursal_numero = Suc.numero
JOIN cliente_x_prestamo CxP ON CxP.prestamo_id = P.id
JOIN cliente Cte ON Cte.id = CxP.cliente_id
WHERE Suc.numero = 4;

-- 10. Reportar el número del préstamo y la cantidad de cuotas pagadas por cada préstamo.
-- Se debe formatear el dato de la cantidad de cuotas pagadas, por ejemplo:
-- si se ha pagado una cuota, sería "1 cuota pagada"; si se han pagado dos o
-- más cuotas, sería en plural "2 cuotas pagadas" y "Ninguna cuota pagada" para los
-- préstamos que aún no han recibido un pago.
SELECT P.id NoPrestamo,
	CASE
		WHEN COUNT(cuota_nro) = 0 THEN "Ninguna cuota pagada"
		WHEN COUNT(cuota_nro) = 1 THEN "1 cuota pagada"
		ELSE CONCAT(COUNT(cuota_nro), " ", "cuotas pagadas")
	END CuotasPagadas
FROM prestamo P
LEFT JOIN pago ON pago.prestamo_id = P.id
GROUP BY NoPrestamo;
SELECT * FROM prestamo;
SELECT * FROM pago ORDER BY prestamo_id;

-- 11. Listar absolutamente todos los empleados y las cuentas bancarias que tengan
-- asociada. Mostrar en una sola columna el apellido y la letra inicial del nombre del
-- empleado (Ej. Tello Aguilera C.), en otra columna, el número de cuenta y el tipo
-- (Ej. 10560 - CAJA DE AHORRO). Los campos nulos deben figurar con la leyenda
-- "-Sin asignación-".
SELECT
	CASE
		WHEN C.ejecutivo_cuenta IS NULL THEN "-Sin asignación-"
        ELSE CONCAT(E.apellido, " ", LEFT(E.nombre, 1), ".")
	END NombreEmpleado,
CONCAT(C.numero, " - ", UPPER(CT.tipo)) TipoCuenta
FROM empleado E
RIGHT JOIN cuenta C ON c.ejecutivo_cuenta = E.legajo
JOIN cuenta_tipo CT ON CT.id = C.cuenta_tipo_id
ORDER BY C.numero;

-- 12. Reportar todos los datos de los clientes y los números de cuenta que tienen.


-- 13. Listar los clientes con residencia en las ciudades de "Las Heras - Mendoza", "Viña
-- del Mar - Valparaíso", "Córdoba - Córdoba" y "Monroe - Buenos Aires". Se debe
-- mostrar el apellido, nombre del cliente y todos los datos referidos a la ciudad


-- 14. Listar los clientes que tienen préstamos otorgados entre 15/08/21 al 5/09/21
-- (ordenarlos por fecha de otorgamiento). Mostrar sólo el email del cliente,
-- teléfono móvil y todos los datos referidos al préstamo.


-- 15. Listar de manera ordenada, los empleados que no pertenezcan a la sucursal de
-- la ciudad "Monroe - Buenos Aires" y que la fecha de alta del contrato se halle
-- dentro del rango 2016 al 2018. Mostrar el email del empleado, número de
-- sucursal y el nombre de la ciudad


-- 16. Listar las cuentas bancarias que tienen dos titulares. Mostrar sólo el número de
-- cuenta y la cantidad de titulares
-- 17. Se desea conocer el segundo pago con mayor importe efectuado en las
-- sucursales de Chile. Mostrar el número y hora de pago, importe pagado y el nombre del país.


-- 18. Listar los clientes que no tienen préstamos. Mostrar el apellido, nombre y email del cliente.

-- 19. Se desea conocer el mes y año en que se terminaría de pagar el préstamo
-- número treinta a partir de la fecha de otorgamiento. Se debe mostrar el email
-- del cliente, número de préstamo, fecha de otorgamiento, importe prestado, mes
-- y año que correspondería a la última cuota (Ej. "agosto de 2021").


-- 20. Listar las ciudades (sin repetir) que tengan entre dos a cuatro cuentas bancarias.
-- Se debe mostrar el país, ciudad y la cantidad de cuentas. Además, se debe
-- ordenar por país y ciudad.


-- 21. Mostrar el nombre, apellido, número de cuenta de todos los clientes que poseen
-- una cuenta tipo "CAJA DE AHORRO", cuyo saldo es mayor que $ 15000


-- 22. Por cada sucursal, contar la cantidad de clientes y el saldo promedio de sus cuentas.


-- 23. Listar todos aquellos clientes que teniendo un saldo negativo en la cuenta,
-- tengan un descubierto otorgado mayor a cero. Mostrar el apellido, nombre,
-- saldo y descubierto otorgado.


-- 24. Se desea conocer el último acceso de cada cliente al sistema. Mostrar el nombre,
-- apellido y última fecha de acceso.


-- 25. Listar el apellido y nombre de todos los empleados del banco. Si poseen cuentas
-- a cargo, mostrar cuántas. Ordenar por apellido y nombre.