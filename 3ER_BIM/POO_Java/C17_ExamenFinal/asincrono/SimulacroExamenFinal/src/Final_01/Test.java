package Final_01;

public class Test {
    public static void main(String[] args) {

        // Creación de Cursos individuales
        Curso front = new Curso("Frontend", "Bases del desarrollo Frontend", 16, 2, 1000);
        System.out.println("Precio curso " + front.getNombre() + ": $" + + front.calcularPrecio());
        Curso back = new Curso("Backend", "Introducción al Backend con Java", 20, 2, 900);
        System.out.println("Precio curso " + back.getNombre() + ": $" + back.calcularPrecio());
        // Creación de un Programa, que contendrá Cursos
        Programa full = new Programa("Fullstack", "Desarrollo web Fullstack", 20);
        full.agregarOferta(front);
        full.agregarOferta(back);
        System.out.println("Costo total programa " + full.getNombre() + ": $" + full.calcularPrecio());


        // Creación de Trabajos Prácticos individuales
        OfertaAcademica TP_01 = new TrabajoPractico("Practico 01", "Introducción al TP 01", 630);
        OfertaAcademica TP_02 = new TrabajoPractico("Practico 02", "Introducción al TP 02", 520);
        OfertaAcademica TP_03 = new TrabajoPractico("Practico 03", "Introducción al TP 03", 860);
        OfertaAcademica TP_04 = new TrabajoPractico("Practico 04", "Introducción al TP 04", 780);
        // Creación de un Taller, que contendrá Trabajos Prácticos
        Taller taller_01 = new Taller("Taller 01", "Fundamentos de TP 01");
        taller_01.agregarTrabajoPractico(TP_01);
        taller_01.agregarTrabajoPractico(TP_02);
        taller_01.agregarTrabajoPractico(TP_03);
        taller_01.agregarTrabajoPractico(TP_04);
        System.out.println("Costo total " + taller_01.getNombre() + ": $" + taller_01.calcularPrecio());

        Carrera developer = new Carrera("CTD", "Certified Tech Developer", 1000);
        developer.agregarCurso(front);
        developer.agregarCurso(back);
        developer.agregarTaller(taller_01);


        // Impresión de Reportes
        Reporte ofertaActual = new Reporte();
        ofertaActual.agregarOferta(front);
        ofertaActual.agregarOferta(back);
        ofertaActual.agregarOferta(full);
        ofertaActual.agregarOferta(TP_01);
        ofertaActual.agregarOferta(TP_02);
        ofertaActual.agregarOferta(TP_03);
        ofertaActual.agregarOferta(TP_04);
        ofertaActual.agregarOferta(taller_01);
        ofertaActual.agregarOferta(developer);
        ofertaActual.verReporte();

    }
}
