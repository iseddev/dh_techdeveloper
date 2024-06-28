public class Curso extends Oferta{
    private int cargaHoraria;
    private int mesesDuracion;
    private double valorHora;

    public Curso(String nombre, String descripcion, int cargaHoraria, int mesesDuracion, double valorHora) {
        super(nombre, descripcion);
        this.cargaHoraria = cargaHoraria;
        this.mesesDuracion = mesesDuracion;
        this.valorHora = valorHora;
    }
    public double getPrecio(){
        return cargaHoraria * mesesDuracion * valorHora;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getMesesDuracion() {
        return mesesDuracion;
    }

    public void setMesesDuracion(int mesesDuracion) {
        this.mesesDuracion = mesesDuracion;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
}
