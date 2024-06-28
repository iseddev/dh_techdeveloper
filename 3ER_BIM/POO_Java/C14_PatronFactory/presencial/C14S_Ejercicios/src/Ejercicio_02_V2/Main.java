package Ejercicio_02_V2;

public class Main {
    public static void main(String[] args) {
        // Instanciamos a cada "creador" de empleados específico
        CreadorEmpleados creadorPH = new CreadorEmpleadoPH();
        CreadorEmpleados creadorRD = new CreadorEmpleadoRD();

        Empleado PH_01 = creadorPH.crearEmpleado("EMP-ph");
        System.out.println("Salario PH: " + PH_01.calcularSueldo(15));
        Empleado RD_01 = creadorRD.crearEmpleado("Emp-Rd");
        System.out.println("Salario RD: " + RD_01.calcularSueldo(15));
    }
}
