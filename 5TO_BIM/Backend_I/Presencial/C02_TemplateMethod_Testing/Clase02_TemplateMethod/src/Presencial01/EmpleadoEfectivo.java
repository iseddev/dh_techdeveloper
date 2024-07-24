package Presencial01;

public class EmpleadoEfectivo extends Empleado {
    private Double sueldoBasico, premios, descuentos;

    public EmpleadoEfectivo(String nombre, String apellido, String numeroDeCuenta, Double sueldoBasico, Double premios, Double descuentos) {
        super(nombre, apellido, numeroDeCuenta);
        this.sueldoBasico = sueldoBasico;
        this.premios = premios;
        this.descuentos = descuentos;
    }

    public Double getSueldoBasico() { return sueldoBasico; }
    public Double getPremios() { return premios; }
    public Double getDescuentos() { return descuentos; }

    public void setSueldoBasico(Double sueldoBasico) { this.sueldoBasico = sueldoBasico; }
    public void setPremios(Double premios) { this.premios = premios; }
    public void setDescuentos(Double descuentos) { this.descuentos = descuentos; }
}
