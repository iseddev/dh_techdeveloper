# ¡Vamos a practicar!

Luego de recorrer el contenido de la clase de hoy, llegó tu turno de poner en práctica lo visto. Tenemos que crear una entidad que se llame Pacientes en la base de datos H2 que tenga los siguientes campos: nombre, apellido, domicilio, DNI, fecha de alta, usuario y password.

*¿Qué debés hacer?*

* Crear una connection a la base de datos e insertar una fila paciente.
* Luego, abrir una transacción (setAutocommit(false)) y asignar otro password con una sentencia update y, paso siguiente, generar una excepción (throw new Exception).
* Por último, corroborar con una consulta que el paciente existe y que el campo password mantuvo su valor inicial del punto 1.
