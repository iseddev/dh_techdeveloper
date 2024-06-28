package Herencia;

public class SocioAlberca extends Socio {

    // Atributos
    private Double cuotaAlberca;
    private boolean estaHabilitado;

    // Constructor (incluímos los atributos de la Superclase Socio) y los atributos popios de esta Clase
    public SocioAlberca(Integer codigo, String nombre, Double cuotaMensual, String actividad, Double cuotaAlberca) {
        super(codigo, nombre, cuotaMensual, actividad);
        this.cuotaAlberca = cuotaAlberca;
        estaHabilitado = false;
    }

    public void setEstaHabilitado(boolean estaHabilitado) { this.estaHabilitado = estaHabilitado; }

    // Éste método "sobreescribirá" al método original
    @Override // Firma de este método que asegura que es el mismo método (en este caso, el primer método) que el de la Clase Socio
    // Método calcularCuotaMensaual() SIN parámetros
    public Double calcularCuotaMensual() {
        if(!estaHabilitado) {
            System.out.println("Socio NO HABILITADO, error al calcular cuota TOTAL mensual:");
            return 0.00;
        } else {
            // Se obtiene la cuota mensual "general" y se agrega el costo extra (costoAlberca) para poder ser un SocioAlberca
            double cuotaBase = super.calcularCuotaMensual();
            System.out.println("Socio HABILITADO, cuota TOTAL mensual (sin MORATORIA):");
            return cuotaAlberca + cuotaBase;
        }
    }

    @Override // Firma de este método que asegura que es el mismo método (en este caso, el segundo método) que el de la Clase Socio
    // Método calcularCuotaMensual() CON parámetros
    public Double calcularCuotaMoratoria() {
        if(!estaHabilitado) {
            System.out.println("Socio NO HABILITADO, error al calcular cuota TOTAL  moratoria mensual:");
            return 0.00;
        } else {
            double cuotaMoratoria = super.calcularCuotaMoratoria();
            System.out.println("Socio HABILITADO, cuota TOTAL mensual (con moratoria):");
            return  cuotaAlberca + cuotaMoratoria;
        }
    }
}