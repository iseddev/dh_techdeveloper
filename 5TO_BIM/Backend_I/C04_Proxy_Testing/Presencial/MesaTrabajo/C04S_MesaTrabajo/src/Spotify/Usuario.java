package Spotify;

public class Usuario {
    private String identificador;
    private TipoUsuario tipoUsuario;

    public Usuario(String identificador, TipoUsuario tipoUsuario) {
        this.identificador = identificador;
        this.tipoUsuario = tipoUsuario;
    }

    public String getIdentificador() { return identificador; }
    public TipoUsuario getTipoUsuario() { return tipoUsuario; }
}
