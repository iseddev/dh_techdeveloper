import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // Crear instancias de cursos
        Curso cursoFrontEnd = new Curso("Front End","Curso de desarrollo Front End",16,2,1000);
        Curso cursoBackEnd = new Curso("Back End","Curso de desarollo Back End",20,2,900);

        // Crear una lista para almacenar los cursos del programa FullStack
        List<Curso> cursosFullStack = new ArrayList<>();
        cursosFullStack.add(cursoFrontEnd);
        cursosFullStack.add(cursoBackEnd);

        // Crear una instancia del programa FullStack
        Programa programaFullStack = new Programa("FullStack","Programa intensivo FullStack",cursosFullStack,0.2);

        // Crear una instancia del taller
        Taller taller = new Taller("Taller","Taller intensivo",10,50);

        // Crear una lista para almacenar los cursos y talleres de la carrera
        List<Oferta> cursosYTalleres = new ArrayList<>();
        cursosYTalleres.add(cursoFrontEnd);
        cursosYTalleres.add(cursoBackEnd);
        cursosYTalleres.add(taller);

        // Crear una instancia de la carrera
        Carrera carrera = new Carrera("Carrera", "Carrera de desarrollo FullStack", cursosYTalleres, 10000);

        System.out.println("Informe de Cursos y programas: ");
        System.out.println("Curso: " + cursoFrontEnd.getNombre() + "- Precio: $" + cursoFrontEnd.getPrecio());
        System.out.println("Curso: " + cursoBackEnd.getNombre() + "- Precio: $" + cursoBackEnd.getPrecio());

        System.out.println("Programa: " + programaFullStack.getNombre() + "- Precio: $" + programaFullStack.getPrecio());
        System.out.println("Carrera: " + carrera.getNombre() + "- Precio: $" + carrera.getPrecio());
    }
}
