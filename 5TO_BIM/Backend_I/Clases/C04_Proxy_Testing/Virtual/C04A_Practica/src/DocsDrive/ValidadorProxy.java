package DocsDrive;

public class ValidadorProxy implements IValidador {

  private Validador validador;

  public ValidadorProxy() { this.validador = new Validador(); }

  // De acuerdo a las instrucciones, se debe pasar como argumentos una "url" y un "email" que nos ayudaran a validar si se permite o no el acceso al documento solicitado.
  @Override
  public String validarAcceso(Documento documento) {
    if(documento.getAutorizados() == Autorizados.AUTHORIZED) {
      return validador.validarAcceso(documento);
    } else { return "Error en credenciales de acceso..."; }
  }
}