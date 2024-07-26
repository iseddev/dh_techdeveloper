package Presencial01;

public class Empleado {
    private String nombre, apellido, numeroDeCuenta;

    public Empleado(String nombre, String apellido, String numeroDeCuenta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getNumeroDeCuenta() { return numeroDeCuenta; }

    public void setNoombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setNumeroDeCuenta(String numeroDeCuenta) { this.numeroDeCuenta = numeroDeCuenta; }
}
