package presencial;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creación de un objeto
        // Para crear el objeto lo primero que debemos hacer es
        Scanner scanner = new Scanner(System.in);
        System.out.println("***** Inscripciones a Examenes CTD *****");
        System.out.println("Ingrese nombre del estudiante: ");
        String nombreEstudiante = scanner.nextLine();
        System.out.println("Ingrese la matrícula (numérica): ");
        int matriculaEstudiante = scanner.nextInt();
        System.out.println("Ingrese su edad: ");
        int edadEstudiante = scanner.nextInt();
        System.out.println("Ingrese la nota anterior: ");
        double notaEstudiante = scanner.nextDouble();

        System.out.println("===== Verifique los datos ingresados =====");
        System.out.println(nombreEstudiante + ", " + matriculaEstudiante + ", " + edadEstudiante + ", " + notaEstudiante);

        char primerCaracter = primeraLetra(nombreEstudiante);
        System.out.println("Primera letra del nombre: " + primerCaracter);

        char ultimoCaracter = ultimaLetra(nombreEstudiante);
        System.out.println("Última letra del nombre: " + ultimoCaracter);

        scanner.close();

        if(esMayor(edadEstudiante)) {
            System.out.println("El alumno es mayor de edad");
        } else {
            System.out.println("El alumno NO es mayor de edad");
        }
    }

    public static char primeraLetra(String nombre) {
        return nombre.charAt(0);
    }

    public static char ultimaLetra(String nombre) {
        return nombre.charAt(nombre.length() - 1);
    }

    public static boolean esMayor(int edad) {
        int mayoriaEdad = 18;
        return edad >= mayoriaEdad;
    }
}
