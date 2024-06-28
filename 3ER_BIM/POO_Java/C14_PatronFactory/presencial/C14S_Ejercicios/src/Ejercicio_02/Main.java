package Ejercicio_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("********** Calculadora de Salarios **********");
        System.out.println("Ingrese el tipo de empleado (EMP-RD ó EMP-PH): ");

        // ********** Usando if - else **********
        String tipoEmpleado = scanner.nextLine();

        // Ejecución sin validación del tipo de empleado pasado por el usuario
        /*
        // Se crean los objetos "fabricadores" de tipo "EmpleadoFactory" pero cada objeto instanciado a su "propia fábrica"
        EmpleadoFactory factoryPH = new EmpleadoPHFactory();
        EmpleadoFactory factoryRD = new EmpleadoRDFactory();

        // Se crean los objetos de tipo Empleado instanciados a su respectivo "fabricador"
        Empleado empleadoRD = factoryRD.crearEmpleado(tipoEmpleado);
        Empleado empleadoPH = factoryPH.crearEmpleado(tipoEmpleado);

        System.out.println("Días trabajados por el empleado: ");
        int diasTrabajados = scanner.nextInt();
        System.out.println("Salario RD: " + empleadoRD.calcularSueldo(diasTrabajados));
        System.out.println("Salario PH: " + empleadoPH.calcularSueldo(diasTrabajados));
         */

        // Ejecución con validación del tipo de empleado ingresado por el usuario
        if (tipoEmpleado.equalsIgnoreCase("EMP-RD")) {
            EmpleadoFactory factoryRD = new EmpleadoRDFactory();
            Empleado empleadoRD = factoryRD.crearEmpleado(tipoEmpleado);
            System.out.println("Días trabajados por el empleado: ");
            int diasTrabajados = scanner.nextInt();
            System.out.println("Salario RD: " + empleadoRD.calcularSueldo(diasTrabajados));
        } else if (tipoEmpleado.equalsIgnoreCase("EMP-PH")) {
            EmpleadoFactory factoryPH = new EmpleadoPHFactory();
            Empleado empleadoPH = factoryPH.crearEmpleado(tipoEmpleado);
            System.out.println("Días trabajados por el empleado: ");
            int diasTrabajados = scanner.nextInt();
            System.out.println("Salario PH: " + empleadoPH.calcularSueldo(diasTrabajados));
        } else {
            System.err.println("ERROR!!! Tipo de empleado no válido");
        }

        // ********** Usando switch **********
        /*
        String tipoEmpleado = scanner.nextLine().toLowerCase();
        switch (tipoEmpleado) {
            case "emp-rd": {
                EmpleadoFactory factoryRD = new EmpleadoRDFactory();
                Empleado empleadoRD = factoryRD.crearEmpleado(tipoEmpleado);
                System.out.println("Días trabajados por el empleado: ");
                int diasTrabajados = scanner.nextInt();
                System.out.println("Salrio RD: " + empleadoRD.calcularSueldo(diasTrabajados));
                break;
            }
            case "emp-ph": {
                EmpleadoFactory factoryPH = new EmpleadoPHFactory();
                Empleado empleadoPH = factoryPH.crearEmpleado(tipoEmpleado);
                System.out.println("Días trabajados por el empleado: ");
                int diasTrabajados = scanner.nextInt();
                System.out.println("Salrio PH: " + empleadoPH.calcularSueldo(diasTrabajados));
                break;
            }
            default: System.err.println("ERROR!!! Tipo de empleado no válido");
        }
        */

        scanner.close();
    }
}
