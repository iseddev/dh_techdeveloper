package Bosque;

import java.util.HashMap;
import java.util.Map;

public class ArbolFactory {

  private Map<String, Arbol> mapArboles;

  // Constructor
  public ArbolFactory() { mapArboles = new HashMap<>(); }

  // Getter
  public Arbol getArbol(int alto, int ancho, String color, String tipo) {

    String key = "key_" + alto + ancho + color;
    if(!mapArboles.containsKey(key)) {
      mapArboles.put(key, new Arbol(alto, ancho, color, tipo));
    }
    return mapArboles.get(key);
  }
}
