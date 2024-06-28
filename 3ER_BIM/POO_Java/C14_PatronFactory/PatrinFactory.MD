# Patron Factory

## Propósito Creacional

Patrón de diseño creacional que proporciona una interfaz para crear una interfaz (interface, puede aplicarse tambien mediante Clases Abstractas) para crear objetos en una superclase, mientras permite a las subclases alterar el tipo de objetos que se crearán.  

Este patrón sugiere que, en lugar de llamar al operador `new` para construir objetos directamente, se invoque a un ***método fábrica especial***. No te preocupes: los objetos se siguen creando a través del operador `new`, pero se invocan desde el método fábrica. Los objetos devueltos por el método fábrica a menudo se denominan productos.
