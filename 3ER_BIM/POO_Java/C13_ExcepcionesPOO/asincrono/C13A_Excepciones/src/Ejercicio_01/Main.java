package Ejercicio_01;

public class Main {
    public static void main(String[] args) {
        /*
        // No se hace ningún manejo de errores/excepciones
        Date01 fecha01 = new Date01(100, -100, 1000);
        System.out.println(fecha01);
         */

        /*
        // RuntimeException
        Date02 fecha02 = new Date02(100, -100, 1000);
        System.out.println(fecha02);
         */

        try { Date03 fecha03 = new Date03(100, -100, 1000); }
        catch(Exception e) { System.out.println("ERROR!!! Los datos ingresados no son válidos..."); }
    }
}
