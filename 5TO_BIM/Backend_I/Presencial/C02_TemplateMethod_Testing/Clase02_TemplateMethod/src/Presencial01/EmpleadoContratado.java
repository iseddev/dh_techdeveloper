package Presencial01;

public class EmpleadoContratado extends Empleado {

    private Double valorPorHora;
    private Integer cantidadHoras;

    public EmpleadoContratado(String nombre, String apellido, String numeroDeCuenta, Double valorPorHora, Integer cantidadHoras) {
        super(nombre, apellido, numeroDeCuenta);
        this.valorPorHora = valorPorHora;
        this.cantidadHoras = cantidadHoras;
    }


    public Double getValorPorHora() { return valorPorHora; }
    public Integer getCantidadHoras() { return cantidadHoras; }

    public void setValorPorHora(Double valorPorHora) { this.valorPorHora = valorPorHora; }
    public void setCantidaDeHoras(Integer cantidaDeHoras) { this.cantidadHoras = cantidadHoras; }
}
