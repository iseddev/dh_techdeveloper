USE el_descubierto;

-- ##### Consigna - CheckPoint III #####

-- 1. Listar todos los clientes que tengan tres o más cuentas bancarias. Mostrar el
-- número de cliente, apellido y nombre separado por un espacio dentro de una
-- misma columna denominada "Cliente" y, la cantidad de cuentas que posee.
SELECT CONCAT(cli.id, ' ', cli.apellido, ' ', cli.nombre) AS Cliente, COUNT(distinct cxn.cuenta_numero) AS cantidad_cuentas
FROM cliente cli
JOIN cliente_x_cuenta cxn ON cli.id = cxn.cliente_id
GROUP BY Cliente
HAVING cantidad_cuentas >= 3;

-- 2, Listar todos los clientes que no tengan una cuenta bancaria. Mostrar el número
-- de cliente, apellido y nombre en mayúsculas dentro de una misma columna
-- denominada "Cliente sin cuenta bancaria".
SELECT CONCAT(cli.id, ' ', UPPER(cli.apellido), ' ', UPPER(cli.nombre)) AS "Cliente sin cuenta bancaria"
FROM cliente cli
WHERE cli.id NOT IN (SELECT cliente_id FROM cliente_x_cuenta);

-- 3. Listar todos los clientes que tengan al menos un préstamo que corresponda a la
-- sucursal de la ciudad de "Pilar - Buenos Aires". Se debe mostrar el número de
-- cliente, apellido, nombre, número de préstamo, número de sucursal, nombre de
-- la ciudad y país de dicha sucursal.
SELECT cli.id AS numero_cliente, cli.apellido, cli.nombre, p.id AS numero_prestamo, s.numero AS numero_sucursal, c.nombre AS nombre_ciudad, pais.nombre AS nombre_pais
FROM cliente cli
JOIN cliente_x_prestamo cxp ON cli.id = cxp.cliente_id
JOIN prestamo p ON cxp.prestamo_id = p.id
JOIN sucursal s ON p.sucursal_numero = s.numero
JOIN ciudad c ON s.Ciudad_id = c.id
JOIN pais ON c.pais_id = pais.id
WHERE c.nombre = 'Pilar - Buenos Aires';

-- 4. Listar los clientes que tengan una o más cajas de ahorro y que en la segunda
-- letra de su apellido contenga una "e".
SELECT cli.id, cli.apellido, cli.nombre, cxn.cuenta_numero
FROM cliente cli
JOIN cliente_x_cuenta cxn ON cli.id = cxn.cliente_id
JOIN cuenta c ON cxn.cuenta_numero = c.numero
JOIN cuenta_tipo ct ON c.cuenta_tipo_id = ct.id
WHERE ct.tipo = 'CAJA DE AHORRO' AND SUBSTRING(cli.apellido, 2, 1) = 'e';

-- 5. Listar absolutamente todos los países y la cantidad de clientes que tengan.
SELECT p.nombre AS pais, COUNT(distinct cli.id) AS cantidad_clientes FROM pais p
LEFT JOIN ciudad c ON p.id = c.pais_id
LEFT JOIN cliente cli ON c.id = cli.ciudad_id
GROUP BY p.nombre;

-- 6. Calcular el importe total y la cantidad de préstamos otorgados en el mes de
-- agosto por cada cliente. Mostrar el número de cliente, importe total y cantidad
-- de préstamos.
SELECT cli.id AS numero_cliente, SUM(p.importe) AS importe_total, COUNT(distinct p.id) AS cantidad_prestamos
FROM cliente cli
JOIN cliente_x_prestamo cxp ON cli.id = cxp.cliente_id
JOIN prestamo p ON cxp.prestamo_id = p.id
WHERE MONTH(p.fecha_otorgado) = 8
GROUP BY numero_cliente;

-- 7. Calcular el importe total y la cantidad de cuotas pagadas para el préstamo
-- número cuarenta.
SELECT p.id AS numero_prestamo, SUM(pago.importe) AS importe_total, COUNT(pago.id) AS cuotas_pagadas
FROM prestamo p
LEFT JOIN pago ON p.id = pago.prestamo_id
WHERE p.id = 40;

-- 8. Determinar el importe restante que falta por pagar para el préstamo número 45.
SELECT p.id AS numero_prestamo, (p.importe - SUM(pago.importe)) AS importe_restante
FROM prestamo p
LEFT JOIN pago ON p.id = pago.prestamo_id
WHERE p.id = 45;

-- 9. Listar los préstamos de la sucursal número cuatro. Mostrar el número de cliente,
-- apellido, nombre y el número de préstamo.
SELECT cli.id, cli.apellido, cli.nombre, p.id AS numero_prestamo
FROM cliente cli
JOIN cliente_x_prestamo cxp ON cli.id = cxp.cliente_id
JOIN prestamo p ON cxp.prestamo_id = p.id
WHERE p.sucursal_numero = 4;

