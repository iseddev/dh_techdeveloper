package Musicfy;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {

    CancionFactory factory = new CancionFactory();

    Cancion inBloom = factory.getCancion("In bloom", "Nirvana", "Grunge");
    Cancion sadButTrue = factory.getCancion("Sad but true", "Metallica", "Rock");
    Cancion feuerUndWasser = factory.getCancion("Feuer und Wasser", "Rammsteim", "Industrial");
    Cancion freiflug = factory.getCancion("Freiflug", "Megahertz", "Industrial");
    Cancion breakingTheHabit = factory.getCancion("Breaking the habit", "Linkin Park", "Urban Rock");
    Cancion ieaiaio = factory.getCancion("i-e-a-i-a-i-o", "System of a Down", "Rock");
    // Instancias duplicadas
    Cancion inBloom2 = factory.getCancion("In bloom", "Nirvana", "grunge");
    Cancion feuerUndWasser2 = factory.getCancion("Feuer und Wasser", "Rammsteim", "Industrial");
    Cancion sadButTrue2 = factory.getCancion("Sad but true", "Metallica", "Rock");
    Cancion breakingTheHabit2 = factory.getCancion("Breaking the habit", "Linkin Park", "Urban Rock");

    ListaReproduccion lista1 = new ListaReproduccion("Lista Reproducción 1");
    lista1.agregarCancion(inBloom);
    lista1.eliminarCancion(inBloom);
    lista1.agregarCancion(inBloom);
    lista1.agregarCancion(sadButTrue);
    lista1.eliminarCancion(sadButTrue);
    lista1.agregarCancion(sadButTrue);
    lista1.agregarCancion(feuerUndWasser);
    lista1.eliminarCancion(feuerUndWasser);
    lista1.agregarCancion(feuerUndWasser);
    lista1.agregarCancion(freiflug);
    lista1.agregarCancion(breakingTheHabit);
    lista1.agregarCancion(breakingTheHabit2);
    lista1.agregarCancion(ieaiaio);
    System.out.println("Lista de reproducción >>>>>" + lista1.getNombre() + "<<<<<");
    lista1.getListaCanciones();
  }
}
