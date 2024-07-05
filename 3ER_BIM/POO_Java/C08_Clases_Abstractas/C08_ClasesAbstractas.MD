# Clases Abstractas

Una clase abstracta es aquella que por si mismas no se pueden identificar con algo _concreto_ (no existen como tal en el mundo real), pero **sí** poseen determinadas características que son comunes entre otras clases que heredarán de esta [no está permitido instanciar (crear objetos) a partir de una Clase Abstracta].

Estas Clases Abstractas nos permiten declarar métodos(que llamaremos abstractos también), pero **no** estarán implementados, es decir, que no harán nada en la Clase Abstracta, pero **obligarán** a las Subclases a implementarlos y **_sobreescribirlos_**.

![Diagrama UML](./C08_ClasesAbstractas_UML.svg)

## Código
  
```java
// Clase Abstracta
public abstract class Animal {
  private String nombre;
  private int edad;
  private boolean estaVacunado;

  public abstract void hacerSonido();
}

// Clase Perro que hereda de Animal (mediante la directiva extends), se sobreescribe el método hacerRuido() (mediante la directiva @Override)
public class Perro extends Animal {
  
  @Override
  public void hacerSonido() {
    System.out.println("Guau guau");
  }
}

// Gato hereda de Animal, mismo proceso que Perro
public class Gato extends Animal {
  
  @Override
  public void hacerSonido() {
    System.out.println("Miau miau");
  }
}

// Perico hereda de Animal, mismo proceso que Perro
public class Perico extends Animal {
  
  @Override
  public void hacerSonido() {
    System.out.println("Pio pio");
  }
}

// Clase Main
public class Main {
  public static void main(String[] args) {

    Perro rufo = new Perro("Rufo", 5, true);
    Gato silvestre = new Gato("Silvestre", 3, false);
    Perico pico = new Perico("Pico", 1, true);

    rufo.hacerSonido();
    silvestre.hacerSonido();
    pico.hacerSonido();

    /*
    List<Animal> animales = new ArrayList<>();
    animales.add(new Perro());
    animales.add(new Gato());
    animales.add(new Perico());
    */

    /*
    Animal[] animales = new Animal[3];
    animales[0] = new Perro();
    animales[1] = new Gato();
    animales[2] = new Perico();
    */

    // for (Animal animal : animales) { animal.hacerSonido(); }

  }
}
```