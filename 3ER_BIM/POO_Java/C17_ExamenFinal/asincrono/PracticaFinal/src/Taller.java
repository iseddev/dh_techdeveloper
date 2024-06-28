public class Taller extends Oferta{
    private int numTrabajosPracticos;
    private double costoTP;

    public Taller(String nombre, String descripcion, int numTrabajosPracticos, double costoTP) {
        super(nombre, descripcion);
        this.numTrabajosPracticos = numTrabajosPracticos;
        this.costoTP = costoTP;
    }
    public double getPrecio(){
        return numTrabajosPracticos * costoTP;
    }

    public int getNumTrabajosPracticos() {
        return numTrabajosPracticos;
    }

    public void setNumTrabajosPracticos(int numTrabajosPracticos) {
        this.numTrabajosPracticos = numTrabajosPracticos;
    }

    public double getCostoTP() {
        return costoTP;
    }

    public void setCostoTP(double costoTP) {
        this.costoTP = costoTP;
    }
}
