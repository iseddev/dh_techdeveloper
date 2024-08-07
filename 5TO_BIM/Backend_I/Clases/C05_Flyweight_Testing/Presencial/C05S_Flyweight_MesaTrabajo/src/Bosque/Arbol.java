package Bosque;

public class Arbol {
  private int alto, ancho;
  private String color, tipo;

  public Arbol(int alto, int ancho, String color, String tipo) {
    this.alto = alto;
    this.ancho = ancho;
    this.color = color;
    this.tipo = tipo;
    System.out.println("Nuevo árbol " + tipo + " creado");
  }
}
