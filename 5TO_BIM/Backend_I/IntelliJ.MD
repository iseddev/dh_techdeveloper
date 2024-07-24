# Guía de uso de IntelliJ para programas en Java

## Crear programa abriendo IntelliJ desde cero

### Una vez abierto IntelliJ, vamos a crear un nuevo proyecto realizando los siguientes pasos:

#### IntelliJ con ventana de inicio por defecto

1. Si el IntelliJ está configurado para abrir la ventana de bienvenida inicial, simplemente hay que hacer click en la pestaña _Nuevo Proyecto_(**New Project**).
2. En el apartado _Nombre_(**Name**), vamos a ingresar el nombre que le vayamos a dara a nuestro proyecto.
3. En el apartado _Ubicación_(**Location**) vamos a seleccionar la carpeta/directorio donde vamos a guardar el proyecto y en el menu de selección hacemos click en _Guardar_(**OK**).
4. De forma opcional, podemos activar la casilla para crear un repositorio de Git.
5. En el apartado de _JDK_, es recomendable seleccionar la versión mas reciente del JDK. _A menos que el proyecto requiera de una versión del JDK específico._
6. Para el apartado de _Configuraciones Avanzadas_(**Advanced Settings**), no es necesario modificar nada.
7. Hacer click en _Crear_(**Create**).
   **IntelliJ realizará las configuraciones necesarias para iniciar el proyecto y se desplegará la ventana de trabajo de IntelliJ con nuestro proyecto creado.**

#### Inicializar de los componentes de nuestro proyecto

Si todo salió bien, podremos visualizar en la ventana lateral derecha nuestra carpeta del proyecto que acabamos de crear, que generalmente tendrá la siguiente estructura:

```
ProjectDirectoryName
    .idea
    src
    .gitignore
    ProjectDirectoryName.iml
External Libraries
Scratches and Consoles
```

En nuestra carpeta/directorio **`src`** es donde vamos a tener todo nuestro código fuente.
Para mantener una estructura lo mejor modularizada posible de nuestro proyecto, vamos a crear en nuestra carpeta/directorio `src` un paquete, por lo que vamos a hacer click derecho con el mouse sobre `src`, del menú contextual desplegado, vamos a _`Nuevo`_(**New**), después hacemos click en `Package`.

Ahora, definimos el nombre de nuestro paquete y damos `Enter`. Lo recomendable es que concuerde con el objetivo de nuestro proyecto.
Veremos como se crea un directorio
con el nombre de nuestro paquete dentro de `src`. Podemos tener maś de un paquete dentro de un mismo proyecto, todo depende de las necesidades de nuestro desarrollo.
Ahora es momento de crear nuestras _clases_(**Class**). Lo recomendable es que en cada paquete exists una clase principal, que por buenas prácticas y convención, la llamaremos `Main`.

Para crear esta clase, hacemos click derecho sobre nuestro paquete recién creado, del menú contextual vamos a _Nuevo_(**New**) y seleccionamos `Java Class`, ingresamos _Main_ y damos `Enter`.

> _Es importante recordar que el nombre de las clases debe iniciar siempre con la primera letra en **mayúscula**, esto por convención y para evitar conflictos futuros. En caso de que que nuestra clase se conforme por dos o más palabras, debemos escribir las palabra subsecuentes con mayúscula su letra inicial. Por ejemplo:_ > `Main`, `TestingClass`, `SecondaryTestingClass`, etc.
