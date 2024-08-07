package Computadoras;

import java.util.HashMap;
import java.util.Map;

public class ComputadoraFactory {

    private final Map<String, Computadora> mapComputadoras;

    // Constructor
    public ComputadoraFactory() { mapComputadoras = new HashMap<>(); }

    // Si computadora no existe, la vamos a crear
    public Computadora getComputadora(Integer ram, Integer discoDuro, String modelo) {

        // Variable para identificar cada computadora y mostrarlo por consola
        String clave = "key: " + ram + discoDuro + modelo;
        System.out.println(clave);

        // Lógica para validar si existe o no una computadora
        if(!mapComputadoras.containsKey(clave)) {
            // Creación de una nueva computadora y se agrega al mapa
            mapComputadoras.put(clave, new Computadora(ram, discoDuro, modelo));
        }
        return mapComputadoras.get(clave);
    }
}
