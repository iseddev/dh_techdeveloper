package Ejercicio_01;

public class Main {
    public static void main(String[] args) {
        Velero velero01 = new Velero(new Capitan("Israel", "Porfirio", 159357), 1500.0, 490.0, 2021, 15, 3);
        Velero velero02 = new Velero(new Capitan("Eduardo", "Moreno", 753951), 1800.0, 590.0, 2015, 9, 6);
        System.out.println("Velero 1 es grande? " + velero01.esGrande() + ", porque tiene " + velero01.cantidadMastiles + " mástiles");
        System.out.println("Velero 2 es grande? " + velero02.esGrande() + ", porque tiene " + velero02.cantidadMastiles + " mástiles");
        
        Yate yate01 = new Yate(new Capitan("John", "Doe", 753963), 2500.0, 690.0, 2010, 12, 6);
        Yate yate02 = new Yate(new Capitan("Elena", "Doe", 147852), 3200.0, 890.0, 2023, 10, 9);
        System.out.println("Yate01 es más lujoso que Yate02? " + yate01.esMayorLujo(yate02));
        System.out.println("Yate02 es más lujoso que Yate01? " + yate02.esMayorLujo(yate01));
    }
}