-- 10. Reportar el número del préstamo y la cantidad de cuotas pagadas por cada uno
-- préstamo. Se debe formatear el dato de la cantidad de cuotas pagadas, por
-- ejemplo, si se ha pagado una cuota, sería "1 cuota paga"; si se han pagado dos o
-- más cuotas, sería en plural "2 cuotas pagas" y "Ninguna cuota paga" para los
-- préstamos que aún no han recibido un pago.
SELECT p.id AS numero_prestamo, 
       CASE 
         WHEN COUNT(pago.id) = 0 THEN 'Ninguna cuota paga'
         WHEN COUNT(pago.id) = 1 THEN '1 cuota paga'
         ELSE CONCAT(COUNT(pago.id), ' cuotas pagas')
       END AS cuotas_pagadas
FROM prestamo p
LEFT JOIN pago ON p.id = pago.prestamo_id
GROUP BY numero_prestamo;

-- 11. Listar absolutamente todos los empleados y las cuentas bancarias que tengan
-- asociada. Mostrar en una sola columna el apellido y la letra inicial del nombre del
-- empleado (Ej. Tello Aguilera C.), en otra columna, el número de cuenta y el tipo
-- (Ej. 10560 - CAJA DE AHORRO). Los campos nulos deben figurar con la leyenda
-- "-Sin asignación-".
SELECT CONCAT(e.apellido, ' ', LEFT(e.nombre, 1), '.') AS nombre_empleado,
       CONCAT(c.numero, ' - ', ct.tipo) AS cuenta_asociada
FROM empleado e
LEFT JOIN cuenta c ON e.legajo = c.ejecutivo_cuenta
LEFT JOIN cuenta_tipo ct ON c.cuenta_tipo_id = ct.id
UNION
SELECT CONCAT(e.apellido, ' ', LEFT(e.nombre, 1), '.') AS nombre_empleado,
       '-Sin asignación-' AS cuenta_asociada
FROM empleado e
WHERE e.legajo NOT IN (SELECT DISTINCT ejecutivo_cuenta FROM cuenta WHERE ejecutivo_cuenta IS NOT NULL);

-- 12. Reportar todos los datos de los clientes y los números de cuenta que tienen.
SELECT cli.id, cli.apellido, cli.nombre, cxn.cuenta_numero
FROM cliente cli
LEFT JOIN cliente_x_cuenta cxn ON cli.id = cxn.cliente_id;

-- 13. Listar los clientes con residencia en las ciudades de "Las Heras - Mendoza", "Viña
-- del Mar - Valparaíso", "Córdoba - Córdoba" y "Monroe - Buenos Aires". Se debe
-- mostrar el apellido, nombre del cliente y todos los datos referidos a la ciudad.
SELECT cli.apellido, cli.nombre, cli.email, c.numero, c.saldo, c.descubierto_otorgado
FROM cliente cli
JOIN cliente_x_cuenta cxn ON cli.id = cxn.cliente_id
JOIN cuenta c ON cxn.cuenta_numero = c.numero
WHERE c.descubierto_otorgado > 0 AND c.saldo < 0;

-- 14. Listar los clientes que tienen préstamos otorgados entre 15/08/21 al 5/09/21
-- (ordenarlos por fecha de otorgamiento). Mostrar sólo el email del cliente,
-- teléfono móvil y todos los datos referidos al préstamo.
SELECT DISTINCT cli.email, cli.telefono_movil, p.*, cli.*
FROM cliente cli
JOIN cliente_x_prestamo cxp ON cli.id = cxp.cliente_id
JOIN prestamo p ON cxp.prestamo_id = p.id
WHERE p.fecha_otorgado BETWEEN '2021-08-15' AND '2021-09-05'
ORDER BY p.fecha_otorgado;

-- 15. Listar de manera ordenada, los empleados que no pertenezcan a la sucursal de
-- la ciudad "Monroe - Buenos Aires" y que la fecha de alta del contrato se halle
-- dentro del rango 2016 al 2018. Mostrar el email del empleado, número de
-- sucursal y el nombre de la ciudad.
SELECT e.apellido, e.nombre, e.email, s.numero AS numero_sucursal, c.nombre AS nombre_ciudad
FROM empleado e
JOIN sucursal s ON e.sucursal_numero = s.numero
JOIN ciudad c ON s.Ciudad_id = c.id
WHERE c.nombre != 'Monroe - Buenos Aires' AND YEAR(e.alta_contrato_laboral) BETWEEN 2016 AND 2018
ORDER BY e.apellido, e.nombre;

-- 16. Listar las cuentas bancarias que tienen dos titulares. Mostrar sólo el número de
--cuenta y la cantidad de titulares.
SELECT cxn.cuenta_numero, COUNT(distinct cxn.cliente_id) AS cantidad_titulares
FROM cliente_x_cuenta cxn
GROUP BY cxn.cuenta_numero
HAVING cantidad_titulares = 2;

