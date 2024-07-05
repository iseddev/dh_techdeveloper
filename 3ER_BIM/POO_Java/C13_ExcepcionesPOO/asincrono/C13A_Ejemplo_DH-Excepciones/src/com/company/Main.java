package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1,num2, division;
        try {
            System.out.println("Primer número");
            num1=scanner.nextInt();
            System.out.println("Divisor");
            num2=scanner.nextInt();
            division = num1 / num2;
            System.out.println(division);
        }
        // Validar el tipo de valor ingresado
        catch (InputMismatchException e) { System.err.println("ERROR!!! valores ingresados no válidos"); }
        // VAlidar que la operacion aritmética es correcta
        catch (ArithmeticException e) { System.err.println("ERROR!!! Se está intentando dividir por cero"); }
        //
        catch(Exception e) { System.out.println("Error"); }
    }
}
