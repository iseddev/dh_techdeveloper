package C12S_MesaTrabajo;

public class Contenedor {
    private int numero;
    private Pais paisProcedencia;
    private boolean materialPeligroso;

    public Contenedor(int numero, Pais paisProcedencia, boolean materialPeligroso) {
        this.numero = numero;
        this.paisProcedencia = paisProcedencia;
        this.materialPeligroso = materialPeligroso;
    }

    public int getNumero() { return numero; }
    public Pais getPaisProcedencia() { return paisProcedencia; }
    public boolean getMaterialPeligroso() { return materialPeligroso; }

    @Override
    public String toString() {
        return "Contenedor{" +
                "numero=" + numero +
                ", paisProcedencia=" + paisProcedencia +
                ", materialPeligroso=" + materialPeligroso +
                '}';
    }
}