use el_descubierto;

-- ##### Consigna - CheckPoint II #####

-- 1. Listar todos los clientes cuyo nombre comience con la letra "A". Se debe mostrar
-- id como "Número de cliente", apellido y nombre.

-- 2. Mostrar el número de la sucursal con domicilio "Ramón Freire Serrano 7410".

-- 3. Se requiere saber cuál es el mayor importe prestado

-- 4. Listar los pagos realizados con números 10, 14, 27, 45.

-- 5. Calcular el total de los pagos realizados para el préstamo número cuarenta. El
-- reporte debe tener dos columnas denominadas "Número de préstamo" y el
-- "Total pagado".

-- 6. Listar los empleados que no pertenezcan a la sucursal dos y que la fecha de alta
-- del contrato sea mayor que 5/09/21 o igual a 25/06/21. Ordenar por alta de
-- contrato.

-- 7. Listar los pagos realizados con importe entre $1030,25 a $1666,66 (ordenarlos
-- por el importe pagado de mayor a menor).
SELECT COUNT(importe) AS PaymentNumber, importe Amount FROM pago
GROUP BY importe HAVING importe BETWEEN "1030.25" AND "1666.66"
ORDER BY importe DESC;

-- 8. Mostrar el quinto pago realizado con menor importe.
SELECT id, importe FROM pago
ORDER BY importe LIMIT 1 OFFSET 5;

-- 9. Mostrar el préstamo con mayor importe. Este reporte debe contener el número
-- del préstamo, la fecha de otorgamiento y el importe.

-- 10. Mostrar las diez cuentas bancarias con menor saldo. Este reporte debe contener
-- el número de cuenta, saldo y el código del tipo de cuenta.

-- 11. Listar los préstamos otorgados entre 10/07/21 al 10/08/21 (ordenarlos por fecha
-- de otorgamiento)

-- 12. Listar en forma ordenada las cuentas bancarias que tengan un descubierto
-- otorgado superior o igual a $8999,80.

-- 13. Listar todos los empleados cuyo apellido termine con los caracteres "do". Se
-- debe mostrar el legajo, apellido, nombre y email.

-- 14. Se desea conocer cuál es el promedio de los saldos de las cajas de ahorro

-- 15. Mostrar el tercer préstamo con mayor importe.

-- 16. Calcular la cantidad de cuentas que tiene la sucursal número cinco. El reporte
-- debe tener dos columnas denominadas "Sucursal" y el "Cantidad de Cuentas".

-- 17. Mostrar todas las ciudades que contengan una palabra de cinco caracteres, pero
-- el tercer carácter debe ser igual a "n".

-- 18. Modificar el tipo de cuenta bancaria "Cuenta Corriente" a "Cuenta Especial"

-- 19. En la fecha de hoy, agregar en la sucursal número nueve al empleado Quinteros
-- Arias Raúl Alejandro con domicilio en Av. 25 de mayo 7410 - Pilar - Buenos Aires,
-- mail: quiteros2021bs@gmail.com, teléfono móvil: '+5491154000745'.

-- 20. Eliminar el registro del préstamo número cuarenta y cinco.

-- 21. Mostrar el importe total prestado por el banco a sus clientes.

-- 22. Mostrar la cantidad total de cuentas activas que están registradas en el banco.

-- 23. Mostrar el apellido y la cantidad de clientes que poseen el mismo apellido.

-- 24. Mostrar el id del país y la cantidad de ciudades que posee cada uno de ellos.

-- 25. Necesitamos saber la cantidad de préstamos por sucursal y día otorgado. ¿Hay
-- sucursales que hayan realizado más de un préstamo el mismo día?