# Patrones de Diseño

Prácticamente en todas las áreas se desarrollan estándares para realizar algún procedimiento. En informática no es diferente. Como su nombre indica, utilizar un patrón de diseño es correspondiente a utilizar una estructura de programación ya conocida y consolidada en el mercado, cuya función está previamente definida. Un patrón de diseño, también conocido por el término original en inglés ***design pattern***, describe una solución general reutilizable para un problema recurrente en el desarrollo de sistemas de
software orientados a objetos. No es un código prefabricado, una versión final, sino un modelo de cómo resolver un determinado problema. Los patrones de diseño definen las relaciones e interacciones entre clases u objetos, sin especificar los detalles de los involucrados.

Conceptualmente, un patrón de diseño debe definir: un nombre, el problema, la solución, cuándo aplicar esa solución y las consecuencias de hacerlo.

Podemos decir que los patrones de diseño son plantillas que previamente se han desarrollado por un tercero que nos sirven como una guía para solucionar un problema en específico. Estos patrones nos ayudan a resolver problemas comunes en el desarrollo de software, nos permiten reutilizar código y nos ayudan a mantener un código limpio y ordenado.

* ### Creacional
    Tienen por objetivo *abstraer* el proceso de cómo se crean los objetos dentro de la aplicación. Proporcionan interfaces(plantillas) para crear objetos y copiar objetos ya existentes y producir familias de objetos relacionados sin tener que especificar sus Clases concretas. Además nos permite producir diferentes tipos de representaciones usando el mismo código.

    * #### Patron ***Singleton***
        Garantiza que una clase tenga una única instancia y proporciona un punto de acceso global a ella.
        * Una Clase administra su propia instancia y evita que cualquier otra clase cree una instancia de ella.
        * Para crear la instancia, debe pasar obligatoriamente por la Clase, ninguna otra Clase puede crear una instancia de ella.
        * Proporciona un punto de acceso global a su instancia.
        * La Clase en sí siempre ofrecerá su propia instancia y, si aún no tiene una, la crea y devuelve esta instancia recién creada.
        ```java
        public class Singleton {
            // Atributo con el mismo nombre de ls Clase
            private static Singleton instance = new Singleton();

            // Constructor(es) privado(s)
            private Singleton() {
                // Code here ...
            }

            // Método getInstance estático
            public static Singleton getInstance() {
                // Code here ...
                return instance;
            }
        }
        ```

    * #### Patrón ***Factory Method***
        Define una interfaz para crear un objeto, pero deja que las subclases decidan qué clase instanciar. Permite a una clase delegar la responsabilidad de la creación de instancias a una o más subclases.
        ```java
        public abstract class Gaseosa {
            private String nombre;

            public String getNombre() { return nombre;}
            public void abrir(){
                System.out.println("Abriendo la gaseosa " + getNombre());
            }
            public abstract Product factoryMethod();
        }

        public class GaseosaCola extends Gaseosa {
            String nombre = "Coca Cool";

            @Override
            public String getNombre() { return nombre; }
            
            @Override
            public void abrir() { super.abrir(); }
            }
        }

        public class GaseosaNaranja extends Gaseosa {
            String nombre = "Naranja Cool";

            @Override
            public String getNombre() { return nombre; }
            
            @Override
            public void abrir() { super.abrir(); }
            }
        }

        public class GaseosaFactory {
            public static Gaseosa construir(String tipo) {
                try {
                    switch (tipo) {
                        case "coca":
                            return new GaseosaCola();
                        case "naranja":
                            return new GaseosaNaranja();
                    }
                } catch (Exception err) {
                    System.err.println("ERROR!!! " + err);
                    return null;
                }
            }
        }

        public static void main(String[] args) {
            Gaseosa gaseosaCoca = GaseosaFactory.construir("coca");
            gaseosaCoca.abrir();

            Gaseosa gaseosaNaranja = GaseosaFactory.construir("naranja");
            gaseosaNaranja.abrir();

            Gaseosa gaseosaUva = GaseosaFactory.construir("uva");
            gaseosaUva.abrir();

        }
        ```
    * #### Patrón ***Abstract Factory***
        Proporciona una interfaz para crear familias de objetos relacionados o dependientes sin especificar sus Clases concretas.

* ### Comportamiento
    Se encarga de las *relaciones* entre Objetos y Clases, las distribuciones de responsabilidades en la aplicación. Algunos de estos patrones hacen uso de la Herencia para estudiar el comportamiento de las Clases y otros utilizan la COmposición para distinguir ese comportamiento.

* ### Estructural
    Lidia con la composición de una Clase y Objeto. Este patron habilita la colaboración de los Objetos con interfaces incompatibles agregando nuevos comportamientos, por lo que se puede dividir una Clase o un conjunto de Clases estrechamente vinculadas en dos jerarquías separadas: Abstracción e Implementación que pueden ser desarrolladas independientemente una de la otra. Otra funcionalidad es la composición de Objetos en una estructuras de árbol y luego trabajar con esas estructuras como si fueran Objetos individuales.

## Herencia

La Herencia es un mecanismo que permite la creación de una nueva clase a partir de una clase existente. La nueva clase hereda los atributos y métodos de la clase existente y puede añadir nuevos atributos y métodos. La clase existente se conoce como clase base o superclase y la nueva clase se conoce como clase derivada o subclase.
```java
public class Animal {
    // code here ...
}
public class Perro extends Animal {
    // code here ...
}
public class Gato extends Animal {
    // code here ...
}
```

## Composición
En lugar de codificar un comportamiento de forma estática (como se hace con la Herencia), definimos pequeños comportamientos predeterminados y los usamos para declarar comportamientos mas complejos:
```java
public class Sistema {
    public class Sistema {
        Persona persona = new Persona();
        // Code here ...
    }
    public class Persona {
        // Code here ...
    }
}
```

## ¿Cuándo usar la Herencia?
En general, siempre se prefiere usar la Composición sobre la Herencia, sin embargo, podemos definir algunas reglas para identificar cuándo podemos usar la Herencia para que no tengamos los problemas de conlleva.

1. La Herencia su usa si una instancia de una Clase hija nunca necesitará convertirse en un Objeto de otra Clase.
2. Si la jerarquía de Herencia representa una relación "*Es una*" y no tiene una relación "*Tiene una*".
3. Si se desea o necesita realizar cambios globales en las Clases secundarias cambiando la Clase principal.
4. Cuando la Clase secundaria se extiende en lugar de reemplazar total o parcialmente las responsabilidades de la Clase principal.