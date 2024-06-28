package MesaTrabajo;

public class UsuarioJuego {
    private String nombre;
    private String clave;
    private double puntaje;
    private int nivel;

    public UsuarioJuego(String nombre, String clave, double puntaje, int nivel) {
        this.nombre = nombre;
        this.clave = clave;
        this.puntaje = puntaje;
        this.nivel = nivel;
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getClave() { return clave; }

    public void setClave(String clave) { this.clave = clave; }

    public double getPuntaje() { return puntaje; }

    public void setPuntaje(double puntaje) { this.puntaje = puntaje; }

    public int getNivel() { return nivel; }

    public void setNivel(int nivel) { this.nivel = nivel; }

    public void aumentarPuntaje() { puntaje++; }
    public  void  subirNivel() { nivel++; }
    public  void bonus(double valor) { puntaje += valor; }
}
