package mesa_trabajo_1;

import java.util.Date;

public abstract class Impresora {
    private String modelo;
    private String tipoConexion;
    private Date fechaFabricacion;
    private int hojasDisponibles;
    private Double porcentajeTinta;

    public Impresora(String modelo, String tipoConexion, Date fechaFabricacion, int hojasDisponibles, Double porcentajeTinta) {
        this.modelo = modelo;
        this.tipoConexion = tipoConexion;
        this.fechaFabricacion = fechaFabricacion;
        this.hojasDisponibles = hojasDisponibles;
        this.porcentajeTinta = porcentajeTinta;
    }

    public boolean tienePapel() { return false; }

    public boolean necesitaTinta() { return false; }

    public abstract String imprimir();
}
