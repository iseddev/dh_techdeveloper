package DocsDrive;

import java.util.ArrayList;
import java.util.List;

public class Validador implements IValidador {

  private List<Documento> listaAccesos;

  public Validador() { this.listaAccesos = new ArrayList<>(); }

  public void agregarAcceso(Documento documento) { listaAccesos.add(documento); }

  public List<Documento> getListaAccesos() { return listaAccesos; }

  // Método que debe ejecutarse al momento de que se haya validado de forma EXITOSA el acceso al documento
  @Override
  public String validarAcceso(Documento documento) {
    this.agregarAcceso(documento);
    return "Acceso confirmado al documento: " + documento.getId()
        + ", en la URL: " + documento.getUrl()
        + ", contenido: " + documento.getContenido();
  }
}