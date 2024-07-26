package Spotify;

public class ServicioDescarga implements IServicioDescarga {
    @Override
    public String descargar(Usuario usuario) {
        return "Descargando canción para el usuario: " + usuario.getIdentificador();
    }
}