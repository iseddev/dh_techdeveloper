package Ejercicio_03;

public class Cuenta {

    private Estado estado;

    public Cuenta() { setEstado(new Activa()); }
    // Otra forma de lograr lo anterior es como sigue:
    // public Cuenta() { estado = new Activa(); }

    public void setEstado(Estado estado) { this.estado = estado; }
    public void cambiarEstado() { estado.controlarEstado(this); }
    public void verEstado() { estado.verEstado(); }
}
