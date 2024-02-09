package presencial;

import java.util.Objects;
import java.util.Scanner;

public class MesaTrabajo3 {

    /* Escribir una función: boolean cadenasDeTextoDistintas(String unTextoA, String unTextoB) que debe tomar dos cadenas de texto y devolver true, en caso de que sean distintos, o false, en caso de que coincidan. */
    public static boolean cadenasDeTextoDistintas(String textoA, String textoB) {
        return !textoA.equals(textoB);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /* Verificar que dos cadenas de texto son distintas*/
        System.out.println("***** Verificador de textos distintos *****");
        System.out.println("Ingresa el primer texto:");
        String primerTexto = scanner.nextLine().toUpperCase();
        System.out.println("Ingresa el segundo texto:");
        String segundoTexto = scanner.nextLine().toUpperCase();

        if(cadenasDeTextoDistintas(primerTexto, segundoTexto)) {
            System.out.println("Los textos son DISTINTOS");
        } else {
            System.out.println("Los textos son IGUALES");
        }
    }
}
