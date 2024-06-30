USE dhalmundo;

-- 1. Listar todas las reservas de hoteles realizadas en la ciudad de Nápoles.
SELECT * FROM hoteles H
JOIN hotelesxreserva HR ON HR.idHotel = H.idHotel
WHERE H.ciudad = "Napoles";

-- 2. Listar el número de pago (idpago), el precio, la cantidad de cuotas de todas las
-- reservas realizadas con tarjeta de crédito.
SELECT P.idpago IDPago, MP.nombre MetodoPago, precioTotal Total, cantidadCuotas TotalCuotas FROM pagos P
JOIN metodospago MP ON MP.idmetodospago = P.idmetodospago
WHERE MP.idmetodospago = 3;

-- 3. Listar la cantidad de reservas realizadas de acuerdo al método de pago.
SELECT MP.nombre MetodoPago, COUNT(R.idreserva) TotalReservas FROM reservas R
JOIN pagos P ON P.idPago = R.idPago
JOIN metodospago MP ON MP.idMetodosPago = P.idMetodosPago
GROUP BY MP.nombre;

-- 4. Listar las reservas de los clientes cuyo pago lo hicieron a través de tarjeta de
-- crédito, se pide mostrar el nombre, apellido, país y el método de pago.
SELECT C.nombres Nombre, C.apellidos Apellido, Pais.nombre Pais, MP.nombre MetodoPago FROM clientes C
JOIN paises Pais ON Pais.idPais = C.idPais
JOIN reservas R ON R.idCliente = C.idCliente
JOIN pagos P ON P.idPago = R.idPago
JOIN metodospago MP ON MP.idMetodosPago = P.idMetodosPago
WHERE MP.nombre = "Tarjeta de Credito";

-- 5. Listar la cantidad de reservas de hoteles por país, se necesita mostrar el nombre
-- del país y la cantidad.
SELECT P.nombre Pais, COUNT(idReserva) TotalReservas FROM hoteles H
JOIN hotelesxreserva HR ON HR.idHotel = H.idHotel
JOIN paises P ON P.idPais = H.idPais
GROUP BY P.nombre;

-- 6. Listar el nombre, apellido, número de pasaporte,ciudad y nombre del país de los
-- clientes de origen Peruano.
SELECT nombres Nombre, apellidos Apellido, numeroPasaporte, ciudad, P.nombre Pais FROM clientes C
JOIN  paises P ON P.idPais = C.idPais
WHERE P.nombre = "Peru";

-- 7. Listar la cantidad de reservas realizadas de acuerdo al cliente y el método de
-- pago, mostrar el nombre completo del cliente, y el método de pago, ordenar por apellido.
SELECT apellidos, nombres, COUNT(R.idreserva) TotalReservas, MP.nombre MetodoPago FROM reservas R
JOIN clientes C ON C.idCliente = R.idCliente
JOIN pagos P ON P.idPago = R.idPago
JOIN metodospago MP ON MP.idMetodosPago = P.idMetodosPago
GROUP BY apellidos, nombres, MetodoPago
ORDER BY C.apellidos;

-- 8. Mostrar la cantidad de clientes por país, se necesita visualizar el nombre del
-- país y la cantidad de clientes.
SELECT P.nombre Pais, COUNT(C.idCliente) TotalClientes FROM paises P
LEFT JOIN clientes C ON C.idPais = P.idPais
GROUP BY p.idPais;

-- 9. Listar todas las reservas de hotel, se pide mostrar el nombre del hotel,dirección,
-- ciudad, el país, el tipo de pensión(tipo hospedaje) y que tengan como tipo de hospedaje 'Media pensión'.
SELECT H.nombre Hotel, H.direccion, H.ciudad, TH.nombre TipoHospedaje FROM reservas R
JOIN hotelesxreserva HR ON HR.idReserva = R.idReserva
JOIN hoteles H ON H.idHotel = HR.idHotel
JOIN paises P ON P.idPais = H.idPais
JOIN tiposhospedaje TH ON TH.idTiposHospedaje = HR.idTiposHospedaje
WHERE TH.nombre = "Media Pensión";

-- 10. Mostrar por cada método de pago el monto total obtenido,se pide visualizar el
-- nombre del método de pago y el total.
SELECT MP.nombre MetodoPago, SUM(P.precioTotal) TotalObtenido FROM metodospago MP
JOIN pagos P ON P.idMetodosPago = MP.idMetodosPago
GROUP BY MetodoPago;

