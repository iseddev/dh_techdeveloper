package Musicfy;

public class Cancion {

  private String nombre, artista, genero;

  public Cancion(String nombre, String artista, String genero) {
    this.nombre = nombre;
    this.artista = artista;
    this.genero = genero;
  }

  public String getNombre() { return nombre; }
  public String getArtista() { return artista; }
  public String getGenero() { return genero; }
}