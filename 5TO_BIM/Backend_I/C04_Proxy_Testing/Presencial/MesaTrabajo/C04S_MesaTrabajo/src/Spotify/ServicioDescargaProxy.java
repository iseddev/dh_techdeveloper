package Spotify;

public class ServicioDescargaProxy implements IServicioDescarga {
    ServicioDescarga servicioDescarga;

    public ServicioDescargaProxy() { this.servicioDescarga = new ServicioDescarga(); }

    @Override
    public String descargar(Usuario usuario) {
        if(usuario.getTipoUsuario() == TipoUsuario.PREMIUM) {
            return servicioDescarga.descargar(usuario);
        } else { return "Usuario FREE, no es posible descargar canción..."; }
    }
}
