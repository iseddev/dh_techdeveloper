package Ejercicio_02;

public class Main {
    public static void main(String[] args) {
        Final final01 = new Final(new Alumno("Israel", "Porfirio", 123654), "Español", "Introducción a la lengua española", 8.5, 9.5, "Introducción a la lengua española");
        Final final02 = new Final(new Alumno("Israel", "Porfirio", 123654), "Español", "Introducción a la lengua española II", 8.9, 9.0, "Introducción a la lengua española II");
        System.out.println("Final01 es mayor a Final02? " + final01.esMayor(final02));
        System.out.println("Final02 es mayor a Final01? " + final02.esMayor(final01));

        Parcial parcial01 = new Parcial(new Alumno("Eduardo", "Moreno", 987654), "Matematicas", "Introducción a la Geometría", 4.5, 3, 0);
        System.out.println("Parcial01 se puede recuperar? " + parcial01.puedeRecuperar());
        System.out.println("Numero reintentos Parcial01: " + parcial01.numeroReintentos);
    }
}
