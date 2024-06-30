-- Vamos a practicar sobre consultas SELECT, enfocándonos en distintos tipos de JOINS.
-- Tips:
-- * Cada enunciado se corresponde con una consulta SELECT.
-- * Recordá ir guardando las consultas. SQL.

-- Reportes parte I - Repasamos INNER JOIN
-- Realizar una consulta de la facturación de e-market. Incluir la siguiente información:
USE emarket;

-- ● Id de la factura
SELECT FacturaID FROM facturas;

-- ● fecha de la factura
SELECT FechaFactura FROM facturas;

-- ● nombre de la empresa de correo
SELECT Compania FROM correos;

-- ● nombre del cliente
SELECT Contacto FROM clientes;

-- ● categoría del producto vendido
SELECT CategoriaID FROM categorias;

-- ● nombre del producto
SELECT ProductoNombre FROM productos;

-- ● precio unitario
SELECT PrecioUnitario FROM facturadetalle;

-- ● cantidad
SELECT cantidad FROM facturadetalle;

-- Union de todas las consultas en un solo reporte
SELECT facturas.FacturaID,
FechaFactura,
clientes.Compania,
Contacto,
categorias.CategoriaID,
ProductoNombre,
facturadetalle.PrecioUnitario,
facturadetalle.cantidad FROM facturas
INNER JOIN correos ON CorreoID = EnvioVia
INNER JOIN clientes ON clientes.ClienteID = facturas.CLienteID
INNER JOIN facturadetalle ON facturadetalle.FacturaID = facturas.FacturaID
INNER JOIN productos ON productos.ProductoID = facturadetalle.ProductoID
INNER JOIN categorias ON categorias.CategoriaID = productos.CategoriaID;

-- ########## Reportes parte II - INNER, LEFT Y RIGHT JOIN ##########
-- 1. Listar todas las categorías junto con información de sus productos. Incluir todas
-- las categorías aunque no tengan productos.
SELECT categorias.CategoriaID, ProductoNombre FROM categorias
LEFT JOIN productos ON productos.CategoriaID = categorias.CategoriaID
ORDER BY CategoriaID;

-- 2. Listar la información de contacto de los clientes que no hayan comprado nunca en emarket.
SELECT contacto, clientes.ClienteID, facturaID FROM clientes
LEFT JOIN facturas ON facturas.ClienteID = clientes.ClienteID
WHERE facturas.ClienteID IS NULL;

-- 3. Realizar un listado de productos. Para cada uno indicar su nombre, categoría, y
-- la información de contacto de su proveedor. Tener en cuenta que puede haber
-- productos para los cuales no se indicó quién es el proveedor.
SELECT productos.CategoriaID, ProductoNombre, Compania, Contacto FROM productos
LEFT JOIN proveedores ON proveedores.ProveedorID = productos.ProveedorID
ORDER BY CategoriaID;

-- 4. Para cada categoría listar el promedio del precio unitario de sus productos.
SELECT categorias.CategoriaID, COALESCE(AVG(PrecioUnitario), "Sin información") PrecioPromedio FROM categorias
LEFT JOIN productos ON categorias.CategoriaID = productos.CategoriaID
GROUP BY categorias.CategoriaID;

-- 5. Para cada cliente, indicar la última factura de compra. Incluir a los clientes que
-- nunca hayan comprado en e-market.
SELECT clientes.contacto, COALESCE(max(FechaFactura), "Sin Compras") UltimaCompra FROM clientes
LEFT JOIN facturas ON facturas.ClienteID = clientes.ClienteID
GROUP BY clientes.contacto;

-- 6. Todas las facturas tienen una empresa de correo asociada (enviovia).
-- Generar un listado con todas las empresas de correo, y la cantidad de facturas
-- correspondientes. Realizar la consulta utilizando RIGHT JOIN.
SELECT CorreoID, Compania, Telefono, COUNT(FacturaID) TotalFacturas FROM facturas
RIGHT JOIN correos ON CorreoID = EnvioVia
GROUP BY CorreoID;
