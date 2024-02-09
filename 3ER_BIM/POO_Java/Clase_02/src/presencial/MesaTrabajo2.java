package presencial;

import java.util.Scanner;

public class MesaTrabajo2 {

    /* Escribir una función que reciba tres números y devuelva el máximo entre los tres números. Integer maximoEntreTresNumeros(Integer unNumeroA, Integer unNumeroB, Integer unNumeroC) */
    public static Integer maxNum (int num1, int num2, int num3) {
        int greatest;
        if(num1 > num2 && num1 > num3) {
            greatest = num1;
        } else if( num2 > num1 && num2 > num3) {
            greatest = num2;
        } else { greatest = num3; }
        return greatest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* Luego hacer un programa que permita el ingreso de 3 valores, utilice la función y muestre el resultado. */
        System.out.println("Mayor de TRES números");
        System.out.println("Ingres el primer número entero: ");
        int numOne = scanner.nextInt();
        System.out.println("Ingres el segundo número entero: ");
        int numTwo = scanner.nextInt();
        System.out.println("Ingres el tercer número entero: ");
        int numThree = scanner.nextInt();
        int maxNumber = maxNum(numOne, numTwo, numThree);
        System.out.println("El número mayor entre " + numOne + ", " + numTwo + " y " + numThree + " es: " + maxNumber);
        scanner.close();
    }
}