-- 11. Mostrar la suma de los pagos realizados en la sucursal de Mendoza, llamar al
-- resultado “TOTAL MENDOZA”.
SELECT S.ciudad, SUM(P.precioTotal) TotalMendoza FROM sucursales S
JOIN reservas R ON R.idSucursal = S.idSucursal
JOIN pagos P ON P.idPago = R.idPago
WHERE S.ciudad = "Mendoza";

-- 12. Listar todos los clientes que no han realizado reservas.
SELECT C.* FROM reservas R
RIGHT JOIN clientes C ON C.idCliente = R.idCliente
WHERE r.idreserva IS NULL;

-- 13. Listar todas las reservas de vuelos realizadas donde el origen sea Chile y el
-- destino Ecuador, mostrar el código de la reserva, número de vuelo, fecha de
-- partida, fecha de llegada, fecha de la reserva.
SELECT R.codigoReserva, V.nroVuelo, V.fechaPartida, V.fechaLlegada, R.fechaRegistro FROM vuelos V
JOIN vuelosxreserva VR ON VR.idVuelo = V.idVuelo
JOIN reservas R ON R.idReserva = VR.idReserva
WHERE V.origen = "Chile" AND V.destino = "Ecuador";

-- 14. Listar el nombre y cantidad de habitaciones de aquellos hoteles que tengan de
-- 30 a 70 habitaciones pertenecientes al país Argentina.
SELECT H.nombre Hotel, cantidadHabitaciones, P.nombre Pais FROM hoteles H
JOIN paises P ON P.idPais = H.idPais
WHERE (cantidadHabitaciones BETWEEN 30 AND 70) AND P.nombre = "Argentina";

-- 15. Listar el top 10 de hoteles más utilizados y la cantidad de reservas en las que ha
-- sido reservado.
SELECT H.nombre Hotel, COUNT(HR.idReserva) TotalReservas FROM hoteles H
JOIN hotelesxreserva HR ON HR.idHotel
GROUP BY H.idHotel ORDER BY TotalReservas DESC LIMIT 10;


-- 16. Listar los clientes (nombre y apellido) que pagaron con transferencia bancara o
-- en efectivo, esta lista deberá estar ordenada por apellidos de manera ascendente.
SELECT C.nombres Nombre, C.apellidos Apellido, MP.nombre MetodoPago FROM clientes C
JOIN reservas R ON R.idCliente = C.idCliente
JOIN pagos P ON P.idPago = R.idPago
JOIN metodospago MP ON MP.idMetodosPago = P.idMetodosPago
WHERE P.idMetodosPago BETWEEN 1 AND 2
ORDER BY C.apellidos;

-- 17. Listar la cantidad de reservas que se realizaron para los vuelos que el origen ha
-- sido de Argentina o Colombia, cuyo horario de partida sean las 18:11 hs. Mostrar
-- la cantidad de vuelos y país de origen.
SELECT V.origen, COUNT(*) TotalVuelos FROM reservas R
JOIN vuelosxreserva VR ON VR.idReserva = R.idReserva
JOIN vuelos V ON V.idVuelo = VR.idVuelo
-- WHERE origen IN("ARGENTINA", "COLOMBIA") AND fechaPartida LIKE "%18:11%";
WHERE (origen LIKE "Argentina" OR origen LIKE "Colombia") AND fechaPartida LIKE "%18:11%"
GROUP BY V.origen;

-- 18. Mostrar los totales de ventas de sucursales por países y ordenarlas de mayor a menor.
SELECT * FROM paises;
SELECT * FROM sucursales;
SELECT Pais.nombre NombrePais, SUM(precioTotal) TotalVentasSucursales FROM paises Pais
JOIN sucursales Suc ON Suc.idPais = Pais.idPais
JOIN reservas R ON R.idSucursal = Suc.idsucursal
JOIN pagos Pago ON Pago.idPago = R.idPago
GROUP BY NombrePais
ORDER BY TotalVentasSucursales DESC;

-- 19. Mostrar los países que no tienen clientes asignados ordenados por los que
-- empiezan por Z primero.
SELECT P.nombre NombrePais, COALESCE(C.idCliente, 0) TotalClientes FROM clientes C
RIGHT JOIN paises P ON P.idPais = C.idPais
WHERE C.idCliente IS NULL
ORDER BY NombrePais DESC;

-- 20. Generar un listado con los hoteles que tuvieron más de 2 reservas realizadas.
-- Mostrar el nombre del hotel y la cantidad.
SELECT HR.idHotel IDHotel, H.nombre Hotel, COUNT(HR.idReserva) TotalReservas FROM hoteles H
JOIN hotelesxreserva HR ON HR.idHotel = H.idHotel
GROUP BY IDHotel HAVING TotalReservas > 2
ORDER BY IDHotel;