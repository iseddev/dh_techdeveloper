package PagosConTarjeta;

public abstract class Tarjeta {

    private String numeroFrontal;
    private int codigoSeguridad;
    private int mesExpiracion, anioExpiracion;

    public Tarjeta(String numeroFrontal, int codigoSeguridad, int mesExpiracion, int anioExpiracion) {
        this.numeroFrontal = numeroFrontal;
        this.codigoSeguridad = codigoSeguridad;
        this.mesExpiracion = mesExpiracion;
        this.anioExpiracion = anioExpiracion;
    }

    public String getNumeroFrontal() { return numeroFrontal; }
    public void setNumeroFrontal(String numeroFrontal) { this.numeroFrontal = numeroFrontal; }

    public int getCodigoSeguridad() { return codigoSeguridad; }
    public void setCodigoSeguridad(int codigoSeguridad) { this.codigoSeguridad = codigoSeguridad; }

    public int getMesExpiracion() { return mesExpiracion; }
    public void setMesExpiracion(int fechaExpiracion) { this.mesExpiracion = mesExpiracion; }

    public int getAnioExpiracion() { return anioExpiracion; }
    public void setAnioExpiracion(int anioExpiracion) { this.anioExpiracion = anioExpiracion; }
}