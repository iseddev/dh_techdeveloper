package C12S_MesaTrabajo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Puerto {
    private List<Contenedor> listaContenedores;

    public Puerto(){ listaContenedores = new ArrayList<>(); }

    public void agregarContenedor(int numero, Pais paisProcedencia, boolean materialPeligroso) {
        Contenedor contenedor = new Contenedor(numero, paisProcedencia, materialPeligroso);
        listaContenedores.add(contenedor);
    }

    public void mostrarContenedoresOrdenados() {
        Collections.sort(listaContenedores, Comparator.comparingInt(Contenedor::getNumero));
        for (Contenedor contenedor : listaContenedores) { System.out.println(contenedor); }
    }

    public int contarContenedoresPeligrosos() {
        int contador = 0;
        for (Contenedor contenedor : listaContenedores) {
            if(contenedor.getMaterialPeligroso() && contenedor.getPaisProcedencia() == Pais.DESCONOCIDO) { contador++; }
        }
        return contador;
    }
}
