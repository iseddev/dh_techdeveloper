package Bosque;

public class Main {
  public static void main(String[] args) {
    ArbolFactory factory = new ArbolFactory();

    for (int i = 0; i < 500000; i++) {
      System.out.println(factory.getArbol(10, 3, "verde", "ornamental"));
      System.out.println(factory.getArbol(5, 2, "rojo", "frutal"));
    }

    Runtime runtime = Runtime.getRuntime();
    System.out.println(">>> Memoria usada (en Mb): " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024) + " <<<");
  }
}
