package Herencia;

/*
* Un gimnasio que ya tiene implementado un sistema que cuenta con un módulo para el cobro de cuota de sus socios. Los socios en el sistema poseen un código de socio, nombre, cuota mensual, actividad que realiza -esto es sólo el nombre de la actividad-.
* Todos los socios pagan, además de la cuota mensual, el equivalente al 5% de la misma por mes a modo de bono contribución para los servicios de mantenimiento y limpieza.
* El gimnasio incorporó a sus instalaciones una alberca, por lo que ofrece como adicioal el acceso a la misma, este acceso tiene un costo fijo y para ingresar, el socio debe estar habilitado, es decir, tener la revisión médica.
* Para incorporar este nuevo servicio, el analista propone extender las Clases existentes de la siguiente manera: el gimnasio necesita saber cual es la cuota que debe pagar el socio. En caso que no esté habilitado para ingresar a la alberca, no se le cobrará costo adicional.
*/

public class Socio {
    private Integer codigo;
    private String nombre;
    private Double cuotaMensual;
    private String actividad;
    static double extraCuotaMensual = 0.05;
    static double interesMoratorio = 0.1;

    // Método que nos permite instanciar a esta clase al momento de crear un objeto "hijo" (que deriva) de esta Clase.


    public Socio(Integer codigo, String nombre, Double cuotaMensual, String actividad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cuotaMensual = cuotaMensual;
        this.actividad = actividad;
    }

    // Se calcula cuota por pagar de cada Socio
    public Double calcularCuotaMensual() {
        double cuotaTotal = cuotaMensual * (1 + extraCuotaMensual);
        /*System.out.println("Cuota base: " + cuotaMensual);
        System.out.println("Cuota extra: " + (cuotaMensual * extraCuotaMensual));
        System.out.println("Cuota total MENSUAL: " + cuotaTotal);*/
        return cuotaTotal;
    }

    // Se agrega (a manera de ejercitación) la cuota mensual en caso de haber moratoria(atraso) en el pago de la cuota mensual
    public Double calcularCuotaMoratoria() {
        double cuotaMoratoria = cuotaMensual * (1 + extraCuotaMensual + interesMoratorio);
        /*System.out.println("Cuota base: " + cuotaMensual);
        System.out.println("Cuota extra: " + (cuotaMensual * extraCuotaMensual));
        System.out.println("Cuota moratoria: " + (cuotaMensual * interesMoratorio));
        System.out.println("Total cuota MORATORIA: " + cuotaMoratoria);*/
        return cuotaMoratoria;
    }
}
