package Final_01;

import java.util.ArrayList;
import java.util.List;

public class Reporte {
    private List<OfertaAcademica> listaOfertas;

    public Reporte() { listaOfertas = new ArrayList<>(); }

    public void agregarOferta(OfertaAcademica oferta) { listaOfertas.add(oferta); }

    public void verReporte() {
        System.out.println("########## Reporte General Oferta Académica ##########");
        for (OfertaAcademica oferta : listaOfertas) {
            System.out.println(oferta.getNombre() + ", Precio: $" + oferta.calcularPrecio());
        }
    }
}
