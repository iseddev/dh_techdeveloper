package DocsDrive;

import java.util.ArrayList;
import java.util.List;

public class Documento {
  private String id, url, contenido;
  private Autorizados autorizados;

  public Documento(String id, String url, String contenido, Autorizados autorizados) {
    this.id = id;
    this.url = url;
    this.contenido = contenido;
    this.autorizados = autorizados;
  }

  public String getId() { return id; }
  public String getUrl() { return url; }
  public String getContenido() { return contenido; }
  public  Autorizados getAutorizados() { return autorizados; }

//  public void setId(String id) { this.id = id; }
//  public void setUrl(String url) { this.url = url; }
//  public void setContenido(String contenido) { this.contenido = contenido; }
//  public void setAutorizados(Autorizados autorizados) { this.autorizados = autorizados; }
}