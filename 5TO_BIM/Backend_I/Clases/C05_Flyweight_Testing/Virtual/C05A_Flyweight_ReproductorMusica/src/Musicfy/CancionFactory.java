package Musicfy;

import java.util.HashMap;
import java.util.Map;

public class CancionFactory {

  // Creamos una lista para almacenar el id(String) y una canción(Cancion)
  private final Map<String, Cancion> listaCanciones;

  // Creamos el constructor de CancionFactory que creará una lista de canciones
  public CancionFactory() { listaCanciones = new HashMap<>(); }

  // Método que nos ayuda a obtener una canción(Cancion).
  // => Si existe, devuelve esa canción.
  // => Si NO existe, crea la canción con los argumentops recibidos. Parte de la optimización de creación de objetos.
  public Cancion getCancion(String nombre, String artista, String genero) {

    // Creamos un id compuesto por la concatenación de los argumentos recibidos
    String id = nombre + artista + genero;

    // Validamos si NO existe la canción con el id generado
    if(!listaCanciones.containsKey(id)) {
      // Si no existe, se añade a la lista esta canción con sus correspondientes valores
      listaCanciones.put(id, new Cancion(nombre, artista, genero));
      System.out.println("CANCIÓN CREADA: " + nombre);
    }

    // Retornamos la canción requerida(ya sea que ya existiese o la nueva que se generó)
    return listaCanciones.get(id);
  }
}