-- 17. Se desea conocer el segundo pago con mayor importe efectuado en las
-- sucursales de Chile. Mostrar el número y hora de pago, importe pagado y el
-- nombre del país.
SELECT p.id AS numero_pago, pago.fecha, pago.importe, pais.nombre AS nombre_pais
FROM pago
JOIN prestamo p ON pago.prestamo_id = p.id
JOIN sucursal s ON p.sucursal_numero = s.numero
JOIN ciudad c ON s.Ciudad_id = c.id
JOIN pais ON c.pais_id = pais.id
WHERE pais.nombre = 'Chile'
ORDER BY pago.importe DESC
LIMIT 1 OFFSET 1;

-- 18. Listar los clientes que no tienen préstamos. Mostrar el apellido, nombre y email del cliente.
SELECT cli.apellido, cli.nombre, cli.email
FROM cliente cli
LEFT JOIN cliente_x_prestamo cxp ON cli.id = cxp.cliente_id
WHERE cxp.cliente_id IS NULL;

-- 19. Se desea conocer el mes y año en que se terminaría de pagar el préstamo
-- número treinta a partir de la fecha de otorgamiento. Se debe mostrar el email
-- del cliente, número de préstamo, fecha de otorgamiento, importe prestado, mes
-- y año que correspondería a la última cuota (Ej. "agosto de 2021").
SELECT cli.email, p.id AS numero_prestamo, p.fecha_otorgado, p.importe,
       DATE_FORMAT(ADDDATE(p.fecha_otorgado, INTERVAL p.cantidad_cuota MONTH), '%M de %Y') AS fecha_ultimo_pago
FROM cliente cli
JOIN cliente_x_prestamo cxp ON cli.id = cxp.cliente_id
JOIN prestamo p ON cxp.prestamo_id = p.id
WHERE p.id = 30;

-- 20. Listar las ciudades (sin repetir) que tengan entre dos a cuatro cuentas bancarias.
-- Se debe mostrar el país, ciudad y la cantidad de cuentas. Además, se debe
-- ordenar por país y ciudad.
SELECT p.nombre AS pais, c.nombre AS ciudad, COUNT(distinct cxn.cuenta_numero) AS cantidad_cuentas
FROM pais p
JOIN ciudad c ON p.id = c.pais_id
JOIN cliente cli ON c.id = cli.ciudad_id
JOIN cliente_x_cuenta cxn ON cli.id = cxn.cliente_id
GROUP BY p.nombre, c.nombre
HAVING cantidad_cuentas BETWEEN 2 AND 4
ORDER BY p.nombre, c.nombre;

-- 21. Mostrar el nombre, apellido, número de cuenta de todos los clientes que poseen
-- una cuenta tipo "CAJA DE AHORRO", cuyo saldo es mayor que $ 15000.
SELECT cli.nombre, cli.apellido, cxn.cuenta_numero
FROM cliente cli
JOIN cliente_x_cuenta cxn ON cli.id = cxn.cliente_id
JOIN cuenta c ON cxn.cuenta_numero = c.numero
JOIN cuenta_tipo ct ON c.cuenta_tipo_id = ct.id
WHERE ct.tipo = 'CAJA DE AHORRO' AND c.saldo > 15000;

-- 22. Por cada sucursal, contar la cantidad de clientes y el saldo promedio de sus cuentas.
SELECT s.numero AS numero_sucursal, COUNT(distinct cli.id) AS cantidad_clientes, AVG(c.saldo) AS saldo_promedio
FROM sucursal s
JOIN empleado e ON s.numero = e.sucursal_numero
JOIN cliente cli ON e.legajo = cli.ejecutivo_cuenta
JOIN cliente_x_cuenta cxn ON cli.id = cxn.cliente_id
JOIN cuenta c ON cxn.cuenta_numero = c.numero
GROUP BY s.numero;

-- 23. Listar todos aquellos clientes que teniendo un saldo negativo en la cuenta,
-- tengan un descubierto otorgado mayor a cero. Mostrar el apellido, nombre,
-- saldo y descubierto otorgado.
SELECT cli.apellido, cli.nombre, c.saldo, c.descubierto_otorgado
FROM cliente cli
JOIN cliente_x_cuenta cxn ON cli.id = cxn.cliente_id
JOIN cuenta c ON cxn.cuenta_numero = c.numero
WHERE c.saldo < 0 AND c.descubierto_otorgado > 0;

-- 24. Se desea conocer el último acceso de cada cliente al sistema. Mostrar el nombre,
-- apellido y última fecha de acceso.
SELECT cli.nombre, cli.apellido, MAX(ha.acceso) AS ultima_fecha_acceso
FROM cliente cli
JOIN historial_acceso ha ON cli.id = ha.cliente_id
GROUP BY cli.id;

-- 25. Listar el apellido y nombre de todos los empleados del banco. Si poseen cuentas
-- a cargo, mostrar cuántas. Ordenar por apellido y nombre.
SELECT e.apellido, e.nombre, COUNT(c.numero) AS cantidad_cuentas
FROM empleado e
LEFT JOIN cuenta c ON e.legajo = c.ejecutivo_cuenta
GROUP BY e.apellido, e.nombre
ORDER BY e.apellido, e.nombre;

